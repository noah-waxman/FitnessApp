import { useRef } from "react";
import {
  Animated,
  Pressable,
  StyleProp,
  StyleSheet,
  ViewStyle,
} from "react-native";
import { AppText } from "./AppText";

type LongButtonProps = {
  text: string;
  color: string;
  textColor: string;
  radius?: number;
  onPress?: () => void;
  style?: StyleProp<ViewStyle>;
};

export default function LongButton({
  text,
  color,
  textColor,
  radius = 10,
  onPress,
  style,
}: LongButtonProps) {
  const scale = useRef(new Animated.Value(1)).current;

  const pressIn = () => {
    Animated.spring(scale, {
      toValue: 0.96,
      speed: 40,
      bounciness: 6,
      useNativeDriver: true,
    }).start();
  };

  const pressOut = () => {
    Animated.spring(scale, {
      toValue: 0.96,
      speed: 50,
      bounciness: 0,
      useNativeDriver: true,
    }).start();
  };

  return (
    <Pressable
      onPressIn={pressIn}
      onPressOut={pressOut}
      onPress={onPress}
      style={style}
    >
      <Animated.View
        style={[
          styles.button,
          {
            backgroundColor: color,
            borderRadius: radius,
            transform: [{ scale }],
          },
        ]}
      >
        <AppText style={[styles.text, { color: textColor }]}>{text}</AppText>
      </Animated.View>
    </Pressable>
  );
}

const styles = StyleSheet.create({
  button: {
    alignSelf: "stretch",
    alignItems: "center",
    paddingHorizontal: 30,
    paddingVertical: 15,
    elevation: 5,
  },
  text: {
    fontWeight: "bold",
    fontSize: 16,
  },
});
