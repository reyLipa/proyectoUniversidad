/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouniversidad.accesoADatos;

import java.sql.*;//en vez de importar varias con el * importo a todas
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Isabel
 */
public class Conexion {
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="universidad";
    private static final String USER="root";
    private static final String PASSWORD="";
    private static Connection connection;
    
    private Conexion(){}//constructor privado no se podra instanciar objetos de ella
    
    public static Connection getConexion(){
        if (connection==null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection=DriverManager.getConnection(URL+DB, USER, PASSWORD);
                JOptionPane.showMessageDialog(null, "conectado");
            } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "error al cargar los Driver");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error al conectar");
            }
        }
        return connection;
    }
    
    
}
