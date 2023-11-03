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
            extract($filtros);
            
            $SQL="SELECT * FROM usuarios WHERE 1=1 ";
            
            if($nombre_texto!=''){
                $aTexto=explode(' ', $nombre_texto);
                $SQL.=" AND (1=2 ";
                foreach ($aTexto as $palabra){
                    $SQL.=" OR nombre LIKE '%$palabra%' ";
                }
                $SQL.=" ) ";
            }

            if($apellido_texto!=''){
                $aTexto=explode(' ', $apellido_texto);
                $SQL.=" AND (1=2 ";
                foreach ($aTexto as $palabra){
                    $SQL.=" OR apellido_1 LIKE '%$palabra%' ";
                }
                $SQL.=" ) ";
            }

            if($a_texto!=''){
                $aTexto=explode(' ', $a_texto);
                $SQL.=" AND (1=2 ";
                foreach ($aTexto as $palabra){
                    $SQL.=" OR activo LIKE '%$palabra%' ";
                }
                $SQL.=" ) ";
            }
            
            $usuarios=$this->DAO->consultar($SQL);
            return $usuarios;
        }

        public function login($usuario){

            $SQL = "SELECT * FROM usuarios WHERE login LIKE '%$usuario%'";
            $usuarios=$this->DAO->consultar($SQL);

            return $usuarios;
        }

    }
?>