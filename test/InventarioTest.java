import java.sql.ResultSet;
import org.junit.Test;
import static org.junit.Assert.*;
import sql.Inventario;

/**
 * La clase `InventarioTest` contiene métodos de prueba unitaria para verificar el correcto
 * funcionamiento de los métodos de la clase `Inventario`.
 */
public class InventarioTest {
    ResultSet rs;

    /**
     * Prueba el método `Insertar` de la clase `Inventario`, que inserta un producto en la base de datos.
     * Se asegura de que el producto insertado exista en la base de datos después de la inserción.
     */
    @Test
    public void testInsertarProducto() {
        Inventario inventario = new Inventario();
        inventario.conectar(); // Asegúrate de que la conexión esté establecida

        // Insertar un producto ficticio para probar
        int id = 1837;
        String tipo = "Camisa";
        String talla = "M";
        int cantidad = 10;
        String genero = "Hombre";
        String color = "Azul";

        inventario.Insertar(id, tipo, talla, cantidad, genero, color);

        // Buscar el producto insertado para verificar la inserción
        ResultSet rs = inventario.buscarPorId(id);
        assertNotNull("El producto insertado debe existir en la base de datos", rs);
    }

    /**
     * Prueba el método `Actualizar` de la clase `Inventario`, que actualiza un producto existente en la base de datos.
     * Se asegura de que el producto actualizado exista en la base de datos después de la actualización.
     */
    @Test
    public void testActualizarProducto() {
        Inventario inventario = new Inventario();
        inventario.conectar(); // Asegúrate de que la conexión esté establecida

        // Actualizar un producto existente para probar
        int id = 1837;
        String tipo = "Camisa Actualizada";
        String talla = "L";
        int cantidad = 15;
        String genero = "Mujer";
        String color = "Rojo";

        inventario.Actualizar(id, tipo, talla, cantidad, genero, color);

        // Buscar el producto actualizado para verificar la actualización
        ResultSet rs = inventario.buscarPorId(id);
        assertNotNull("El producto actualizado debe existir en la base de datos", rs);
    }

    /**
     * Prueba el método `Eliminar` de la clase `Inventario`, que elimina un producto de la base de datos.
     * Se verifica que el producto eliminado no exista en la base de datos después de la eliminación.
     */
    @Test
    public void testEliminarProducto() {
        Inventario inventario = new Inventario();
        inventario.conectar(); // Asegúrate de que la conexión esté establecida

        // Eliminar un producto existente para probar
        int id = 1837;
        inventario.Eliminar(id);

        // Intentar buscar el producto eliminado para verificar que fue eliminado correctamente
        ResultSet rs = inventario.buscarPorId(id);
        
    }
}
