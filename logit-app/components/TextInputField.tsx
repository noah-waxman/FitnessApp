import React, { ComponentRef, useRef, useState } from "react";
import {
  View,
  TextInput,
  StyleSheet,
  Pressable,
  type TextInputProps,
} from "react-native";
import { AppText } from "./AppText";
import { colors } from "../theme";

// This describes the props (inputs) that our component accepts
interface TextInputFieldProps {
  label: string;
  placeholder: string;
  value: string;
  onChangeText: (text: string) => void;
  onFocus?: TextInputProps["onFocus"];
  unit?: string;
}

function TextInputField(props: TextInputFieldProps) {
  // Track whether the input is currently focused
  const [isFocused, setIsFocused] = useState(false);
  const inputRef = useRef<ComponentRef<typeof TextInput>>(null);

  const handlePress = () => {
    inputRef.current?.focus();
  };

  // Choose the border color based on focus state
  let borderColor: string = colors.BorderStrong;
  if (isFocused) {
    borderColor = colors.BorderFocused;
  }

  function handleFocus() {
    setIsFocused(true);
  }

  function handleBlur() {
    setIsFocused(false);
  }

  // Only render the unit if one was provided
  let unitElement = null;
  if (props.unit) {
    unitElement = <AppText style={styles.unit}>{props.unit}</AppText>;
  }

  return (
    <View style={styles.container}>
      <AppText style={styles.label}>{props.label}</AppText>
      <View style={[styles.inputWrapper, { borderColor: borderColor }]}>
        <TextInput
          ref={inputRef}
          style={styles.input}
          placeholder={props.placeholder}
          placeholderTextColor={colors.TextTertiary}
          selectionColor={colors.BorderFocused}
          value={props.value}
          onChangeText={props.onChangeText}
          onFocus={(e) => {
            setIsFocused(true);
            props.onFocus?.(e);
          }}
          onBlur={handleBlur}
        />
        {!isFocused && (
          <Pressable style={StyleSheet.absoluteFill} onPress={handlePress} />
        )}
        {unitElement}
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    marginBottom: 16,
  },
  label: {
    fontSize: 16,
    marginBottom: 6,
    color: colors.TextSecondary,
  },
  inputWrapper: {
    flexDirection: "row",
    alignItems: "center",
    height: 44,
    borderWidth: 1,
    borderRadius: 8,
    paddingHorizontal: 12,
    backgroundColor: colors.SurfaceInput,
  },
  input: {
    flex: 1, // Take up all the space the unit doesn't need
    height: "100%",
    fontSize: 16,
    color: colors.TextPrimary,
  },
  unit: {
    marginLeft: 8,
    fontSize: 16,
    color: colors.TextSecondary,
  },
});

export default TextInputField;
