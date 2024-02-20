<?php

    require_once 'modelos/Modelo.php';
    require_once 'modelos/DAO.php';

    class M_Seguridad extends Modelo{

        public $DAO;

        public function __construct(){
            parent::__construct(); //ejecuta constructor del padre
            $this->DAO = new DAO();
        }
        public function buscarRoles(){

            $SQL = "SELECT * FROM ROL";
            $roles=$this->DAO->consultar($SQL);

            return $roles;

        }

        public function buscarMenus($filtros){

            $nombre_texto = '';
            $rol_texto = '';
            
            extract($filtros);

            if($nombre_texto!=''){
                $SQL = 'SELECT
                U.ID_USUARIO
                PU.ID_PERMISO_USUARIO,
                P.ID_PERMISO,
                P.NOMBRE_PERMISO,
                RU.ID_ROL_USUARIO,
                R.ID_ROL,
                R.NOMBRE_ROL,
                M.ID_MENU,
                M.TITULO,
                M.ID_PADRE,
                M.ACCION,
                M.ORDEN,
                M.PRIVADO
                FROM USUARIO U
                INNER JOIN PERMISO_USUARIO PU ON U.ID_USUARIO = PU.ID_USUARIO
                INNER JOIN PERMISO P ON PU.ID_PERMISO = P.ID_PERMISO
                INNER JOIN ROL_USUARIO RU ON U.ID_USUARIO = RU.ID_USUARIO
                INNER JOIN ROL R ON RU.ID_ROL = R.ID_ROL
                INNER JOIN MENU M ON P.ID_MENU = M.ID_MENU
                WHERE U.ID_USUARIO = '.$nombre_texto.'
                ORDER BY M.ID_PADRE ASC, M.ORDEN ASC;';
            }else{

                $SQL = 'SELECT
                U.ID_USUARIO,
                PU.ID_PERMISO_USUARIO,
                P.ID_PERMISO,
                P.NOMBRE_PERMISO,
                RU.ID_ROL_USUARIO,
                R.ID_ROL,
                R.NOMBRE_ROL,
                M.ID_MENU,
                M.TITULO,
                M.ID_PADRE,
                M.ACCION,
                M.ORDEN,
                M.PRIVADO
                FROM USUARIO U
                INNER JOIN PERMISO_USUARIO PU ON U.ID_USUARIO = PU.ID_USUARIO
                INNER JOIN PERMISO P ON PU.ID_PERMISO = P.ID_PERMISO
                INNER JOIN ROL_USUARIO RU ON U.ID_USUARIO = RU.ID_USUARIO
                INNER JOIN ROL R ON RU.ID_ROL = R.ID_ROL
                INNER JOIN MENU M ON P.ID_MENU = M.ID_MENU
                ORDER BY M.ID_PADRE ASC, M.ORDEN ASC;';
            }

            echo $SQL;
            $menus=$this->DAO->consultar($SQL);

    
            return $menus;

        }

    }

?>