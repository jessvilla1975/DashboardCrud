/**
 * La clase `Usuario` en Java representa un usuario con atributos como identificación, nombre, correo
 * electrónico y contraseña, junto con métodos getter y setter para cada atributo.
 */
package usuarios;

public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String password;

    // Constructor
    public Usuario(int id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

   /**
    * Esta función Java devuelve el valor del atributo id.
    * 
    * @return El método `getId()` devuelve el valor de la variable `id`.
    */
    public int getId() {
        return id;
    }

    /**
     * La función setId establece la identificación de un objeto en el valor especificado.
     * 
     * @param id Un valor entero que representa el identificador de un objeto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * La función `getNombre()` en Java devuelve el valor de la variable `nombre`.
     * 
     * @return El método `getNombre()` está devolviendo el valor de la variable `nombre`.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * La función establece el valor de la variable "nombre" en una clase Java.
     * 
     * @param nombre El parámetro "nombre" es un parámetro de tipo String que se utiliza para
     * establecer el nombre de un objeto o entidad.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * La función getEmail en Java devuelve la dirección de correo electrónico.
     * 
     * @return El método getEmail() devuelve la dirección de correo electrónico almacenada en la
     * variable "correo electrónico".
     */
    public String getEmail() {
        return email;
    }

    /**
     * La función setEmail en Java establece la variable de instancia de correo electrónico en el
     * parámetro de correo electrónico proporcionado.
     * 
     * @param email El método `setEmail` es un método de configuración que se utiliza para establecer
     * la dirección de correo electrónico de un objeto. El parámetro "correo electrónico" es la
     * dirección de correo electrónico que se asignará al atributo "correo electrónico" del objeto.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * La función getPassword() en Java devuelve la contraseña.
     * 
     * @return Se devuelve la variable `contraseña`.
     */
    public String getPassword() {
        return password;
    }

    /**
     * La función `setPassword` establece la contraseña para un objeto.
     * 
     * @param password Una cadena que representa la contraseña que se establecerá para el objeto.
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
