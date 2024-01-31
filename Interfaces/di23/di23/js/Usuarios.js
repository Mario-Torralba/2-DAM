let botonBuscar = document.getElementById("desplegarFormularioBuscar") 
let botonCrear = document.getElementById("desplegarFormularioCrear") 
let formBuscar = document.getElementById("formularioBusqueda") 
let formCrear = document.getElementById("formularioCrear") 

let nombre = document.getElementById("nombre_crear");
let apellido1 = document.getElementById("apellido_1_crear");
let apellido2 = document.getElementById("apellido_2_crear");
let usuario = document.getElementById("login_crear");
let contraseña = document.getElementById("pass_crear");

botonBuscar.addEventListener("click", function(){
    if(formBuscar.style.display == "flex"){
        formBuscar.style.display = "none"
    }else{
        formBuscar.style.display = "flex"
    }
    if(formCrear.style.display == "flex"){
        formCrear.style.display = "none"
    }
});
botonCrear.addEventListener("click", function(){
    if(formBuscar.style.display == "flex"){
        formBuscar.style.display = "none"
    }
    if(formCrear.style.display == "flex"){
        formCrear.style.display = "none"
    }else{
        formCrear.style.display = "flex"
    }
});


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
function validarNuevoUsuario(){

    let mensajeNombre;
    let mensajeApellido1;
    let mensajeApellido2;
    let mensajeUsuario;
    let mensajeContraseña;

    let mensajeNombreCorrecto;
    let mensajeApellido1Correcto;
    let mensajeApellido2Correcto;
    let mensajeUsuarioCorrecto;
    let mensajeContraseñaCorrecto;

    if(nombre.value == ""){
        mensajeNombre = "Campo vacío"
    }else{
        if(nombre.value.length<2){
            mensajeNombre = "Mínimo 2 carácteres"
        }else{
            mensajeNombreCorrecto = true;
        }
    }

    if(apellido1.value == ""){
        mensajeApellido1 = "Campo vacío"
    }else{
        if(apellido1.value.length<2){
            mensajeApellido1 = "Mínimo 2 carácteres"
        }else{
            mensajeApellido1Correcto = true;
        }
    }

    if(apellido2.value == ""){
        mensajeApellido2 = "Campo vacío"
    }else{
        if(apellido2.value.length<2){
            mensajeApellido2 = "Mínimo 2 carácteres"
        }else{
            mensajeApellido2Correcto = true;
        }
    }

    if(usuario.value == ""){
        mensajeUsuario = "Campo vacío"
    }else{
        if(usuario.value.length<2){
            mensajeUsuario = "Mínimo 2 carácteres"
        }else{
            mensajeUsuarioCorrecto = true;
        }
    }

    let contieneMayuscula = /[A-Z]/.test(contraseña.value);
    let contieneNumero = /[0-9]/.test(contraseña.value);

    if(contraseña.value == ""){
        mensajeContraseña = "Campo vacío"
    }else{
        if(contraseña.value.length<6){
            mensajeContraseña = "Mínimo 6 carácteres"
            if(!contieneMayuscula){
                mensajeContraseña += ", 1 mayúscula"
                if(!contieneNumero){
                    mensajeContraseña += " , 1 número"
                }
            }else{
                if(!contieneNumero){
                    mensajeContraseña += " , 1 número"
                }
            }
        }else{
            if(!contieneMayuscula){
                mensajeContraseña = "Mínimo 1 mayúscula"
                if(!contieneNumero){
                    mensajeContraseña += " y 1 número"
                }
            }else{
                if(!contieneNumero){
                    mensajeContraseña += "Mínimo 1 número"
                }else{
                    mensajeContraseñaCorrecto = true
                }
            }
        }
    }

    if(nombre.value=="Campo vacío" || nombre.value=="undefined"){
        mensajeNombreCorrecto = false;
    }

    if(apellido1.value=="Campo vacío" || apellido1.value=="undefined"){
        mensajeApellido1Correcto = false;
    }

    if(apellido2.value=="Campo vacío" || apellido2.value=="undefined"){
        mensajeApellido2Correcto = false;
    }

    if(usuario.value=="Campo vacío" || nombre.value=="undefined"){
        mensajeUsuarioCorrecto = false;
    }

    if(contraseña.value=="Campo vacío" || contraseña.value=="undefinedMínimo 1 número"){
        mensajeContraseñaCorrecto = false;
    }


    if(mensajeNombreCorrecto&&mensajeApellido1Correcto&&mensajeApellido2Correcto&&mensajeUsuarioCorrecto&&mensajeContraseñaCorrecto){
        formCrear.style.display = "none"
    }else{

        if(!mensajeNombreCorrecto){
            nombre.value= mensajeNombre;
            nombre.style.color = "red"
            nombre.style.borderBottom = "2px solid red"
        }

        if(!mensajeApellido1Correcto){
            apellido1.value= mensajeApellido1;
            apellido1.style.color = "red"
            apellido1.style.borderBottom = "2px solid red"
        }

        if(!mensajeApellido2Correcto){
            apellido2.value= mensajeApellido2;
            apellido2.style.color = "red"
            apellido2.style.borderBottom = "2px solid red"
        }

        if(!mensajeUsuarioCorrecto){
            usuario.value= mensajeUsuario;
            usuario.style.color = "red"
            usuario.style.borderBottom = "2px solid red"
        }

        if(!mensajeContraseñaCorrecto){
            contraseña.setAttribute("type", "text")
            contraseña.value = mensajeContraseña;
            contraseña.style.color = "red"
            contraseña.style.borderBottom = "2px solid red"
        }

        errorGarrafal();
    }
}

nombre.addEventListener("focus",function(){
    nombre.value = ""
    nombre.style.color = "black"
    nombre.style.borderBottom = "1px solid rgb(51, 133, 226)"
})
apellido1.addEventListener("focus",function(){
    apellido1.value = ""
    apellido1.style.color = "black"
    apellido1.style.borderBottom = "1px solid rgb(51, 133, 226)"
})
apellido2.addEventListener("focus",function(){
    apellido2.value = ""
    apellido2.style.color = "black"
    apellido2.style.borderBottom = "1px solid rgb(51, 133, 226)"
})
usuario.addEventListener("focus",function(){
    usuario.value = ""
    usuario.style.color = "black"
    usuario.style.borderBottom = "1px solid rgb(51, 133, 226)"
})
contraseña.addEventListener("focus",function(){
    contraseña.setAttribute("type","password")
    contraseña.value = ""
    contraseña.style.color = "black"
    contraseña.style.borderBottom = "1px solid rgb(51, 133, 226)"
})
