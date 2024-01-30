let botonBuscar = document.getElementById("desplegarFormularioBuscar") 
let botonCrear = document.getElementById("desplegarFormularioCrear") 
let formBuscar = document.getElementById("formularioBusquedaMenu") 
let formCrear = document.getElementById("formularioCrearMenu") 

function funcionDisplay3(){
    if(formBuscar.style.display == "flex"){
        formBuscar.style.display = "none"
    }else{
        formBuscar.style.display = "flex"
    }
    if(formCrear.style.display == "flex"){
        formCrear.style.display = "none"
    }
}

function funcionDisplay4(){
    if(formBuscar.style.display == "flex"){
        formBuscar.style.display = "none"
    }
    if(formCrear.style.display == "flex"){
        formCrear.style.display = "none"
    }else{
        formCrear.style.display = "flex"
    }
}
