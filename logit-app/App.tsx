import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View } from "react-native";
import { globalStyles } from "./globalStyles";
import { SafeAreaProvider } from "react-native-safe-area-context";
import LoginRegisterScreen from "./components/LoginRegisterScreen";
import { AuthProvider, useAuth } from "./auth/AuthContext";

function Root() {
  const { user, loading } = useAuth();

  if (loading) return <Text>Loading</Text>;

  //replace null with logged in activity
  return user ? null : (
    <View style={globalStyles.testContainer}>
      <LoginRegisterScreen />
    </View>
  );
}

export default function App() {
  return (
    <AuthProvider>
      <SafeAreaProvider>
        <Root />
      </SafeAreaProvider>
    </AuthProvider>
  );
}
