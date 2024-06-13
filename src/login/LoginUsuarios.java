/**
 * La clase `LoginUsuarios` en Java verifica las credenciales de usuario tanto para administradores
 * como para usuarios normales comparando contraseñas y descifrando contraseñas almacenadas usando una
 * clave secreta.
 */
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

    /**
     * La función "verificarCredenciales" verifica las credenciales del usuario, permitiendo el acceso
     * a un administrador con un nombre de usuario y contraseña específicos, y a los usuarios normales
     * al comparar su contraseña cifrada almacenada con la entrada.
     * 
     * @param user El parámetro `usuario` en el método `verificarCredenciales` se usa para pasar el
     * nombre de usuario o ID del usuario que intenta iniciar sesión. Se usa para identificar al
     * usuario en el sistema y verificar sus credenciales.
     * @param password El parámetro `contraseña` en el método `verificarCredenciales` es la contraseña
     * ingresada proporcionada por el usuario que intenta iniciar sesión. Esta contraseña se compara
     * con la contraseña almacenada y cifrada en la base de datos para el ID de usuario correspondiente
     * (“usuario”). Si la contraseña proporcionada coincide con la contraseña descifrada recuperada de
     * @return El método `verificarCredenciales` devuelve un valor booleano. Si el usuario y la
     * contraseña coinciden con las credenciales de administrador, devuelve "verdadero", lo que indica
     * un inicio de sesión exitoso como administrador. Si el usuario es un usuario normal y las
     * credenciales proporcionadas coinciden con la contraseña cifrada almacenada después del
     * descifrado, también devuelve "verdadero", lo que indica que el inicio de sesión se realizó
     * correctamente como usuario normal. Si falla cualquier otra condición o se produce una excepción
     * durante
     */
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
