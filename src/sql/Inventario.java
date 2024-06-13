/**
 * La clase `Inventario` en Java proporciona métodos para administrar productos en una base de datos,
 * incluida la inserción, actualización, búsqueda, listado y generación de informes en Excel con
 * representaciones de gráficos de barras.
 */
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
    /**
     * Esta función Java inserta un nuevo producto en una tabla de base de datos con atributos
     * específicos y muestra un mensaje de éxito o error usando JOptionPane.
     * 
     * @param id El parámetro `id` en el método `Insertar` representa el identificador único del
     * producto que desea insertar en la tabla de la base de datos. Normalmente es un valor entero que
     * se utiliza para identificar de forma única cada producto en la base de datos.
     * @param tipo Tipo se refiere al tipo o categoría del producto que se inserta en la base de datos.
     * Podría ser algo así como "camisa", "pantalones", "zapatos", etc.
     * @param talla El parámetro "talla" en el método Insertar representa el tamaño del producto. Por
     * lo general, se utiliza para especificar el tamaño de prendas de vestir, como pequeña, mediana,
     * grande, etc.
     * @param cantidad "Cantidad" es un parámetro que representa la cantidad o número de artículos de
     * un producto que se insertan en una base de datos. Es un valor entero que indica cuántas unidades
     * del producto se están agregando al inventario.
     * @param genero "genero" es un parámetro que representa el género del producto que se inserta en
     * la base de datos. Es un parámetro de tipo String en el método Insertar.
     * @param color El parámetro "color" en el método "Insertar" representa el color del producto que
     * se inserta en la base de datos. Es un parámetro de tipo String que contiene la información de
     * color del producto. Al llamar al método "Insertar", deberá proporcionar un valor de color
     * específico para el producto que se agrega.
     */
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
    /**
     * La función busca un producto en una base de datos por su ID y devuelve el conjunto de
     * resultados.
     * 
     * @param id El método `buscarPorId` toma un número entero `id` como parámetro, que se utiliza para
     * buscar un producto específico en la base de datos en función de su identificador único.
     * @return Se devuelve un ResultSet que contiene los datos del producto con la identificación
     * especificada.
     */
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
    
    /**
     * La función ListarProductosAgregados recupera de una base de datos productos con cantidad menor o
     * igual a 6.
     * 
     * @return Este método devuelve un ResultSet que contiene los productos que tienen una cantidad
     * menor o igual a 6 de la tabla "productos" de la base de datos.
     */
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
   

    /**
     * La función "Actualizar" actualiza un producto en una base de datos según el ID proporcionado con
     * nueva información como tipo, tamaño, cantidad, sexo y color.
     * 
     * @param id El parámetro `id` en el método `Actualizar` representa el identificador único del
     * producto que desea actualizar en la base de datos. Esta identificación se utiliza para ubicar el
     * registro de producto específico que debe modificarse.
     * @param tipo El parámetro "tipo" en el método representa el tipo de producto. Podría ser una
     * categoría o clasificación a la que pertenece el producto, como por ejemplo “Zapatos”, “Ropa”,
     * “Accesorios”, etc.
     * @param talla El parámetro "talla" en el método representa el tamaño del producto. Podría ser una
     * talla de ropa como pequeña, mediana, grande, etc., dependiendo del tipo de producto que se
     * trate.
     * @param cantidad El parámetro "cantidad" en el método representa la cantidad o importe del
     * producto que se actualiza. Es un valor entero que indica cuántas unidades del producto hay
     * disponibles o en stock.
     * @param genero El parámetro "género" en el método representa el género del producto. Es un
     * parámetro de tipo Cadena que se utiliza para especificar la categoría de género a la que
     * pertenece el producto, como "Hombres", "Mujeres", "Unisex", etc. Esta información se puede
     * utilizar para categorizar y organizar productos según
     * @param color El color es un parámetro que representa el color del producto. Es de tipo String en
     * el método `Actualizar` y se utiliza para actualizar el color de un producto en la base de datos.
     */
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
    /**
     * El método `Eliminar` elimina un producto de una tabla de base de datos según la ID proporcionada
     * y muestra un mensaje de éxito o error usando JOptionPane.
     * 
     * @param id El método "Eliminar" está diseñado para eliminar un producto de una tabla de base de
     * datos según el parámetro "id" proporcionado. El parámetro "id" representa el identificador único
     * del producto que debe eliminarse. Cuando se llama al método con un "id" específico, construye
     * una consulta SQL para eliminar
     */
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
    /**
     * La función `ContarProductos` recupera el recuento de productos de una tabla de base de datos.
     * 
     * @return El método `ContarProductos()` devuelve un valor entero, que representa el recuento de
     * productos en la tabla "productos" de la base de datos.
     */
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
    
    /**
     * La función `StockProductos` recupera el recuento de productos con una cantidad menor a 6 de una
     * tabla de base de datos.
     * 
     * @return El método `StockProductos` está devolviendo el conteo de productos que tienen una
     * cantidad menor a 6 en la tabla de la base de datos `productos`.
     */
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
    
    /**
     * La función genera un informe de productos a partir de una base de datos, incluidos datos en un
     * archivo de Excel y una representación de gráfico de barras de los tipos de productos.
     */
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