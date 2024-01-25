<?php
    require_once 'controladores/Controlador.php';
    require_once 'vistas/Vista.php';
    require_once 'modelos/M_Menu.php';

    class C_Menu extends Controlador{

        private $modelo;

        public function __construct(){
            parent::__construct();
            $this->modelo = new M_Menu();
        }

        public function recuperarMenuController(){
            $menu=$this->modelo->recuperarMenuModel();
            Vista::render('vistas/V_Menu.php', 
            array('menu'=>$menu));
        }

        public function getVistaConfiguracionMenu(){
            Vista::render('vistas/V_Configuracion_Menu.php');
        }
    }

?>