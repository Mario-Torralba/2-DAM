<?php
    require_once "modelo/Modelo.php";
    class M_Usuarios extends Modelo{
        public $DAO;

        public function __construct(){
            
            parent::__construct(); //Ejecuta constructor del padre
            $this->DAO = new DAO();

        }

        public function buscaUsuarios($filtros=array()){
            $SQL = "SELECT * FROM usuarios WHERE 1=1 ";
            $usuarios = $this-> DAO -> consultar($SQL);
            return $usuarios;
        }
  
    }
?>