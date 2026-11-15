import { useRef } from "react";
import { Animated, Pressable, StyleSheet, Text } from "react-native";

type LongButtonProps = {
  text: string;
  color: string;
  textColor: string;
  onClick?: () => void;
};

export default function LongButton({
  text,
  color,
  textColor,
  onClick,
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
      toValue: 1,
      speed: 40,
      bounciness: 6,
      useNativeDriver: true,
    }).start();
  };

  return (
    <Pressable onPressIn={pressIn} onPressOut={pressOut} onClick={onClick}>
      <Animated.View
        style={[
          styles.button,
          { backgroundColor: color, transform: [{ scale }] },
        ]}
      >
        <Text style={[styles.text, { color: textColor }]}>{text}</Text>
      </Animated.View>
    </Pressable>
  );
}

const styles = StyleSheet.create({
  button: {
    alignSelf: "stretch",
    alignItems: "center",
    marginHorizontal: 20,
    paddingHorizontal: 30,
    paddingVertical: 15,
    borderRadius: 10,
    elevation: 5,
  },
  text: {
    fontWeight: "bold",
    fontSize: 16,
  },
});
