package datos;

import domain.Producto;

import java.sql.SQLException;
import java.util.List;

public interface ProductoDAO {

    public List<Producto> seleccionar() throws SQLException;

    public List<Producto> buscarCategoria(String categoria) throws SQLException;

    public Producto buscarId(int id) throws SQLException;

    public List<Producto> buscarNombre(String cadena) throws SQLException;

    public List<Producto> buscarPrecio(double precio) throws SQLException;

    public int insertar(Producto producto) throws SQLException;

    public int actualizar(Producto producto) throws SQLException;

    public int eliminar(Producto producto) throws SQLException;
}
