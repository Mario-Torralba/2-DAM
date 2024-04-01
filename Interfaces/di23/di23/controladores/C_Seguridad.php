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

        public function buscarMenus($parametros){
            $menus=$this->modelo->buscarMenus($parametros);
            Vista::render('vistas/V_SeguridadBusquedaMenus.php', 
            array('menus'=>$menus));
        }
        public function alterarMenusMantenimiento($parametros){

            
            $tipo=0;
            extract($parametros);
            if($tipo==1){
                $cambios=$this->modelo->crearPadre($parametros);
            }
            if($tipo==2){
                $cambios=$this->modelo->crearHijo($parametros);
            }
            if($tipo==3){
                $cambios=$this->modelo->crearHijoAlFinal($parametros);
            }
            if($tipo==4){
                $cambios=$this->modelo->borrarPadre($parametros);
            }
            // Vista::render('vistas/V_SeguridadBusquedaMenus.php', 
            // array('menus'=>$cambios));

            


        }

    }

?>