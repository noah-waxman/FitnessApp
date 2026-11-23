import React from "react";
import { Text, TextProps, StyleSheet } from "react-native";

export interface AppTextProps extends TextProps {
  children?: React.ReactNode;
}

export function AppText({ style, ...props }: AppTextProps) {
  return <Text style={[styles.defaultFont, style]} {...props} />;
}

const styles = StyleSheet.create({
  defaultFont: {
    fontFamily: "Inter-Regular", // Replace with your exact font filename
  },
});
