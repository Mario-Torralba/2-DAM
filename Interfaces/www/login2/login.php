<?php session_start();

    $usuario = "";
    $pass = "";

    extract($_POST);

    if ( $usuario == '' || $pass == '' ){
        $mensa = "Debe completar los campos";
    }else{
        if($usuario == "Javier" && $pass= "123"){
            $_SESSION["usuario"] = $usuario;
            
        }else{  
            $mensa = "Datos incorrectos";
        }
    }
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='./css/login.css'>
    <script defer src='./js/login.js'></script>
    <script defer type="text/javascript" >

        function validar(){

            const USUARIO = document.getElementById("usuario")
            const PASS = document.getElementById("pass")
            let mensaje = "";

            if ( usuario.value === ""|| pass.value === "" ){
 
                mensaje = "Debes completar los campos"
 
            } else {
 
                let opciones = {method: "GET"}
                let parametros = "$usuario=" + USUARIO.value +"$pass=" + PASS.value;
 
                fetch("validarUsuario.php?"+ parametros, opciones)
                    .then(res => {
                        if(res.ok){
                            console.log("Respuesta ok")
                            return res.json();
                        }
                    })
                    .then(respuestaJson => {
                        console.log(respuestaJson)
                        if(respuestaJson.valido == "SI"){
                            location.href = "../indexPrueba.php"
                        }else{
                            document.getElementById("msj").innerHTML = respuestaJson.msj
                        }
                    })
                    .catch(err=>{
                        console.log("Error al realizar la peticion",err.message)
                    });
            }
            document.getElementById("msj").innerHTML = mensaje
        }

    </script>
</head>
<body>
    <header></header>
    <main>
        <form id="formularioLogin" method="post" action="login.php">

            <label for="usuario">Usuario:</label><br>
            <input type="text" id="usuario" name="usuario" value=""><br>
    
            <label for="pass">Contraseña:</label><br>
            <input type="password" id="pass" name="pass" value=""><br>
            
            <button type="button" id="aceptar" onclick="validar()">Aceptar</button>

            <p id="msj"></p>

        </form>
    </main>
    <footer></footer>
</body>
</html>