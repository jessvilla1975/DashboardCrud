/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package table;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Locale;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import sql.Inventario;
import sql.Inventario;

/**
 *
 * @author Jess
 */
public class TablaUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form xd
     */
    Inventario crud = new Inventario();
    public TablaUsuarios() {
        initComponents();
        
        table.setDefaultRenderer(Object.class, new TableGradientCell());
        table.setBounds(0, 0, 600, 410);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.setForeground(Color.BLACK);
        table.getTableHeader().setBackground(new Color(42,33,133));
        table.getTableHeader().setForeground(new Color(255,255,255));
        
        /*JPanel.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");*/
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
        ResultSet resultados = crud.Listar("usuarios");
        String[] nombresColumnas = {
                "ID",
                "Nombre",
                "Email",
                "Password"
            };
        // Llamar al método actualizarTabla con los resultados y nombres de columnas
       actualizarTabla(resultados, nombresColumnas);
    }
    
    public void testData2(int id){
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        modeloTabla = new DefaultTableModel();
        table.setModel(modeloTabla);
        ResultSet resultados = crud.buscarPorId(id);
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
    public void testData3() {
    int filaSeleccionada = table.getSelectedRow();
    if (filaSeleccionada != -1) {
        // Obtener datos de la fila seleccionada
        int id = Integer.parseInt(table.getValueAt(filaSeleccionada, 0).toString());
        String tipo = table.getValueAt(filaSeleccionada, 1).toString();
        String talla = table.getValueAt(filaSeleccionada, 2).toString();
        int cantidad = Integer.parseInt(table.getValueAt(filaSeleccionada, 3).toString());
        String genero = table.getValueAt(filaSeleccionada, 4).toString();
        String color = table.getValueAt(filaSeleccionada, 5).toString();
        crud.Actualizar(id, tipo, talla, cantidad, genero, color);

        
    } 
}
    public void testData4(){
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        modeloTabla = new DefaultTableModel();
        table.setModel(modeloTabla);
        ResultSet resultados = crud.ListarProductosAgregados();
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
                crud.Eliminar(id);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(600, 410));
        setPreferredSize(new java.awt.Dimension(600, 410));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 410));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
