<div id='contenedores'>
    <?php
        foreach ($_SESSION['PERMISOS'] as $permiso) {
            if($permiso['NOMBRE_PERMISO'] == 'mantenimientoBuscarMenus'){
                $seguridadBuscarMenus = true;
                echo '<div class="cont" id="desplegarFormularioBuscarMenu">Búsqueda</div>';
            }
        }
        foreach ($_SESSION['PERMISOS'] as $permiso) {
            if($permiso['NOMBRE_PERMISO'] == 'mantenimientoCrearMenus'){
                $seguridadCrearMenus = true;
                echo '<div class="cont" id="desplegarFormularioCrearMenu">Nuevo</div>';
            }
        }
    ?>
</div>
<div id="formularioBusquedaMenu">

    <form id="formularioBuscarMenu" name="formularioBuscarMenu">
        <div>
            <label id="label" for="nombre_texto"> ID de Usuario
                <input class="inputBusqueda" type="text" id="nombre_texto" name="nombre_texto">
            </label>
        </div>
        <div>
        </div>
        <div id="divSelect">
            <label id="label" for="rol_texto"> Rol
                <select class="inputBusqueda" name="rol_texto" id="rol_texto">
                    <option value=" "></option>
                    <?php
                    print_r($_SESSION['ROLES']);
                        foreach ($_SESSION['ROLES'] as $element) {
                            echo '<option value="'.$element['NOMBRE_ROL'].'">'.$element['NOMBRE_ROL'].'</option>';

                        }
                    ?>
                </select>
            </label>
        </div>
    
        <div id="botonbuscardiv">

            <button id="botonBusquedaMenus" class="botonUsuarios" type="button" onclick="buscarMenus(2)">BUSCAR</button>
        </div>
        <!-- <button id="botonBusquedaUsuarios" class="botonUsuarios" type="button" onclick="paginado(127)">GO!!</button> -->
    
        </form>
</div>

<div id="formularioCrearMenu">
    <form id='formularioCrearMenu2' name='formularioCrearMenu2' >
        
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
        <div id="botonbuscardiv">
            <button id='botonCrearMenu' class='botonUsuarios' type='button' onclick='validarNuevoUsuario(),crearUsuarios(),buscarUsuariosTotales(),buscarUsuarios(1,10)'>CREAR</button>
        </div>
    </form>
</div>
<br><br>
<div id="capaResultadosBusqueda">
    
</div>