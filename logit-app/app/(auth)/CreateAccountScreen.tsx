import { Text, View } from "react-native";
import { useRouter } from "expo-router";
import { StyleSheet } from "react-native";
import { globalStyles } from "../../globalStyles";
import Animated, { FadeIn } from "react-native-reanimated";
import LongButton from "../../components/LongButton";

export default function CreateAccountScreen() {
  const router = useRouter();
  return (
    <Animated.View
      style={globalStyles.defaultContainer}
      entering={FadeIn.duration(250)}
    >
      <View style={styles.container}>
        <LongButton text="Create Account" color="#175DDC" textColor="#FFF" />
      </View>
    </Animated.View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
  },
});
