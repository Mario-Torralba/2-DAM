const API_HOST = "http://192.168.104.59:300/peliculas"
export async function getPokemonsApi() {
  try {
    // const url = `${API_HOST}/pokemon?limit=20&offset=0`;
    const url = `${API_HOST}`;
    console.log(url);
    // http://localhost:300/peliculas/
    const response = await fetch(url);
    const result = await response.json();
    console.log(result);
    return result;


  } catch (error) {
    throw error;
  }
}

export async function getPokemonDetailsByUrlApi(url) {
  try {
    const response = await fetch(url);
    const result = await response.json();
    return result;
  } catch (error) {
    throw error;
  }
}