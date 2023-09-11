/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouniversidad.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectouniversidad.entidades.Alumno;

/**
 *
 * @author Isabel
 */
public class AlumnoData {
    
    private Connection con=null;
    
    public AlumnoData(){//constructor de la variable date va inicializar la variable con
        con=Conexion.getConexion();//esta clase conexion hace la conexion a la bd
    }
    
    public void guardarAlumno(Alumno alumno){
        String sql="INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado )"
                + "VALUE(?, ?, ?, ?, ?)";
            
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               
                JOptionPane.showMessageDialog(null, "alumno guardado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumno"); }
    }
    
}
