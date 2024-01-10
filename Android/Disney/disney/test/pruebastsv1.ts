let promesaDeDatos = new Promise(function(resolve, reject) {
	// Imagina que estamos cargando datos de internet aquí
	if (/* los datos se cargaron correctamente */) {
    	resolve(datos); // La promesa se cumple, y entregamos los datos
	} else {
    	reject('Error'); // La promesa falla, y reportamos un error
	}
});
