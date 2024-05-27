package sql;


import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Date;

public class crudsql extends conexionsql {

    java.sql.Statement st;
    ResultSet rs;

    public ResultSet buscar(String tabla) {
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
    public void insertar(int id, String tipo, String talla, int cantidad, String genero, String color) {
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
    
    public ResultSet ProductosAgotados() {
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
   

    public void update(int id, String tipo, String talla, int cantidad, String genero, String color) {
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
    public void eliminar(int id) {
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
    public int contarProductos() {
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
    
    public int stockProductos() {
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

}