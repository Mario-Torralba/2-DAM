
<?php
    if(isset($_SESSION["usuario"])){
        if($_SESSION["usuario"]=='mario'){
            echo "Crear Usuario<br>";
            echo "<form id='formularioCrear' name='formularioCrear' >
    
            <label for='nombre_crear'>
                <input placeholder='Nombre' type='text' id='nombre_crear' name='nombre_crear'>
            </label>
            
            <label for='apellido_1_crear'>
                <input placeholder='Primer apellido' type='text' id='apellido_1_crear' name='apellido_1_crear'>
            </label>
        
            <label for='apellido_2_crear'>
                <input placeholder='Segundo apellido' type='text' id='apellido_2_crear' name='apellido_2_crear'>
            </label>
        
            <label for='login_crear'>
                <input placeholder='Usuario' type='text' id='login_crear' name='login_crear'>
            </label>
        
            <label for='pass_crear'>
                <input placeholder='Contraseña' type='password' id='pass_crear' name='pass_crear'>
            </label>
            <br><br>
            <button id='botonCrearUsuarios' class='botonUsuarios' type='button' onclick='crearUsuarios()'>Crear</button>
            </form>
            <br><br>";
            echo 'Busqueda de usuarios: ';
    }else{
        echo "Debes logearte para eso";
    }   

    }
?>

<br>
</form>
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
<br><br>
<button id="botonBusquedaUsuarios" class="botonUsuarios" type="button" onclick="buscarUsuarios()">Buscar</button>
</form>
<br><br>
<div id="capaResultadosBusqueda">
    
</div>