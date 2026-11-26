import { StyleSheet, View } from "react-native";
import { AppText } from "../../components/AppText";
import { globalStyles } from "../../globalStyles";
import { useSafeAreaInsets } from "react-native-safe-area-context";
import { colors } from "../../theme";
import { KeyboardAwareScrollView } from "react-native-keyboard-controller";
import TextInputField from "../../components/TextInputField";
import { useState } from "react";
import LongButton from "../../components/LongButton";

export default function AddFood() {
  const insets = useSafeAreaInsets();
  const [footerHeight, setFooterHeight] = useState(0);

  const [name, setName] = useState<string>("");
  const [brand, setBrand] = useState<string>("");
  const [amount, setAmount] = useState<string>("");
  const [protein, setProtein] = useState<string>("");
  const [carbs, setCarbs] = useState<string>("");
  const [fat, setFat] = useState<string>("");
  return (
    <View style={[globalStyles.defaultContainer, { paddingTop: insets.top }]}>
      <AppText style={styles.title}>Add Food</AppText>
      <KeyboardAwareScrollView
        keyboardShouldPersistTaps="handled"
        contentContainerStyle={{ paddingBottom: 20 }}
        bottomOffset={20}
        extraKeyboardSpace={-footerHeight}
        showsVerticalScrollIndicator={false}
      >
        <View style={styles.card}>
          <TextInputField
            label="Name"
            placeholder="Greek Yogurt"
            value={name}
            onChangeText={setName}
          ></TextInputField>
          <TextInputField
            label="Brand"
            placeholder="Chobani"
            value={brand}
            onChangeText={setBrand}
          ></TextInputField>
        </View>
        <View style={styles.card}>
          <AppText style={styles.cardTitle}>Nutrition</AppText>
          <TextInputField
            label="Amount the label is based on"
            placeholder="100"
            value={amount}
            onChangeText={setAmount}
            unit="g"
          ></TextInputField>
          <TextInputField
            label="Protein"
            placeholder="100"
            value={protein}
            onChangeText={setProtein}
            unit="g"
          ></TextInputField>
          <TextInputField
            label="Carbs"
            placeholder="100"
            value={carbs}
            onChangeText={setCarbs}
            unit="g"
          ></TextInputField>
          <TextInputField
            label="Fat"
            placeholder="100"
            value={fat}
            onChangeText={setFat}
            unit="g"
          ></TextInputField>
        </View>
      </KeyboardAwareScrollView>
      <View
        onLayout={(e) => setFooterHeight(e.nativeEvent.layout.height)}
        style={{
          paddingBottom: insets.bottom,
          paddingTop: 10,
          borderTopWidth: StyleSheet.hairlineWidth,
          borderTopColor: colors.SurfaceNav,
        }}
      >
        <LongButton text="Save Food" color="#175DDC" textColor="#FFF" />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  title: {
    color: "#fff",
    fontSize: 24,
    fontWeight: "bold",
  },
  card: {
    backgroundColor: colors.SurfaceNav,
    borderRadius: 10,
    padding: 15,
    marginBottom: 3,
    marginTop: 15,
  },
  cardTitle: {
    color: "#fff",
    fontSize: 16,
    marginBottom: 10,
  },
});
