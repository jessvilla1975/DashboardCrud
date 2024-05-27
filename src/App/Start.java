
package App;


import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import login.Login;



 
public class Start {

    
    public static void main(String[] args) {
      FlatLaf.registerCustomDefaultsSource("table");
      FlatMacDarkLaf.setup();
      Login abrir=new Login();
      abrir.setVisible(true);
     
      
    }
    
}
