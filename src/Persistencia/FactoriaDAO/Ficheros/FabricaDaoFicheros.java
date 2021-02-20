package Persistencia.FactoriaDAO.Ficheros;

import Persistencia.FactoriaDAO.FabricaDao;
import Persistencia.FactoriaDAO.IEmpleadoDao;
import Persistencia.FactoriaDAO.IProyectoDao;
import Persistencia.FactoriaDAO.IUsuarioDao;

public class FabricaDaoFicheros extends FabricaDao{

    @Override
    public IUsuarioDao getUsuarioDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEmpleadoDao getEmpleadoDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IProyectoDao getProyectoDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
