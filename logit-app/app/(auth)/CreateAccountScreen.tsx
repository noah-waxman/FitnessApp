import { Text, View } from "react-native";
import { useRouter } from "expo-router";
import { StyleSheet } from "react-native";
import { globalStyles } from "../../globalStyles";
import { AppText } from "../../components/AppText";
import Animated, { FadeIn } from "react-native-reanimated";
import LongButton from "../../components/LongButton";
import TextInputField from "../../components/TextInputField";
import { useEffect, useState } from "react";
import { colors } from "../../theme";
import { registerAccount } from "../../api";
import { KeyboardAwareScrollView } from "react-native-keyboard-controller";
import { useSafeAreaInsets } from "react-native-safe-area-context";

export default function CreateAccountScreen() {
  const insets = useSafeAreaInsets();
  const router = useRouter();
  const [email, setEmail] = useState<string>("");
  const [password, setPassword] = useState<string>("");
  const [error, setError] = useState<string>("");

  const handleRegisterAccount = async () => {
    if (!email.trim() || !password.trim()) {
      console.log("Email or password is empty");
      return;
    }
    const result = await registerAccount(email, password, "Etc/GMT+8");

    if (result.success) {
      router.push({
        pathname: "/LoginScreen",
        params: {
          successfulRegistration: "true",
          emailFromRegistration: email,
        },
      });
    } else {
      setError(result.error);
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
        <View style={[styles.header]}>
          <AppText style={styles.headerText}>Your Account</AppText>
        </View>
        <View style={styles.container}>
          <AppText style={styles.caption}>
            You are creating an account with CalsPerGram
          </AppText>
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
              text="Create"
              color="#175DDC"
              textColor="#FFF"
              onPress={() => handleRegisterAccount()}
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
  header: {
    marginBottom: 30,
    flexDirection: "column",
    gap: 15,
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
