import { Stack } from "expo-router";
import { SafeAreaProvider } from "react-native-safe-area-context";
import { colors } from "../theme";
import { useAuthStore } from "../stores/auth";
import { KeyboardProvider } from "react-native-keyboard-controller";

export default function RootLayout() {
  const token = useAuthStore((s) => s.token);
  const hasHydrated = useAuthStore((s) => s.hasHydrated);

  if (!hasHydrated) return null; // wait for the saved token to load

  const isAuthenticated = !!token;

  return (
    <KeyboardProvider>
      <SafeAreaProvider>
        <Stack
          screenOptions={{
            animation: "none",
            headerShown: false,
            contentStyle: { backgroundColor: colors.background },
          }}
        >
          <Stack.Protected guard={isAuthenticated}>
            <Stack.Screen name="(app)" />
          </Stack.Protected>

          <Stack.Protected guard={!isAuthenticated}>
            <Stack.Screen name="(auth)" />
          </Stack.Protected>
        </Stack>
      </SafeAreaProvider>
    </KeyboardProvider>
  );
}
