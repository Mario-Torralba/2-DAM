<!-- <div class="centradoPaginado">
        <div id="aleatorio" class="menos"><</div>
        <div class="numero">1</div>
        <div class="numero">2</div>
        <div class="numero">1230</div>
        <div class="numero">1230</div>
        <div class="mas">></div>
</div> -->
<?php
        if($_SESSION["cantidadTotal"]<$_SESSION["cantidadEntradas"]){
                echo "<div class='centradoPaginado'>";
                echo "</div>";
        }else{
                $cantidadNumeros = intval($_SESSION["cantidadTotal"]/$_SESSION["cantidadEntradas"]);
                $cantidadSobrante = $_SESSION["cantidadTotal"] % $_SESSION["cantidadEntradas"] ;

                echo "<div class='centradoPaginado'>";

                if($_SESSION["paginaActual"]!=1){
                        echo "<div onclick='buscarUsuarios(".($_SESSION["paginaActual"] - 1).",".$_SESSION["cantidadEntradas"].")' class='menos hover'><</div>";
                }else{
                        echo "<div class='menos rojos'><</div>";

                }
                if($cantidadNumeros==1&&$cantidadSobrante!=0){   
                        for ($i=1; $i <= $cantidadNumeros+1; $i++) { 
                                if($i==$_SESSION["paginaActual"]){
                                        echo "<div class='numero marcado'>$i</div>"; 
                                }else{
                                        echo "<div onclick='buscarUsuarios(".$i.",".$_SESSION["cantidadEntradas"].")' class='numero hover'>$i</div>"; 
                                }
                        }  
                }
                if($cantidadNumeros==2&&$cantidadSobrante!=0){ 

                        for ($i=1; $i <= $cantidadNumeros+1; $i++) { 
                                if($i==$_SESSION["paginaActual"]){
                                        echo "<div class='numero marcado'>$i</div>"; 
                                }else{
                                        echo "<div onclick='buscarUsuarios(".$i.",".$_SESSION["cantidadEntradas"].")' class='numero hover'>$i</div>"; 
                                }
                        }
                }
                if($cantidadNumeros==2&&$cantidadSobrante==0){ 

                        for ($i=1; $i <= $cantidadNumeros; $i++) { 
                                if($i==$_SESSION["paginaActual"]){
                                        echo "<div class='numero marcado'>$i</div>"; 
                                }else{
                                        echo "<div onclick='buscarUsuarios(".$i.",".$_SESSION["cantidadEntradas"].")' class='numero hover'>$i</div>"; 
                                }
                        }
                }
                if($cantidadNumeros==3&&$cantidadSobrante!=0){ 

                        for ($i=1; $i <= $cantidadNumeros+1; $i++) { 
                                if($i==$_SESSION["paginaActual"]){
                                        echo "<div class='numero marcado'>$i</div>"; 
                                }else{
                                        echo "<div onclick='buscarUsuarios(".$i.",".$_SESSION["cantidadEntradas"].")' class='numero hover'>$i</div>"; 
                                }
                        }
                }
                if($cantidadNumeros==3&&$cantidadSobrante==0){ 

                        for ($i=1; $i <= $cantidadNumeros; $i++) { 
                                if($i==$_SESSION["paginaActual"]){
                                        echo "<div class='numero marcado'>$i</div>"; 
                                }else{
                                        echo "<div onclick='buscarUsuarios(".$i.",".$_SESSION["cantidadEntradas"].")' class='numero hover'>$i</div>"; 
                                }
                        }
                }
                // else{
                //         for ($i=1; $i < $cantidadNumeros; $i++) { 
                //                 if($i==$_SESSION["paginaActual"]){
                //                         echo "<div class='numero marcado'>$i</div>"; 
                //                 }else{
                //                         echo "<div class='numero'>$i</div>"; 
                //                 }
                //         } 
                // }



                if($_SESSION["paginaActual"]== ($cantidadNumeros+1)){
                        echo "<div class='mas rojos'>></div>";
                }else{
                        if($_SESSION["paginaActual"]== $cantidadNumeros && $cantidadSobrante==0){
                                echo "<div class='mas rojos'>></div>";
                        }else{
                                echo "<div onclick='buscarUsuarios(".($_SESSION["paginaActual"] + 1).",".$_SESSION["cantidadEntradas"].")' class='mas hover'>></div>";
                        }
                }
                echo "</div>";
        }


        
?>