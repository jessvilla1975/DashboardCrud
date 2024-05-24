/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.ingresar;
import java.awt.Color;
import sql.crudsql;
import java.sql.ResultSet;


/**
 *
 * @author Jess
 */
public class IngresarProducto extends javax.swing.JFrame {

    /**
     * Creates new form IngresarColegio
     */
    public IngresarProducto() {
        initComponents();
        idpro.setBackground(Color.WHITE);
        idpro.setFocusable(false); 
        texttipo.setBackground(Color.WHITE);
        texttipo.setFocusable(false); 
        TextColor.setBackground(Color.WHITE);
        TextColor.setFocusable(false); 
        Text3.setForeground(Color.BLACK);
        Text4.setForeground(Color.BLACK);
        Text6.setForeground(Color.BLACK);
        Text11.setForeground(Color.BLACK);
        Text14.setForeground(Color.BLACK);
        Text7.setForeground(Color.BLACK);
        Title.setForeground(Color.BLACK);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    crudsql crud=new crudsql();
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelColegio = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Text3 = new javax.swing.JLabel();
        idpro = new javax.swing.JTextField();
        texttipo = new javax.swing.JTextField();
        Text4 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        Guardar = new javax.swing.JButton();
        Text11 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        Text6 = new javax.swing.JLabel();
        itemTalla = new javax.swing.JComboBox<>();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        Text14 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        Jgenero = new javax.swing.JComboBox<>();
        TextColor = new javax.swing.JTextField();
        Text7 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        SCantidad = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(600, 220));
        setUndecorated(true);
        setResizable(false);

        PanelColegio.setBackground(new java.awt.Color(255, 255, 255));
        PanelColegio.setPreferredSize(new java.awt.Dimension(620, 550));

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setText("Datos Producto");
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Text3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text3.setText("Id Producto");

        idpro.setForeground(new java.awt.Color(102, 102, 102));
        idpro.setText("Ingresar id del producto");
        idpro.setBorder(null);
        idpro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                idproMousePressed(evt);
            }
        });

        texttipo.setForeground(new java.awt.Color(102, 102, 102));
        texttipo.setText("Ingresar tipo del producto");
        texttipo.setBorder(null);
        texttipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                texttipoMousePressed(evt);
            }
        });
        texttipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texttipoActionPerformed(evt);
            }
        });

        Text4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text4.setText("Tipo");

        jSeparator5.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator5.setPreferredSize(new java.awt.Dimension(200, 10));

        Guardar.setBackground(new java.awt.Color(153, 153, 255));
        Guardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Guardar.setForeground(new java.awt.Color(255, 255, 255));
        Guardar.setText("Agregar");
        Guardar.setBorder(null);
        Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GuardarMouseExited(evt);
            }
        });
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Text11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text11.setText("Cantidad");

        jSeparator7.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator7.setPreferredSize(new java.awt.Dimension(200, 10));

        Text6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text6.setText("Talla");

        itemTalla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unica", "S", "L", "M", "X", "XL" }));
        itemTalla.setBorder(null);
        itemTalla.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        itemTalla.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemTallaItemStateChanged(evt);
            }
        });
        itemTalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTallaActionPerformed(evt);
            }
        });

        jSeparator8.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator8.setPreferredSize(new java.awt.Dimension(200, 10));

        jSeparator9.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator9.setPreferredSize(new java.awt.Dimension(200, 10));

        Text14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text14.setText("Genero");

        jSeparator10.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator10.setPreferredSize(new java.awt.Dimension(200, 10));

        Jgenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", "Unisex" }));
        Jgenero.setBorder(null);
        Jgenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JgeneroItemStateChanged(evt);
            }
        });
        Jgenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JgeneroActionPerformed(evt);
            }
        });

        TextColor.setForeground(new java.awt.Color(102, 102, 102));
        TextColor.setText("Ingresar color de la prenda");
        TextColor.setBorder(null);
        TextColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TextColorMousePressed(evt);
            }
        });
        TextColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextColorActionPerformed(evt);
            }
        });

        Text7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text7.setText("Color");

        jSeparator12.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator12.setPreferredSize(new java.awt.Dimension(200, 10));

        javax.swing.GroupLayout PanelColegioLayout = new javax.swing.GroupLayout(PanelColegio);
        PanelColegio.setLayout(PanelColegioLayout);
        PanelColegioLayout.setHorizontalGroup(
            PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelColegioLayout.createSequentialGroup()
                .addGroup(PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelColegioLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelColegioLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelColegioLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Text3)
                                .addComponent(Text11)
                                .addGroup(PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelColegioLayout.createSequentialGroup()
                                            .addComponent(Text6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(itemTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(Text4)
                                                .addComponent(texttipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(idpro, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PanelColegioLayout.createSequentialGroup()
                                        .addComponent(Text14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Jgenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelColegioLayout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(Title))
                                .addComponent(Text7)
                                .addComponent(TextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelColegioLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );
        PanelColegioLayout.setVerticalGroup(
            PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelColegioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addComponent(Text3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Text4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texttipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text6)
                    .addComponent(itemTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text11)
                    .addComponent(SCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text14)
                    .addComponent(Jgenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(PanelColegioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelColegioLayout.createSequentialGroup()
                    .addGap(134, 134, 134)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(372, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelColegio, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelColegio, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        System.out.println("Se presionó el botón guardar");
        
        int id = Integer.parseInt(idpro.getText());
        String tipo = texttipo.getText();
        String item = (String) itemTalla.getSelectedItem();
        int cant = (int) SCantidad.getValue();
        String genero = (String) Jgenero.getSelectedItem();
        String color = TextColor.getText();

        crud.insertar(id,tipo,item,cant,genero,color);
       

        idpro.setText("Ingresar id del producto");
        texttipo.setText("Ingresar tipo del producto");
        TextColor.setText("Ingresar color de la prenda");
        setVisible(false);

    }//GEN-LAST:event_GuardarActionPerformed

    private void GuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseExited
        Guardar.setBackground(new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_GuardarMouseExited

    private void GuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseEntered
        Guardar.setBackground(new java.awt.Color(21, 101, 192));
    }//GEN-LAST:event_GuardarMouseEntered

    private void texttipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texttipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texttipoActionPerformed

    private void texttipoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_texttipoMousePressed
        if(texttipo.getText().equals("Ingresar tipo del producto"))
        texttipo.setText("");
        texttipo.setFocusable(true);
        texttipo.requestFocusInWindow();
    }//GEN-LAST:event_texttipoMousePressed

    private void idproMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idproMousePressed
        if(idpro.getText().equals("Ingresar id del producto"))
        idpro.setText("");
        idpro.setFocusable(true);
        idpro.requestFocusInWindow();
    }//GEN-LAST:event_idproMousePressed

    private void itemTallaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemTallaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_itemTallaItemStateChanged

    private void itemTallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemTallaActionPerformed

    private void JgeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JgeneroItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_JgeneroItemStateChanged

    private void JgeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JgeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JgeneroActionPerformed

    private void TextColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextColorMousePressed
        if(TextColor.getText().equals("Ingresar color de la prenda"))
        TextColor.setText("");
        TextColor.setFocusable(true);
        TextColor.requestFocusInWindow();
    }//GEN-LAST:event_TextColorMousePressed

    private void TextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextColorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IngresarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JComboBox<String> Jgenero;
    private javax.swing.JPanel PanelColegio;
    private javax.swing.JSpinner SCantidad;
    private javax.swing.JLabel Text11;
    private javax.swing.JLabel Text14;
    private javax.swing.JLabel Text3;
    private javax.swing.JLabel Text4;
    private javax.swing.JLabel Text6;
    private javax.swing.JLabel Text7;
    private javax.swing.JTextField TextColor;
    private javax.swing.JLabel Title;
    public javax.swing.JTextField idpro;
    private javax.swing.JComboBox<String> itemTalla;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField texttipo;
    // End of variables declaration//GEN-END:variables
}