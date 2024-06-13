/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import javax.swing.*;
import java.awt.*;

public class PanelDeslizante extends JFrame {
    private JPanel panel;
    private int posicionX = 0; // Posición inicial del panel

    public PanelDeslizante() {
        setTitle("Panel Deslizante");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setBounds(posicionX, 100, 100, 100); // Posición y tamaño inicial del panel
        getContentPane().setLayout(null);
        getContentPane().add(panel);

        // Crear y iniciar el hilo para mover el panel
        Thread hiloMovimiento = new Thread(new MovimientoPanel());
        hiloMovimiento.start();
    }

    private class MovimientoPanel implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10); // Ajusta la velocidad del movimiento
                    posicionX += 1; // Incrementa la posición en X

                    // Actualizar la posición del panel
                    panel.setBounds(posicionX, 100, 100, 100);

                    // Reiniciar la posición si el panel sale de la ventana
                    if (posicionX >= getContentPane().getWidth() - 100) {
                        posicionX = 0;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PanelDeslizante().setVisible(true);
            }
        });
    }
}
