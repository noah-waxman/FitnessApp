import { Stack } from "expo-router";
import { colors } from "../../theme";

export default function AppLayout() {
  return (
    <Stack
      screenOptions={{
        animation: "none",
        headerShown: false,
        contentStyle: { backgroundColor: colors.background },
      }}
    />
  );
}
