// src/auth/AuthContext.tsx
import React, { createContext, useContext, useEffect, useState } from "react";
import { getToken, setToken, clearToken } from "../storage/token";

const API_URL = "https://localhost"; // change this

type User = { id: string; email: string; timezone: string }; // match your /me response

type AuthState = {
  user: User | null;
  loading: boolean;
  signIn: (token: string) => Promise<void>;
  signOut: () => Promise<void>;
};

const AuthContext = createContext<AuthState | undefined>(undefined);

async function fetchMe(token: string): Promise<User | null> {
  try {
    const res = await fetch(`${API_URL}/auth/me`, {
      headers: { Authorization: `Bearer ${token}` },
    });
    if (!res.ok) return null; // 401 = expired/invalid token
    return await res.json();
  } catch {
    return null; // network error
  }
}

export function AuthProvider({ children }: { children: React.ReactNode }) {
  const [user, setUser] = useState<User | null>(null);
  const [loading, setLoading] = useState(true);

  // Runs once when the app starts
  useEffect(() => {
    (async () => {
      const token = await getToken();
      if (token) {
        const me = await fetchMe(token);
        if (me) setUser(me);
        else await clearToken(); // token was bad, remove it
      }
      setLoading(false);
    })();
  }, []);

  const signIn = async (token: string) => {
    await setToken(token);
    const me = await fetchMe(token);
    setUser(me);
  };

  const signOut = async () => {
    await clearToken();
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ user, loading, signIn, signOut }}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  const ctx = useContext(AuthContext);
  if (!ctx) throw new Error("useAuth must be used inside AuthProvider");
  return ctx;
}
