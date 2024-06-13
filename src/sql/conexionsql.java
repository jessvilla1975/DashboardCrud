/**
 * La clase `ConexionSQL` en Java establece una conexión a una base de datos MySQL utilizando
 * credenciales específicas y proporciona métodos para conectarse y desconectarse de la base de datos.
 */

package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionSQL {
    String bd = "inventariods";
    Connection cx;
    String url="jdbc:mysql://localhost:3306/";
    String usuario="root";
    String clave="1111";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    
    public ConexionSQL(){
    }
    
    /**
     * La función "conectar" intenta establecer una conexión a una base de datos utilizando el
     * controlador, URL, nombre de usuario y contraseña especificados en Java.
     * 
     * @return El método `conectar()` devuelve un objeto `Connection`.
     */
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd,usuario,clave);
            System.out.println("conexion exitosa");
        } catch (ClassNotFoundException |SQLException ex) {
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error coneectar");
        }
        
        return cx;
    }
    
    /**
     * El método `desconectar` se utiliza para desconectarse de una base de datos SQL cerrando la
     * conexión.
     */
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //prueba de conexion 
    public static void main(String[] args){
        ConexionSQL co = new ConexionSQL();
        co.conectar();    
    
    }
    
}
