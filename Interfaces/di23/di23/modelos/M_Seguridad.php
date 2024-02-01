<?php

    require_once 'modelos/Modelo.php';
    require_once 'modelos/DAO.php';

    class M_Seguridad extends Modelo{

        public $DAO;

        public function __construct(){
            parent::__construct(); //ejecuta constructor del padre
            $this->DAO = new DAO();
        }

    }

?>