/**
 * La clase `Administrador` en Java extiende `Usuario`, implementa métodos de cifrado y descifrado para
 * los datos del usuario y proporciona funcionalidad para registrar usuarios de forma segura en una
 * base de datos.
 */
package usuarios;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import sql.ConexionSQL;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Administrador extends Usuario {

    java.sql.Statement st;
    ConexionSQL cx = new ConexionSQL();
    private static SecretKey secretKey;
    private static final String ALGORITHM = "AES";

    public Administrador(int id, String nombre, String email, String password) {
        super(id, nombre, email, password);
        try {
            // Genera una clave única para el cifrado AES
            secretKey = generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Genera una clave AES
    /**
     * La función genera una clave secreta utilizando un KeyGenerator con un algoritmo y un tamaño de
     * clave específicos.
     * 
     * @return El método `generateKey()` devuelve un objeto `SecretKey`.
     */
    private SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        return keyGen.generateKey();
    }

    // Cifra un mensaje
    /**
     * La función `encrypt` toma un mensaje y una clave secreta, cifra el mensaje usando la clave y
     * devuelve el mensaje cifrado como una cadena codificada en Base64.
     * 
     * @param message El parámetro `message` en el método `encrypt` es el mensaje de texto sin formato
     * que desea cifrar. Este mensaje se cifrará utilizando la `SecretKey` proporcionada mediante un
     * algoritmo de cifrado simétrico especificado por la constante `ALGORITHM`.
     * @param key El parámetro `key` en el método `encrypt` es de tipo `SecretKey`. Esta clave se
     * utiliza para inicializar el cifrado antes de cifrar el mensaje. Es esencial para proteger el
     * proceso de cifrado y garantizar que el mensaje pueda descifrarse correctamente más adelante
     * utilizando la misma clave.
     * @return El método `encrypt` devuelve el mensaje cifrado como una cadena codificada en Base64.
     */
    private String encrypt(String message, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Descifra un mensaje
    /**
     * La función `decrypt` toma un mensaje cifrado y una clave secreta, descifra el mensaje usando la
     * clave y devuelve el mensaje descifrado como una cadena.
     * 
     * @param encryptedMessage El parámetro `encryptedMessage` es el mensaje que se ha cifrado
     * utilizando un algoritmo específico y debe descifrarse.
     * @param key El parámetro `key` en el método `decrypt` es un objeto `SecretKey` que se utiliza
     * para descifrar. La instancia `Cipher` utiliza esta clave para descifrar el mensaje cifrado. Es
     * esencial para descifrar el mensaje correctamente y debe coincidir con la clave que se utilizó
     * para el cifrado.
     * @return El método `decrypt` devuelve el mensaje descifrado como una cadena después de descifrar
     * el `encryptedMessage` utilizando la `SecretKey` proporcionada.
     */
    public static String decrypt(String encryptedMessage, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes);
    }

    // Método para obtener la clave secreta desde una cadena base64
    /**
     * La función `getSecretKeyFromString` decodifica una cadena codificada en Base64 en un objeto
     * SecretKey.
     * 
     * @param keyStr El parámetro `keyStr` es una representación de cadena de una clave secreta que
     * debe decodificarse del formato Base64 a una matriz de bytes para crear un objeto `SecretKey`.
     * @return El método `getSecretKeyFromString` devuelve un objeto `SecretKey` creado a partir de la
     * matriz de bytes decodificada obtenida de la cadena de entrada decodificada en Base64 `keyStr`.
     */
    public static SecretKey getSecretKeyFromString(String keyStr) {
        byte[] decodedKey = Base64.getDecoder().decode(keyStr);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);
    }

    /**
     * La función `RegistrarUsuarios` cifra el nombre de usuario y la contraseña, luego inserta los
     * datos del usuario en una tabla de base de datos y muestra un mensaje de éxito o error usando
     * Java Swing.
     * 
     * @param id El parámetro `id` en el método `RegistrarUsuarios` es un valor entero que representa
     * el identificador único del usuario que se está registrando. Se utiliza para identificar a cada
     * usuario en la base de datos y debe ser único para cada usuario.
     * @param nombre El parámetro "nombre" en el método "RegistrarUsuarios" hace referencia al nombre
     * del usuario que se desea registrar. Este nombre se cifrará antes de almacenarse en la base de
     * datos por motivos de seguridad.
     * @param email El parámetro `email` en el método `RegistrarUsuarios` es una variable de tipo
     * `String` que representa la dirección de correo electrónico del usuario que se está registrando.
     * Se utiliza para almacenar la información de correo electrónico del usuario en la base de datos
     * cuando se registra un nuevo usuario.
     * @param password El método `RegistrarUsuarios` que proporcionaste se utiliza para registrar
     * usuarios en una base de datos. Toma cuatro parámetros: `id`, `nombre`, `email` y `contraseña`.
     */
    public void RegistrarUsuarios(int id, String nombre, String email, String password) {
        try {
            // Cifrar el nombre de usuario y la contraseña
            String encryptedNombre = encrypt(nombre, secretKey);
            String encryptedPassword = encrypt(password, secretKey);

            Connection cxConnection = cx.conectar();
            String sql = "INSERT INTO usuarios (id, nombre, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = cxConnection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, encryptedNombre);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, encryptedPassword);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            cxConnection.close();

            JOptionPane.showMessageDialog(null, "El usuario se agregó con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El usuario no se guardó: " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * La función `getSecretKeyAsString` devuelve la clave secreta codificada como una cadena Base64.
     * 
     * @return Se devuelve una representación de cadena codificada en Base64 de la matriz de bytes de
     * la clave secreta.
     */
    public static String getSecretKeyAsString() {
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    public static void main(String[] args) {
        
        /*try {
            Administrador admin = new Administrador(1, "admin", "admin@example.com", "admin");
            admin.RegistrarUsuarios(2, "User", "user@example.com", "password123");

            // Ejemplo de descifrado
            String encryptedNombre = admin.encrypt("User", secretKey);
            String decryptedNombre = decrypt(encryptedNombre, secretKey);
            System.out.println("Nombre cifrado: " + encryptedNombre);
            System.out.println("Nombre descifrado: " + decryptedNombre);

            String encryptedPassword = admin.encrypt("password123", secretKey);
            String decryptedPassword = decrypt(encryptedPassword, secretKey);
            System.out.println("Contraseña cifrada: " + encryptedPassword);
            System.out.println("Contraseña descifrada: " + decryptedPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
