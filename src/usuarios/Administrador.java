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
    private SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        return keyGen.generateKey();
    }

    // Cifra un mensaje
    private String encrypt(String message, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Descifra un mensaje
    public static String decrypt(String encryptedMessage, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes);
    }

    // Método para obtener la clave secreta desde una cadena base64
    public static SecretKey getSecretKeyFromString(String keyStr) {
        byte[] decodedKey = Base64.getDecoder().decode(keyStr);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);
    }

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
