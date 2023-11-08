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
            <div class='celda'>BORRAR</div>
            <div class='celda'>EDITAR</div>
        </div>
    ";
    $contador = 1;
    foreach($usuarios as $fila){
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
                echo '<div class="celda"><img class="prueba" src="img/delete2.png" value="" onclick="borrarUsuarios('.$fila['id_Usuario'].')"></div>
                <div class="celda"><img class="prueba" src="img/editar.png" value="" onclick="editarUsuarios('.$fila['id_Usuario'].')"></div>
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
                echo '<div class="celda"><img class="prueba" src="img/delete2.png" value="" onclick="borrarUsuarios('.$fila['id_Usuario'].')"></div>
                <div class="celda"><img class="prueba" src="img/editar.png" value="" onclick="editarUsuarios('.$fila['id_Usuario'].')"></div>
            </div>
            ';
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
    
?>
