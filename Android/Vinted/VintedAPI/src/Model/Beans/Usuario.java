package Model.Beans;

public class Usuario {

    private int id;
    private String nick;
    private String pass;
    private String tlf_usuario;
    private String nombre_usuario;
    private String apellido_1_usuario;
    private String apellido_2_usuario;
    private String email_usuario;

    public int getNumeroVentas() {
        return numeroVentas;
    }

    public void setNumeroVentas(int numeroVentas) {
        this.numeroVentas = numeroVentas;
    }

    private int numeroVentas;

    public Usuario(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTlf_usuario() {
        return tlf_usuario;
    }

    public void setTlf_usuario(String tlf_usuario) {
        this.tlf_usuario = tlf_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_1_usuario() {
        return apellido_1_usuario;
    }

    public void setApellido_1_usuario(String apellido_1_usuario) {
        this.apellido_1_usuario = apellido_1_usuario;
    }

    public String getApellido_2_usuario() {
        return apellido_2_usuario;
    }

    public void setApellido_2_usuario(String apellido_2_usuario) {
        this.apellido_2_usuario = apellido_2_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }
}
