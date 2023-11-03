<?php
    $usuarios= $datos['usuarios'];
    echo '
    <table class="center">
        <tr class="celdaPrincipal"> 
            <td>ID</td>
            <td>Nombre</td>
            <td>Apellido 1</td>
            <td>Apellido 2</td>
            <td>Sexo</td>
            <td>Fecha de alta</td>
            <td>E-Mail</td>
            <td>Movil</td>
            <td>Usuario</td>
            <td>Contraseña</td>
            <td>Activo</td>
        </tr>
    ';
    $contador = 0;
    foreach($usuarios as $fila){
        $_SESSION["numeroUsuario"] = $contador;
        echo '
        <tr class="celdaSecundaria"> 
            <td>'.$fila['id_Usuario'].'</td>
            <td>'.$fila['nombre'].'</td>
            <td>'.$fila['apellido_1'].'</td>
            <td>'.$fila['apellido_2'].'</td>
            <td>'.$fila['sexo'].'</td>
            <td>'.$fila['fecha_Alta'].'</td>
            <td>'.$fila['mail'].'</td>
            <td>'.$fila['movil'].'</td>
            <td>'.$fila['login'].'</td>
            <td>'.$fila['pass'].'</td>
            <td>'.$fila['activo'].'</td>
            <td class="imagenTabla"><img class="prueba" src="img/delete.png" value="'.$contador.'" onclick="borrarUsuarios()"></td>
            <td class="imagenTabla"><img class="prueba" src="img/editar.png" value="'.$contador.'"></td>
        </tr>';
        $contador++;
    }
    echo '</table>';
    
?>
