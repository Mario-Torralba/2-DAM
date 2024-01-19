<?php session_start();

    unset($_SESSION['usuario']);
    unset($_SESSION['ID_USUARIO']);
    header('Location: index.php');

?>