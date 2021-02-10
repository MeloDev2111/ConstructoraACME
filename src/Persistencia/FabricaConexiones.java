package Persistencia;

import Persistencia.FactoriaDAO.*;
import java.sql.Connection;

/* @author MeloDev */
public abstract class FabricaConexiones {
    //DAOs a FABRICAR
    public abstract IUsuarioDao getUsuarioDao();
    //public abstract OrderDAO getOrderDAO();

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
