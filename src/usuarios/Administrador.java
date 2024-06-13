package usuarios;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import sql.ConexionSQL;
public class Administrador extends Usuario{

    java.sql.Statement st;
    ResultSet rs;
    ConexionSQL cx = new ConexionSQL();

    public Administrador(int id, String nombre, String email, String password) {
        super(id, nombre, email, password);
        //TODO Auto-generated constructor stub
    }

    public void RegistrarUsuarios(int id, String nombre, String email, String password){
        try {
            Connection cxConnection = cx.conectar();
            String sql = "INSERT INTO usuarios (id, nombre, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = cxConnection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            cxConnection.close();

            JOptionPane.showMessageDialog(null, "El usuario se agrego con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El usuario no se guardó: " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }


    }

    public static void main(String[] args) {
       
        
    }

}
