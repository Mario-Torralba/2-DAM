<?php
    require_once 'controladores/Controlador.php';
    require_once 'vistas/Vista.php';
    require_once 'modelos/M_Seguridad.php';

    class C_Seguridad extends Controlador{

        private $modelo;

        public function __construct(){
            parent::__construct();
            $this->modelo = new M_Seguridad();
        }

        public function getVistaSeguridad(){
            $roles=$this->modelo->buscarRoles();
            $_SESSION['ROLES'] = $roles;
            Vista::render('vistas/V_Seguridad.php');
        }

        public function buscarMenus($filtros){
            $menus=$this->modelo->buscarMenus($filtros);
            Vista::render('vistas/V_SeguridadBusquedaMenus.php', 
            array('menus'=>$menus));
        }

    }

?>