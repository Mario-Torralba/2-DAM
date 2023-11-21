package Model.Beans.ProductoCaracteristicas;

public class ProductoCaracteristicas {

    int id_usuario_comprador;
    int id_usuario_vendedor;
    String nombre_apellidos;
    int estrellas; // Otra consulta aparte
    int cantidad_estrellas; // Otra consulta aparte
    String nombre_producto;
    String estado_producto;
    String colores_producto;
    int precio_producto;
    String descripcion_producto;


    public int getId_usuario_comprador() {
        return id_usuario_comprador;
    }

    public void setId_usuario_comprador(int id_usuario_comprador) {
        this.id_usuario_comprador = id_usuario_comprador;
    }

    public int getId_usuario_vendedor() {
        return id_usuario_vendedor;
    }

    public void setId_usuario_vendedor(int id_usuario_vendedor) {
        this.id_usuario_vendedor = id_usuario_vendedor;
    }

    public String getNombre_apellidos() {
        return nombre_apellidos;
    }

    public void setNombre_apellidos(String nombre_apellidos) {
        this.nombre_apellidos = nombre_apellidos;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(String estado_producto) {
        this.estado_producto = estado_producto;
    }

    public String getColores_producto() {
        return colores_producto;
    }

    public void setColores_producto(String colores_producto) {
        this.colores_producto = colores_producto;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }
}
