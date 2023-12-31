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
            $usuario='';
            $pass='';
            extract($filtros);
            $pass = md5($pass);
            
            $SQL="SELECT * FROM usuarios WHERE 1=1 ";
            
            if($usuario!='' && $pass!=''){
                $usuario=addslashes($usuario);
                $pass=addslashes($pass);
                $SQL.= "AND login = '$usuario' AND pass = '$pass' ";
            }

            if($b_texto!=''){
                $aTexto=explode(' ', $b_texto);
                $SQL.=" AND (1=2 ";
                foreach ($aTexto as $palabra){
                    $SQL.=" OR apellido_1 LIKE '%$palabra%' ";
                }
                $SQL.=" ) ";
                //$SQL.=" AND apellido_1='".$b_texto."' ";
            }
            
            $usuarios=$this->DAO->consultar($SQL);
            return $usuarios;
        }

    }
?>