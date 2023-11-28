<?php
    require_once 'controladores/Controlador.php';
    require_once 'vistas/Vista.php';
    require_once 'modelos/M_Usuarios.php';

    class C_Paginado extends Controlador{
        private $modelo;
        public function __construct(){
            parent::__construct();
        }

        public static function getVistaPaginado(){
            Vista::render('vistas/V_Paginado.php');
        }
        
    }
?>