window.onload = init()

function init() {

    $(document).ready(function(){
        $('[data-bs-toggle="popover"]').popover();
    });
    
    
    function alterarMenusMantenimiento(tipo, padre, hijo, nombreMenu){
        
        console.log(tipo)
        console.log(padre)
        console.log(hijo)
        console.log(nombreMenu)
        
        let opciones = { method: "GET" };
        let parametros = "controlador=Seguridad&metodo=alterarMenusMantenimiento";
        parametros += "&tipo=" + tipo + "&padre=" + padre + "&hijo=" + hijo + "&nombreMenu=" + nombreMenu
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
    
    
    var botonesPopover = document.querySelectorAll(".botonPopoverPadre");
    
    botonesPopover.forEach(function(botonPopoverFinal) {
        botonPopoverFinal.addEventListener("click", function() {
            console.log(botonPopoverFinal)
            
            var tipo = botonPopoverFinal.getAttribute('data-custom-value1');
            var padre = botonPopoverFinal.getAttribute('data-custom-value2');
            var hijo = botonPopoverFinal.getAttribute('data-custom-value3');
        
            // Inicializa el popover de Bootstrap
            var popover = new bootstrap.Popover(botonPopoverFinal, {
                html: true,
                content: function() {
                    // Crea un elemento input
                    var input = document.createElement('input');
                    input.type = 'text';
                    input.placeholder = 'Introduce el nombre del menú';
        
                    // Crea un botón Bootstrap
                    var botonCrear = document.createElement('button');
                    botonCrear.setAttribute('type', 'button');
                    botonCrear.classList.add('btn', 'btn-primary');
                    botonCrear.textContent = 'Crear';
        
                    // Crea un contenedor div para el input
                    var container = document.createElement('div');
                    container.appendChild(input);
                    container.appendChild(botonCrear);
        
                    
                    botonCrear.addEventListener("click",function(){
        
                        popover.hide()
        
        
                        var elementosPadre = document.querySelectorAll('.padre');
                        var arrayDeElementosPadre = Array.from(elementosPadre);
        
                        // Crear el elemento div con la clase 'padre'
                        var divPadre = document.createElement('div');
                        divPadre.className = 'padre';
        
                        // Crear el div 'contenedorPadre'
                        var contenedorPadre = document.createElement('div');
                        contenedorPadre.className = 'contenedorPadre';
        
                        // Crear el primer bloque 'primerBloquePadre'
                        var primerBloquePadre = document.createElement('div');
                        primerBloquePadre.className = 'primerBloquePadre';
        
                        // Dentro de 'primerBloquePadre', añadir 'tituloMenu'
                        var tituloMenu = document.createElement('div');
                        tituloMenu.className = 'tituloMenu';
                        tituloMenu.textContent = input.value;
        
                        // Añadir 'añadirHijo'
                        var añadirHijo = document.createElement('div');
                        añadirHijo.className = 'añadirHijo';
                        añadirHijo.textContent = 'Añadir Hijo';
        
                        // Añadir los elementos creados al 'primerBloquePadre'
                        primerBloquePadre.appendChild(tituloMenu);
                        primerBloquePadre.appendChild(añadirHijo);
        
                        // Crear el segundo bloque 'segundoBloquePadre'
                        var segundoBloquePadre = document.createElement('div');
                        segundoBloquePadre.className = 'segundoBloquePadre';
        
                        // Dentro de 'segundoBloquePadre', añadir 'permisosMenu'
                        var permisosMenu = document.createElement('div');
                        permisosMenu.className = 'permisosMenu';

                        var permisoInicial = document.createElement('div');
                        permisoInicial.className = 'permiso';
                        permisoInicial.textContent = 'ver' + input.value;
        
                        // Añadir 'permisosMenu' al 'segundoBloquePadre'
                        permisosMenu.appendChild(permisoInicial);
                        segundoBloquePadre.appendChild(permisosMenu);
        
                        // Crear el tercer bloque 'tercerBloquePadre'
                        var tercerBloquePadre = document.createElement('div');
                        tercerBloquePadre.className = 'tercerBloquePadre';
        
                        // Dentro de 'tercerBloquePadre', añadir 'nuevoPermiso'
                        var nuevoPermiso = document.createElement('div');
                        nuevoPermiso.className = 'nuevoPermiso';
                        nuevoPermiso.textContent = 'Nuevo Permiso';
        
                        // Añadir 'borrarPadre'
                        var borrarPadre = document.createElement('div');
                        borrarPadre.className = 'borrarPadre';
        
                        // Crear el SVG y añadirlo a 'borrarPadre'
                        var svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
                        svg.setAttribute('height', '24');
                        svg.setAttribute('viewBox', '0 -960 960 960');
                        svg.setAttribute('width', '24');
                        svg.setAttribute('fill', 'red');
                        svg.innerHTML = '<path d="M280-120q-33 0-56.5-23.5T200-200v-520h-40v-80h200v-40h240v40h200v80h-40v520q0 33-23.5 56.5T680-120H280Zm400-600H280v520h400v-520ZM360-280h80v-360h-80v360Zm160 0h80v-360h-80v360ZM280-720v520-520Z"></path>';
                        borrarPadre.appendChild(svg);
        
                        // Añadir elementos al 'tercerBloquePadre'
                        tercerBloquePadre.appendChild(nuevoPermiso);
                        tercerBloquePadre.appendChild(borrarPadre);
        
                        // Añadir los bloques al 'contenedorPadre'
                        contenedorPadre.appendChild(primerBloquePadre);
                        contenedorPadre.appendChild(segundoBloquePadre);
                        contenedorPadre.appendChild(tercerBloquePadre);
        
                        // Crear 'espacioHijos' y añadirlo al 'divPadre'
                        var espacioHijos = document.createElement('div');
                        espacioHijos.className = 'espacioHijos';
                        divPadre.appendChild(contenedorPadre);
                        divPadre.appendChild(espacioHijos);
        
        
                        arrayDeElementosPadre.splice((padre-1), 0, divPadre);
        
                        var elementoReferencia = elementosPadre[(padre-1)];
        
                        if (elementoReferencia) {
                            elementoReferencia.parentNode.insertBefore(divPadre, elementoReferencia);
                        } else {
                            // Si elementoReferencia no está definido, simplemente agrega divPadre al final del cuerpo del documento
                            document.body.appendChild(divPadre);
                        }
        
        
                        // Crear el nuevo elemento 'nuevoPadre'
                        var nuevoPadre = document.createElement('div');
                        nuevoPadre.className = 'nuevoPadre';
        
                        // Crear el botón que irá dentro del 'nuevoPadre'
                        var boton = document.createElement('button');
                        boton.setAttribute('type', 'button');
                        boton.className = 'botonPopoverPadre';
                        boton.setAttribute('data-bs-toggle', 'popover');
                        boton.setAttribute('data-bs-content', 'asdf');
                        boton.dataset.customValue1 = '1';
                        boton.dataset.customValue2 = '1';
                        boton.dataset.customValue3 = '1';
                        
                        // Crear el SVG que irá dentro del botón
                        var svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
                        svg.setAttribute('height', '24');
                        svg.setAttribute('viewBox', '0 -960 960 960');
                        svg.setAttribute('width', '24');
                        svg.innerHTML = '<path d="M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160Zm40 200q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z"></path>';
        
                        // Añadir el SVG al botón
                        boton.appendChild(svg);
        
                        // Añadir el botón al 'nuevoPadre'
                        nuevoPadre.appendChild(boton);
                        
                        var elementoReferencia = elementosPadre[padre-1]; 
        
                        elementoReferencia.parentNode.insertBefore(nuevoPadre,elementoReferencia)
                        
                        //RESETEAR LOS CUSTOM-VALUES
                        
                        var customValuesPadre = document.querySelectorAll(".botonPopoverPadre");
    
    
                        for (let index = 0; index < customValuesPadre.length; index++) {
                            customValuesPadre[index].setAttribute('data-custom-value2', (index + 1));
                        }

                        var padres = document.querySelectorAll(".padre");

                        for (let index = 0; index < padres.length; index++) {
                            var hijos = padres[index].querySelectorAll(".botonPopoverHijo")
                            for (let index2 = 0; index2 < hijos.length; index2++) {
                                hijos[index2].setAttribute('data-custom-value2', (index + 1));
                            }
                        }



                        //REALIZAR CONSULTA/S
                        alterarMenusMantenimiento(tipo,padre,hijo,input.value)
                        
                        //RECARGAR JS
                        init();
                        
                    })
                    return container;
                }
            });
        });
    })
    
}

/* <div class="nuevoPadre">            <button type="button" id="botonPopoverPadre" data-bs-toggle="popover" title="" data-bs-content="asdf" data-custom-value1="1" data-custom-value2="1" data-custom-value3="1" data-bs-original-title="Nombre del menu">
                <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24"><path d="M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160Zm40 200q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z"></path></svg>
</button> 

</div>                
<div class="padre">
                
    <div class="contenedorPadre">
        <div class="primerBloquePadre">
            <div class="tituloMenu">Home</div>
            <div class="añadirHijo">Añadir Hijo</div>
        </div>
        <div class="segundoBloquePadre">
            <div class="permisosMenu">
                    
                    Este menu no tiene permisos asociados
                                            </div>
        </div>
        <div class="tercerBloquePadre">
            <div class="nuevoPermiso">Nuevo Permiso</div>
            <div class="borrarPadre">
                <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="red"><path d="M280-120q-33 0-56.5-23.5T200-200v-520h-40v-80h200v-40h240v40h200v80h-40v520q0 33-23.5 56.5T680-120H280Zm400-600H280v520h400v-520ZM360-280h80v-360h-80v360Zm160 0h80v-360h-80v360ZM280-720v520-520Z"></path></svg>
            </div>
        </div>
    
    </div>
    
    <div class="espacioHijos">

    </div>
</div>  */
