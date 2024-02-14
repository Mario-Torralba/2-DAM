import { View, Text, Button, SafeAreaView } from "react-native";
import React from "react";

export default function HomeScreen(props) {
  console.log(props);
  return (
    <SafeAreaView>
      <Text>HomeScreen</Text>
      <Text>HomeScreen</Text>
      <Text>HomeScreen</Text>
      <Text>HomeScreen</Text>
      <Text>HomeScreen</Text>
      <Button
        title="Go to Home"
        onPress={() => props.navigation.navigate("Home")}
        //ArrayFunction para que se ejecute cuando lo pulsamos
      ></Button>
    </SafeAreaView>
  );
}
