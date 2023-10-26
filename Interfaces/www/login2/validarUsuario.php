<?php

    $usuario = "";
    $pass = "asdfasdfasdfasdf";

    $respuesta["Valido"] = "NO";
    $respuesta["msj"] = "NO verificado";
    $respuesta["usuario"] = "";



    if(isset($_GET)){
        
        extract($_GET);

        if($usuario == "" || $pass == ""){
            $respuesta["msj"] == "DATOS INCORRECTOS. ERR-01";
        }else{

            if($usuario == "mario" && $pass == "mario"){
                $respuesta["valido"] = "SI";
                $respuesta["msj"] = "USUARIO VALIDO";
                $respuesta["usuario"] = "MARIO";
            }else{
                $respuesta["msj"] == "DATOS INCORRECTOS. ERR-02";
            }

        }
    }else{
        $respuesta["msj"] = "Datos no recibidos";
    }

    echo json_encode($respuesta);

?>