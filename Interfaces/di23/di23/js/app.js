window.onload = peticionMenu("Menu", "recuperarMenuController")

function cargarUnScript(url){
    let script = document.createElement('script');
    script.src = url;
    document.head.appendChild(script);
    script.defer = true;
    script.type = "module";
}
function returnHomePage() {
    window.location = "index.php"
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
            cargarUnScript('js/Paginado.js');
        })
        .catch(err => {
            console.log("Error al realizar la peticion.", err.message);
        });
}

function peticionMenu(controlador, metodo) {
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

            document.getElementById("secMenuPagina").innerHTML = vista;
            cargarUnScript('js/'+controlador+'.js');

        })
        .catch(err => {
            console.log("Error al realizar la peticion.", err.message);
        });
}




