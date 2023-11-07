document.addEventListener("DOMContentLoaded", initComponents);

function initComponents(){
    let botonBuscar = document.getElementById("desplegarFormularioBuscar") 
    let botonCrear = document.getElementById("desplegarFormularioCrear") 
    let formBuscar = document.getElementById("formularioBusqueda") 
    let formCrear = document.getElementById("formularioCrear") 

    botonBuscar.addEventListener("click", function(){
        if(formBuscar.style.display == "inline"){
            formBuscar.style.display = "none"
        }else{
            formBuscar.style.display = "inline"
        }
        if(formCrear.style.display == "inline"){
            formCrear.style.display = "none"
        }
    })

    botonCrear.addEventListener("click", function(){
        if(formBuscar.style.display == "inline"){
            formBuscar.style.display = "none"
        }
        if(formCrear.style.display == "inline"){
            formCrear.style.display = "none"
        }else{
            formCrear.style.display = "inline"
        }
    })
}


function cargarUnScript(url){
    let script = document.createElement('script');
    script.src = url;
    document.head.appendChild(script);
    script.defer = true;
    script.type = "module";
}

function peticion(controlador, metodo) {
    let opciones = { method: "GET" };
    let parametros = "controlador=" + controlador + "&metodo=" + metodo;
    fetch("C_Ajax.php?" + parametros, opciones)
        .then(res => {
            if (res.ok) {
                console.log('Respuesta ok');
                return res.text();
            }
        })
        .then(vista => {

            document.getElementById("secContenidoPagina").innerHTML = vista;
            cargarUnScript('js/'+controlador+'.js');
        })
        .catch(err => {
            console.log("Error al realizar la peticion.", err.message);
        });
}



