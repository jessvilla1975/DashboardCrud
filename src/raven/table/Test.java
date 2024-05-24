package raven.table;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;
import sql.crudsql;

/**
 *
 * @author RAVEN
 */
public class Test extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    crudsql crud = new crudsql();
    public Test() {
        initComponents();
        table.setDefaultRenderer(Object.class, new TableGradientCell());
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.setForeground(Color.BLACK);
        table.getTableHeader().setBackground(new Color(42,33,133));
        table.getTableHeader().setForeground(new Color(255,255,255));
        
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background");
        scroll.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,0,3,0,$Table.background,10,10");
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverTrackColor:null");
        modeloTabla = new DefaultTableModel();
        table.setModel(modeloTabla);
        testData();
    }

    private DefaultTableModel modeloTabla;
    public void testData(){
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        modeloTabla = new DefaultTableModel();
        table.setModel(modeloTabla);
        ResultSet resultados = crud.buscar("productos");
        String[] nombresColumnas = {
                "ID",
                "Tipo",
                "Talla",
                "Cantidad",
                "Genero",
                "Color"
            };
        // Llamar al método actualizarTabla con los resultados y nombres de columnas
       actualizarTabla(resultados, nombresColumnas);
    }
     public void actualizarTabla(ResultSet resultados, String[] nombresColumnas) {
        // Limpiar la tabla antes de agregar nuevos datos
        
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnIdentifiers(nombresColumnas); // Establecer los nombres de las columnas
       

        try {
            // Obtener el número de columnas en el conjunto de resultados
            ResultSetMetaData metaData = resultados.getMetaData();
            int numColumnas = metaData.getColumnCount();

            // Iterar a través de los resultados y agregarlos a la tabla
            while (resultados.next()) {
                Object[] fila = new Object[numColumnas];

                // Llenar el array con los datos de cada columna
                for (int i = 1; i <= numColumnas; i++) {
                    fila[i - 1] = resultados.getObject(i);
                }
                modeloTabla.addRow(fila);

                // Agregar la fila al modelo de la tabla
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public void eliminarFila(){
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {  
                // Obtener datos de la fila seleccionada
                int id = Integer.parseInt(table.getValueAt(filaSeleccionada, 0).toString());
                crud.eliminar(id);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scroll.setBackground(new java.awt.Color(255, 255, 255));
        scroll.setForeground(new java.awt.Color(255, 255, 255));
        scroll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Email", "Address", "Position"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        scroll.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(10);
            table.getColumnModel().getColumn(1).setPreferredWidth(150);
            table.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        jPanel1.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 872, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        FlatLaf.registerCustomDefaultsSource("raven.table");
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Test t = new Test();
                t.setBounds(320, 280, 872, 418);
                t.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
