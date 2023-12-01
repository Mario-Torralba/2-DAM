let botonBuscar = document.getElementById("desplegarFormularioBuscar") 
let botonCrear = document.getElementById("desplegarFormularioCrear") 
let formBuscar = document.getElementById("formularioBusqueda") 
let formCrear = document.getElementById("formularioCrear") 

function funcionDisplay1(){
    if(formBuscar.style.display == "flex"){
        formBuscar.style.display = "none"
    }else{
        formBuscar.style.display = "flex"
    }
    if(formCrear.style.display == "flex"){
        formCrear.style.display = "none"
    }
}

function funcionDisplay2(){
    if(formBuscar.style.display == "flex"){
        formBuscar.style.display = "none"
    }
    if(formCrear.style.display == "flex"){
        formCrear.style.display = "none"
    }else{
        formCrear.style.display = "flex"
    }
}

function buscarUsuarios(paginaActual, cantidadEntradas){

    if(paginaActual==0 && cantidadEntradas==0){
        let paginaActualNueva = document.getElementById("paginaActual").value
        let cantidadEntradaNueva = document.getElementById("cantidadEntradas").value
    
        if(paginaActualNueva!=0){
            paginaActual = paginaActualNueva;
        }
        if(cantidadEntradaNueva!=0){
            cantidadEntradas = cantidadEntradaNueva;
        }
    }
    if(paginaActual==0 && cantidadEntradas!=0){
        
        let opciones = { method: "GET" };
        let parametros = "controlador=Usuarios&metodo=buscarUsuarios" + "&cantidadEntradas=" + cantidadEntradas;
        parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscar"))).toString();
        console.log(parametros)
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
    if(paginaActual!=0 && cantidadEntradas==0){
        
        let opciones = { method: "GET" };
        let parametros = "controlador=Usuarios&metodo=buscarUsuarios" + "&paginaActual=" + paginaActual;
        parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscar"))).toString();
        console.log(parametros)
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

    if(paginaActual!=0 && cantidadEntradas!=0){

        let opciones = { method: "GET" };
        let parametros = "controlador=Usuarios&metodo=buscarUsuarios" + "&paginaActual=" + paginaActual  + "&cantidadEntradas=" + cantidadEntradas;
        parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscar"))).toString();
        console.log(parametros)
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
}

function buscarUsuariosTotales(){
    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=buscarUsuariosTotales";
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscar"))).toString();
    console.log(parametros)
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('Respuesta ok');
                return res.text();
            }
        })
        .catch(err => {
            console.log("Error al realizar la peticion.", err.message);
        });
}

function borrarUsuarios(id){

    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=borrarUsuarios";
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscar"))).toString();
    parametros += "&id=" + id;
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

function crearUsuarios(){

    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=crearUsuarios";
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioCrear2"))).toString();
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('Respuesta ok');
                res.text();
            }
        })
        .then(vista => {

            document.getElementById("capaResultadosBusqueda").innerHTML = vista;
        })
        .catch(err => {
            console.log("Error al realizar la peticion.", err.message);
        });

}

function editarUsuarios(id){

    
    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=editarUsuarios";
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscar"))).toString();
    parametros += "&id=" + id;
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

function confirmarEditarUsuarios(id){


    let nombre = document.getElementById("nombre_editar")
    let apellido_1 = document.getElementById("apellido_1_editar")
    let apellido_2 = document.getElementById("apellido_2_editar")
    let email = document.getElementById("email_editar")
    let activo = document.getElementById("activo_editar")


    let opciones = { method: "GET" };
    let parametros = "controlador=Usuarios&metodo=confirmarEditarUsuarios";
    parametros += "&id=" + id;
    parametros += "&nombre_editar=" + nombre.value;
    parametros += "&apellido_1_editar=" + apellido_1.value;
    parametros += "&apellido_2_editar=" + apellido_2.value;
    parametros += "&email_editar=" + email.value;
    parametros += "&activo_editar=" + activo.value;
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscar"))).toString();
    console.log(parametros)
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
