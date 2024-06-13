
package login;

import javax.swing.JOptionPane;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import sql.ConexionSQL;

/**
 *
 * @author Jess
 */

public class LoginUsuarios extends ConexionSQL{
    
    java.sql.Statement st;
    ResultSet rs;
    String admin="admin";
    String clave="admin";
    
    public String nombre = "";
    public boolean verificarCredenciales(String user, String password) {
        // Verificar si es el administrador
        if (user.equals(admin) && password.equals(clave)) {
            System.out.println("Ingreso administrador");
            return true;
        }
        
        // Verificar si es un usuario normal
        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM usuarios WHERE id = ? AND password = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, user);  // Asumiendo que user contiene el ID del usuario
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if (rs != null && rs.next()) {
                //System.out.println("Usuario encontrado: " + rs.getString("nombre"));
                nombre = rs.getString("nombre");
                return true;
            } else {
                //System.out.println("Usuario no encontrado.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
        // Crear una instancia de LoginUsuarios y probar el método verificarUsuario
        LoginUsuarios login = new LoginUsuarios();
        
        // Prueba de verificar credenciales para el administrador
        boolean adminLogin = login.verificarCredenciales("admin", "admin");
        System.out.println("Login administrador: " + adminLogin);

        // Prueba de verificar credenciales para un usuario
        boolean userLogin = login.verificarCredenciales("1", "password123");  // Asumiendo que el ID del usuario es "1"
        System.out.println("Login usuario: " + userLogin);
    }
    
    
    
   
    
    
}
