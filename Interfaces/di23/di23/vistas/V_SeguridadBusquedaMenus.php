<?php
$datos = $datos['menus'];
$listaPadres = array();
$listaHijos = array();
$listaPermisos = array();

// RELLENAR ARRAY DE PADRES
$contador = 0;
foreach ($datos as $element) {
    if($contador==0){
        array_push($listaPadres, $element);
        $contador+=1;
    }else{
        $booleano = true;
        foreach ($listaPadres as $elemento2) {
            if($elemento2['ID_MENU'] == $element['ID_MENU']){
                $booleano= false;
                break;
            }
        }
        if($booleano && $elemento2['ID_PADRE']== 0){
            array_push($listaPadres, $element);
        }
    }
    
}

$_SESSION['ID_USUARIO_MANTENIMIENTO'] = $listaPadres[1]['ID_USUARIO'];

// RELLENAR ARRAY DE HIJOS

foreach ($datos as $element) {
    $contador = 0;
    if ($element['ID_PADRE'] != 0) {
        foreach ($listaHijos as $element2) {
            if ($element['TITULO'] == $element2['TITULO']) {
                $contador += 1;
            }
        }
        if ($contador == 0) {
            array_push($listaHijos, $element);
        }
    }
}

// RELLENAR ARRAY DE PERMISOS

foreach ($datos as $element) {
    $contador = 0;

    foreach ($listaPermisos as $element2) {
        if ($element['NOMBRE_PERMISO'] == $element2['NOMBRE_PERMISO']) {
            $contador += 1;
        }
    }
    if ($contador == 0) {
        array_push($listaPermisos, $element);
    }

}




// PINTAR MENU
$contadorPadres = 1;
$contadorHijos = 1;
?>
<div class="nuevoPadre">
    <button type="button" class="botonPopoverPadre" data-bs-toggle="popover" title="Nombre del menu" data-bs-content=""
        data-custom-value1=1 data-custom-value2=<?php echo $contadorPadres ?> data-custom-value3=<?php echo $contadorHijos ?>>
        <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24">
            <path
                d="M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160Zm40 200q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z" />
        </svg>
    </button>
</div>
<?php
foreach ($listaPadres as $e) {
    $contadorHijos = 1;
    ?>
    <div class="padre">

        <div class="contenedorPadre">
            <div class="primerBloquePadre">
                <div class="tituloMenu">
                    <?php echo $e['TITULO']; ?>
                </div>
                <div class="añadirHijo">
                    Añadir Hijo
                    <input class="inputAñadirHijo" type="text">
                    <div onclick="añadirHijo(3,<?php echo $contadorPadres ?>,1)" class="aceptarAñadirHijo">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="white" height="24" viewBox="0 -960 960 960"
                            width="24">
                            <path
                                d="m424-296 282-282-56-56-226 226-114-114-56 56 170 170Zm56 216q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z" />
                        </svg>
                    </div>


                </div>
            </div>
            <div class="segundoBloquePadre">
                <div class="permisosMenu">
                    <?php
                    $contador = 0;
                    foreach ($listaPermisos as $element) {
                        if ($e['ID_MENU'] == $element['ID_MENU']) {
                            ?>
                            <div class="permiso">
                                <?php echo $element['NOMBRE_PERMISO']; ?>
                                <div class="borrarPermisoPadre"
                                    onclick="borrarPermisoPadre(6,<?php echo $contadorPadres ?>,1,'<?php echo $element['NOMBRE_PERMISO']; ?>')">
                                    <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24"
                                        fill="red">
                                        <path
                                            d="M280-120q-33 0-56.5-23.5T200-200v-520h-40v-80h200v-40h240v40h200v80h-40v520q0 33-23.5 56.5T680-120H280Zm400-600H280v520h400v-520ZM360-280h80v-360h-80v360Zm160 0h80v-360h-80v360ZM280-720v520-520Z" />
                                    </svg>
                                </div>
                            </div>

                            <?php
                        }
                        $contador += 1;
                    }
                    if ($contador == 0) {
                        ?> Este menu no tiene permisos asociados
                        <?php
                    }
                    ?>
                </div>
            </div>
            <div class="tercerBloquePadre">
                <div class="nuevoPermiso">Nuevo Permiso
                    <input class="inputAñadirPermisoPadre" type="text">
                    <div onclick="añadirPermisoPadre(8,<?php echo $contadorPadres ?>,1)" class="aceptarAñadirPermisoPadre">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="white" height="24" viewBox="0 -960 960 960"
                            width="24">
                            <path
                                d="m424-296 282-282-56-56-226 226-114-114-56 56 170 170Zm56 216q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z" />
                        </svg>
                    </div>
                </div>
                <div class="borrarPadre" onclick="borrarPadre(4,<?php echo $contadorPadres ?>,1)">
                    <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="red">
                        <path
                            d="M280-120q-33 0-56.5-23.5T200-200v-520h-40v-80h200v-40h240v40h200v80h-40v520q0 33-23.5 56.5T680-120H280Zm400-600H280v520h400v-520ZM360-280h80v-360h-80v360Zm160 0h80v-360h-80v360ZM280-720v520-520Z" />
                    </svg>
                </div>
            </div>

        </div>

        <div class="espacioHijos">

            <?php
            foreach ($listaHijos as $element) {
                if ($element['ID_PADRE'] == $e['ID_MENU']) {
                    ?>
                    <div class="nuevoHijo">
                        <button type="button" class="botonPopoverHijo" data-bs-toggle="popover" title="Nombre del menu"
                            data-bs-content="" data-custom-value1=2 data-custom-value2=<?php echo $contadorPadres ?>
                            data-custom-value3=<?php echo $contadorHijos ?>>
                            <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24">
                                <path
                                    d="M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160Zm40 200q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z" />
                            </svg>
                        </button>
                    </div>

                    <div class="tamañoHijo">
                        <div class="primerBloqueHijo">
                            <div class="tituloMenuHijos">
                                <?php echo $element['TITULO']; ?>
                            </div>
                        </div>


                        <div class="segundoBloqueHijo"> 
                            <div class="permisosMenuHijos">
                                <?php
                                $contador = 0;
                                foreach ($listaPermisos as $element2) {
                                    if ($element['ID_MENU'] == $element2['ID_MENU']) {
                                        ?>
                                        <div class="permiso">
                                            <?php echo $element2['NOMBRE_PERMISO']; ?>
                                            <div class="borrarPermisoHijo"
                                                onclick="borrarPermisoHijo(7,<?php echo $contadorPadres ?>,<?php echo $contadorHijos ?>,'<?php echo $element2['NOMBRE_PERMISO']; ?>')">
                                                <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24"
                                                    fill="red">
                                                    <path
                                                        d="M280-120q-33 0-56.5-23.5T200-200v-520h-40v-80h200v-40h240v40h200v80h-40v520q0 33-23.5 56.5T680-120H280Zm400-600H280v520h400v-520ZM360-280h80v-360h-80v360Zm160 0h80v-360h-80v360ZM280-720v520-520Z" />
                                                </svg>
                                            </div>
                                        </div>
                                        <?php
                                        $contador += 1;
                                    }
                                }
                                if ($contador == 0) {
                                    ?>
                                    Este menu no tiene permisos asociados
                                    <?php
                                }
                                ?>
                            </div>
                        </div>

                        <div class="tercerBloqueHijo">
                            <div class="nuevoPermiso">Nuevo Permiso
                                <input class="inputAñadirPermisoHijo" type="text">
                                <div onclick="añadirPermisoHijo(9,<?php echo $contadorPadres ?>,<?php echo $contadorHijos ?>)" class="aceptarAñadirPermisoHijo">
                                    <svg xmlns="http://www.w3.org/2000/svg" fill="white" height="24" viewBox="0 -960 960 960"
                                        width="24">
                                        <path
                                            d="m424-296 282-282-56-56-226 226-114-114-56 56 170 170Zm56 216q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z" />
                                    </svg>
                                </div>
                            </div>
                            <div class="borrarHijo"
                                onclick="borrarHijo(5,<?php echo $contadorPadres ?>,<?php echo $contadorHijos ?>)">
                                <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="red">
                                    <path
                                        d="M280-120q-33 0-56.5-23.5T200-200v-520h-40v-80h200v-40h240v40h200v80h-40v520q0 33-23.5 56.5T680-120H280Zm400-600H280v520h400v-520ZM360-280h80v-360h-80v360Zm160 0h80v-360h-80v360ZM280-720v520-520Z" />
                                </svg>
                            </div>
                        </div>
                        <?php $contadorHijos += 1; ?>
                    </div>
                    <?php
                }
            }


            ?>
            <?php
            if ($contadorHijos > 1) {

                ?>
                <div class="nuevoHijo">
                    <button type="button" class="botonPopoverHijo" data-bs-toggle="popover" title="Nombre del menu"
                        data-bs-content="" data-custom-value1=2 data-custom-value2=<?php echo $contadorPadres ?>
                        data-custom-value3=<?php echo $contadorHijos ?>>
                        <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24">
                            <path
                                d="M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160Zm40 200q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z" />
                        </svg>
                    </button>
                </div>
                <?php
            }
            $contadorPadres += 1;
            ?>
        </div>
    </div>
    </div>
    <div class="nuevoPadre">
        <button type="button" class="botonPopoverPadre" data-bs-toggle="popover" title="Nombre del menu" data-bs-content=""
            data-custom-value1=1 data-custom-value2=<?php echo $contadorPadres ?> data-custom-value3=<?php echo $contadorHijos ?>>
            <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24">
                <path
                    d="M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160Zm40 200q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z" />
            </svg>
        </button>
    </div>
    <?php
}
?>
<?php
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


    </div>  -->