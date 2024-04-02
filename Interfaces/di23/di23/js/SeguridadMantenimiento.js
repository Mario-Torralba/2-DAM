window.onload = init();

function alterarMenusMantenimiento(tipo, padre, hijo, nombreMenu) {
  console.log(tipo);
  console.log(padre);
  console.log(hijo);
  console.log(nombreMenu);

  let opciones = { method: "GET" };
  let parametros = "controlador=Seguridad&metodo=alterarMenusMantenimiento";
  parametros +=
    "&tipo=" +
    tipo +
    "&padre=" +
    padre +
    "&hijo=" +
    hijo +
    "&nombreMenu=" +
    nombreMenu;
  console.log(parametros);
  fetch("C_Ajax.php?" + parametros, opciones)
    .then((res) => {
      if (res.ok) {
        console.log("Respuesta ok");
        return res.text();
      }
    })
      .then((vista) => {
        document.getElementById("capaResultadosBusqueda").innerHTML = vista;
      })
    .catch((err) => {
      console.log("Error al realizar la peticion.", err.message);
    });
}

function borrarPermisoPadre(custom1, custom2, custom3, nombrePermiso) {

  var padres = document.querySelectorAll(".padre")
  var permisos = padres[custom2-1].querySelectorAll(".permiso")
  var permisosMenu = padres[custom2-1].querySelector(".permisosMenu")

  for (let index = 0; index < permisos.length; index++) {
    if(permisos[index].textContent.trim() == nombrePermiso){
      permisosMenu.removeChild(permisos[index])
    }
  }

  //REALIZAR CONSULTA/S
  alterarMenusMantenimiento(custom1, custom2, custom3, nombrePermiso);

  //RECARGAR JS
  init();

}

function borrarPermisoHijo(custom1, custom2, custom3, nombrePermiso) {

  var padres = document.querySelectorAll(".padre")
  var hijos = padres[custom2-1].querySelectorAll(".tamañoHijo")
  console.log(hijos)
  var permisosMenu = hijos[custom3-1].querySelector(".permisosMenuHijos")
  console.log(permisosMenu)
  var permisosHijos = hijos[custom3-1].querySelectorAll(".permiso")

  for (let index = 0; index < permisosHijos.length; index++) {
    if(permisosHijos[index].textContent.trim() == nombrePermiso){
      permisosMenu.removeChild(permisosHijos[index])
    }
  }

  //REALIZAR CONSULTA/S
  alterarMenusMantenimiento(custom1, custom2, custom3, nombrePermiso);

  //RECARGAR JS
  init();

}

function añadirHijo(custom1, custom2, custom3) {
  let padres = document.querySelectorAll(".padre");
  let padre = padres[custom2 - 1];
  let inputAñadirHijo = padre.querySelectorAll(".inputAñadirHijo");


  let boton = document.createElement("button");
  boton.setAttribute("type", "button");
  boton.classList.add("botonPopoverHijo");
  boton.setAttribute("data-bs-toggle", "popover");
  boton.setAttribute("title", "Nombre del menu");
  boton.setAttribute("data-bs-content", "");
  boton.setAttribute("data-custom-value1", "2");
  boton.setAttribute("data-custom-value2", custom2);
  boton.setAttribute("data-custom-value3", "1");

  // Creación del icono dentro del botón
  let svgIcono = document.createElementNS("http://www.w3.org/2000/svg", "svg");
  svgIcono.setAttribute("xmlns", "http://www.w3.org/2000/svg");
  svgIcono.setAttribute("height", "24");
  svgIcono.setAttribute("viewBox", "0 -960 960 960");
  svgIcono.setAttribute("width", "24");

  let pathIcono = document.createElementNS(
    "http://www.w3.org/2000/svg",
    "path"
  );
  pathIcono.setAttribute(
    "d",
    "M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160Zm40 200q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z"
  );
  svgIcono.appendChild(pathIcono);

  boton.appendChild(svgIcono);

  // Creación del contenedor del botón
  let contenedorBoton = document.createElement("div");
  contenedorBoton.classList.add("nuevoHijo");
  contenedorBoton.appendChild(boton);

  let boton2 = document.createElement("button");
  boton2.setAttribute("type", "button");
  boton2.classList.add("botonPopoverHijo");
  boton2.setAttribute("data-bs-toggle", "popover");
  boton2.setAttribute("title", "Nombre del menu");
  boton2.setAttribute("data-bs-content", "");
  boton2.setAttribute("data-custom-value1", "2");
  boton2.setAttribute("data-custom-value2", custom2);
  boton2.setAttribute("data-custom-value3", "1");

  // Creación del icono dentro del botón
  let svgIcono2 = document.createElementNS("http://www.w3.org/2000/svg", "svg");
  svgIcono2.setAttribute("xmlns", "http://www.w3.org/2000/svg");
  svgIcono2.setAttribute("height", "24");
  svgIcono2.setAttribute("viewBox", "0 -960 960 960");
  svgIcono2.setAttribute("width", "24");

  let pathIcono2 = document.createElementNS(
    "http://www.w3.org/2000/svg",
    "path"
  );
  pathIcono2.setAttribute(
    "d",
    "M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160Zm40 200q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z"
  );
  svgIcono2.appendChild(pathIcono2);

  boton2.appendChild(svgIcono2);

  // Creación del contenedor del botón
  let contenedorBoton2 = document.createElement("div");
  contenedorBoton2.classList.add("nuevoHijo");
  contenedorBoton2.appendChild(boton2);

  // Creación del bloque de tamaño
  let tituloMenu = document.createElement("div");
  tituloMenu.classList.add("tituloMenuHijos");
  tituloMenu.textContent = inputAñadirHijo[0].value;

  let primerBloque = document.createElement("div");
  primerBloque.classList.add("primerBloqueHijo");
  primerBloque.appendChild(tituloMenu);

  let permiso = document.createElement("div");
  permiso.classList.add("permiso");
  permiso.textContent = "Ver" + inputAñadirHijo[0].value;

  let permisosMenu = document.createElement("div");
  permisosMenu.classList.add("permisosMenuHijos");
  permisosMenu.appendChild(permiso);

  let segundoBloque = document.createElement("div");
  segundoBloque.classList.add("segundoBloqueHijo");
  segundoBloque.appendChild(permisosMenu);

  let nuevoPermiso = document.createElement("div");
  nuevoPermiso.classList.add("nuevoPermiso");
  nuevoPermiso.textContent = "Nuevo Permiso";

  let borrarPadre = document.createElement("div");
  borrarPadre.classList.add("borrarHijo");

  let svgBorrar = document.createElementNS("http://www.w3.org/2000/svg", "svg");
  svgBorrar.setAttribute("xmlns", "http://www.w3.org/2000/svg");
  svgBorrar.setAttribute("height", "24");
  svgBorrar.setAttribute("viewBox", "0 -960 960 960");
  svgBorrar.setAttribute("width", "24");
  svgBorrar.setAttribute("fill", "red");

  let pathBorrar = document.createElementNS(
    "http://www.w3.org/2000/svg",
    "path"
  );
  pathBorrar.setAttribute(
    "d",
    "M280-120q-33 0-56.5-23.5T200-200v-520h-40v-80h200v-40h240v40h200v80h-40v520q0 33-23.5 56.5T680-120H280Zm400-600H280v520h400v-520ZM360-280h80v-360h-80v360Zm160 0h80v-360h-80v360ZM280-720v520-520Z"
  );
  svgBorrar.appendChild(pathBorrar);
  borrarPadre.appendChild(svgBorrar);

  let tercerBloque = document.createElement("div");
  tercerBloque.classList.add("tercerBloqueHijo");
  tercerBloque.appendChild(nuevoPermiso);
  tercerBloque.appendChild(borrarPadre);

  let tamañoHijo = document.createElement("div");
  tamañoHijo.classList.add("tamañoHijo");
  tamañoHijo.appendChild(primerBloque);
  tamañoHijo.appendChild(segundoBloque);
  tamañoHijo.appendChild(tercerBloque);

  // Agregar el contenedor del botón y el bloque de tamaño al cuerpo del documento

  var espaciosHijos = document.querySelectorAll(".espacioHijos");
  var espacioEspecifico = espaciosHijos[custom2 - 1];
  var elementosPadre = document.querySelectorAll(".padre");
  var espacios = espacioEspecifico.querySelectorAll(".tamañoHijo")
  if (espacios.length > 0) {
    var padreEspecifico = elementosPadre[custom2 - 1];

    var hijosArray = padreEspecifico.querySelectorAll(".tamañoHijo");
    var arrayDeElementosHijo = Array.from(hijosArray);

    var ultimoElemento = hijosArray[hijosArray.length - 1];

    if (ultimoElemento) {
      ultimoElemento.parentNode.appendChild(tamañoHijo);
    }
    hijosArray = padreEspecifico.querySelectorAll(".tamañoHijo");
    var ultimoElemento = hijosArray[hijosArray.length - 1];

    if (ultimoElemento) {
      ultimoElemento.parentNode.appendChild(contenedorBoton2);
    }
  } else {
    espacioEspecifico.appendChild(contenedorBoton)
    espacioEspecifico.appendChild(tamañoHijo);
    espacioEspecifico.appendChild(contenedorBoton2);
  }


  //RESETEAR LOS CUSTOM-VALUES

  for (let index = 0; index < elementosPadre.length; index++) {
    var customValuesHijoss =
      elementosPadre[index].querySelectorAll(".botonPopoverHijo");

    for (let index2 = 0; index2 < customValuesHijoss.length; index2++) {
      customValuesHijoss[index2].setAttribute("data-custom-value3", index2 + 1);
    }
  }

  let espacioHijos = document.querySelectorAll(".espacioHijos")
  for (let index = 0; index < espacioHijos.length; index++) {
    let botonesBorrarHijo = espacioHijos[index].querySelectorAll(".borrarHijo")
    for (let index2 = 0; index2 < botonesBorrarHijo.length; index2++) {
      botonesBorrarHijo[index2].setAttribute("onclick","borrarHijo(5,"+ (index+1) +", "+(index2+1) +")")
    }
  }

  //REALIZAR CONSULTA/S
  alterarMenusMantenimiento(custom1, custom2, custom3, inputAñadirHijo[0].value);

  //RECARGAR JS
  init();
}
function borrarHijo(custom1, custom2, custom3) {

  console.log(custom1)
  console.log(custom2)
  console.log(custom3)

  let elementosPadre = document.querySelectorAll(".padre") 
  let elementosHijo = elementosPadre[custom2-1].querySelectorAll(".tamañoHijo")
  let elementosHijoBoton = elementosPadre[custom2-1].querySelectorAll(".nuevoHijo")

  let espacioHijos2 = document.querySelectorAll(".espacioHijos")
  let espacioHijosEspecifico = espacioHijos2[custom2-1]

  console.log(elementosHijo)
  console.log(elementosHijoBoton)
  console.log(espacioHijosEspecifico)

  espacioHijosEspecifico.removeChild(elementosHijo[(custom3-1)])
  espacioHijosEspecifico.removeChild(elementosHijoBoton[(custom3-1)])


  elementosPadre = document.querySelectorAll(".padre") 

  for (let index = 0; index < elementosPadre.length; index++) {
    var customValuesHijoss = elementosPadre[index].querySelectorAll(".botonPopoverHijo");
    for (let index2 = 0;index2 < customValuesHijoss.length;index2++) {
      customValuesHijoss[index2].setAttribute("data-custom-value3",(index2+1))
    }
  }


  let espacioHijos = document.querySelectorAll(".espacioHijos")
  for (let index = 0; index < espacioHijos.length; index++) {
    let botonesBorrarHijo = espacioHijos[index].querySelectorAll(".borrarHijo")
    for (let index2 = 0; index2 < botonesBorrarHijo.length; index2++) {
      botonesBorrarHijo[index2].setAttribute("onclick","borrarHijo(5,"+ (index+1) +", "+(index2+1) +")")
    }
  }



  alterarMenusMantenimiento(custom1,custom2,custom3," ")

  init();

}

function borrarPadre(custom1, custom2, custom3) {

  let elementosPadre = document.querySelectorAll(".padre") 
  let elementosPadreCrear = document.querySelectorAll(".nuevoPadre") 
  let elementosPadreArray = Array.from(elementosPadre)
  let capaResultadosBusqueda = document.getElementById("capaResultadosBusqueda")
 
  capaResultadosBusqueda.removeChild(elementosPadre[custom2-1])
  capaResultadosBusqueda.removeChild(elementosPadreCrear[custom2-1])
    
  let botonesBorrarPadre = document.querySelectorAll(".borrarPadre")

  for (let index = 0; index < botonesBorrarPadre.length; index++) {
    botonesBorrarPadre[index].setAttribute("onclick","borrarPadre(4,"+(index+1)+",1)");
  }

  let botonesPopoverPadre = document.querySelectorAll(".botonPopoverPadre")

  for (let index = 0; index < botonesPopoverPadre.length; index++) {
    botonesPopoverPadre[index].setAttribute("data-custom-value2",(index+1))
  }

  elementosPadre = document.querySelectorAll(".padre") 

  for (let index = 0; index < elementosPadre.length; index++) {
    var customValuesHijoss = elementosPadre[index].querySelectorAll(".botonPopoverHijo");
    for (let index2 = 0;index2 < customValuesHijoss.length;index2++) {
      customValuesHijoss[index2].setAttribute("data-custom-value2",(index+1))
    }
  }

  let aceptarAñadirHijo = document.querySelectorAll(".aceptarAñadirHijo")

  for (let index = 0; index < aceptarAñadirHijo.length; index++) {
    aceptarAñadirHijo[index].setAttribute("onclick","añadirHijo(3,"+ (index+1) +",1)")
  }

  let espacioHijos = document.querySelectorAll(".espacioHijos")
  for (let index = 0; index < espacioHijos.length; index++) {
    let botonesBorrarHijo = espacioHijos[index].querySelectorAll(".borrarHijo")
    for (let index2 = 0; index2 < botonesBorrarHijo.length; index2++) {
      botonesBorrarHijo[index2].setAttribute("onclick","borrarHijo(5,"+ (index+1) +","+(index2+1)+")")
    }
  }



  alterarMenusMantenimiento(custom1,custom2,custom3," ")
  init();

}





function init() {
  $(document).ready(function () {
    $('[data-bs-toggle="popover"]').popover();
  });

  

  // AÑADIR HIJO AL FINAL (BOTON AÑADIR HIJO)

  // CREACION PADRE

  var botonesPopoverPadre = document.querySelectorAll(".botonPopoverPadre");

  botonesPopoverPadre.forEach(function (botonPopoverFinal) {
    botonPopoverFinal.addEventListener("click", function () {
      console.log(botonPopoverFinal);

      var tipo = botonPopoverFinal.getAttribute("data-custom-value1");
      var padre = botonPopoverFinal.getAttribute("data-custom-value2");
      var hijo = botonPopoverFinal.getAttribute("data-custom-value3");

      // Inicializa el popover de Bootstrap
      var popover = new bootstrap.Popover(botonPopoverFinal, {
        html: true,
        content: function () {
          // Crea un elemento input
          var input = document.createElement("input");
          input.type = "text";
          input.placeholder = "Introduce el nombre del menú";

          // Crea un botón Bootstrap
          var botonCrear = document.createElement("button");
          botonCrear.setAttribute("type", "button");
          botonCrear.classList.add("btn", "btn-primary");
          botonCrear.textContent = "Crear";

          // Crea un contenedor div para el input
          var container = document.createElement("div");
          container.appendChild(input);
          container.appendChild(botonCrear);

          botonCrear.addEventListener("click", function () {
            popover.hide();

            // Crear el elemento div con la clase 'padre'
            var divPadre = document.createElement("div");
            divPadre.className = "padre";

            // Crear el div 'contenedorPadre'
            var contenedorPadre = document.createElement("div");
            contenedorPadre.className = "contenedorPadre";

            // Crear el primer bloque 'primerBloquePadre'
            var primerBloquePadre = document.createElement("div");
            primerBloquePadre.className = "primerBloquePadre";

            // Dentro de 'primerBloquePadre', añadir 'tituloMenu'
            var tituloMenu = document.createElement("div");
            tituloMenu.className = "tituloMenu";
            tituloMenu.textContent = input.value;

            // Añadir 'añadirHijo'
            var añadirHijo = document.createElement("div");
            añadirHijo.className = "añadirHijo";
            añadirHijo.textContent = "Añadir Hijo";
            var inputAñadirHijo = document.createElement("input");
            inputAñadirHijo.className = "inputAñadirHijo";
            var aceptarAñadirHijo = document.createElement("div");
            aceptarAñadirHijo.className = "aceptarAñadirHijo";
            aceptarAñadirHijo.setAttribute("onclick", "añadirHijo(3,99,1)");

            var svg = document.createElementNS(
              "http://www.w3.org/2000/svg",
              "svg"
            );
            svg.setAttribute("xmlns", "http://www.w3.org/2000/svg");
            svg.setAttribute("fill", "white");
            svg.setAttribute("height", "24");
            svg.setAttribute("viewBox", "0 -960 960 960");
            svg.setAttribute("width", "24");

            // Crear el elemento path dentro del SVG
            var path = document.createElementNS(
              "http://www.w3.org/2000/svg",
              "path"
            );
            path.setAttribute(
              "d",
              "m424-296 282-282-56-56-226 226-114-114-56 56 170 170Zm56 216q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z"
            );

            // Agregar el elemento path al elemento SVG
            svg.appendChild(path);
            aceptarAñadirHijo.appendChild(svg);
            añadirHijo.appendChild(inputAñadirHijo);
            añadirHijo.appendChild(aceptarAñadirHijo);

            // Añadir los elementos creados al 'primerBloquePadre'
            primerBloquePadre.appendChild(tituloMenu);
            primerBloquePadre.appendChild(añadirHijo);

            // Crear el segundo bloque 'segundoBloquePadre'
            var segundoBloquePadre = document.createElement("div");
            segundoBloquePadre.className = "segundoBloquePadre";

            // Dentro de 'segundoBloquePadre', añadir 'permisosMenu'
            var permisosMenu = document.createElement("div");
            permisosMenu.className = "permisosMenu";

            var permisoInicial = document.createElement("div");
            permisoInicial.className = "permiso";
            permisoInicial.textContent = "ver" + input.value;

            // Añadir 'permisosMenu' al 'segundoBloquePadre'
            permisosMenu.appendChild(permisoInicial);
            segundoBloquePadre.appendChild(permisosMenu);

            // Crear el tercer bloque 'tercerBloquePadre'
            var tercerBloquePadre = document.createElement("div");
            tercerBloquePadre.className = "tercerBloquePadre";

            // Dentro de 'tercerBloquePadre', añadir 'nuevoPermiso'
            var nuevoPermiso = document.createElement("div");
            nuevoPermiso.className = "nuevoPermiso";
            nuevoPermiso.textContent = "Nuevo Permiso";

            // Añadir 'borrarPadre'
            var borrarPadre = document.createElement("div");
            borrarPadre.className = "borrarPadre";

            // Crear el SVG y añadirlo a 'borrarPadre'
            var svg = document.createElementNS(
              "http://www.w3.org/2000/svg",
              "svg"
            );
            svg.setAttribute("height", "24");
            svg.setAttribute("viewBox", "0 -960 960 960");
            svg.setAttribute("width", "24");
            svg.setAttribute("fill", "red");
            svg.innerHTML =
              '<path d="M280-120q-33 0-56.5-23.5T200-200v-520h-40v-80h200v-40h240v40h200v80h-40v520q0 33-23.5 56.5T680-120H280Zm400-600H280v520h400v-520ZM360-280h80v-360h-80v360Zm160 0h80v-360h-80v360ZM280-720v520-520Z"></path>';
            borrarPadre.appendChild(svg);

            // Añadir elementos al 'tercerBloquePadre'
            tercerBloquePadre.appendChild(nuevoPermiso);
            tercerBloquePadre.appendChild(borrarPadre);

            // Añadir los bloques al 'contenedorPadre'
            contenedorPadre.appendChild(primerBloquePadre);
            contenedorPadre.appendChild(segundoBloquePadre);
            contenedorPadre.appendChild(tercerBloquePadre);

            // Crear 'espacioHijos' y añadirlo al 'divPadre'

            var espacioHijos = document.createElement("div");
            espacioHijos.className = "espacioHijos";
            divPadre.appendChild(contenedorPadre);
            divPadre.appendChild(espacioHijos);

            var elementosPadre = document.querySelectorAll(".padre");
            var arrayDeElementosPadre = Array.from(elementosPadre);
            var elementoReferencia;

            if (padre != arrayDeElementosPadre.length + 1) {
              arrayDeElementosPadre.splice(padre, 0, divPadre);

              elementoReferencia = elementosPadre[padre - 1];

              if (elementoReferencia) {
                elementoReferencia.parentNode.insertBefore(
                  divPadre,
                  elementoReferencia
                );
              }
            } else {
              var ultimoElemento = elementosPadre[elementosPadre.length - 1];

              if (ultimoElemento) {
                ultimoElemento.parentNode.appendChild(divPadre);
              }
            }

            // Crear el nuevo elemento 'nuevoPadre'
            var nuevoPadre = document.createElement("div");
            nuevoPadre.className = "nuevoPadre";

            // Crear el botón que irá dentro del 'nuevoPadre'
            var boton = document.createElement("button");
            boton.setAttribute("type", "button");
            boton.className = "botonPopoverPadre";
            boton.setAttribute("data-bs-toggle", "popover");
            boton.setAttribute("data-bs-content", "asdf");
            boton.dataset.customValue1 = "1";
            boton.dataset.customValue2 = "1";
            boton.dataset.customValue3 = "1";

            // Crear el SVG que irá dentro del botón
            var svg = document.createElementNS(
              "http://www.w3.org/2000/svg",
              "svg"
            );
            svg.setAttribute("height", "24");
            svg.setAttribute("viewBox", "0 -960 960 960");
            svg.setAttribute("width", "24");
            svg.innerHTML =
              '<path d="M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160Zm40 200q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z"></path>';

            // Añadir el SVG al botón
            boton.appendChild(svg);

            // Añadir el botón al 'nuevoPadre'
            nuevoPadre.appendChild(boton);

            if (padre != arrayDeElementosPadre.length + 1) {
              arrayDeElementosPadre.splice(padre, 0, nuevoPadre);

              elementoReferencia = elementosPadre[padre - 1];

              if (elementoReferencia) {
                elementoReferencia.parentNode.insertBefore(
                  nuevoPadre,
                  elementoReferencia
                );
              }
            } else {
              elementosPadre = document.querySelectorAll(".padre");
              var ultimoElemento = elementosPadre[elementosPadre.length - 1];

              if (ultimoElemento) {
                ultimoElemento.parentNode.appendChild(nuevoPadre);
              }
            }

            //RESETEAR LOS CUSTOM-VALUES

            var customValuesPadre =
              document.querySelectorAll(".botonPopoverPadre");

            for (let index = 0; index < customValuesPadre.length; index++) {
              customValuesPadre[index].setAttribute(
                "data-custom-value2",
                index + 1
              );
            }

            var padres = document.querySelectorAll(".padre");

            for (let index = 0; index < padres.length; index++) {
              var hijos = padres[index].querySelectorAll(".botonPopoverHijo");
              for (let index2 = 0; index2 < hijos.length; index2++) {
                hijos[index2].setAttribute("data-custom-value2", index + 1);
              }
            }

            var onClickAñadirHijo =
              document.querySelectorAll(".aceptarAñadirHijo");

            for (let index = 0; index < onClickAñadirHijo.length; index++) {
              onClickAñadirHijo[index].setAttribute(
                "onclick",
                "añadirHijo(3," + (index + 1) + ",1)"
              );
            }

            var borrarPadres = document.querySelectorAll(".borrarPadre");
            
            for (let index = 0; index < padres.length; index++) {
              borrarPadres[index].setAttribute("onclick","borrarPadre(4,"+ (index+1) +",1)");
              var borrarHijos = padres[index].querySelectorAll(".borrarHijo");
              for (let index2 = 0; index2 < borrarHijos.length; index2++) {
                borrarHijos[index2].setAttribute("onclick","borrarHijo(5,"+ (index+1) +","+ (index2+1) +")");
              }
            }
            
            //REALIZAR CONSULTA/S
            alterarMenusMantenimiento(tipo, padre, hijo, input.value);

            //RECARGAR JS
            init();
          });
          return container;
        },
      });
    });
  });

  // CREACION HIJO

  var botonesPopoverHijo = document.querySelectorAll(".botonPopoverHijo");

  botonesPopoverHijo.forEach(function (botonPopoverFinal) {
    botonPopoverFinal.addEventListener("click", function () {
      console.log(botonPopoverFinal);

      var tipo = botonPopoverFinal.getAttribute("data-custom-value1");
      var padre = botonPopoverFinal.getAttribute("data-custom-value2");
      var hijo = botonPopoverFinal.getAttribute("data-custom-value3");

      // Inicializa el popover de Bootstrap
      var popover = new bootstrap.Popover(botonPopoverFinal, {
        html: true,
        content: function () {
          // Crea un elemento input
          let input = document.createElement("input");
          input.type = "text";
          input.placeholder = "Introduce el nombre del menú";

          // Crea un botón Bootstrap
          var botonCrear = document.createElement("button");
          botonCrear.setAttribute("type", "button");
          botonCrear.classList.add("btn", "btn-primary");
          botonCrear.textContent = "Crear";

          // Crea un contenedor div para el input
          var container = document.createElement("div");
          container.appendChild(input);
          container.appendChild(botonCrear);

          botonCrear.addEventListener("click", function () {
            popover.hide();

            // Creación del botón
            let boton = document.createElement("button");
            boton.setAttribute("type", "button");
            boton.classList.add("botonPopoverHijo");
            boton.setAttribute("data-bs-toggle", "popover");
            boton.setAttribute("title", "Nombre del menu");
            boton.setAttribute("data-bs-content", "");
            boton.setAttribute("data-custom-value1", "2");
            boton.setAttribute("data-custom-value2", padre);
            boton.setAttribute("data-custom-value3", "1");

            // Creación del icono dentro del botón
            let svgIcono = document.createElementNS(
              "http://www.w3.org/2000/svg",
              "svg"
            );
            svgIcono.setAttribute("xmlns", "http://www.w3.org/2000/svg");
            svgIcono.setAttribute("height", "24");
            svgIcono.setAttribute("viewBox", "0 -960 960 960");
            svgIcono.setAttribute("width", "24");

            let pathIcono = document.createElementNS(
              "http://www.w3.org/2000/svg",
              "path"
            );
            pathIcono.setAttribute(
              "d",
              "M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160Zm40 200q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z"
            );
            svgIcono.appendChild(pathIcono);

            boton.appendChild(svgIcono);

            // Creación del contenedor del botón
            let contenedorBoton = document.createElement("div");
            contenedorBoton.classList.add("nuevoHijo");
            contenedorBoton.appendChild(boton);

            // Creación del bloque de tamaño
            let tituloMenu = document.createElement("div");
            tituloMenu.classList.add("tituloMenuHijos");
            tituloMenu.textContent = input.value;

            let primerBloque = document.createElement("div");
            primerBloque.classList.add("primerBloqueHijo");
            primerBloque.appendChild(tituloMenu);

            let permiso = document.createElement("div");
            permiso.classList.add("permiso");
            permiso.textContent = "Ver" + input.value;

            let permisosMenu = document.createElement("div");
            permisosMenu.classList.add("permisosMenuHijos");
            permisosMenu.appendChild(permiso);

            let segundoBloque = document.createElement("div");
            segundoBloque.classList.add("segundoBloqueHijo");
            segundoBloque.appendChild(permisosMenu);

            let nuevoPermiso = document.createElement("div");
            nuevoPermiso.classList.add("nuevoPermiso");
            nuevoPermiso.textContent = "Nuevo Permiso";

            let borrarPadre = document.createElement("div");
            borrarPadre.classList.add("borrarHijo");

            let svgBorrar = document.createElementNS(
              "http://www.w3.org/2000/svg",
              "svg"
            );
            svgBorrar.setAttribute("xmlns", "http://www.w3.org/2000/svg");
            svgBorrar.setAttribute("height", "24");
            svgBorrar.setAttribute("viewBox", "0 -960 960 960");
            svgBorrar.setAttribute("width", "24");
            svgBorrar.setAttribute("fill", "red");

            let pathBorrar = document.createElementNS(
              "http://www.w3.org/2000/svg",
              "path"
            );
            pathBorrar.setAttribute(
              "d",
              "M280-120q-33 0-56.5-23.5T200-200v-520h-40v-80h200v-40h240v40h200v80h-40v520q0 33-23.5 56.5T680-120H280Zm400-600H280v520h400v-520ZM360-280h80v-360h-80v360Zm160 0h80v-360h-80v360ZM280-720v520-520Z"
            );
            svgBorrar.appendChild(pathBorrar);
            borrarPadre.appendChild(svgBorrar);

            let tercerBloque = document.createElement("div");
            tercerBloque.classList.add("tercerBloqueHijo");
            tercerBloque.appendChild(nuevoPermiso);
            tercerBloque.appendChild(borrarPadre);

            let tamañoHijo = document.createElement("div");
            tamañoHijo.classList.add("tamañoHijo");
            tamañoHijo.appendChild(primerBloque);
            tamañoHijo.appendChild(segundoBloque);
            tamañoHijo.appendChild(tercerBloque);

            // Agregar el contenedor del botón y el bloque de tamaño al cuerpo del documento

            var elementosPadre = document.querySelectorAll(".padre");
            var padreEspecifico = elementosPadre[padre - 1];

            var hijosArray = padreEspecifico.querySelectorAll(".tamañoHijo");
            var arrayDeElementosHijo = Array.from(hijosArray);

            if (hijo != arrayDeElementosHijo.length + 1) {
              arrayDeElementosHijo.splice(hijo, 0, tamañoHijo);

              elementoReferencia = hijosArray[hijo - 1];

              if (elementoReferencia) {
                elementoReferencia.parentNode.insertBefore(
                  tamañoHijo,
                  elementoReferencia
                );
              }
            } else {
              var ultimoElemento = hijosArray[hijosArray.length - 1];

              if (ultimoElemento) {
                ultimoElemento.parentNode.appendChild(tamañoHijo);
              }
            }

            if (hijo != arrayDeElementosHijo.length + 1) {
              arrayDeElementosHijo.splice(hijo, 0, tamañoHijo);

              elementoReferencia = hijosArray[hijo - 1];

              if (elementoReferencia) {
                elementoReferencia.parentNode.insertBefore(
                  contenedorBoton,
                  elementoReferencia
                );
              }
            } else {
              hijosArray = padreEspecifico.querySelectorAll(".tamañoHijo");
              var ultimoElemento = hijosArray[hijosArray.length - 1];

              if (ultimoElemento) {
                ultimoElemento.parentNode.appendChild(contenedorBoton);
              }
            }

            //RESETEAR LOS CUSTOM-VALUES

            for (let index = 0; index < elementosPadre.length; index++) {
              var customValuesHijoss =
                elementosPadre[index].querySelectorAll(".botonPopoverHijo");

              for (
                let index2 = 0;
                index2 < customValuesHijoss.length;
                index2++
              ) {
                customValuesHijoss[index2].setAttribute(
                  "data-custom-value3",
                  index2 + 1
                );
              }
            }

            var padres = document.querySelectorAll(".padre");

            for (let index = 0; index < padres.length; index++) {
              var borrarHijos = padres[index].querySelectorAll(".borrarHijo");
              for (let index2 = 0; index2 < borrarHijos.length; index2++) {
                borrarHijos[index2].setAttribute("onclick","borrarHijo(5,"+ (index+1) +","+ (index2+1) +")");
              }
            }


            //REALIZAR CONSULTA/S
            alterarMenusMantenimiento(tipo, padre, hijo, input.value);

            //RECARGAR JS
            init();
          });
          return container;
        },
      });
    });
  });
}
