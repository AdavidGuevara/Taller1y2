package productoTest;

import datos.Conexion;
import datos.ProductoDAO;
import datos.ProductoDaoJDBC;
import domain.Producto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestManejoProducto {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }

            ProductoDAO productoDAO = new ProductoDaoJDBC(conexion);

            // Listando toda la base de datos.
            List<Producto> productos = productoDAO.seleccionar();
            System.out.println("Listando toda base de datos:");
            for (Producto producto: productos) {
                System.out.println(producto);
            }
            System.out.println(" ");

            // Listando todos los productos de una categoria especifica.
            List<Producto> productosCategoria = productoDAO.buscarCategoria("Alimentos");
            System.out.println("Listando todos los productos de la categoria \"Alimentos\":");
            for (Producto producto: productosCategoria) {
                System.out.println(producto);
            }
            System.out.println(" ");

            // Buscando un producto por un "id" especifico.
            Producto productoId = productoDAO.buscarId(5210300);
            System.out.println("Buscanod informacion del producto con id=5210300:");
            System.out.println(productoId);
            System.out.println(" ");

            // Listando todos los productos que empiencen por una letra (se puede tambien buscar cuaquier cadena).
            List<Producto> productosLetra = productoDAO.buscarNombre("A%");
            System.out.println("Listando todos los productos que empiezen por \"A\":");
            for (Producto producto: productosLetra) {
                System.out.println(producto);
            }
            System.out.println(" ");

            // Listando los productos filtrados a traves del precio.
            List<Producto> productosPrecio = productoDAO.buscarPrecio(50000);
            System.out.println("Listando todos los productos cuyo precio sea menor o igual a $50000:");
            for (Producto producto: productosPrecio) {
                System.out.println(producto);
            }
            System.out.println(" ");



            conexion.commit();
            System.out.println("Se ha hecho commit de la transacion");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println(" ");
            System.out.println("Entramos en rollback");
            try {
                assert conexion != null;
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
