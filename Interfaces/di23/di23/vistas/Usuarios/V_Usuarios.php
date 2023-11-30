<div id='contenedores'>
        <div class="cont" id="desplegarFormularioBuscar" onclick="funcionDisplay1()">BUSCAR</div>
        <div class="cont" id="desplegarFormularioCrear" onclick="funcionDisplay2()">CREAR</div>
    </div>

    <div id="formularioBusqueda">

        <form id="formularioBuscar" name="formularioBuscar">
            <label for="nombre_texto">
                <input placeholder="Nombre" type="text" id="nombre_texto" name="nombre_texto">
            </label>
            <label for="apellido_texto">
                <input placeholder="Apellido" type="text" id="apellido_texto" name="apellido_texto">
            </label>
            <label for="a_texto">
                <select name="a_texto" id="a_texto">
                    <option value=" "></option>
                    <option value="S">S</option>
                    <option value="N">N</option>
                </select>
            </label>
            <button id="botonBusquedaUsuarios" class="botonUsuarios" type="button" onclick="buscarUsuariosTotales(),buscarUsuarios(1,10)">GO!!</button>
            <!-- <button id="botonBusquedaUsuarios" class="botonUsuarios" type="button" onclick="paginado(127)">GO!!</button> -->
        
            </form>
    </div>

    <div id="formularioCrear">
        <form id='formularioCrear2' name='formularioCrear2' >
    
            <label for='nombre_crear'>
                <input placeholder='Nombre' type='text' id='nombre_crear' name='nombre_crear'>
            </label>
            
            <label for='apellido_1_crear'>
                <input placeholder='Primer apellido' type='text' id='apellido_1_crear' name='apellido_1_crear'>
            </label>
        
            <label for='apellido_2_crear'>
                <input placeholder='Segundo apellido' type='text' id='apellido_2_crear' name='apellido_2_crear'>
            </label>
        <br><br>
            <label for='login_crear'>
                <input placeholder='Usuario' type='text' id='login_crear' name='login_crear'>
            </label>
        
            <label for='pass_crear'>
                <input placeholder='Contraseña' type='password' id='pass_crear' name='pass_crear'>
            </label>
            <button id='botonCrearUsuarios' class='botonUsuarios' type='button' onclick='crearUsuarios()'>GO!!</button>
            </form>
    </div>
    <br><br>
    <div id="capaResultadosBusqueda">
    </div>
