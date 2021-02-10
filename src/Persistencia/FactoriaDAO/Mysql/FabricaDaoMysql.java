package Persistencia.FactoriaDAO.Mysql;

import java.sql.Connection;
import Persistencia.ConexionTipo;
import Persistencia.FabricaConexiones;
import Persistencia.FactoriaDAO.FabricaDao;
import Persistencia.FactoriaDAO.IUsuarioDao;

public class FabricaDaoMysql extends FabricaDao{
    private Connection con = FabricaConexiones.getConnection(ConexionTipo.CLEVERCLOUD);

    @Override
    public IUsuarioDao getUsuarioDao() {
        return new UsuarioDaoMysql(con);
    }

}
