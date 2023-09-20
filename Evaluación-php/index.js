document.body.addEventListener("load",initComponents());


function initComponents(){
    
    const boton = document.getElementById("botonFormulario")

    const usuario = document.getElementById("nickUsuario")
    const mensajeUsuario = document.getElementById("mensajeUsuario")

    const contraseña = document.getElementById("contraseñaUsuario")
    const mensajeContraseña = document.getElementById("mensajeContraseña")

    const email = document.getElementById("correoUsuario")
    const mensajeEmail = document.getElementById("mensajeEmail")

    const telefono = document.getElementById("tlfUsuario")
    const mensajeTelefono = document.getElementById("mensajeTelefono")
    
    boton.addEventListener("click",()=>{

        // Usuario
        if(usuario.value.length==0){
            mensajeUsuario.innerHTML = "Rellena el campo"
            mensajeUsuario.style.color = "red"
        }else{
            if(usuario.value.length<5){
                mensajeUsuario.innerHTML = "El usuario debe contener al menos 5 carácteres"
                mensajeUsuario.style.color = "red"
            }else{
                mensajeUsuario.style.color = "white"
            }
        }
        
        // Contraseña
        if(contraseña.value.length==0){
            mensajeContraseña.innerHTML = "Rellena el campo"
            mensajeContraseña.style.color = "red"
        }else{
            if(contraseña.value.length<5){
                mensajeContraseña.innerHTML = "La contraseña tiene menos de 5 carácteres"
                mensajeContraseña.style.color = "red"
            }else{
                mensajeContraseña.style.color = "white"
            }
        }

        // Email

        if(email.value.length==0){
            mensajeEmail.innerHTML = "Rellena el campo"
            mensajeEmail.style.color = "red"
        }else{
            mensajeEmail.style.color = "white"
        }


        // Telefono

        if(telefono.value.length == 0){
            mensajeTelefono.innerHTML = "Rellena el campo"
            mensajeTelefono.style.color = "red"
        }else{
            if(telefono.value.length != 9){
                mensajeTelefono.innerHTML = "El número de teléfono no es correcto"
                mensajeTelefono.style.color = "red"
            }else{
                mensajeTelefono.style.color = "white"
            }
        }
        

        


    })
}