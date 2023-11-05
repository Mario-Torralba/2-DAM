
<?php
    echo 'Busqueda de usuarios: ';
    
?>
<form id="formularioBuscar" name="formularioBuscar" onkeydown="return event.key != 'Enter';">
<label for="nombre_texto">
    <input placeholder="Nombre" type="text" id="nombre_texto" name="nombre_texto">
</label>
<label for="apellido_texto">
    <input placeholder="Apellido" type="text" id="apellido_texto" name="apellido_texto">
</label>
<label for="a_texto">
    <select name="a_texto" id="a_texto">
        <option value="S">S</option>
        <option value="N">N</option>
    </select>
</label>
<button id="botonBusquedaUsuarios" type="button" onclick="buscarUsuarios()">Buscar</button>
</form>
<div id="capaResultadosBusqueda">
    
</div>