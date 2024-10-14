package conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Rama
 */
public class Conexion {

    //conexion local
    public static Connection conectar() {

        try {

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/sistema_compraventa?useSSL=false", "root", "1234");
            return cn;

        } catch (SQLException e) {
            System.out.println("Error en la conexion local" + e);
        }

        return null;
    }
}
