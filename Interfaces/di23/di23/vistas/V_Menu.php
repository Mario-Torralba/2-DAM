<?php

    $menu = $datos['menu'];
    $_SESSION['PERMISOS'] = $menu;

    $arrayPadres = array();
    $contador = 1;
    $menus = array();
    $contador2 = -1;


    foreach ($menu as $elemento) {
        if($contador2 == -1){
            array_push($menus, $elemento);
            $contador2++;
        }else{
            if($menu[$contador2]['ID_MENU'] != $elemento['ID_MENU']){
                array_push($menus, $elemento);
                $contador2++;
            }
        }
    }

    foreach ($menus as $dato) {

        if($dato['ID_PADRE'] == 0){   //   [0]     [1]
            $arrayPadres[$contador] = array($dato, array());
        }

        $contador++;
    }

    foreach ($menus as $dato) {

        if($dato['ID_PADRE'] != 0){
            array_push($arrayPadres[$dato['ID_PADRE']][1],$dato);
        }

    }



    echo "<nav class='navbar navbar-expand-sm navbar-light' style='background-color: #68a8f1' aria-label='Fourth navbar example'>
        <div class='container-fluid'>
            <button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#navbarsExample04' aria-controls='navbarsExample04' aria-expanded='false' aria-label='Toggle navigation'>
                <span class='navbar-toggler-icon'></span>
            </button>

            <div class='collapse navbar-collapse' id='navbarsExample04'>
                <ul class='navbar-nav me-auto mb-2 mb-md-0'>";
            
    

    foreach ($arrayPadres as $padre) {

        if($padre[1] != null){
            echo "  <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' style='color: ";
            if($padre[0]['TITULO'] != 'Disabled'){
                echo "white' ";
            }else{
                echo "grey' ";
            }
            echo    "href='#' data-bs-toggle='dropdown' aria-expanded='false'>".$padre[0]['TITULO']."</a>
                    <ul class='dropdown-menu'>";

            foreach ($padre[1] as $hijo) {

                // print_r($hijo);
                echo '  <li onclick="'.$hijo['ACCION'].'"><a class="dropdown-item" href="#">'.$hijo['TITULO'].'</a></li>';
            }
            echo "  </ul>
                    </li>";
        }else{
            echo '  <li class="nav-item" onclick="'.$padre[0]['ACCION'].'">
            <a class="nav-link active" style="color: ';
            if($padre[0]['TITULO'] != 'Disabled'){
                echo 'white" ';
            }else{
                echo 'grey" ';
            }
        
            echo "aria-current='page' href='#'>".$padre[0]['TITULO']."</a>
            </li>";
        }

    }

echo        "</ul>
        </div>
    </div>
</nav>";




?>