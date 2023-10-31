<?php
    require_once 'controladores/Controlador.php';
    require_once 'vistas/Vista.php';
    require_once 'modelos/M_Usuarios.php';

    class C_Usuarios extends Controlador{
        private $modelo;
        public function __construct(){
            parent::__construct();
            $this->modelo = new M_Usuarios();
        }

        public function validarUsuario($datos){

            $usuario='';
            $pass='';
            extract($datos);

            $valido='N';
            $usuarios = $this->modelo->login($usuario);

            if($usuario==$usuarios[0]['login'] && md5($pass)== $usuarios[0]['pass']){
                $_SESSION['usuario']=$usuario;
                $valido='S';
            }
            echo $valido;
            return $valido;
        }

        public function getVistaUsuarios(){
            Vista::render('vistas/Usuarios/V_Usuarios.php');
        }
        public function buscarUsuarios($filtros=array()){
            $usuarios=$this->modelo->buscarUsuarios($filtros);
            $_SESSION["arrayUsuarios"] = $usuarios;
            //echo json_encode($usuarios);
            Vista::render('vistas/Usuarios/V_Usuarios_Listado.php', 
                            array('usuarios'=>$usuarios));
        }
        public function borrarEntrada(){
            header('Location: index.php');
        }
    }
?>