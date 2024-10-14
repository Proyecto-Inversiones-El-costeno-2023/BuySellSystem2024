package controlador;

import modelo.Usuario;
import java.sql.Connection;
import conexion.Conexion;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


/**
 *
 * @author Rama
 */
public class Ctrl_Usuario {

    //metodo para iniciar sesion
    public boolean loginUser(Usuario objeto) {

        boolean respuesta = false;

        Connection cn = Conexion.conectar();
        String sql = "select  usuario, password from usuario where usuario = '" + objeto.getUsuario() + "' and password = '" + objeto.getPassword() +
        "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al inciar Sesion");
            JOptionPane.showMessageDialog(null, "Error al inciar Sesion");
        }
        
        return respuesta;

    }

}
