import { Stack } from "expo-router";

export default function AppLayout() {
  return (
    <Stack screenOptions={{ headerShown: false }}>
      <Stack.Screen name="(tabs)" />
      <Stack.Screen
        name="AddFood"
        options={{ presentation: "modal" }} // optional, or remove for a normal push
      />
    </Stack>
  );
}
