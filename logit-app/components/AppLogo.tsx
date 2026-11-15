// AppLogo.js
import React from "react";
import Svg, { Rect, Circle, Path } from "react-native-svg";

type AppLogoProps = {
  size: number;
};

export default function AppLogo({ size }: AppLogoProps) {
  return (
    <Svg width={size} height={size} viewBox="0 0 160 160">
      <Path
        d="M80 34 C80 34 112 62 112 92 C112 112 98 126 80 126 C62 126 48 112 48 92 C48 74 60 62 66 50 C70 58 72 62 76 64 C78 56 78 44 80 34 Z"
        fill="#FF9F0A"
      />
      <Path
        d="M80 84 C80 84 94 98 94 108 C94 116 88 122 80 122 C72 122 66 116 66 108 C66 98 80 84 80 84 Z"
        fill="#FFD60A"
      />
    </Svg>
  );
}
