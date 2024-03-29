import React, { useState, useEffect } from "react";
import { StyleSheet, Text } from "react-native";
import { getPokemonsApi } from "../api/disney";
import PokemonList1 from "../screens/PokemonList1";
import { SafeAreaView } from "react-native-safe-area-context";

export default function Pokedex() {
  const [peliculas, setPeliculas] = useState([]);
  //console.log("pokemons--->", pokemons);

  useEffect(() => {
    (async () => {
      await loadPokemons();
    })();
  }, []);

  const loadPokemons = async () => {
    try {
      const response = await getPokemonsApi();

      const peliculasArray = [];
      for (const pelicula of response) {

        console.log("pelicula--->", pelicula);
        peliculasArray.push({
          id: pelicula.id,
          name: pelicula.titulo,
          imagen: pelicula.imagen,
        });
      }
      setPeliculas([...peliculas, ...peliculasArray]);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <SafeAreaView style={styles.container}>
      <PokemonList1 peliculas={peliculas} />
    </SafeAreaView>
  );
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    marginTop: 0,
  },
  item: {
    backgroundColor: "#f9c2ff",
    padding: 20,
    marginVertical: 8,
    marginHorizontal: 16,
  },
  title: {
    fontSize: 16,
  },
});		