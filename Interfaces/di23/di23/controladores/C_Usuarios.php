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
            if (count($usuarios)>0) {
                if($usuario==$usuarios[0]['LOGIN'] && md5($pass)== $usuarios[0]['PASS']){
                    $_SESSION['usuario']=$usuario;
                    $_SESSION['ID_USUARIO']=$usuarios[0]['ID_USUARIO'];
                    $valido='S';
                }
            }
            return $valido;
        }

        public function getVistaUsuarios(){
            Vista::render('vistas/Usuarios/V_Usuarios.php');
        }
        public function buscarUsuarios($filtros=array()){
            sleep(0.5);
            $usuarios=$this->modelo->buscarUsuarios($filtros);
            
            Vista::render('vistas/Usuarios/V_Usuarios_Listado.php', 
                            array('usuarios'=>$usuarios));
            Vista::render('vistas/V_Paginado.php', 
            array('usuarios'=>$usuarios));

        }

        public function buscarUsuariosTotales($filtros=array()){
 
            $usuarios=$this->modelo->buscarUsuariosTotales($filtros);
            $contador = 0;
            foreach ($usuarios as $element) {
                $contador++;
            }
            $_SESSION["cantidadTotal"] = $contador;

        }

        public function crearUsuarios($usuario){
            
            $salida = $this->modelo->crear($usuario);

        }
        public function borrarUsuarios($data){
            $salida = $this->modelo->borrar($data);
            $usuarios=$this->modelo->buscarUsuariosTotales($data);
            $contador = 0;
            foreach ($usuarios as $element) {
                $contador++;
            }
            $_SESSION["cantidadTotal"] = $contador;
            $usuarios=$this->modelo->buscarUsuarios($data);
            Vista::render('vistas/Usuarios/V_Usuarios_Listado.php',
                            array('usuarios'=>$usuarios));
            Vista::render('vistas/V_Paginado.php', 
                            array('usuarios'=>$usuarios));
        }

        public function editarUsuarios($filtros=array()){
            $id=9999;
            extract($filtros);
            $_SESSION['idEditar'] = $id;
            $usuarios=$this->modelo->buscarUsuarios($filtros);
            Vista::render('vistas/Usuarios/V_Usuarios_Editar.php',
                            array('usuarios'=>$usuarios));
            Vista::render('vistas/V_Paginado.php', 
                            array('usuarios'=>$usuarios));
        }

        public function confirmarEditarUsuarios($data){

            $this->modelo->editar($data);
            $usuarios=$this->modelo->buscarUsuarios($data);
            Vista::render('vistas/Usuarios/V_Usuarios_Listado.php', 
                            array('usuarios'=>$usuarios));
            Vista::render('vistas/V_Paginado.php', 
                            array('usuarios'=>$usuarios));

        }

    }

?>