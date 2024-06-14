import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sql.ConexionSQL;

/**
 * La clase `ConexionSQLTest` contiene métodos de prueba unitaria para verificar el correcto
 * funcionamiento de los métodos de la clase `ConexionSQL`.
 */
public class ConexionSQLTest {
    private ConexionSQL conexion;

    /**
     * Método de configuración que se ejecuta antes de cada método de prueba.
     * Crea una nueva instancia de `ConexionSQL` para realizar las pruebas.
     */
    @Before
    public void setUp() {
        conexion = new ConexionSQL();
    }

    /**
     * Método de limpieza que se ejecuta después de cada método de prueba.
     * Desconecta la conexión después de cada prueba para liberar recursos.
     */
    @After
    public void tearDown() {
        conexion.desconectar();
    }

    /**
     * Prueba el método `conectar` de la clase `ConexionSQL`, que intenta establecer una conexión a la base de datos.
     * Verifica que la conexión no sea nula para asegurar una conexión exitosa.
     */
    @Test
    public void testConexionExitosa() {
        assertNotNull("La conexión no debe ser nula", conexion.conectar());
    }
}
