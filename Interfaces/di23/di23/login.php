<?php session_start();
$usuario = '';
$pass = '';
extract($_POST);
//var_dump($_POST);
if ($usuario == '' || $pass == '') {
    $mensa = 'Debe completar los campos -- PHP';
} else {
    require_once 'controladores/C_Usuarios.php';
    $objUsuarios = new C_Usuarios();
    $datos['usuario'] = $usuario;
    $datos['pass'] = $pass;
    $resultado = $objUsuarios->validarUsuario($datos);


    if ($resultado == 'S') {
        header('Location: index.php');
    } else {
        $mensa = 'Datos incorrectos';
    }
}
?>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="css/login.css">
    <script type="text/javascript">
        function validar() {
            const usuario = document.getElementById("usuario");
            const pass = document.getElementById("pass");
            let mensaje = '';
            if (usuario.value == '' || pass.value == '') {
                mensaje = 'Desbes completar los campos -- JS';
            } else {
                //enviar formulario
                document.getElementById("formularioLogin").submit();
            }
            document.getElementById("msj").innerHTML = mensaje;
        }
    </script>

</head>

<body>
    <div class="log-form">
        <div class="title">LOGIN </div>
        <div class="form">
            <form id="formularioLogin" name="formularioLogin" method="post" action="login.php">

                <div class="user"><label for="usuario"></label><input class="input" id="usuario" name="usuario" type="text" placeholder="Usuario"
                        value="<?php echo $usuario; ?>" /></div>
                <div class="pass"><label for="pass"></label><input class="input" id="pass" name="pass" type="password" placeholder="Contraseña"
                        value="<?php echo $pass; ?>" /></div>
                <div class="centrado rojo" ><span id="msj">
                    <?php echo $mensa; ?>
                </span></div>
                <div class="boton"><button type="button" class="btn" id="aceptar" onclick="validar()">Login</button>
                    <a class="forgot" href="">¿Olvidaste tu contraseña?</a>
                </div>
            </form>
        </div>
    </div>
    <!-- <form id="formularioLogin" name="formularioLogin" method="post" action="login.php">
        <label for="usuario">Usuario:</label><br>
        <input type="text" id="usuario" name="usuario" value="<?php echo $usuario; ?>"><br>

        <label for="pass">Contraseña:</label><br>
        <input type="password" id="pass" name="pass" value="<?php echo $pass; ?>"><br>
        <span id="msj">
            <?php echo $mensa; ?>
        </span>
        <button type="button" id="aceptar" onclick="validar()">Aceptar</button>
    </form> -->

</body>

</html>