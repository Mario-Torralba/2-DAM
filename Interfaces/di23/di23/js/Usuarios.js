function buscarUsuarios(){
    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=buscarUsuarios";
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscar"))).toString();
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('Respuesta ok');
                return res.text();
            }
        })
        .then(vista => {

            document.getElementById("capaResultadosBusqueda").innerHTML = vista;
        })
        .catch(err => {
            console.log("Error al realizar la peticion.", err.message);
        });
}

function borrarUsuarios(id){

    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=borrarUsuarios";
    parametros += "&id=" + id;
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('Respuesta ok');
                // return res.text();
                console.log(res.text());
            }
        })
        .then(vista => {

            document.getElementById("capaResultadosBusqueda").innerHTML = "EL USUARIO HA SIDO BORRADO";
        })
        .catch(err => {
            console.log("Error al realizar la peticion.", err.message);
        });
}

function crearUsuarios(){

    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=crearUsuarios";
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioCrear"))).toString();
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('Respuesta ok');
                res.text();
            }
        })
        .then(vista => {

            document.getElementById("capaResultadosBusqueda").innerHTML = "SE HA AÑADIDO EL USUARIO";
        })
        .catch(err => {
            console.log("Error al realizar la peticion.", err.message);
        });

}