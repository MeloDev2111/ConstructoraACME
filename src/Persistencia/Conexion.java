package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection con;
    //JDBC driver y url
    private static final String JDBC_Driver="com.mysql.cj.jdbc.Driver";
    //"org.postgresql.Driver"
    //com.mysql.jdbc.Driver //org.gjt.mm.mysql.Driver
    
    private static final String url="jdbc:mysql://"
            + "bibw7bucdseuvvxngiow-mysql.services.clever-cloud.com" //HOST
            + ":3306" //PORT
            + "/bibw7bucdseuvvxngiow"; //DBNAME
    
    //Credenciales
    private static final String user="utgaevgccfl63stq";
    private static final String pass="OsA0ld0zIEcUQJdwZCLO";

    private static final String descripcion="CLEVER CLOUD";

    
    public static Connection getInstance() {
        if (con == null) {
            try {
                Class.forName(JDBC_Driver);
                con = DriverManager.getConnection(url, user, pass);//"con" tipo Connection de clase conexion
                System.out.println("Conexion establecida con Clever Cloud");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return con;
    }    
    
    
    public void cerrar() throws SQLException{
        if (con!=null) {
            if(!con.isClosed()){
                con.close();
//                System.out.println("CONEXION CERRADA");
            }
        }
    }

    
    public void descripcion() {
        System.out.println(descripcion);
    }
    
}
