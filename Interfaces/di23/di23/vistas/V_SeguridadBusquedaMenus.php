<?php
    $datos = $datos['menus'];
    $listaPadres = array();
    $listaHijos = array();

    foreach ($datos as $element) {

        if($element['ID_PADRE'] == 0){
            array_push($listaPadres, $element);
        }

    }

    print_r($listaPadres);


?>

<!-- <div class="contenedorMenus">

        <div class="padre">
            <div class="barraSuperior">
                <div class="masSuperior">
                    <svg xmlns="http://www.w3.org/2000/svg" height="24" color="red" viewBox="0 -960 960 960" width="24" fill="green"><path d="M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160ZM200-120q-33 0-56.5-23.5T120-200v-560q0-33 23.5-56.5T200-840h560q33 0 56.5 23.5T840-760v560q0 33-23.5 56.5T760-120H200Zm0-80h560v-560H200v560Zm0-560v560-560Z"/></svg>
                </div>
                <div class="borrarPadre">
                    <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="red"><path d="M280-120q-33 0-56.5-23.5T200-200v-520h-40v-80h200v-40h240v40h200v80h-40v520q0 33-23.5 56.5T680-120H280Zm400-600H280v520h400v-520ZM360-280h80v-360h-80v360Zm160 0h80v-360h-80v360ZM280-720v520-520Z"/></svg>
                </div>
            </div>
            <div class="contenedorPadre">

                <div class="tituloMenu">Home</div>
    
                <div class="añadirHijo">Añadir Hijo</div>
                <div class="permisosMenu">
                    <div class="permiso">Permiso1</div>
                    <div class="permiso">Permiso2</div>
                    <div class="permiso">Permiso3</div>
                    <div class="permiso">Permiso4</div>
                    <div class="permiso">Permiso5</div>
                </div>
                <div class="nuevoPermiso">Nuevo Permiso</div>

            </div>
            
            <div class="espacioHijos">
                <div>
                    <div class="iconoNuevoHijo"><svg xmlns="http://www.w3.org/2000/svg" height="24" color="red" viewBox="0 -960 960 960" width="24" fill="green"><path d="M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160ZM200-120q-33 0-56.5-23.5T120-200v-560q0-33 23.5-56.5T200-840h560q33 0 56.5 23.5T840-760v560q0 33-23.5 56.5T760-120H200Zm0-80h560v-560H200v560Zm0-560v560-560Z"/></svg></div>
                    <div class="tituloMenuHijos">Hijo Home</div>
                    <div class="iconoNuevoHijo"><svg xmlns="http://www.w3.org/2000/svg" height="24" color="red" viewBox="0 -960 960 960" width="24" fill="green"><path d="M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160ZM200-120q-33 0-56.5-23.5T120-200v-560q0-33 23.5-56.5T200-840h560q33 0 56.5 23.5T840-760v560q0 33-23.5 56.5T760-120H200Zm0-80h560v-560H200v560Zm0-560v560-560Z"/></svg></div>
                </div>
                <div class="permisosMenuHijos">
                    <div class="permiso">Permiso1</div>
                    <div class="permiso">Permiso2</div>
                    <div class="permiso">Permiso3</div>
                    <div class="permiso">Permiso4</div>
                    <div class="permiso">Permiso5</div>
                </div>
                <div class="nuevoPermiso">Nuevo Permiso</div>
            </div>
        </div>


    </div> -->