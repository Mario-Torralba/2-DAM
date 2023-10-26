<?php
    require_once 'controladores/Controlador.php';
    require_once 'vistas/Vista.php';
    
    class C_Usuarios extends Controlador{
        public function __construct(){
            parent::__construct();
        }

        public function validarUsuario($datos){
            $usuario='';
            $pass='srfdvsvwrt';
            extract($datos);
            $valido='N';
            if($usuario=='javier' && $pass=='123'){
                $_SESSION['usuario']=$usuario;
                $valido='S';   
            }
            echo $valido;
        }

        public function getVistaUsuarios(){
            Vista::render('vistas/Usuarios/V_Usuarios.php');
        }
        public function buscarUsuarios(){
            echo "Resultado buscar";
        }


    }
?>