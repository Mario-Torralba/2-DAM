<?php
    $datos = $datos['menus'];
    $listaPadres = array();
    $listaHijos = array();
    $listaPermisos = array();

    // RELLENAR ARRAY DE PADRES
    foreach ($datos as $element) {
        $contador = 0;
        if($element['ID_PADRE'] == 0){
            foreach ($listaPadres as $element2) {
                if($element['NOMBRE_PERMISO']==$element2['NOMBRE_PERMISO']){
                    $contador += 1;
                }
            }
            if($contador==0){
                array_push($listaPadres, $element);
            }
        }
    }

    // RELLENAR ARRAY DE HIJOS

    foreach ($datos as $element) {
        $contador = 0;
        if($element['ID_PADRE'] != 0){
            foreach ($listaHijos as $element2) {
                if($element['TITULO']==$element2['TITULO']){
                    $contador += 1;
                }
            }
            if($contador==0){
                array_push($listaHijos, $element);
            }
        }
    }

        // RELLENAR ARRAY DE PERMISOS

        foreach ($datos as $element) {
            $contador = 0;
            
            foreach ($listaPermisos as $element2) {
                if($element['NOMBRE_PERMISO']==$element2['NOMBRE_PERMISO']){
                    $contador += 1;
                }
            }
            if($contador==0){
                array_push($listaPermisos, $element);
            }
            
        }


    // PINTAR MENU
    
    ?>
    <div class="contenedorMenus">
    <?php

    foreach ($listaPadres as $e) {
        
        ?>
        <div class="padre">
            
            <div class="contenedorPadre">

                <div class="tituloMenu"><?php echo $e['TITULO']; ?></div>
    
                <div class="añadirHijo">Añadir Hijo</div>
                <div class="permisosMenu">
                    <?php 
                    foreach ($listaPermisos as $element) {
                        if($e['ID_MENU']==$element['ID_PADRE']){
                            ?> 
                            <div class="permiso"><?php echo $element['NOMBRE_PERMISO']; ?></div>
                            <?php 
                        }
                    }
                    ?>
                </div>
                <div class="nuevoPermiso">Nuevo Permiso</div>
                <div class="borrarPadre">
                    <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="red"><path d="M280-120q-33 0-56.5-23.5T200-200v-520h-40v-80h200v-40h240v40h200v80h-40v520q0 33-23.5 56.5T680-120H280Zm400-600H280v520h400v-520ZM360-280h80v-360h-80v360Zm160 0h80v-360h-80v360ZM280-720v520-520Z"/></svg>
                </div>

            </div>
            
            <div class="espacioHijos">
            <?php 
            foreach ($listaHijos as $element) {
                if($element['ID_PADRE']==$e['ID_MENU']){
                ?> 
                <div class="tamañoHijo">
                <div>
                    <div class="tituloMenuHijos"><?php echo $element['TITULO']; ?></div>
                </div>
                <div class="permisosMenuHijos">
                <?php 
                foreach ($listaPermisos as $element2) {
                    if($element['ID_MENU']==$element2['ID_MENU']){
                        ?> 
                        <div class="permiso"><?php echo $element2['NOMBRE_PERMISO']; ?></div>
                        <?php 
                    }
                }
                ?>
                </div>
                <div class="nuevoPermiso">Nuevo Permiso</div>
                </div>
                <?php 
                }
            }
            ?>

            </div>
        </div>
        <?php 

    }

    ?>
    </div>
    <?php

    print_r($listaHijos)


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