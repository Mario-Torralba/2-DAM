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
    <head>
        <meta name="viewport" 
            content="width=device-width, initial-scale=1.0">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="icon" type="image/x-icon" href="img/favicon.png">
        <script defer src="js/app.js"></script>
        <link rel="stylesheet" href="css/index.css">
        <link rel="stylesheet" href="css/lista.css">
        <link rel="stylesheet" href="css/paginado.css">
        <link rel="stylesheet" href="css/seguridad.css">
        <style>
            .popover {
            max-width: 100%;
            }
        </style>
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
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

    </body>
</html>
