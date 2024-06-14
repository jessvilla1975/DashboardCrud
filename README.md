# DashboardCrud
# Descripción General
InventoryManager es una aplicación de gestión de inventario diseñada para una tienda de ropa, que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre productos, categorías y proveedores.

## Instrucciones de Uso
1. Haz una copia de este repositorio mediante el comando de clonación.
2. Extrae el contenido del archivo comprimido (rar) llamado "Librerias" y añádelo a las dependencias de tu proyecto.
3. Importa las tablas del archivo IventarioBase.sql en MySQL para configurar la base de datos.
4. Inserta los datos proporcionados en las sentencias de BaseDatosInventario.txt y BaseDatosUsuarios.txt correspondientes.
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
## Estructura del proyecto
```
└── 📁src
    └── 📁App
        └── Start.java
    └── 📁Icons
    └── 📁login
        └── Login.form
        └── Login.java
        └── LoginUsuarios.java
    └── 📁ropa
        └── Ropa.java
    └── 📁sql
        └── ConexionSQL.java
        └── Inventario.java
    └── 📁table
        └── FlatLaf.properties
        └── TablaInventario.form
        └── TablaInventario.java
        └── TablaUsuarios.form
        └── TablaUsuarios.java
        └── TableGradientCell.java
    └── 📁usuarios
        └── Administrador.java
        └── Usuario.java
        └── Vendedor.java
    └── 📁video
        └── videito.gif
        └── vidInv.gif
    └── 📁vistas
        └── 📁ingresar
            └── IngresarRopa.form
            └── IngresarRopa.java
            └── IngresarUsers.form
            └── IngresarUsers.java
        └── 📁menus
            └── MenuPrincipal.form
            └── MenuPrincipal.java
```
## Interfaz Login
[![image](https://github.com/jessvilla1975/DashboardCrud/assets/114515509/8b655848-8633-48dd-aa78-be113a7f43a2)](https://github.com/jessvilla1975/DashboardCrud/assets/114515509/35f85f1c-2763-4ffb-8e71-414c445d35af)


## Interfaz Menu Principal
[![image](https://github.com/jessvilla1975/DashboardCrud/assets/114515509/02c8920c-9e69-4149-bf02-dd7f894ca5b1)](https://github.com/jessvilla1975/DashboardCrud/assets/114515509/676450eb-6873-4b57-ab8d-5b389cb51978)


## Interfaz de tablas de productos
![image](https://github.com/jessvilla1975/DashboardCrud/assets/114515509/76cd0049-00de-4411-9a95-f9774859cd10)

## Interfaz de insertar producto
![image](https://github.com/jessvilla1975/DashboardCrud/assets/114515509/ef9320fe-5386-44c0-8962-14b5457b6310)

## Interfaz de registro de usuarios
![image](https://github.com/jessvilla1975/DashboardCrud/assets/114515509/9545c88c-1370-4679-846a-637b05af9e13)

## Interfaz de tablas de usuarios registrados con encriptado
![image](https://github.com/jessvilla1975/DashboardCrud/assets/114515509/a5ce623b-c1f7-457c-8430-fb678da520c7)


