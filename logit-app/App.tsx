import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View } from "react-native";
import { globalStyles } from "./globalStyles";
import { SafeAreaProvider } from "react-native-safe-area-context";
import Test from "./components/test";

export default function App() {
  return (
    <SafeAreaProvider>
      <View style={globalStyles.testContainer}>
        <Test />
      </View>
    </SafeAreaProvider>
  );
}
