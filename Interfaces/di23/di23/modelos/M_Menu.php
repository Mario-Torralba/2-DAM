<?php

    require_once 'modelos/Modelo.php';
    require_once 'modelos/DAO.php';

    class M_Menu extends Modelo{

        public $DAO;

        public function __construct(){
            parent::__construct(); //ejecuta constructor del padre
            $this->DAO = new DAO();
        }

        public function recuperarMenuModel(){

            $SQL = "SELECT * FROM MENU";
            $menu=$this->DAO->consultar($SQL);

            return $menu;
        }
    }
?>