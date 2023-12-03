<div id='contenedores'>
        <div class="cont" id="desplegarFormularioBuscar" onclick="funcionDisplay1()">Búsqueda</div>
        <div class="cont" id="desplegarFormularioCrear" onclick="funcionDisplay2()">Nuevo</div>
    </div>

    <div id="formularioBusqueda">

        <form id="formularioBuscar" name="formularioBuscar">
            <div>
                <label id="label" for="nombre_texto"> Nombre 
                    <input class="inputBusqueda" type="text" id="nombre_texto" name="nombre_texto">
                </label>
            </div>
            <div>
                <label id="label" for="apellido_texto"> Primer apellido 
                    <input class="inputBusqueda" type="text" id="apellido_texto" name="apellido_texto">
                </label>
            </div>
            <div id="divSelect">
                <label id="label" for="a_texto"> Activo
                    <select class="inputBusqueda" name="a_texto" id="a_texto">
                        <option value=" "></option>
                        <option value="S">S</option>
                        <option value="N">N</option>
                    </select>
                </label>
            </div>
        
            <div id="botonbuscar2">

                <button id="botonBusquedaUsuarios" class="botonUsuarios" type="button" onclick="buscarUsuariosTotales(),buscarUsuarios(1,10)">BUSCAR</button>
            </div>
            <!-- <button id="botonBusquedaUsuarios" class="botonUsuarios" type="button" onclick="paginado(127)">GO!!</button> -->
        
            </form>
    </div>

    <div id="formularioCrear">
        <form id='formularioCrear2' name='formularioCrear2' >
            
            <div>
                <label id="label" for='nombre_crear'>Nombre 
                    <?php 
                    if(isset($mensajeNombre)){
                        echo $mensajeNombre;
                    }
                    ?>
                    <input class="inputBusqueda" type='text' id='nombre_crear' name='nombre_crear'>
                </label>
            </div>

            <div>
                <label id="label" for='apellido_1_crear'>Primer apellido
                    <?php 
                    if(isset($mensajeApellido1)){
                        echo $mensajeApellido1;
                    }
                    ?>
                    <input class="inputBusqueda"  type='text' id='apellido_1_crear' name='apellido_1_crear'>
                </label>
            </div>
            <div>
                <label id="label" for='apellido_2_crear'>Segundo apellido
                <?php 
                    if(isset($mensajeApellido2)){
                        echo $mensajeApellido2;
                    }
                    ?>
                    <input class="inputBusqueda"  type='text' id='apellido_2_crear' name='apellido_2_crear'>
                </label>

            </div>
            <div> 
            <label id="label" for='login_crear'>Usuario 
                    <?php 
                    if(isset($mensajeUsuario)){
                        echo $mensajeUsuario;
                    }
                    ?>
                <input class="inputBusqueda"  type='text' id='login_crear' name='login_crear'>
            </label>
            </div>
            <div>
                <label id="label" for='pass_crear'>Contraseña 
                    <?php 
                    if(isset($mensajeContraseña)){
                        echo $mensajeContraseña;
                    }
                    ?>
                    <input class="inputBusqueda"  type='password' id='pass_crear' name='pass_crear'>
                </label>
            </div>
            <div id="botonbuscar2">
                <button id='botonCrearUsuarios' class='botonUsuarios' type='button' onclick='validarNuevoUsuario(),crearUsuarios(),buscarUsuariosTotales(),buscarUsuarios(1,10)'>CREAR</button>
            </div>
        </form>
    </div>
    <br><br>
    <div id="capaResultadosBusqueda">
    </div>