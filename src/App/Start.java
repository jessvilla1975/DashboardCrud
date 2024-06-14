
/**
 * Nombre del archivo: Start.java
 * Descripción: Este archivo contiene la clase Start la cual inicia la app
 * Autores: YESSICA FERNANDA VILLA NUÑEZ CÓDIGO: 2266301-3743
            KAREN JHULIETH GRIJALBA ORTIZ CÓDIGO: 2259623-3743
            MANUEL ANTONIO VIDALES DURAN CÓDIGO:2155481-3743
            KEVIN ANDRÉS BEJARANO TELLO CÓDIGO: 2067678-3743
     
 * Fecha de creación: 25/05/2024
 * Última modificación: 13/06/2024
 * Versión: 1.0
 * 
 */

/**
 * La clase Inicio en el paquete de la aplicación configura la apariencia de FlatLaf con un tema
 * personalizado y abre una ventana de inicio de sesión.
 */

package App;


import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import login.Login;



 
public class Start {

    /**
     * La función main es el punto de entrada de la aplicación. Configura el tema de la interfaz gráfica
     * utilizando FlatLaf y muestra la ventana de login.
     * 
     * @param args Los argumentos de la línea de comandos no se utilizan en esta aplicación.
     */
    public static void main(String[] args) {
      // Registrar la fuente de valores predeterminados personalizados para FlatLaf
      FlatLaf.registerCustomDefaultsSource("table");

      // Configurar el tema FlatMacDarkLaf para la interfaz gráfica
      FlatMacDarkLaf.setup();

      // Crear una instancia de la ventana de login y hacerla visible
      Login abrir = new Login();
      abrir.setVisible(true);
  }
    
}
