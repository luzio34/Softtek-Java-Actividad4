
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Main {
    
    private Connection conectar = null;
    
    private final String usuario = "root";
    
    private final String contrasena = "Lucio12345";
            
    //private final String db = "personal1";
    
    //private final String ip ="localhost";
    
    //private final String puerto = "3306";
    
    private final Statement st = null;
    
    private final ResultSet rs = null;
    
    //private final String cadena = "jdbc:mysql://localhost:3306/personal1";
    
    private static final String cadena = "jdbc:mysql://localhost:3306/listtask2";
    
    public Connection establecerConeccion(){
        try{
            this.conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            JOptionPane.showMessageDialog(null, "Se conecto correctamente");
        }catch (Exception e){
            System.out.println(e);
        }
        return this.conectar;
    }
    
    public static void main(String[] args) {
        Main app = new Main();
        app.establecerConeccion();
    }
    
            
            
    
}