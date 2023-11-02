
<?php
    echo 'Busqueda de usuarios: ';
    
?>
<form id="formularioBuscar" name="formularioBuscar" onkeydown="return event.key != 'Enter';">
<label for="b_texto">
    <input placeholder="Nombre/apellido" type="text" id="b_texto" name="b_texto">
</label>
<label for="a_texto">
    <input placeholder="Activo(S,N)" type="text" id="a_texto" name="a_texto">
</label>
<button type="button" onclick="buscarUsuarios()">Buscar</button>
</form>
<div id="capaResultadosBusqueda">
    
</div>