/**
 * La clase `Ropa` en Java representa prendas de vestir con atributos como ID, tipo, talla, cantidad,
 * género y color, junto con métodos getter y setter para cada atributo.
 */

package ropa;


public class Ropa {
    private int id;
    private String tipo;
    private String talla;
    private int cantidad;
    private String genero;
    private String color;

    // Constructor
    public Ropa(int id, String tipo, String talla, int cantidad, String genero, String color) {
        this.id = id;
        this.tipo = tipo;
        this.talla = talla;
        this.cantidad = cantidad;
        this.genero = genero;
        this.color = color;
    }

    /**
     * La función getId() en Java devuelve el valor de identificación.
     * 
     * @return El método `getId()` devuelve el valor de la variable `id`.
     */
    public int getId() {
        return id;
    }

    /**
     * La función setId establece la identificación de un objeto en el valor especificado.
     * 
     * @param id El parámetro "id" es un valor entero que se utiliza para establecer el ID de un
     * objeto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * La función `getTipo()` en Java devuelve el valor de la variable `tipo`.
     * 
     * @return El método `getTipo()` devuelve el valor de la variable `tipo`.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * La función establece el valor del atributo "tipo" en una clase Java.
     * 
     * @param tipo El método `setTipo` es un método de establecimiento que se utiliza para establecer
     * el valor del atributo `tipo` en una clase. El parámetro `tipo` es el valor que se asignará al
     * atributo `tipo`.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Esta función Java devuelve el valor de la variable "talla" como un String.
     * 
     * @return El método `getTalla()` devuelve el valor de la variable `talla`.
     */
    public String getTalla() {
        return talla;
    }

    /**
     * Esta función Java establece el valor de la variable de instancia "talla" en la entrada
     * proporcionada.
     * 
     * @param talla El parámetro "talla" representa el tamaño o medida de un artículo, como ropa o
     * zapatos. Normalmente se utiliza para especificar las dimensiones o el ajuste del artículo.
     */
    public void setTalla(String talla) {
        this.talla = talla;
    }

    /**
     * Esta función Java devuelve el valor de la variable "cantidad".
     * 
     * @return El método `getCantidad` está devolviendo el valor de la variable `cantidad`.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * La función establece la cantidad de un determinado artículo.
     * 
     * @param cantidad El parámetro "cantidad" representa la cantidad o monto que se está configurando
     * para un atributo o variable en particular en el código. El método "setCantidad" se utiliza para
     * asignar un valor específico al atributo "cantidad" dentro de la clase.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * La función `getGenero` en Java devuelve el valor de la variable `genero`.
     * 
     * @return El método `getGenero()` devuelve el valor de la variable `genero`, que probablemente sea
     * una cadena que representa el género de algo.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Esta función de Java establece el valor del atributo "género" en un objeto.
     * 
     * @param genero El método `setGenero` es un método de establecimiento que se utiliza para asignar
     * un valor al atributo `genero` de un objeto. El parámetro `genero` es el valor que se asignará al
     * atributo `genero`.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * La función getColor() en Java devuelve el color de un objeto.
     * 
     * @return Se devuelve la variable `color`.
     */
    public String getColor() {
        return color;
    }

    /**
     * Esta función establece el color de un objeto al color especificado.
     * 
     * @param color Un parámetro de cadena que representa el color que se va a establecer.
     */
    public void setColor(String color) {
        this.color = color;
    }

    
}
