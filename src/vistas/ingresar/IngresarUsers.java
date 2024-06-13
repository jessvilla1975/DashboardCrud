/**
 * La clase `IngresarUsers` es un panel GUI de Java para registrar usuarios con campos de ID, nombre,
 * correo electrónico y contraseña.
 */

package vistas.ingresar;

import java.awt.Color;
import javax.swing.JOptionPane;
import usuarios.Administrador;


public class IngresarUsers extends javax.swing.JPanel {

    
   
    public IngresarUsers() {
        initComponents();
        PanelUsuario.setBounds(100, 500,PanelUsuario.getWidth() ,PanelUsuario.getHeight());
        Title.setForeground(Color.black);
        Text3.setForeground(Color.black);
        Text4.setForeground(Color.black);
        Text6.setForeground(Color.black);
        Text7.setForeground(Color.black); 
        idpro.setBackground(Color.white);
        nombretxt.setBackground(Color.white);
        txtEmail.setBackground(Color.white);
        txtPassword.setBackground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelUsuario = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Text3 = new javax.swing.JLabel();
        idpro = new javax.swing.JTextField();
        nombretxt = new javax.swing.JTextField();
        Text4 = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        Text6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        Text7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(345, 516));
        setLayout(new java.awt.BorderLayout());

        PanelUsuario.setBackground(new java.awt.Color(255, 255, 255));
        PanelUsuario.setPreferredSize(new java.awt.Dimension(345, 516));

        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setText("Registrar Usuario");
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Text3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text3.setText("ID");

        idpro.setForeground(new java.awt.Color(102, 102, 102));
        idpro.setText("Ingresar id del usuario");
        idpro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        idpro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                idproMousePressed(evt);
            }
        });

        nombretxt.setForeground(new java.awt.Color(102, 102, 102));
        nombretxt.setText("Ingresar nombre del usuario");
        nombretxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        nombretxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nombretxtMousePressed(evt);
            }
        });
        nombretxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombretxtActionPerformed(evt);
            }
        });

        Text4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text4.setText("Nombre");

        Guardar.setBackground(new java.awt.Color(153, 153, 255));
        Guardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Guardar.setForeground(new java.awt.Color(255, 255, 255));
        Guardar.setText("Agregar");
        Guardar.setBorder(null);
        Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GuardarMouseClicked(evt);
            }
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

        Text6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text6.setText("Email");

        txtPassword.setForeground(new java.awt.Color(102, 102, 102));
        txtPassword.setText("Ingresar password del usuario");
        txtPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        Text7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text7.setText("Password");

        txtEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtEmail.setText("Ingresar email del usuario");
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailMousePressed(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelUsuarioLayout = new javax.swing.GroupLayout(PanelUsuario);
        PanelUsuario.setLayout(PanelUsuarioLayout);
        PanelUsuarioLayout.setHorizontalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelUsuarioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Title)
                .addGap(64, 64, 64))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelUsuarioLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text3)
                            .addComponent(Text6)
                            .addComponent(Text4)
                            .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idpro, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text7)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelUsuarioLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        PanelUsuarioLayout.setVerticalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addComponent(Text3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idpro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Text4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(Text6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Text7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        add(PanelUsuario, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void idproMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idproMousePressed
        if(idpro.getText().equals("Ingresar id del usuario"))
        idpro.setText("");
        idpro.setFocusable(true);
        idpro.requestFocusInWindow();
    }//GEN-LAST:event_idproMousePressed

    private void nombretxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombretxtMousePressed
        if(nombretxt.getText().equals("Ingresar nombre del usuario"))
        nombretxt.setText("");
        nombretxt.setFocusable(true);
        nombretxt.requestFocusInWindow();
    }//GEN-LAST:event_nombretxtMousePressed

    private void nombretxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombretxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombretxtActionPerformed

    private void GuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseEntered
        Guardar.setBackground(new java.awt.Color(42, 33, 133));
    }//GEN-LAST:event_GuardarMouseEntered

    private void GuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseExited
        Guardar.setBackground(new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_GuardarMouseExited

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        System.out.println("Se presionó el botón guardar");

        try {
            // Obtener los datos de los JTextField
            int id = Integer.parseInt(idpro.getText());
            String nombre = nombretxt.getText();
            String email = txtEmail.getText();
            String password = txtPassword.getText();

            // Crear una instancia de Administrador
            Administrador admin = new Administrador(id, nombre, email, password);
            admin.RegistrarUsuarios(id, nombre, email, password);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        idpro.setText("Ingresar id del usuario");
        nombretxt.setText("Ingresar nombre del usuario");
        txtEmail.setText("Ingresar email del usuario");
        txtPassword.setText("Ingresar password del usuario");
    }//GEN-LAST:event_GuardarActionPerformed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if(txtPassword.getText().equals("Ingresar password del usuario"))
        txtPassword.setText("");
        txtPassword.setFocusable(true);
        txtPassword.requestFocusInWindow();
    }//GEN-LAST:event_txtPasswordMousePressed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        if(txtPassword.getText().equals("Ingresar password del usuario"))
        txtPassword.setText("");
        txtPassword.setFocusable(true);
        txtPassword.requestFocusInWindow();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMousePressed
        if(txtEmail.getText().equals("Ingresar email del usuario"))
        txtEmail.setText("");
        txtEmail.setFocusable(true);
        txtEmail.requestFocusInWindow();
    }//GEN-LAST:event_txtEmailMousePressed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardarMouseClicked
   
            
        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Guardar;
    private javax.swing.JPanel PanelUsuario;
    private javax.swing.JLabel Text3;
    private javax.swing.JLabel Text4;
    private javax.swing.JLabel Text6;
    private javax.swing.JLabel Text7;
    private javax.swing.JLabel Title;
    public javax.swing.JTextField idpro;
    private javax.swing.JTextField nombretxt;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
