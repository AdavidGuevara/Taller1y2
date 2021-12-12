package datos;

import domain.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoJDBC implements ProductoDAO{
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT idproductos, categoria, nombre, tarifa, precio FROM b65ihh8zrciucldqywtr.productos";
    private static final String SQL_INSERT = "INSERT INTO b65ihh8zrciucldqywtr.productos(idproducto, categoria, nombre, tarifa, precio) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE b65ihh8zrciucldqywtr.productos SET categoria = ?, nombre = ?, tarifa = ?, precio = ? WHERE idpersona = ?";
    private static final String SQL_DELETE = "DELETE FROM b65ihh8zrciucldqywtr.productos WHERE idproducto = ?";

    private static final String SQL_BUSQUEDA1 = "SELECT * FROM b65ihh8zrciucldqywtr.productos WHERE categoria = ?";
    private static final String SQL_BUSQUEDA2 = "SELECT * FROM b65ihh8zrciucldqywtr.productos WHERE idproductos = ?";
    private static final String SQL_BUSQUEDA3 = "SELECT * FROM b65ihh8zrciucldqywtr.productos WHERE nombre LIKE ?";
    private static final String SQL_BUSQUEDA4 = "SELECT * FROM b65ihh8zrciucldqywtr.productos WHERE precio <= ?";

    public ProductoDaoJDBC(){

    }

    public ProductoDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Producto> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Producto producto;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            st = conn.prepareStatement(SQL_SELECT);
            rs = st.executeQuery();

            while (rs.next()){
                int idProducto = rs.getInt("idproductos");
                String categoria = rs.getString("categoria");
                String nombre = rs.getString("nombre");
                int tarifa = rs.getInt("tarifa");
                double precio = rs.getDouble("precio");

                producto = new Producto(idProducto, categoria, nombre, tarifa, precio);
                productos.add(producto);
            }
        }finally {
            try {
                assert rs != null;
                Conexion.close(rs);
                Conexion.close(st);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productos;
    }

    public int insertar(Producto producto) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            st = conn.prepareStatement(SQL_INSERT);
            st.setInt(1, producto.getIdProducto());
            st.setString(2, producto.getCategoria());
            st.setString(3, producto.getNombre());
            st.setInt(4, producto.getTarifa());
            st.setDouble(5, producto.getPrecio());
            registros = st.executeUpdate();
        } finally {
            try {
                assert st != null;
                Conexion.close(st);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registros;
    }

    public int actualizar(Producto producto) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            st = conn.prepareStatement(SQL_UPDATE);
            st.setString(1, producto.getNombre());
            st.setString(2, producto.getCategoria());
            st.setInt(3, producto.getTarifa());
            st.setDouble(4, producto.getPrecio());
            st.setInt(5, producto.getIdProducto());
            registros = st.executeUpdate();
        }finally {
            try {
                assert st != null;
                Conexion.close(st);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registros;
    }

    public int eliminar(Producto producto) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            st = conn.prepareStatement(SQL_DELETE);
            st.setInt(1, producto.getIdProducto());
            registros = st.executeUpdate();
        } finally {
            try {
                assert st != null;
                Conexion.close(st);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registros;
    }

    public List<Producto> buscarCategoria(String categoria) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Producto producto;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            st = conn.prepareStatement(SQL_BUSQUEDA1);
            st.setString(1, categoria);
            rs = st.executeQuery();

            while (rs.next()){
                int idProducto = rs.getInt("idproductos");
                String categorias = rs.getString("categoria");
                String nombre = rs.getString("nombre");
                int tarifa = rs.getInt("tarifa");
                double precio = rs.getDouble("precio");

                producto = new Producto(idProducto, categorias, nombre, tarifa, precio);
                productos.add(producto);
            }
        }finally {
            try {
                assert rs != null;
                Conexion.close(rs);
                Conexion.close(st);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productos;
    }

    public Producto buscarId(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Producto producto = null;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            st = conn.prepareStatement(SQL_BUSQUEDA2);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()){
                int idProducto = rs.getInt("idproductos");
                String categoria = rs.getString("categoria");
                String nombre = rs.getString("nombre");
                int tarifa = rs.getInt("tarifa");
                double precio = rs.getDouble("precio");

                producto = new Producto(idProducto, categoria, nombre, tarifa, precio);
            }
        }finally {
            try {
                assert rs != null;
                Conexion.close(rs);
                Conexion.close(st);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return producto;
    }

    public List<Producto> buscarNombre(String cadena) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Producto producto;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            st = conn.prepareStatement(SQL_BUSQUEDA3);
            st.setString(1, cadena);
            rs = st.executeQuery();

            while (rs.next()){
                int idProducto = rs.getInt("idproductos");
                String categorias = rs.getString("categoria");
                String nombre = rs.getString("nombre");
                int tarifa = rs.getInt("tarifa");
                double precio = rs.getDouble("precio");

                producto = new Producto(idProducto, categorias, nombre, tarifa, precio);
                productos.add(producto);
            }
        }finally {
            try {
                assert rs != null;
                Conexion.close(rs);
                Conexion.close(st);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productos;
    }

    public List<Producto> buscarPrecio(double precios) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Producto producto;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            st = conn.prepareStatement(SQL_BUSQUEDA4);
            st.setDouble(1, precios);
            rs = st.executeQuery();

            while (rs.next()){
                int idProducto = rs.getInt("idproductos");
                String categorias = rs.getString("categoria");
                String nombre = rs.getString("nombre");
                int tarifa = rs.getInt("tarifa");
                double precio = rs.getDouble("precio");

                producto = new Producto(idProducto, categorias, nombre, tarifa, precio);
                productos.add(producto);
            }
        }finally {
            try {
                assert rs != null;
                Conexion.close(rs);
                Conexion.close(st);
                if(this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productos;
    }
}
