package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import sql.ConexionSQL;
import javax.crypto.SecretKey;
import java.util.Base64;
import usuarios.Administrador;

public class LoginUsuarios extends ConexionSQL {

    java.sql.Statement st;
    ResultSet rs;
    String admin = "admin";
    String clave = "admin";

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
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, user);  // Asumiendo que user contiene el ID del usuario
            rs = ps.executeQuery();

            if (rs != null && rs.next()) {
                // Obtener la clave secreta desde una cadena almacenada (debes almacenarla de alguna forma segura)
                String secretKeyStr = Administrador.getSecretKeyAsString();
                SecretKey secretKey = Administrador.getSecretKeyFromString(secretKeyStr);

                // Obtener y descifrar la contraseña almacenada
                String encryptedPassword = rs.getString("password");
                String decryptedPassword = Administrador.decrypt(encryptedPassword, secretKey);

                if (password.equals(decryptedPassword)) {
                    nombre = Administrador.decrypt(rs.getString("nombre"), secretKey);  // Descifrar también el nombre
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
      
    }
}
