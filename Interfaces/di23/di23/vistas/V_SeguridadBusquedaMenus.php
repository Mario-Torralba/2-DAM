<?php
    $datos = $datos['menus'];
    $listaPadres = array();
    $listaHijos = array();
    json_encode($datos);


    foreach ($datos as $element) {

        $salida = false;
        if(isset($element['ID_PADRE'])){

            print($element['TITULO']);
            
        }

    }


?>