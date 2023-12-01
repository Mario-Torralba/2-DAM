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
            <div class='celda'>BORRAR</div>
            <div class='celda'>EDITAR</div>
        </div>
    ";
    

    $_SESSION["contador"] = $contador;

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
        $contador++;
    }
    echo '</div>';
    
?>
