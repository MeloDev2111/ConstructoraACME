package Persistencia.FactoriaDAO.Ficheros;

import Persistencia.FactoriaDAO.FabricaDao;
import Persistencia.FactoriaDAO.IAreaDao;
import Persistencia.FactoriaDAO.IEmpleadoDao;
import Persistencia.FactoriaDAO.IGrupoDao;
import Persistencia.FactoriaDAO.IMaterialDao;
import Persistencia.FactoriaDAO.IProyectoDao;
import Persistencia.FactoriaDAO.IRequerimientoDao;
import Persistencia.FactoriaDAO.IUnidadDao;
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

    @Override
    public IRequerimientoDao getRequerimientoDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IAreaDao getAreaDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IUnidadDao getUnidadDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IGrupoDao getGrupoDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IMaterialDao getMaterialDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
