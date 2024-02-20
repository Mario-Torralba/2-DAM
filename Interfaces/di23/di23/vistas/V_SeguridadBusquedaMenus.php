<?php
    $datos = $datos['menus'];
    $usuarios = array();
    json_encode($datos);

    foreach ($datos as $element) {
        $salida = false;
        foreach ($usuarios as $usuario) {
            if($usuario == $element['ID_USUARIO']){
                $salida = true;
                break;
            }else{
                $salida = false;
            }
        }
        if(!$salida){
            array_push($usuarios, $element['ID_USUARIO']);
        }
    }

    sort($usuarios);

    foreach ($usuarios as $usuario) {
        ?>
        <div class="contenedor_usuario"></div>
        <?php
    }
?>