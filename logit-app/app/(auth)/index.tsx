import { View, StyleSheet, Platform } from "react-native";
import { useSafeAreaInsets } from "react-native-safe-area-context";
import { useRouter } from "expo-router";
import LongButton from "../../components/LongButton";
import AppLogo from "../../components/AppLogo";

export default function LoginRegisterScreen() {
  const insets = useSafeAreaInsets();
  const router = useRouter();

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
          <LongButton
            text="Create Account"
            color="#175DDC"
            textColor="#FFF"
            onPress={() => router.push("/CreateAccountScreen")}
          />
          <LongButton
            text="Login"
            color="#20293d"
            textColor="#FFF"
            onPress={() => router.push("/LoginScreen")}
          />
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
  body: { flexDirection: "column", padding: 15 },
  logo: { alignItems: "center" },
});
