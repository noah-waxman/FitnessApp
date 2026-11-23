import React, { useState } from "react";
import { View, TextInput, StyleSheet } from "react-native";
import { AppText } from "./AppText";
import { colors } from "../theme";

// This describes the props (inputs) that our component accepts
interface TextInputFieldProps {
  label: string;
  placeholder: string;
  value: string;
  onChangeText: (text: string) => void;
}

function TextInputField(props: TextInputFieldProps) {
  // Track whether the input is currently focused
  const [isFocused, setIsFocused] = useState<boolean>(false);

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

  return (
    <View style={styles.container}>
      <AppText style={styles.label}>{props.label}</AppText>
      <TextInput
        style={[styles.input, { borderColor: borderColor }]}
        placeholder={props.placeholder}
        placeholderTextColor={colors.TextTertiary}
        selectionColor={colors.BorderFocused}
        value={props.value}
        onChangeText={props.onChangeText}
        onFocus={handleFocus}
        onBlur={handleBlur}
      />
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
  input: {
    height: 44,
    borderWidth: 1,
    borderRadius: 8,
    paddingHorizontal: 12,
    fontSize: 16,
    backgroundColor: colors.SurfaceInput,
    color: colors.TextPrimary,
  },
});

export default TextInputField;
