import { View, Text } from 'react-native'
import React from 'react'

export default function LoginForm(props) {
    console.log(props);
    const {name, surname} = props;
  return (
    <View>
      <Text>LoginForm {name} {surname}</Text>
      <Text>LoginForm</Text>
      <Text>LoginForm</Text>
    </View>
  )
}