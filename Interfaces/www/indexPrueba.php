<?php session_start();
    if(isset($_SESSION["usuario"]) && $_SESSION["usuario"]!=""){

    }else{
        header("Location: ./login/login.php");
    }

?>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>
</head>
<body>
    Hola a todos

    <!-- <?php
        echo "<br>hoy es jueves";
        $numero=5;
        $numero+=5;

        $texto = "<br> esto es un texto";
        $texto = "<br> esto es un texto $numero";
        echo $texto;

        $array =[1,2,3,4];
        echo '<br>';
        print_r($array);

        for($x=0;$x<sizeof($array);$x++){
            echo "<br> Estoy en la posicion $array[$x]";
        }
        foreach ($array as $key => $value) {
            echo "<br> Estoy en la posicion $array[$key]";

        }

        $edades = ["Javier"=>52,"Ivan"=>33];

        foreach ($edades as $nombre => $edad) {
            echo "<br> $nombre tiene $edad años";
        }

        
        define("CENTRO","San Valero");
    ?> -->
    

</body>
</html>