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

