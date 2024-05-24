# DashboardCrud
#Descripción General
InventoryManager es una aplicación de gestión de inventario diseñada para una tienda de ropa, que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre productos, categorías y proveedores.

## Instrucciones de Uso
1. Haz una copia de este repositorio mediante el comando de clonación.
2. Extrae el contenido del archivo comprimido (rar) llamado "Librerias" y añádelo a las dependencias de tu proyecto.
3. Importa las tablas del archivo nventarioBase.sql en MySQL para configurar la base de datos.
4. Inserta los datos proporcionados en las sentencias de inserts.txt correspondientes.
5. Actualiza nombre del server de la data base, la dirección URL, nombre de usuario y contraseña en tu servidor de MySQL según las configuraciones necesarias.

```java
public class conexionsql {
    String bd = "inventariods";
    Connection cx;
    String url="jdbc:mysql://localhost:3306/";
    String usuario="root";
    String clave="1111";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    
    public conexionsql(){
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd,usuario,clave);
            System.out.println("conexion exitosa");
        } catch (ClassNotFoundException |SQLException ex) {
            Logger.getLogger(conexionsql.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error coneectar");
        }
        
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexionsql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
```
## Instrucciones para Acceder al Sistema
Una vez que el programa esté en ejecución, accede al módulo de inicio de sesión.
Utiliza las credenciales predeterminadas:

![Icono de Usuario](https://img.shields.io/badge/-Usuario-%2300f?style=flat-square&logo=user): admin
![Icono de Contraseña](https://img.shields.io/badge/-Contraseña-%2300f?style=flat-square&logo=lock) :admin

## Interfaz Login
![image](https://github.com/jessvilla1975/DashboardCrud/assets/114515509/92e929a4-a12a-4c05-a600-d4b60c43b030)

## Interfaz Menu Principal
![image](https://github.com/jessvilla1975/DashboardCrud/assets/114515509/cdc12da3-727e-407b-858b-81f56d0973dd)
