
package proyectouniversidad;

import java.sql.Connection;
import proyectouniversidad.accesoADatos.Conexion;

public class ProyectoUniversidad {

   
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con=Conexion.getConexion();
    }
    
}
