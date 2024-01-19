<?php
    require_once 'modelos/Modelo.php';
    require_once 'modelos/DAO.php';
    class M_Usuarios extends Modelo{
        public $DAO;

        public function __construct(){
            parent::__construct(); //ejecuta constructor del padre
            $this->DAO = new DAO();
        }

        public function buscarUsuarios($filtros=array()){
            $b_texto='';
            $nombre_texto='';
            $paginaActual = $_SESSION["paginaActual"];
            $cantidadEntradas = $_SESSION["cantidadEntradas"];
            
            extract($filtros);
            
            $SQL="SELECT * FROM USUARIO WHERE 1=1 ";
            
            if($nombre_texto!=''){
                $aTexto=explode(' ', $nombre_texto);
                $SQL.=" AND (1=2 ";
                foreach ($aTexto as $palabra){
                    $SQL.=" OR NOMBRE LIKE '%$palabra%' ";
                }
                $SQL.=" ) ";
            }

            if($apellido_texto!=''){
                $aTexto=explode(' ', $apellido_texto);
                $SQL.=" AND (1=2 ";
                foreach ($aTexto as $palabra){
                    $SQL.=" OR APELLIDO_1 LIKE '%$palabra%' ";
                }
                $SQL.=" ) ";
            }

            if($a_texto!=''){
                $aTexto=explode(' ', $a_texto);
                $SQL.=" AND (1=2 ";
                foreach ($aTexto as $palabra){
                    $SQL.=" OR ACTIVO LIKE '%$palabra%' ";
                }
                $SQL.=" ) LIMIT " . (($paginaActual-1)*$cantidadEntradas) . ",$cantidadEntradas";
            }
            
            $usuarios=$this->DAO->consultar($SQL);
            return $usuarios;
        }

        public function buscarUsuariosTotales($filtros=array()){
            $b_texto='';
            $nombre_texto='';
            
            extract($filtros);
            
            $SQL="SELECT * FROM USUARIO WHERE 1=1 ";
            
            if($nombre_texto!=''){
                $aTexto=explode(' ', $nombre_texto);
                $SQL.=" AND (1=2 ";
                foreach ($aTexto as $palabra){
                    $SQL.=" OR NOMBRE LIKE '%$palabra%' ";
                }
                $SQL.=" ) ";
            }

            if($apellido_texto!=''){
                $aTexto=explode(' ', $apellido_texto);
                $SQL.=" AND (1=2 ";
                foreach ($aTexto as $palabra){
                    $SQL.=" OR APELLIDO_1 LIKE '%$palabra%' ";
                }
                $SQL.=" ) ";
            }

            if($a_texto!=''){
                $aTexto=explode(' ', $a_texto);
                $SQL.=" AND (1=2 ";
                foreach ($aTexto as $palabra){
                    $SQL.=" OR ACTIVO LIKE '%$palabra%' ";
                }
                $SQL.=" ) ";
            }
            
            $usuarios=$this->DAO->consultar($SQL);
            return $usuarios;
        }

        public function login($usuario){

            $SQL = "SELECT * FROM USUARIO WHERE LOGIN LIKE '%$usuario%'";
            $usuarios=$this->DAO->consultar($SQL);

            return $usuarios;
        }

        public function crear($usuario){

            $nombre_crear='';
            $apellido_1_crear='';
            $apellido_2_crear='';
            $login_crear='';
            $pass_crear='';

            extract($usuario);

            $passw = md5($pass_crear);

            $SQL = "INSERT INTO USUARIO (NOMBRE, APELLIDO_1, APELLIDO_2, LOGIN, PASS) VALUES ('$nombre_crear', '$apellido_1_crear', '$apellido_2_crear', '$login_crear', '$passw')";

            $this->DAO->insertar($SQL);
            
            echo $SQL;

            return;
        }

        public function borrar($data){

            $id = 9999;
            extract($data);

            $SQL = "DELETE FROM USUARIO WHERE ID_USUARIO = $id;";
            
            $filas = $this->DAO->borrar($SQL);

            return $filas;
        }

        public function editar($data){

            $id = 9999;
            $nombre_editar='';
            $apellido_1_editar='';
            $apellido_2_editar='';
            $email_editar = '';
            $activo_editar = '';

            extract($data);

            $SQL = "UPDATE USUARIO SET NOMBRE = '$nombre_editar', APELLIDO_1 = '$apellido_1_editar', APELLIDO_2 = '$apellido_2_editar', MAIL = '$email_editar', ACTIVO = '$activo_editar' WHERE ID_USUARIO = $id;";
            
            $filas = $this->DAO->actualizar($SQL);

            return $filas;
        }

    }
?>