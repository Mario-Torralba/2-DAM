function paginado(cantidadFilas) {
    let opciones = { method: "GET" };
    let parametros = "controlador=Paginado&metodo=getVistaPaginado&cantidadFilas=" + cantidadFilas;
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('Respuesta ok');
                return res.text();
            }
        })
        .then(vista => {
            document.getElementById("paginado").innerHTML = vista;
        })
        .catch(err => {
            console.log("Error al realizar la peticion.", err.message);
        });
}

let aleatorio = document.getElementById("aleatorio")

aleatorio.addEventListener("load",function(){

    alert("aaaa")

})