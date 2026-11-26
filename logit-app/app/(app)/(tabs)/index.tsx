import { View, StyleSheet, ScrollView, Button } from "react-native";
import { globalStyles } from "../../../globalStyles";
import { useAuthStore } from "../../../stores/auth";
import LongButton from "../../../components/LongButton";
import { colors } from "../../../theme";
import { useSafeAreaInsets } from "react-native-safe-area-context";
import { AppText } from "../../../components/AppText";
import { useRouter } from "expo-router";

const MEALS = ["Breakfast", "Lunch", "Dinner", "Snacks"];

export default function Home() {
  const insets = useSafeAreaInsets();
  const router = useRouter();
  const signOut = useAuthStore((s) => s.signOut);

  return (
    <View style={[globalStyles.defaultContainer]}>
      <ScrollView style={[styles.scrollContent, { paddingTop: insets.top }]}>
        <View style={styles.food}>
          <View style={styles.titleContent}>
            <AppText style={styles.title}>Meals</AppText>
          </View>

          {MEALS.map((meal, index) => (
            <View
              key={meal}
              style={[
                styles.mealSection,
                index < MEALS.length - 1 && styles.mealDivider,
              ]}
            >
              <AppText style={styles.mealTitle}>{meal}</AppText>
              <AppText style={styles.emptyText}>No food added yet</AppText>
            </View>
          ))}
        </View>
        {/* rest of your scrollable content */}
      </ScrollView>
      <View>
        <LongButton
          text="Add Food"
          color="#175DDC"
          textColor="#fff"
          onPress={() => router.push("/AddFood")}
        ></LongButton>
      </View>
      {/* <Button title="Sign out" onPress={signOut} /> */}
    </View>
  );
}

const styles = StyleSheet.create({
  scrollContent: {
    flex: 1,
  },
  food: {
    borderRadius: 10,
    backgroundColor: colors.SurfaceNav,
    overflow: "hidden",
  },
  titleContent: {
    backgroundColor: colors.SurfaceInput,
    borderBottomWidth: 1,
    borderColor: colors.BorderSubtle,
  },
  title: {
    color: "#fff",
    fontSize: 20,
    fontWeight: "bold",
    paddingVertical: 10,
    paddingLeft: 15,
  },
  mealSection: {
    paddingVertical: 12,
    paddingHorizontal: 15,
  },
  mealDivider: {
    borderBottomWidth: 1,
    borderColor: colors.BorderSubtle,
  },
  mealTitle: {
    color: "#fff",
    fontSize: 16,
    fontWeight: "600",
  },
  emptyText: {
    color: "#888",
    fontSize: 13,
    marginTop: 4,
  },
});
