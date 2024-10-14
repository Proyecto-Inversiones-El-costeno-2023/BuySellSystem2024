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
        String sql = "select  usuario, pass from usuario where usuario = '" + objeto.getUsuario() + "' and pass =aes_encrypt('" + objeto.getPass() +
        "','P69H_2b+O[£h')";
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
