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
                echo $cantidadNumeros;
                echo $cantidadSobrante;
                echo $_SESSION["cantidadTotal"];
                echo $_SESSION["cantidadEntradas"];
                if($_SESSION["paginaActual"]!=1){
                        echo "<div class='menos'><</div>";
                }
                if($cantidadSobrante== 0){
                }
                if($cantidadNumeros==1&&$cantidadSobrante!=0){   
                        for ($i=1; $i <= $cantidadNumeros+1; $i++) { 
                                if($i==$_SESSION["paginaActual"]){
                                        echo "<div class='numero marcado'>$i</div>"; 
                                }else{
                                        echo "<div class='numero'>$i</div>"; 
                                }
                        }  
                }
                if($cantidadNumeros==2){ 

                        for ($i=1; $i <= $cantidadNumeros; $i++) { 
                                if($i==$_SESSION["paginaActual"]){
                                        echo "<div class='numero marcado'>$i</div>"; 
                                }else{
                                        echo "<div class='numero'>$i</div>"; 
                                }
                        }
                }
                if($cantidadNumeros==3){ 

                        for ($i=1; $i <= $cantidadNumeros; $i++) { 
                                if($i==$_SESSION["paginaActual"]){
                                        echo "<div class='numero marcado'>$i</div>"; 
                                }else{
                                        echo "<div class='numero'>$i</div>"; 
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
                }else{
                        if($_SESSION["paginaActual"]== $cantidadNumeros && $cantidadSobrante==0){
                        }else{
                                echo "<div class='mas'>></div>";
                        }
                        
                }
                echo "</div>";
        }


        
?>