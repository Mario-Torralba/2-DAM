<?php session_start();
    if(isset($_SESSION['usuario']) && $_SESSION['usuario']!=''){
        //esta logeado
    }else{
        //header('Location: login.php');
    }
    // https://es.cooltext.com/
?>
<!DOCTYPE html>
<html lang="es">
<html>
    <head>
        <meta name="viewport" 
            content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" 
            href="librerias/bootstrap-5.1.3-dist/css/bootstrap.min.css">
        </link>
        <link rel="icon" type="image/x-icon" href="img/favicon.png">
        <script defer src="js/app.js"></script>
        <link rel="stylesheet" href="css/index.css">
        <link rel="stylesheet" href="css/lista.css">
        <link rel="stylesheet" href="css/paginado.css">
        <link rel="stylesheet" href="css/seguridad.css">
        
    </head>
    <body>
        <br>
        <section id="secEncabezadoPagina" class="container-fluid">
            <div class="header">
                <div class="divLogotipo">
                    <img src="./img/PHP.png">
                </div>

                <div class="divTituloApp">Mario Torralba Pardos</div>
                <div class="divLog">
                    <?php
                        if(isset($_SESSION['usuario'])){
                            echo '<a href="logout.php" title="Salir">';
                            echo $_SESSION['usuario'];
                            echo    '<img src="img/logout.png">';
                            echo '</a>';
                        }else{
                            echo '<a href="login.php" title="Entrar">';
                            echo    '<img src="img/login.png">';
                            echo '</a>';
                        }
                    ?>
                </div>
            </div>
        </section>
        <br>
        <section id="secMenuPagina" class="container-fluid">
                             
        </section>
        <section id="secContenidoPagina" class="container-fluid">

        </section>
        <div id="paginado">

        </div>
        
        



        <script src="librerias/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
