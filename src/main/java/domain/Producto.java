package domain;

public class Producto {
    private int idProducto;
    private String categoria;
    private String nombre;
    private int tarifa;
    private double precio;

    public Producto(){

    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto(int idProducto, String categoria, String nombre, int tarifa, double precio) {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTarifa() {
        return tarifa;
    }
    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "idProducto=" + idProducto +
                ", categoria='" + categoria + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tarifa=" + tarifa +
                ", precio=" + precio +
                '}';
    }
}
