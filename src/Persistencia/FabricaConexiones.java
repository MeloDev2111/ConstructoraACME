package Persistencia;

import java.sql.Connection;

/* @author MeloDev */
public abstract class FabricaConexiones {

    public static Connection getConnection(ConexionTipo tipo) {
      switch (tipo) {
        case CLEVERCLOUD: 
            return ConexionCleverCloud.getInstance();
        case LOCALHOST: 
            return ConexionLocalHost.getInstance();
        default           : 
            return null;
      }
    } 
}
