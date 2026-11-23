import { create } from "zustand";
import {
  persist,
  createJSONStorage,
  type StateStorage,
} from "zustand/middleware";
import * as SecureStore from "expo-secure-store";
import { loginAccount } from "../api";

const secureStorage: StateStorage = {
  getItem: (name) => SecureStore.getItemAsync(name),
  setItem: (name, value) => SecureStore.setItemAsync(name, value),
  removeItem: (name) => SecureStore.deleteItemAsync(name),
};

type SignInResult = { success: true } | { success: false; error: string };

type AuthState = {
  token: string | null;
  hasHydrated: boolean;
  signIn: (email: string, password: string) => Promise<SignInResult>;
  signOut: () => void;
};

export const useAuthStore = create<AuthState>()(
  persist(
    (set) => ({
      token: null,
      hasHydrated: false,

      signIn: async (email, password) => {
        const result = await loginAccount(email, password);
        if (!result.success) {
          return { success: false, error: result.error };
        }
        set({ token: result.token });
        return { success: true };
      },

      signOut: () => set({ token: null }),
    }),
    {
      name: "auth",
      storage: createJSONStorage(() => secureStorage),
      partialize: (state) => ({ token: state.token }),
      onRehydrateStorage: () => () => {
        useAuthStore.setState({ hasHydrated: true });
      },
    },
  ),
);
