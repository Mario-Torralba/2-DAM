let botonBuscarMenu = document.getElementById("desplegarFormularioBuscarMenu") 
let botonCrearMenu = document.getElementById("desplegarFormularioCrearMenu") 
let formBuscarMenu = document.getElementById("formularioBusquedaMenu") 
let formCrearMenu = document.getElementById("formularioCrearMenu") 

botonBuscarMenu.addEventListener('click',function(){

    if(formBuscarMenu.style.display == "flex"){
        formBuscarMenu.style.display = "none"
    }else{
        formBuscarMenu.style.display = "flex"
    }
    if(formCrearMenu.style.display == "flex"){
        formCrearMenu.style.display = "none"
    }

})

botonCrearMenu.addEventListener('click',function(){

    if(formBuscarMenu.style.display == "flex"){
        formBuscarMenu.style.display = "none"
    }
    if(formCrearMenu.style.display == "flex"){
        formCrearMenu.style.display = "none"
    }else{
        formCrearMenu.style.display = "flex"
    }

})


function buscarMenus(){


    if(formBuscarMenu.style.display == "flex"){
        formBuscarMenu.style.display = "none"
    }else{
        formBuscarMenu.style.display = "flex"
    }
    if(formCrearMenu.style.display == "flex"){
        formCrearMenu.style.display = "none"
    }

    let opciones = { method: "GET" };
    let parametros = "controlador=Seguridad&metodo=buscarMenus";
    parametros += "&" + new URLSearchParams(new FormData(document.getElementById("formularioBuscarMenu"))).toString();
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
            cargarUnScript('js/SeguridadMantenimiento.js');
        })
        .catch(err => {
            console.log("Error al realizar la peticion.", err.message);
        });
    

}

