<?php
    $cantidadEntradas = 5;
    $usuarios = $datos['usuarios'];
    $contador = 0;
    foreach ($usuarios as $fila) {
        $contador++;
    }

    $cantidadPaginas = $contador/$cantidadEntradas;
    echo "
    <div id='lista'>
        <div class='filaSuperior'>
            <div class='celda'>ID</div>
            <div class='celda'>NOMBRE</div>
            <div class='celda'>PRIMER APELLIDO</div>
            <div class='celda'>SEGUNDO APELLIDO</div>
            <div class='celda'>EMAIL</div>
            <div class='celda'>ACTIVO</div>
            <div class='celda'>SALIR</div>
            <div class='celda'>CONFIRMAR</div>
        </div>
    ";

    $_SESSION["contador"] = $contador;
    foreach($usuarios as $fila){
        if($_SESSION['idEditar'] == $fila['ID_USUARIO']){
            echo '<form id="formularioEditar" name="formularioEditar">';
            if($contador%2==1){
                echo'
                <div class="filaInferior1">
                    <div class="celda">'.$fila['ID_USUARIO'].'</div>
                    <div class="celda"><label for="nombre_editar"><input value="'.$fila['NOMBRE'].'" type="text" placeholder="'.$fila['NOMBRE'].'" id="nombre_editar" name="nombre_editar"></label></div>
                    <div class="celda"><label for="apellido_1_editar"><input value="'.$fila['APELLIDO_1'].'" type="text" placeholder="'.$fila['APELLIDO_1'].'" id="apellido_1_editar" name="apellido_1_editar"></label></div>
                    <div class="celda"><label for="apellido_2_editar"><input value="'.$fila['APELLIDO_2'].'" type="text" placeholder="'.$fila['APELLIDO_2'].'" id="apellido_2_editar" name="apellido_2_editar"></label></div>
                    <div class="celda"><label for="email_editar"><input value="'.$fila['MAIL'].'" type="text" placeholder="'.$fila['MAIL'].'" id="email_editar" name="email_editar"></label></div>
                    <div class="celda"><label for="activo_editar">
                        <select name="activo_editar" id="activo_editar">
                            <option value="S">S</option>
                            <option value="N">N</option>
                        </select>
                    </label></div>
                    <div class="celda"><img class="prueba" src="img/delete2.png" value="" onclick="buscarUsuarios('.$_SESSION["paginaActual"].','.$_SESSION["cantidadEntradas"].')"></div>
                    <div class="celda"><img class="prueba" src="img/confirmar.png" value="" onclick="confirmarEditarUsuarios('.$fila['ID_USUARIO'].')"></div>
                </div>
                ';
            }else{
                echo'
                <div class="filaInferior2">
                    <div class="celda">'.$fila['ID_USUARIO'].'</div>
                    <div class="celda"><label for="nombre_editar"><input value="'.$fila['NOMBRE'].'" type="text" placeholder="'.$fila['NOMBRE'].'" id="nombre_editar" name="nombre_editar"></label></div>
                    <div class="celda"><label for="apellido_1_editar"><input value="'.$fila['APELLIDO_1'].'" type="text" placeholder="'.$fila['APELLIDO_1'].'" id="apellido_1_editar" name="apellido_1_editar"></label></div>
                    <div class="celda"><label for="apellido_2_editar"><input value="'.$fila['APELLIDO_2'].'" type="text" placeholder="'.$fila['APELLIDO_2'].'" id="apellido_2_editar" name="apellido_2_editar"></label></div>
                    <div class="celda"><label for="email_editar"><input value="'.$fila['MAIL'].'" type="text" placeholder="'.$fila['MAIL'].'" id="email_editar" name="email_editar"></label></div>
                    <div class="celda"><label for="activo_editar">
                        <select name="activo_editar" id="activo_editar">
                            <option value="S">S</option>
                            <option value="N">N</option>
                        </select>
                    </label></div>
                    <div class="celda"><img class="prueba" src="img/delete2.png" value="" onclick="buscarUsuarios('.$_SESSION["paginaActual"].','.$_SESSION["cantidadEntradas"].')"></div>
                    <div class="celda"><img class="prueba" src="img/confirmar.png" value="" onclick="confirmarEditarUsuarios('.$fila['ID_USUARIO'].')"></div>
                </div>
                ';
            }
            echo '</form>';
            
        }else{
            if($contador%2==1){
                echo'
                <div class="filaInferior1">
                    <div class="celda">'.$fila['ID_USUARIO'].'</div>
                    <div class="celda">'.$fila['NOMBRE'].'</div>
                    <div class="celda">'.$fila['APELLIDO_1'].'</div>
                    <div class="celda">'.$fila['APELLIDO_2'].'</div>
                    <div class="celda">'.$fila['MAIL'].'</div>';
                    if($fila['ACTIVO']=='S'){
                        echo '<div class="celda verde">Activo</div>';
                    }else{
                        echo '<div class="celda rojo">No Activo</div>';
                    }
                    echo '<div class="celda"></div>
                    <div class="celda"></div>
                </div>
                ';
            }else{
                echo'
                <div class="filaInferior2">
                    <div class="celda">'.$fila['ID_USUARIO'].'</div>
                    <div class="celda">'.$fila['NOMBRE'].'</div>
                    <div class="celda">'.$fila['APELLIDO_1'].'</div>
                    <div class="celda">'.$fila['APELLIDO_2'].'</div>
                    <div class="celda">'.$fila['MAIL'].'</div>';
                    if($fila['ACTIVO']=='S'){
                        echo '<div class="celda verde">Activo</div>';
                    }else{
                        echo '<div class="celda rojo">No Activo</div>';
                    }
                    echo '<div class="celda"></div>
                    <div class="celda"></div>
                </div>
                ';
            }
        }
        
        $contador++;
    }
    echo '</div>';
    unset($_SESSION['idEditar']);
    
?>
