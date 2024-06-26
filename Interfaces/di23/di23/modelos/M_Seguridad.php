<?php

require_once 'modelos/Modelo.php';
require_once 'modelos/DAO.php';

class M_Seguridad extends Modelo
{

    public $DAO;

    public function __construct()
    {
        parent::__construct(); //ejecuta constructor del padre
        $this->DAO = new DAO();
    }
    public function buscarRoles()
    {

        $SQL = "SELECT * FROM ROL";
        $roles = $this->DAO->consultar($SQL);

        return $roles;

    }

    public function buscarMenus($parametros)
    {

        $id_usuario = 0;
        $rol_usuario = '';
        extract($parametros);

        if ($id_usuario != 0) {
            $SQL = "SELECT
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
                WHERE U.ID_USUARIO = $id_usuario 
                ORDER BY M.ID_PADRE ASC, M.ORDEN ASC;";
        } else {

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

        $menus = $this->DAO->consultar($SQL);


        return $menus;

    }

    public function crearPadre($parametros)
    {

        $padre = 0;
        $nombreMenu = '';

        extract($parametros);

        $usuario = $_SESSION['ID_USUARIO_MANTENIMIENTO'];

        // CAMBIOS EN TABLA MENU


        $SQL = 'UPDATE MENU
                    SET ID_MENU = ID_MENU + 1
                    WHERE ID_MENU >= ' . $padre . ';';

        $this->DAO->actualizar($SQL);

        $SQL = 'UPDATE MENU
                    SET ID_PADRE = ID_PADRE + 1
                    WHERE ID_PADRE >= ' . $padre . ';';

        $this->DAO->actualizar($SQL);

        $SQL = 'UPDATE MENU
                    SET ORDEN = ORDEN + 1
                    WHERE ID_MENU >= ' . $padre . ' AND ID_PADRE = 0;';

        $this->DAO->actualizar($SQL);

        $SQL = "INSERT INTO MENU (ID_MENU, TITULO, ID_PADRE, ACCION, ORDEN, PRIVADO)
                    VALUES (" . $padre . ", '" . $nombreMenu . "', 0, '', " . $padre . ", true);";

        $this->DAO->actualizar($SQL);

        // TABLA PERMISO, CREAR PERMISO BASICO Y AUMENTAR LOS ID_MENU

        $SQL = 'UPDATE PERMISO
            SET ID_MENU = ID_MENU + 1
            WHERE ID_MENU >= ' . $padre . ';';

        $this->DAO->actualizar($SQL);

        $SQL = "SELECT MAX(ID_PERMISO) + 1 AS siguiente_id FROM PERMISO;";

        $cantidadPermisos = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO (ID_PERMISO, ID_MENU, NOMBRE_PERMISO)
                    VALUES (" . $cantidadPermisos[0]['siguiente_id'] . ", " . $padre . ", 'ver" . $nombreMenu . "');";

        $this->DAO->actualizar($SQL);



        // CAMBIOS EN TABLA PERMISO_USUARIO

        $SQL = "SELECT MAX(ID_PERMISO_USUARIO) + 1 AS siguiente_id FROM PERMISO_USUARIO;";

        $cantidadPermisoUsuario = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO_USUARIO (ID_PERMISO_USUARIO, ID_PERMISO, ID_USUARIO)
            VALUES (" . $cantidadPermisoUsuario[0]['siguiente_id'] . ", " . $cantidadPermisos[0]['siguiente_id'] . ", " . $usuario . ");";

        $this->DAO->actualizar($SQL);

        // CAMBIOS EN TABLA PERMISO_ROL

        $SQL = "SELECT MAX(ID_PERMISO_ROL) + 1 AS siguiente_id FROM PERMISO_ROL;";

        $cantidadPermisorRol = $this->DAO->consultar($SQL);

        $SQL = "SELECT ID_ROL FROM ROL_USUARIO WHERE ID_USUARIO = " . $usuario . ";";

        $rol = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO_ROL (ID_PERMISO_ROL, ID_PERMISO, ID_ROL)
            VALUES (" . $cantidadPermisorRol[0]['siguiente_id'] . ", " . $cantidadPermisos[0]['siguiente_id'] . ", " . $rol[0]['ID_ROL'] . ");";

        $this->DAO->actualizar($SQL);


        return $roles;

    }


    public function crearHijo($parametros)
    {

        $padre = 0;
        $hijo = 0;
        $nombreMenu = '';

        extract($parametros);

        $usuario = $_SESSION['ID_USUARIO_MANTENIMIENTO'];

        // CAMBIOS EN TABLA MENU



        $SQL = "SELECT * FROM MENU ORDER BY id_menu LIMIT " . ($padre - 1) . ", 1;";

        $posicionMenu = $this->DAO->consultar($SQL);

        $SQL = "UPDATE MENU
                SET ORDEN = ORDEN + 1
                WHERE ORDEN >=" . $hijo . " AND ID_PADRE = " . $posicionMenu[0]['ID_MENU'] . ";";

        $this->DAO->actualizar($SQL);

        $SQL = "SELECT MAX(ID_MENU) + 1 AS siguiente_id FROM MENU;";

        $cantidadMenu = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO MENU (ID_MENU, TITULO, ID_PADRE, ACCION, ORDEN, PRIVADO)
                    VALUES (" . $cantidadMenu[0]['siguiente_id'] . ", '" . $nombreMenu . "', " . $posicionMenu[0]['ID_MENU'] . ", '', " . $hijo . ", true);";
        echo $SQL;

        $this->DAO->actualizar($SQL);

        // // TABLA PERMISO, CREAR PERMISO BASICO 


        $SQL = "SELECT MAX(ID_PERMISO) + 1 AS siguiente_id FROM PERMISO;";

        $cantidadPermisos = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO (ID_PERMISO, ID_MENU, NOMBRE_PERMISO)
                    VALUES (" . $cantidadPermisos[0]['siguiente_id'] . ", " . $cantidadMenu[0]['siguiente_id'] . ", 'ver" . $nombreMenu . "');";

        $this->DAO->actualizar($SQL);



        // // CAMBIOS EN TABLA PERMISO_USUARIO

        $SQL = "SELECT MAX(ID_PERMISO_USUARIO) + 1 AS siguiente_id FROM PERMISO_USUARIO;";

        $cantidadPermisoUsuario = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO_USUARIO (ID_PERMISO_USUARIO, ID_PERMISO, ID_USUARIO)
            VALUES (" . $cantidadPermisoUsuario[0]['siguiente_id'] . ", " . $cantidadPermisos[0]['siguiente_id'] . ", " . $usuario . ");";

        $this->DAO->actualizar($SQL);

        // // CAMBIOS EN TABLA PERMISO_ROL

        $SQL = "SELECT MAX(ID_PERMISO_ROL) + 1 AS siguiente_id FROM PERMISO_ROL;";

        $cantidadPermisorRol = $this->DAO->consultar($SQL);

        $SQL = "SELECT ID_ROL FROM ROL_USUARIO WHERE ID_USUARIO = " . $usuario . ";";

        $rol = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO_ROL (ID_PERMISO_ROL, ID_PERMISO, ID_ROL)
            VALUES (" . $cantidadPermisorRol[0]['siguiente_id'] . ", " . $cantidadPermisos[0]['siguiente_id'] . ", " . $rol[0]['ID_ROL'] . ");";

        $this->DAO->actualizar($SQL);


        return $roles;

    }

    public function crearHijoAlFinal($parametros)
    {

        $padre = 0;
        $nombreMenu = '';

        extract($parametros);

        $usuario = $_SESSION['ID_USUARIO_MANTENIMIENTO'];

        // CAMBIOS EN TABLA MENU

        $SQL = "SELECT * FROM MENU ORDER BY id_menu LIMIT " . ($padre - 1) . ", 1;";

        $posicionMenu = $this->DAO->consultar($SQL);

        $SQL = "SELECT MAX(ID_MENU) + 1 AS siguiente_id FROM MENU;";

        $cantidadMenu = $this->DAO->consultar($SQL);

        $SQL = "SELECT MAX(ORDEN) + 1 AS siguiente_id FROM MENU WHERE ID_PADRE = " . $posicionMenu[0]['ID_MENU'] . ";";

        $cantidadOrden = $this->DAO->consultar($SQL);


        if ($cantidadOrden[0]['siguiente_id'] == null) {
            $SQL = "INSERT INTO MENU (ID_MENU, TITULO, ID_PADRE, ACCION, ORDEN, PRIVADO)
                    VALUES (" . $cantidadMenu[0]['siguiente_id'] . ", '" . $nombreMenu . "', " . $posicionMenu[0]['ID_MENU'] . ", '', 0, true);";
        } else {
            $SQL = "INSERT INTO MENU (ID_MENU, TITULO, ID_PADRE, ACCION, ORDEN, PRIVADO)
                    VALUES (" . $cantidadMenu[0]['siguiente_id'] . ", '" . $nombreMenu . "', " . $posicionMenu[0]['ID_MENU'] . ", '', " . $cantidadOrden[0]['siguiente_id'] . ", true);";
        }

        echo $SQL;

        $this->DAO->actualizar($SQL);

        // // TABLA PERMISO, CREAR PERMISO BASICO 


        $SQL = "SELECT MAX(ID_PERMISO) + 1 AS siguiente_id FROM PERMISO;";

        $cantidadPermisos = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO (ID_PERMISO, ID_MENU, NOMBRE_PERMISO)
                    VALUES (" . $cantidadPermisos[0]['siguiente_id'] . ", " . $cantidadMenu[0]['siguiente_id'] . ", 'ver" . $nombreMenu . "');";

        $this->DAO->actualizar($SQL);


        // // CAMBIOS EN TABLA PERMISO_USUARIO

        $SQL = "SELECT MAX(ID_PERMISO_USUARIO) + 1 AS siguiente_id FROM PERMISO_USUARIO;";

        $cantidadPermisoUsuario = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO_USUARIO (ID_PERMISO_USUARIO, ID_PERMISO, ID_USUARIO)
            VALUES (" . $cantidadPermisoUsuario[0]['siguiente_id'] . ", " . $cantidadPermisos[0]['siguiente_id'] . ", " . $usuario . ");";

        $this->DAO->actualizar($SQL);

        // // CAMBIOS EN TABLA PERMISO_ROL

        $SQL = "SELECT MAX(ID_PERMISO_ROL) + 1 AS siguiente_id FROM PERMISO_ROL;";

        $cantidadPermisorRol = $this->DAO->consultar($SQL);

        $SQL = "SELECT ID_ROL FROM ROL_USUARIO WHERE ID_USUARIO = " . $usuario . ";";

        $rol = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO_ROL (ID_PERMISO_ROL, ID_PERMISO, ID_ROL)
            VALUES (" . $cantidadPermisorRol[0]['siguiente_id'] . ", " . $cantidadPermisos[0]['siguiente_id'] . ", " . $rol[0]['ID_ROL'] . ");";

        $this->DAO->actualizar($SQL);


        return $roles;

    }
    public function borrarPadre($parametros)
    {

        $padre = 0;
        $hijo = 0;
        $nombreMenu = '';

        extract($parametros);

        $usuario = $_SESSION['ID_USUARIO_MANTENIMIENTO'];

        // CAMBIOS EN TABLA MENU



        $SQL = 'DELETE FROM MENU
                WHERE ID_MENU = ' . $padre . ';';

        $this->DAO->actualizar($SQL);

        $SQL = 'SELECT ID_MENU
                FROM MENU
                WHERE ID_PADRE = ' . $padre . ';';

        $datosBorrados = $this->DAO->consultar($SQL);

        $SQL = 'DELETE FROM MENU
                WHERE ID_PADRE = ' . $padre . ';';

        $this->DAO->actualizar($SQL);


        // // TABLA PERMISO, CREAR PERMISO BASICO Y AUMENTAR LOS ID_MENU

        $SQL = 'SELECT ID_PERMISO FROM PERMISO
                WHERE ID_MENU = ' . $padre . ';';

        $permisosBorrados = $this->DAO->consultar($SQL);

        $SQL = 'DELETE FROM PERMISO
                WHERE ID_MENU = ' . $padre . ';';

        $this->DAO->actualizar($SQL);

        foreach ($datosBorrados as $element) {

            $SQL = 'SELECT ID_PERMISO FROM PERMISO
            WHERE ID_MENU = ' . $element['ID_MENU'] . ';';

            array_push($permisosBorrados, $this->DAO->consultar($SQL));
        }

        foreach ($datosBorrados as $element) {

            $SQL = 'DELETE FROM PERMISO
            WHERE ID_MENU = ' . $element['ID_MENU'] . ';';

            $this->DAO->actualizar($SQL);
        }

        // // CAMBIOS EN TABLA PERMISO_ROL

        $contador = 0;
        foreach ($permisosBorrados as $element) {

            if ($contador == 0) {
                $SQL = 'DELETE FROM PERMISO_ROL
                WHERE ID_PERMISO = ' . $element['ID_PERMISO'] . ';';
            } else {
                $SQL = 'DELETE FROM PERMISO_ROL
                WHERE ID_PERMISO = ' . $element[0]['ID_PERMISO'] . ';';
            }

            $this->DAO->actualizar($SQL);
            $contador += 1;
        }

        // // CAMBIOS EN TABLA PERMISO_USUARIO
        $contador = 0;
        foreach ($permisosBorrados as $element) {

            if ($contador == 0) {
                $SQL = 'DELETE FROM PERMISO_USUARIO
                WHERE ID_PERMISO = ' . $element['ID_PERMISO'] . ';';
            } else {
                $SQL = 'DELETE FROM PERMISO_USUARIO
                WHERE ID_PERMISO = ' . $element[0]['ID_PERMISO'] . ';';
            }

            $this->DAO->actualizar($SQL);
            $contador += 1;
        }


        return $roles;

    }

    public function borrarHijo($parametros)
    {

        $padre = 0;
        $hijo = 0;
        $nombreMenu = '';

        extract($parametros);

        $usuario = $_SESSION['ID_USUARIO_MANTENIMIENTO'];

        // CAMBIOS EN TABLA MENU


        $SQL = 'SELECT ID_MENU FROM MENU
        WHERE ID_PADRE = 0;';

        $ordenMenu = $this->DAO->consultar($SQL);

        $SQL = 'SELECT ORDEN FROM MENU
        WHERE ID_PADRE = ' . $ordenMenu[$padre - 1]['ID_MENU'] . ';';

        $ordenOrden = $this->DAO->consultar($SQL);

        $SQL = 'SELECT ID_MENU FROM MENU
                WHERE ID_PADRE = ' . $ordenMenu[$padre - 1]['ID_MENU'] . '
                AND ORDEN = ' . $ordenOrden[$hijo - 1]['ORDEN'] . ';';

        $datosBorrados = $this->DAO->consultar($SQL);

        $SQL = 'DELETE FROM MENU
                WHERE ID_PADRE = ' . $ordenMenu[$padre - 1]['ID_MENU'] . '
                AND ORDEN = ' . $ordenOrden[$hijo - 1]['ORDEN'] . ';';

        $this->DAO->actualizar($SQL);


        // // TABLA PERMISO, CREAR PERMISO BASICO Y AUMENTAR LOS ID_MENU


        $permisosBorrados = array();

        foreach ($datosBorrados as $element) {

            $SQL = 'SELECT ID_PERMISO FROM PERMISO
            WHERE ID_MENU = ' . $element['ID_MENU'] . ';';

            array_push($permisosBorrados, $this->DAO->consultar($SQL));
        }

        foreach ($datosBorrados as $element) {

            $SQL = 'DELETE FROM PERMISO
            WHERE ID_MENU = ' . $element['ID_MENU'] . ';';

            $this->DAO->actualizar($SQL);
        }


        // // // CAMBIOS EN TABLA PERMISO_ROL

        foreach ($permisosBorrados as $element) {

            $SQL = 'DELETE FROM PERMISO_ROL
            WHERE ID_PERMISO = ' . $element[0]['ID_PERMISO'] . ';';

            $this->DAO->actualizar($SQL);

        }

        // // // CAMBIOS EN TABLA PERMISO_USUARIO

        foreach ($permisosBorrados as $element) {

            $SQL = 'DELETE FROM PERMISO_USUARIO
            WHERE ID_PERMISO = ' . $element[0]['ID_PERMISO'] . ';';

            $this->DAO->actualizar($SQL);
        }



        return $roles;

    }

    public function borrarPermisoPadre($parametros)
    {

        $padre = 0;
        $hijo = 0;
        $nombreMenu = '';

        extract($parametros);

        $usuario = $_SESSION['ID_USUARIO_MANTENIMIENTO'];

        // CAMBIOS EN TABLA MENU


        // TABLA PERMISO

        $SQL = 'SELECT ID_PERMISO FROM PERMISO
        WHERE NOMBRE_PERMISO = "'.$nombreMenu.'";';

        $permisoBorrado = $this->DAO->consultar($SQL);

        $SQL = 'DELETE FROM PERMISO
        WHERE NOMBRE_PERMISO = "'.$nombreMenu.'";';

        $this->DAO->actualizar($SQL);


        // // // CAMBIOS EN TABLA PERMISO_ROL

        $SQL = 'DELETE FROM PERMISO_ROL
        WHERE ID_PERMISO = '.$permisoBorrado[0]['ID_PERMISO'].';';

        $this->DAO->actualizar($SQL);

        // // // CAMBIOS EN TABLA PERMISO_USUARIO

        $SQL = 'DELETE FROM PERMISO_USUARIO
        WHERE ID_PERMISO = '.$permisoBorrado[0]['ID_PERMISO'].';';

        $this->DAO->actualizar($SQL);

       


        return $permisoBorrado;

    }

    public function borrarPermisoHijo($parametros)
    {

        $padre = 0;
        $hijo = 0;
        $nombreMenu = '';

        extract($parametros);

        $usuario = $_SESSION['ID_USUARIO_MANTENIMIENTO'];

        // CAMBIOS EN TABLA MENU

        

        // TABLA PERMISO

        $SQL = 'SELECT ID_PERMISO FROM PERMISO
        WHERE NOMBRE_PERMISO = "'.$nombreMenu.'";';

        $permisoBorrado = $this->DAO->consultar($SQL);

        $SQL = 'DELETE FROM PERMISO
        WHERE NOMBRE_PERMISO = "'.$nombreMenu.'";';

        $this->DAO->actualizar($SQL);


        // // // CAMBIOS EN TABLA PERMISO_ROL

        $SQL = 'DELETE FROM PERMISO_ROL
        WHERE ID_PERMISO = '.$permisoBorrado[0]['ID_PERMISO'].';';

        $this->DAO->actualizar($SQL);

        // // // CAMBIOS EN TABLA PERMISO_USUARIO

        $SQL = 'DELETE FROM PERMISO_USUARIO
        WHERE ID_PERMISO = '.$permisoBorrado[0]['ID_PERMISO'].';';

        $this->DAO->actualizar($SQL);



        return $permisoBorrado;

    }
    public function añadirPermisoPadre($parametros)
    {

        $padre = 0;
        $hijo = 0;
        $nombreMenu = '';

        extract($parametros);

        $usuario = $_SESSION['ID_USUARIO_MANTENIMIENTO'];

        // CAMBIOS EN TABLA MENU

        
        // TABLA PERMISO

        $SQL = "SELECT * FROM MENU ORDER BY id_menu LIMIT " . ($padre - 1) . ", 1;";

        $posicionMenu = $this->DAO->consultar($SQL);

        $SQL = "SELECT MAX(ID_PERMISO) + 1 AS siguiente_id FROM PERMISO;";

        $nuevoPermiso = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO (ID_PERMISO, ID_MENU, NOMBRE_PERMISO)
        VALUES (" . $nuevoPermiso[0]['siguiente_id'] . ", " . $posicionMenu[0]['ID_MENU'] . ", '" . $nombreMenu . "');";

        $this->DAO->actualizar($SQL);


        // CAMBIOS EN TABLA PERMISO_ROL

        $SQL = "SELECT MAX(ID_PERMISO_ROL) + 1 AS siguiente_id FROM PERMISO_ROL;";

        $cantidadPermisorRol = $this->DAO->consultar($SQL);

        $SQL = "SELECT ID_ROL FROM ROL_USUARIO WHERE ID_USUARIO = " . $usuario . ";";

        $rol = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO_ROL (ID_PERMISO_ROL, ID_PERMISO, ID_ROL)
            VALUES (" . $cantidadPermisorRol[0]['siguiente_id'] . ", " . $nuevoPermiso[0]['siguiente_id'] . ", " . $rol[0]['ID_ROL'] . ");";

        $this->DAO->actualizar($SQL);

        // CAMBIOS EN TABLA PERMISO_USUARIO

        $SQL = "SELECT MAX(ID_PERMISO_USUARIO) + 1 AS siguiente_id FROM PERMISO_USUARIO;";

        $cantidadPermisoUsuario = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO_USUARIO (ID_PERMISO_USUARIO, ID_PERMISO, ID_USUARIO)
            VALUES (" . $cantidadPermisoUsuario[0]['siguiente_id'] . ", " . $nuevoPermiso[0]['siguiente_id'] . ", " . $usuario . ");";

        $this->DAO->actualizar($SQL);

        

        return $usuario;

    }
    public function añadirPermisoHijo($parametros)
    {

        $padre = 0;
        $hijo = 0;
        $nombreMenu = '';

        extract($parametros);

        $usuario = $_SESSION['ID_USUARIO_MANTENIMIENTO'];

        // CAMBIOS EN TABLA MENU

       
        // TABLA PERMISO

        $SQL = "SELECT * FROM MENU ORDER BY id_menu LIMIT " . ($padre - 1) . ", 1;";

        $posicionMenuPadre = $this->DAO->consultar($SQL);

        $SQL = "SELECT * FROM MENU WHERE ID_PADRE =". $posicionMenuPadre[0]['ID_MENU'] ." 
                ORDER BY id_menu
                LIMIT " . ($hijo - 1) . ", 1;"; 
        echo $SQL;

        $posicionMenuHijo = $this->DAO->consultar($SQL);

        $SQL = "SELECT MAX(ID_PERMISO) + 1 AS siguiente_id FROM PERMISO;";

        $nuevoPermiso = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO (ID_PERMISO, ID_MENU, NOMBRE_PERMISO)
        VALUES (" . $nuevoPermiso[0]['siguiente_id'] . ", " . $posicionMenuHijo[0]['ID_MENU'] . ", '" . $nombreMenu . "');";

        $this->DAO->actualizar($SQL);


        // CAMBIOS EN TABLA PERMISO_ROL

        $SQL = "SELECT MAX(ID_PERMISO_ROL) + 1 AS siguiente_id FROM PERMISO_ROL;";

        $cantidadPermisorRol = $this->DAO->consultar($SQL);

        $SQL = "SELECT ID_ROL FROM ROL_USUARIO WHERE ID_USUARIO = " . $usuario . ";";

        $rol = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO_ROL (ID_PERMISO_ROL, ID_PERMISO, ID_ROL)
            VALUES (" . $cantidadPermisorRol[0]['siguiente_id'] . ", " . $nuevoPermiso[0]['siguiente_id'] . ", " . $rol[0]['ID_ROL'] . ");";

        $this->DAO->actualizar($SQL);

        // CAMBIOS EN TABLA PERMISO_USUARIO

        $SQL = "SELECT MAX(ID_PERMISO_USUARIO) + 1 AS siguiente_id FROM PERMISO_USUARIO;";

        $cantidadPermisoUsuario = $this->DAO->consultar($SQL);

        $SQL = "INSERT INTO PERMISO_USUARIO (ID_PERMISO_USUARIO, ID_PERMISO, ID_USUARIO)
            VALUES (" . $cantidadPermisoUsuario[0]['siguiente_id'] . ", " . $nuevoPermiso[0]['siguiente_id'] . ", " . $usuario . ");";

        $this->DAO->actualizar($SQL);

        


        return $usuario;

    }


}

?>