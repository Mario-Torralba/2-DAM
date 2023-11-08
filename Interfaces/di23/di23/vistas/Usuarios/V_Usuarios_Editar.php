<?php
    $usuarios = $datos['usuarios'];
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
    $contador = 1;
    foreach($usuarios as $fila){
        if($_SESSION['idEditar'] == $fila['id_Usuario']){
            echo '<form id="formularioEditar" name="formularioEditar">';
            if($contador%2==1){
                echo'
                <div class="filaInferior1">
                    <div class="celda">'.$fila['id_Usuario'].'</div>
                    <div class="celda"><label for="nombre_editar"><input value="'.$fila['nombre'].'" type="text" placeholder="'.$fila['nombre'].'" id="nombre_editar" name="nombre_editar"></label></div>
                    <div class="celda"><label for="apellido_1_editar"><input value="'.$fila['apellido_1'].'" type="text" placeholder="'.$fila['apellido_1'].'" id="apellido_1_editar" name="apellido_1_editar"></label></div>
                    <div class="celda"><label for="apellido_2_editar"><input value="'.$fila['apellido_2'].'" type="text" placeholder="'.$fila['apellido_2'].'" id="apellido_2_editar" name="apellido_2_editar"></label></div>
                    <div class="celda"><label for="email_editar"><input value="'.$fila['mail'].'" type="text" placeholder="'.$fila['mail'].'" id="email_editar" name="email_editar"></label></div>
                    <div class="celda"><label for="activo_editar">
                        <select name="activo_editar" id="activo_editar">
                            <option value="S">S</option>
                            <option value="N">N</option>
                        </select>
                    </label></div>
                    <div class="celda"><img class="prueba" src="img/delete2.png" value="" onclick="buscarUsuarios()"></div>
                    <div class="celda"><img class="prueba" src="img/confirmar.png" value="" onclick="confirmarEditarUsuarios('.$fila['id_Usuario'].')"></div>
                </div>
                ';
            }else{
                echo'
                <div class="filaInferior2">
                    <div class="celda">'.$fila['id_Usuario'].'</div>
                    <div class="celda"><label for="nombre_editar"><input value="'.$fila['nombre'].'" type="text" placeholder="'.$fila['nombre'].'" id="nombre_editar" name="nombre_editar"></label></div>
                    <div class="celda"><label for="apellido_1_editar"><input value="'.$fila['apellido_1'].'" type="text" placeholder="'.$fila['apellido_1'].'" id="apellido_1_editar" name="apellido_1_editar"></label></div>
                    <div class="celda"><label for="apellido_2_editar"><input value="'.$fila['apellido_2'].'" type="text" placeholder="'.$fila['apellido_2'].'" id="apellido_2_editar" name="apellido_2_editar"></label></div>
                    <div class="celda"><label for="email_editar"><input value="'.$fila['mail'].'" type="text" placeholder="'.$fila['mail'].'" id="email_editar" name="email_editar"></label></div>
                    <div class="celda"><label for="activo_editar">
                        <select name="activo_editar" id="activo_editar">
                            <option value="S">S</option>
                            <option value="N">N</option>
                        </select>
                    </label></div>
                    <div class="celda"><img class="prueba" src="img/delete2.png" value="" onclick="buscarUsuarios()"></div>
                    <div class="celda"><img class="prueba" src="img/confirmar.png" value="" onclick="confirmarEditarUsuarios('.$fila['id_Usuario'].')"></div>
                </div>
                ';
            }
            echo '</form>';
            
        }else{
            if($contador%2==1){
                echo'
                <div class="filaInferior1">
                    <div class="celda">'.$fila['id_Usuario'].'</div>
                    <div class="celda">'.$fila['nombre'].'</div>
                    <div class="celda">'.$fila['apellido_1'].'</div>
                    <div class="celda">'.$fila['apellido_2'].'</div>
                    <div class="celda">'.$fila['mail'].'</div>';
                    if($fila['activo']=='S'){
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
                    <div class="celda">'.$fila['id_Usuario'].'</div>
                    <div class="celda">'.$fila['nombre'].'</div>
                    <div class="celda">'.$fila['apellido_1'].'</div>
                    <div class="celda">'.$fila['apellido_2'].'</div>
                    <div class="celda">'.$fila['mail'].'</div>';
                    if($fila['activo']=='S'){
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
        
        // echo '
        // <tr class="celdaSecundaria"> 
        //     <td>'.$fila['id_Usuario'].'</td>
        //     <td>'.$fila['nombre'].'</td>
        //     <td>'.$fila['apellido_1'].'</td>
        //     <td>'.$fila['apellido_2'].'</td>
        //     <td>'.$fila['sexo'].'</td>
        //     <td>'.$fila['fecha_Alta'].'</td>
        //     <td>'.$fila['mail'].'</td>
        //     <td>'.$fila['movil'].'</td>
        //     <td>'.$fila['login'].'</td>
        //     <td>'.$fila['pass'].'</td>
        //     <td>'.$fila['activo'].'</td>
        //     <td class="imagenTabla"><img class="prueba" src="img/delete.png" value="'.$contador.'" onclick="borrarUsuarios()"></td>
        //     <td class="imagenTabla"><img class="prueba" src="img/editar.png" value="'.$contador.'" ></td>
        // </tr>';
        $contador++;
    }
    echo '</div>';
    unset($_SESSION['idEditar']);
    
?>
