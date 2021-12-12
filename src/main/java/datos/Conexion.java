package datos;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://b65ihh8zrciucldqywtr-mysql.services.clever-cloud.com/b65ihh8zrciucldqywtr?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "ucj2jnpoat15tqjp";
    private static final String JDBC_PASSWORD = "DH59VfSGTGR6UXUcS3Cq";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(PreparedStatement st) throws SQLException {
        st.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
