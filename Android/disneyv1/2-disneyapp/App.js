import 'react-native-gesture-handler'

import { StyleSheet, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import NavigationStacks from './src/navigation/NavigationStacks';
import NavigationTabs from './src/navigation/NavigationTabs';

export default function App() {
  // return <PokemonList /> 
  return(
    // <View>
    //   <LoginForm name="Mario Torralba Pardos" surname="AA"/>
    //   <LoginForm name="PEPO PEPO PEPO" surname="AB"/>
    //   <LoginForm name="PEPE PEPE PEPE" surname="AC"/>
    //   <LoginForm name="PEPU PEPU PEPU" surname="AD"/>
    // </View>
    <NavigationContainer>
      {/* <NavigationStacks/> */}
      <NavigationTabs/>
    </NavigationContainer>
  );
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
