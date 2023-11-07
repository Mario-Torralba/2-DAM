function buscarUsuarios(){
    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=buscarUsuarios";
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscar"))).toString();
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('Respuesta ok');
                console.log(res.text());
            }
        })
        .then(vista => {

            document.getElementById("capaResultadosBusqueda").innerHTML = vista;
        })
        .catch(err => {
            console.log("Error al realizar la peticion.", err.message);
        });
}

function borrarUsuarios(){
    alert("hola")
    // let opciones = { method: "GET" };
    // let parametros = "controlador=Usuarios&metodo=borrarUsuarios";
    // parametros += "&" + id;
    // fetch("C_Ajax.php?" + parametros, opciones)
    //     .then(res => {
    //         if (res.ok) {
    //             console.log('Respuesta ok');
    //             return res.text();
    //         }
    //     })
    //     .then(vista => {

    //         document.getElementById("capaResultadosBusqueda").innerHTML = vista;
    //     })
    //     .catch(err => {
    //         console.log("Error al realizar la peticion.", err.message);
    //     });
}

function crearUsuarios(){

    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=crearUsuarios";
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioCrear"))).toString();
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('Respuesta ok');
                console.log(res.text());
            }
        })
        .then(vista => {

            document.getElementById("capaResultadosBusqueda").innerHTML = "SE HA AÑADIDO EL USUARIO";
        })
        .catch(err => {
            console.log("Error al realizar la peticion.", err.message);
        });

}