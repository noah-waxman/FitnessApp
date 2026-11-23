import { View, Text, Button } from "react-native";
import { globalStyles } from "../../globalStyles";
import { useAuthStore } from "../../stores/auth";

export default function Home() {
  const signOut = useAuthStore((s) => s.signOut);

  return (
    <View style={globalStyles.defaultContainer}>
      <Text>You're logged in</Text>
      <Button title="Sign out" onPress={signOut} />
    </View>
  );
}
