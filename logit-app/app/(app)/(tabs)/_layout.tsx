import { NativeTabs } from "expo-router/native-tabs";
import { colors } from "../../../theme";

export default function AppLayout() {
  return (
    <NativeTabs
      backgroundColor={colors.SurfaceNav}
      tintColor={colors.BorderFocused}
      iconColor={colors.TextTertiary}
      labelVisibilityMode="unlabeled"
    >
      <NativeTabs.Trigger name="index">
        <NativeTabs.Trigger.Label>Home</NativeTabs.Trigger.Label>
        <NativeTabs.Trigger.Icon
          sf={{ default: "house", selected: "house.fill" }}
          md="home"
        />
      </NativeTabs.Trigger>

      <NativeTabs.Trigger name="profile">
        <NativeTabs.Trigger.Label>Profile</NativeTabs.Trigger.Label>
        <NativeTabs.Trigger.Icon
          sf={{ default: "person", selected: "person.fill" }}
          md="person"
        />
      </NativeTabs.Trigger>
    </NativeTabs>
  );
}
