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

                // echo"<form id='formularioPaginado' name='formularioPaginado'>";
                echo "<div class='centradoPaginado'>";
                echo "<label class='textoAzul' for='paginaActual'>Ir a la página
                <input class='inputPaginado' type='number' id='paginaActual' name='paginaActual'>
            </label>";
                // echo "$cantidadNumeros";
                // echo "$cantidadSobrante";
                // echo $_SESSION["cantidadTotal"];
                // echo $_SESSION["cantidadEntradas"];
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
                if($cantidadNumeros==4&&$cantidadSobrante==0){ 

                        for ($i=1; $i <= $cantidadNumeros; $i++) { 
                                if($i==$_SESSION["paginaActual"]){
                                        echo "<div class='numero marcado'>$i</div>"; 
                                }else{
                                        echo "<div onclick='buscarUsuarios(".$i.",".$_SESSION["cantidadEntradas"].")' class='numero hover'>$i</div>"; 
                                }
                        }
                }
                if($cantidadNumeros==4&&$cantidadSobrante!=0){ 

                        for ($i=1; $i <= $cantidadNumeros+1; $i++) { 
                                if($i==$_SESSION["paginaActual"]){
                                        echo "<div class='numero marcado'>$i</div>"; 
                                }else{
                                        echo "<div onclick='buscarUsuarios(".$i.",".$_SESSION["cantidadEntradas"].")' class='numero hover'>$i</div>"; 
                                }
                        }
                }
                if($cantidadNumeros==5&&$cantidadSobrante==0){ 

                        for ($i=1; $i <= $cantidadNumeros; $i++) { 
                                if($i==$_SESSION["paginaActual"]){
                                        echo "<div class='numero marcado'>$i</div>"; 
                                }else{
                                        echo "<div onclick='buscarUsuarios(".$i.",".$_SESSION["cantidadEntradas"].")' class='numero hover'>$i</div>"; 
                                }
                        }
                }
                if($cantidadNumeros>=5&&$cantidadSobrante!=0){ 

                        if($_SESSION["paginaActual"]==1){
                                echo "<div class='numero marcado'>1</div>";  
                                echo "<div onclick='buscarUsuarios(2,".$_SESSION["cantidadEntradas"].")' class='numero hover'>2</div>"; 
                                echo "<div onclick='buscarUsuarios(3,".$_SESSION["cantidadEntradas"].")' class='numero hover'>3</div>"; 
                                echo "<div class='numero hover'>-</div>"; 
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros+1).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros+1)."</div>"; 

                        }

                        if($_SESSION["paginaActual"]==2){
                                echo "<div onclick='buscarUsuarios(1,".$_SESSION["cantidadEntradas"].")' class='numero hover'>1</div>"; 
                                echo "<div class='numero marcado'>2</div>";  
                                echo "<div onclick='buscarUsuarios(3,".$_SESSION["cantidadEntradas"].")' class='numero hover'>3</div>"; 
                                echo "<div class='numero hover'>-</div>"; 
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros+1).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros+1)."</div>"; 
                        }

                        if($_SESSION["paginaActual"]==($cantidadNumeros+1)){
                                echo "<div onclick='buscarUsuarios(1,".$_SESSION["cantidadEntradas"].")' class='numero hover'>1</div>"; 
                                echo "<div class='numero hover'>-</div>"; 
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros-1).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros-1)."</div>"; 
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros)."</div>"; 
                                echo "<div class='numero marcado'>".($cantidadNumeros+1)."</div>";  
                        }
                        if($_SESSION["paginaActual"]==($cantidadNumeros)){
                                echo "<div onclick='buscarUsuarios(1,".$_SESSION["cantidadEntradas"].")' class='numero hover'>1</div>"; 
                                echo "<div class='numero hover'>-</div>"; 
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros-1).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros-1)."</div>"; 
                                echo "<div class='numero marcado'>".($cantidadNumeros)."</div>";  
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros+1).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros+1)."</div>"; 

                        }
                        if($_SESSION["paginaActual"]!=1&&$_SESSION["paginaActual"]!=2&&$_SESSION["paginaActual"]!=($cantidadNumeros+1)&&$_SESSION["paginaActual"]!=($cantidadNumeros)){
                                echo "<div onclick='buscarUsuarios(1,".$_SESSION["cantidadEntradas"].")' class='numero hover'>1</div>"; 
                                echo "<div class='numero hover'>-</div>"; 
                                echo "<div class='numero marcado'>".$_SESSION["paginaActual"]."</div>";  
                                echo "<div class='numero hover'>-</div>"; 
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros+1).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros+1)."</div>"; 

                        }



                }
                if($cantidadNumeros>=5&&$cantidadSobrante==0){ 

                        if($_SESSION["paginaActual"]==1){
                                echo "<div class='numero marcado'>1</div>";  
                                echo "<div onclick='buscarUsuarios(2,".$_SESSION["cantidadEntradas"].")' class='numero hover'>2</div>"; 
                                echo "<div onclick='buscarUsuarios(3,".$_SESSION["cantidadEntradas"].")' class='numero hover'>3</div>"; 
                                echo "<div class='numero hover'>-</div>"; 
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros)."</div>"; 

                        }

                        if($_SESSION["paginaActual"]==2){
                                echo "<div onclick='buscarUsuarios(1,".$_SESSION["cantidadEntradas"].")' class='numero hover'>1</div>"; 
                                echo "<div class='numero marcado'>2</div>";  
                                echo "<div onclick='buscarUsuarios(3,".$_SESSION["cantidadEntradas"].")' class='numero hover'>3</div>"; 
                                echo "<div class='numero hover'>-</div>"; 
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros)."</div>"; 
                        }

                        if($_SESSION["paginaActual"]==($cantidadNumeros)){
                                echo "<div onclick='buscarUsuarios(1,".$_SESSION["cantidadEntradas"].")' class='numero hover'>1</div>"; 
                                echo "<div class='numero hover'>-</div>"; 
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros-2).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros-2)."</div>"; 
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros-1).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros-1)."</div>"; 
                                echo "<div class='numero marcado'>".($cantidadNumeros)."</div>";  
                        }
                        if($_SESSION["paginaActual"]==($cantidadNumeros-1)){
                                echo "<div onclick='buscarUsuarios(1,".$_SESSION["cantidadEntradas"].")' class='numero hover'>1</div>"; 
                                echo "<div class='numero hover'>-</div>"; 
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros-2).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros-2)."</div>"; 
                                echo "<div class='numero marcado'>".($cantidadNumeros-1)."</div>";  
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros)."</div>"; 

                        }
                        if($_SESSION["paginaActual"]!=1&&$_SESSION["paginaActual"]!=2&&$_SESSION["paginaActual"]!=($cantidadNumeros)&&$_SESSION["paginaActual"]!=($cantidadNumeros-1)){
                                echo "<div onclick='buscarUsuarios(1,".$_SESSION["cantidadEntradas"].")' class='numero hover'>1</div>"; 
                                echo "<div class='numero hover'>-</div>"; 
                                echo "<div class='numero marcado'>".$_SESSION["paginaActual"]."</div>";  
                                echo "<div class='numero hover'>-</div>"; 
                                echo "<div onclick='buscarUsuarios(".($cantidadNumeros).",".$_SESSION["cantidadEntradas"].")' class='numero hover'>".($cantidadNumeros)."</div>"; 

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
                echo "<label class='textoAzul margenIzquierdo' for='cantidadEntradas'>Cantidad por página
                <input class='inputPaginado2' type='number' id='cantidadEntradas' name='cantidadEntradas'>
                </label>";
                echo "</div>";
                echo "<div class='centradoPaginado'>
                <button id='botonFormPaginado' class='botonPaginado' type='button' onclick='buscarUsuarios(0,0)'>CAMBIAR PÁGINA</button>
                </div>";
                // </form>";
        }


        
?>