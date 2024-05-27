
package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class conexionsql {
    String bd = "inventariods";
    Connection cx;
    String url="jdbc:mysql://localhost:3306/";
    String usuario="root";
    String clave="1111";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    
    public conexionsql(){
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd,usuario,clave);
            System.out.println("conexion exitosa");
        } catch (ClassNotFoundException |SQLException ex) {
            Logger.getLogger(conexionsql.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error coneectar");
        }
        
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexionsql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //prueba de conexion 
    public static void main(String[] args){
        conexionsql co = new conexionsql();
        co.conectar();    
    
    }
    
}
