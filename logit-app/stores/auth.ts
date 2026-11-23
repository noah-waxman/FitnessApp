import { create } from "zustand";
import {
  persist,
  createJSONStorage,
  type StateStorage,
} from "zustand/middleware";
import * as SecureStore from "expo-secure-store";

const API_URL = "https://localhost";

const secureStorage: StateStorage = {
  getItem: (name) => SecureStore.getItemAsync(name),
  setItem: (name, value) => SecureStore.setItemAsync(name, value),
  removeItem: (name) => SecureStore.deleteItemAsync(name),
};

type AuthState = {
  token: string | null;
  hasHydrated: boolean; // true once the saved token has been loaded
  signIn: (email: string, password: string) => Promise<void>;
  signOut: () => void;
};

export const useAuthStore = create<AuthState>()(
  persist(
    (set) => ({
      token: null,
      hasHydrated: false,

      signIn: async (email: string, password: string) => {
        const res = await fetch(`${API_URL}/auth/login`, {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({ email, password }),
        });
        if (!res.ok) throw new Error("Login failed");
        const data = await res.json();
        set({ token: data.token });
      },

      signOut: () => set({ token: null }),
    }),
    {
      name: "auth", // key used in SecureStore
      storage: createJSONStorage(() => secureStorage),
      partialize: (state) => ({ token: state.token }), // only save the token
      onRehydrateStorage: () => () => {
        useAuthStore.setState({ hasHydrated: true });
      },
    },
  ),
);
