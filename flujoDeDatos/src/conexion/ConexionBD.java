package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Nicolás
 */
public class ConexionBD {
    private String nombreBD = "torneo_cun";
    private String usuario = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/" + nombreBD;
    
    
    Connection con = null;
    public ConexionBD(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, password);
            
            if(con != null){
                System.out.println("Conexion correcta");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
