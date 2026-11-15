import { Text, View, StyleSheet, Platform, Animated } from "react-native";
import { useSafeAreaInsets } from "react-native-safe-area-context";
import LongButton from "./LongButton";
import AppLogo from "./AppLogo";

export default function LoginRegisterScreen() {
  const insets = useSafeAreaInsets();

  return (
    <View
      style={[
        styles.container,
        {
          paddingBottom: Platform.OS === "android" ? insets.bottom : 0,
        },
      ]}
    >
      <View style={styles.body}>
        <View style={styles.logo}>
          <AppLogo size={240} />
        </View>
        <View style={styles.buttons}>
          <LongButton text="Create Account" color="#175DDC" textColor="#FFF" />
          <LongButton text="Login" color="#20293d" textColor="#FFF" />
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
  },
  buttons: {
    flexDirection: "column",
    gap: 20,
  },
  body: { flexDirection: "column" },
  logo: { alignItems: "center" },
});
