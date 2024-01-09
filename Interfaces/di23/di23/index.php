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
            
            <nav class="navbar navbar-expand-sm navbar-light" style="background-color: #68a8f1" aria-label="Fourth navbar example">
                <div class="container-fluid">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarsExample04">
                        <ul class="navbar-nav me-auto mb-2 mb-md-0">
                            <li class="nav-item">
                                <a class="nav-link active" style="color: white" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" style="color: white" href="#">Link</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled">Disabled</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" style="color: white" href="#" data-bs-toggle="dropdown" 
                                    aria-expanded="false">Cruds</a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" 
                                        onclick="peticion('Usuarios', 'getVistaUsuarios')" >Usuarios</a></li>
                                    <li><a class="dropdown-item" 
                                        onclick="peticion('Pedidos', 'getVistaPedidos')">Pedidos</a></li>
                                    <li><a class="dropdown-item" 
                                        onclick="peticion('', '')">Something else here</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <section onload="peticionMenu('Menu', 'getVistaMenu')" id="secPruebaMenu" class="container-fluid">

            </section>     
                        
        </section>
        <section id="secContenidoPagina" class="container-fluid">

        </section>
        <div id="paginado">

        </div>
        
        



        <script src="librerias/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
