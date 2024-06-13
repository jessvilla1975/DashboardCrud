package sql;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.File;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
public class Inventario extends ConexionSQL {

    java.sql.Statement st;
    ResultSet rs;

    public ResultSet Listar(String tabla) {
    try {
        Connection conexion = conectar();
        String sql = "SELECT * FROM " + tabla;
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
    
////INSERT////////////////////////////////////////////////////////////////////////////////////////////////////
    public void Insertar(int id, String tipo, String talla, int cantidad, String genero, String color) {
        try {
            Connection conexion = conectar();
            String sql = "INSERT INTO productos (id, tipo, talla, cantidad, genero, color) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, tipo);
            preparedStatement.setString(3, talla);
            preparedStatement.setInt(4, cantidad);
            preparedStatement.setString(5, genero);
            preparedStatement.setString(6, color);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conexion.close();

            JOptionPane.showMessageDialog(null, "El producto se agrego con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardó: " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    ///////////////////BUSCAR///////////////////////////////////////
    public ResultSet buscarPorId(int id) {
        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM productos WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet ListarProductosAgregados() {
    try {
        Connection conexion = conectar();
        String sql = "SELECT * FROM productos WHERE cantidad <= 6";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

    
    ///////////////////UPDATE///////////////////////////////////////
   

    public void Actualizar(int id, String tipo, String talla, int cantidad, String genero, String color) {
        try {
            Connection conexion = conectar();

            // Verificar si el producto con el ID dado existe antes de editar
            String verificarSql = "SELECT * FROM productos WHERE id = ?";
            PreparedStatement verificarPs = conexion.prepareStatement(verificarSql);
            verificarPs.setInt(1, id);
            ResultSet verificarRs = verificarPs.executeQuery();

            if (!verificarRs.next()) {
                JOptionPane.showMessageDialog(null, "No se encontró un producto con el ID proporcionado", "Mensaje", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Si el producto existe, realizar la actualización
            String editarSql = "UPDATE productos SET tipo = ?, talla = ?, cantidad = ?, genero = ?, color = ? WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(editarSql);
            ps.setString(1, tipo);
            ps.setString(2, talla);
            ps.setInt(3, cantidad);
            ps.setString(4, genero);
            ps.setString(5, color);
            ps.setInt(6, id);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Producto editado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo editar el producto", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }

            ps.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar producto: " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    //////////////////////ELIMINAR////////////////////////////////////////////////////
    public void Eliminar(int id) {
    try {
        Connection conexion = conectar();
        st = conexion.createStatement();
        String sql = "DELETE FROM productos WHERE id = " + id + ";";
        st.execute(sql);

        st.close();
        conexion.close();
        
        JOptionPane.showMessageDialog(null, "Producto eliminado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar: " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
    }
  }
  ///////////////////////FUNCIONES AUX////////////////////////////////////////////////
    public int ContarProductos() {
        int cantidad = 0;
        try {
            Connection conexion = conectar();
            String sql = "SELECT COUNT(*) FROM productos";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt(1);
            }
            rs.close();
            ps.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al contar los productos: " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return cantidad;
    }
    
    public int StockProductos() {
    int cantidad = 0;
    try {
        Connection conexion = conectar();
        String sql = "SELECT COUNT(*) FROM productos WHERE cantidad < 6";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            cantidad = rs.getInt(1);
        }
        rs.close();
        ps.close();
        conexion.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al contar los productos con existencia de 1: " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
    }
    return cantidad;
}
    
    public void generarReporteProductos() {
    try {
        Connection conexion = conectar();
        String sql = "SELECT tipo, talla, cantidad, genero, color FROM productos";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        // Crear un nuevo libro de trabajo de Excel
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet hoja = workbook.createSheet("Reporte de Productos");

        // Escribir los encabezados de las columnas
        XSSFRow encabezado = hoja.createRow(0);
        encabezado.createCell(0).setCellValue("Tipo");
        encabezado.createCell(1).setCellValue("Talla");
        encabezado.createCell(2).setCellValue("Cantidad");
        encabezado.createCell(3).setCellValue("Género");
        encabezado.createCell(4).setCellValue("Color");

        int filaIndex = 1;
        while (rs.next()) {
            XSSFRow fila = hoja.createRow(filaIndex);
            fila.createCell(0).setCellValue(rs.getString("tipo"));
            fila.createCell(1).setCellValue(rs.getString("talla"));
            fila.createCell(2).setCellValue(rs.getInt("cantidad"));
            fila.createCell(3).setCellValue(rs.getString("genero"));
            fila.createCell(4).setCellValue(rs.getString("color"));
            filaIndex++;
        }

        // Generar el gráfico de productos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String sqlGrafico = "SELECT tipo, COUNT(*) AS cantidad FROM productos GROUP BY tipo";
        PreparedStatement psGrafico = conexion.prepareStatement(sqlGrafico);
        ResultSet rsGrafico = psGrafico.executeQuery();
        while (rsGrafico.next()) {
            String tipo = rsGrafico.getString("tipo");
            int cantidad = rsGrafico.getInt("cantidad");
            dataset.addValue(cantidad, "Cantidad", tipo);
        }

        JFreeChart grafico = ChartFactory.createBarChart(
                "Productos por Tipo",
                "Tipo de Producto",
                "Cantidad",
                dataset
        );

        // Insertar el gráfico en el archivo de Excel
        ByteArrayOutputStream chartStream = new ByteArrayOutputStream();
        org.jfree.chart.ChartUtils.writeChartAsPNG(chartStream, grafico, 600, 400);

        int imgIndex = workbook.addPicture(chartStream.toByteArray(), XSSFWorkbook.PICTURE_TYPE_PNG);
        chartStream.close();

        Drawing drawing = hoja.createDrawingPatriarch();
        // Ajustar el ancla para posicionar el gráfico a partir de la columna 3
        ClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, 6, 2, 16, 20);
        drawing.createPicture(anchor, imgIndex);

        // Escribir el archivo Excel
        FileOutputStream outputStream = new FileOutputStream("reporte_productos.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        JOptionPane.showMessageDialog(null, "Reporte de productos generado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al generar el reporte de productos: " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
    }
}
 
   

}