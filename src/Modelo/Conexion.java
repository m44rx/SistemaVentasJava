package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/bd_ventas";
    String user = "root";
    String pass = "123456";

    public Connection Conectar() {

           System.out.println("Intentando conexión base de datos....");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            System.err.println("Error de conexión " + e);
        }

        return con;
    }
    
}
