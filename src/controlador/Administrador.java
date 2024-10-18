/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author Rama
 */
public class Administrador {
    
      public String Administrator(Usuario objeto) {
    
        String tp = "";

        Connection cn = Conexion.conectar();
        String sql = "select  usuario, pass, tipoUsuario from usuario where usuario = '" + objeto.getUsuario() + "' and pass =aes_encrypt('" + objeto.getPass() +
        "','P69H_2b+O[£h')";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                tp = rs.getString("tipoUsuario");
            }

        } catch (SQLException e) {
            System.out.println("Error al inciar Sesion");
            JOptionPane.showMessageDialog(null, "Error al inciar Sesion");
        }

        return tp;
    }
}

