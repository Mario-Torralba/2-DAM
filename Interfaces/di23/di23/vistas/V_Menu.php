<?php

    $menu = $datos['menu'];

    $arrayPadres = array();
    $arrayHijos = array();
    $contador = 1;

    foreach ($menu as $dato) {

        if($dato['ID_PADRE'] == 0){   //   [0]     [1]
            $arrayPadres[$contador] = array($dato, $arrayHijos);
        }

        $contador++;
    }

    $contadorHijo = 1;
    $idDeMismoPadreParaReseteoDelContadorDeHijos = 0;

    foreach ($menu as $dato) {

        if($dato['ID_PADRE'] != $idDeMismoPadreParaReseteoDelContadorDeHijos){
            $contadorHijo = 1;
        }

        if($dato['ID_PADRE'] != 0){
            array_push($arrayPadres[$dato['ID_PADRE']][1],$dato);
            $contadorHijo++;
            $idDeMismoPadreParaReseteoDelContadorDeHijos = $dato['ID_PADRE'];
        }

    }

    print_r($arrayPadres);

    echo "<nav class='navbar navbar-expand-sm navbar-light' style='background-color: #68a8f1' aria-label='Fourth navbar example'>
        <div class='container-fluid'>
            <button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#navbarsExample04' aria-controls='navbarsExample04' aria-expanded='false' aria-label='Toggle navigation'>
                <span class='navbar-toggler-icon'></span>
            </button>

            <div class='collapse navbar-collapse' id='navbarsExample04'>
                <ul class='navbar-nav me-auto mb-2 mb-md-0'>";
            
    

    foreach ($arrayPadres as $e) {
        foreach($arrayPadres[$e] as $e2){
            
        }
    }

    
//                "<li class='nav-item'>
//                     <a class='nav-link active' style='color: white' aria-current='page' href='#'>Home</a>
//                 </li>
//                 <li class='nav-item'>
//                     <a class='nav-link' style='color: white' href='#'>Link</a>
//                 </li>
//                 <li class='nav-item'>
//                     <a class='nav-link disabled'>Disabled</a>
//                 </li>
//                 <li class='nav-item dropdown'>
//                     <a class='nav-link dropdown-toggle' style='color: white' href='#' data-bs-toggle='dropdown' 
//                         aria-expanded='false'>Cruds</a>
//                     <ul class='dropdown-menu'>
//                         <li><a class='dropdown-item' 
//                             onclick='peticion('Usuarios', 'getVistaUsuarios')' >Usuarios</a></li>
//                         <li><a class='dropdown-item' 
//                             onclick='peticion('Pedidos', 'getVistaPedidos')'>Pedidos</a></li>
//                         <li><a class='dropdown-item' 
//                             onclick='peticion('', '')'>Something else here</a></li>
//                     </ul>
//                 </li>
echo        "</ul>
        </div>
    </div>
</nav>";




?>