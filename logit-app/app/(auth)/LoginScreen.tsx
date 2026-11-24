import { Text, View } from "react-native";
import { useRouter } from "expo-router";
import { StyleSheet } from "react-native";
import { globalStyles } from "../../globalStyles";
import { AppText } from "../../components/AppText";
import Animated, { FadeIn } from "react-native-reanimated";
import LongButton from "../../components/LongButton";
import TextInputField from "../../components/TextInputField";
import { colors } from "../../theme";
import { registerAccount } from "../../api";
import { useLocalSearchParams } from "expo-router";
import { useEffect, useState } from "react";
import AppLogo from "../../components/AppLogo";
import { KeyboardAwareScrollView } from "react-native-keyboard-controller";
import { useSafeAreaInsets } from "react-native-safe-area-context";
import { useAuthStore } from "../../stores/auth";

export default function LoginScreen() {
  const signIn = useAuthStore((s) => s.signIn);
  const insets = useSafeAreaInsets();
  const router = useRouter();
  const [email, setEmail] = useState<string>("");
  const [password, setPassword] = useState<string>("");
  const [error, setError] = useState<string>("");

  const { successfulRegistration, emailFromRegistration } =
    useLocalSearchParams<{
      successfulRegistration: string;
      emailFromRegistration: string;
    }>();

  const [showSuccess, setShowSuccess] = useState(
    successfulRegistration === "true",
  );

  useEffect(() => {
    if (emailFromRegistration && emailFromRegistration.trim().length > 0) {
      setEmail(emailFromRegistration.trim());
    }
  }, [emailFromRegistration]);

  const handleLogin = async () => {
    const result = await signIn(email, password);
    if (!result.success) {
      setError(result.error);
      setShowSuccess(false);
    }
  };

  useEffect(() => {
    if (error && error.trim().length > 0) {
      setError("");
    }
  }, [email, password]);

  return (
    <KeyboardAwareScrollView
      contentContainerStyle={{
        flexGrow: 1,
        paddingTop: insets.top,
        paddingBottom: insets.bottom,
        paddingLeft: insets.left,
        paddingRight: insets.right,
      }}
      keyboardShouldPersistTaps="handled"
      bottomOffset={20}
    >
      <Animated.View
        style={[globalStyles.defaultContainer, styles.body]}
        entering={FadeIn.duration(200)}
      >
        <View style={[styles.headerWrapper]}>
          <View style={styles.header}>
            <AppText style={styles.headerText}>Login</AppText>
            <View style={styles.centerOverlay} pointerEvents="none">
              <AppLogo size={60} />
            </View>
          </View>
        </View>
        <View style={styles.container}>
          <AppText style={styles.caption}>Lets count some calories.</AppText>
          <TextInputField
            label="Email"
            placeholder="Enter your email address"
            value={email}
            onChangeText={setEmail}
          />
          <TextInputField
            label="Password"
            placeholder="Enter your password"
            value={password}
            onChangeText={setPassword}
          />
          {showSuccess === true && (
            <Animated.View
              entering={FadeIn.duration(150)}
              style={styles.successBox}
            >
              <AppText style={styles.successText}>
                Account successfully created! Please login
              </AppText>
            </Animated.View>
          )}
          {error.trim().length > 0 && (
            <Animated.View
              entering={FadeIn.duration(150)}
              style={styles.errorBox}
            >
              <AppText style={styles.errorText}>{error}</AppText>
            </Animated.View>
          )}
          <View style={styles.buttons}>
            <LongButton
              style={styles.backButton}
              text="Back"
              color={colors.Text4}
              textColor="#FFF"
              onPress={() => router.replace("/")}
            />
            <LongButton
              style={styles.createButton}
              text="Login"
              color="#175DDC"
              textColor="#FFF"
              onPress={() => handleLogin()}
            />
          </View>
        </View>
      </Animated.View>
    </KeyboardAwareScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  body: {
    flexDirection: "column",
  },
  headerWrapper: {
    marginBottom: 30,
  },
  header: {
    flexDirection: "row",
    alignItems: "center",
  },
  centerOverlay: {
    position: "absolute",
    top: 0,
    left: 0,
    right: 0,
    bottom: 0,
    justifyContent: "center",
    alignItems: "center",
  },
  headerText: {
    fontSize: 25,
    fontWeight: "bold",
    color: "#fff",
  },
  caption: {
    fontSize: 15,
    color: "#ffffff8a",
    marginBottom: 20,
  },
  buttons: {
    flexDirection: "row",
    marginTop: 30,
    gap: 20,
  },
  backButton: {
    width: "30%",
    flexShrink: 0,
  },
  createButton: {
    flex: 1,
  },
  successBox: {
    backgroundColor: "#4ADE801F", // 12% opacity
    borderColor: "#4ADE8080", // 50% opacity
    borderWidth: 1,
    borderRadius: 8,
    paddingVertical: 10,
    paddingHorizontal: 12,
    marginTop: 5,
  },
  successText: {
    color: "#4ADE80",
    fontSize: 14,
  },
  errorBox: {
    backgroundColor: "#FF5C5C1F",
    borderColor: "#FF5C5C80",
    borderWidth: 1,
    borderRadius: 8,
    paddingVertical: 10,
    paddingHorizontal: 12,
    marginTop: 5,
  },
  errorText: {
    color: "#ff6b6b",
    fontSize: 14,
  },
});
