package Persistencia.FactoriaDAO;

import Persistencia.FactoriaDAO.Mysql.FabricaDaoMysql;

/* @author MeloDev */
public abstract class FabricaDao {
    //DAOs a FABRICAR
    public abstract IUsuarioDao getUsuarioDao();
    public abstract IEmpleadoDao getEmpleadoDao();
    public abstract IProyectoDao getProyectoDao();
    public abstract IRequerimientoDao getRequerimientoDao();
    public abstract IAreaDao getAreaDao();
    
    public static FabricaDao getDAOFactory(ETiposFabricaDao tipo) {

      switch (tipo) {
        case MYSQL: 
            return new FabricaDaoMysql();
        case SQLSERVER: 
            //
        case FICHEROS    : 
            //
        default           : 
            return null;
      }
    } 
}
