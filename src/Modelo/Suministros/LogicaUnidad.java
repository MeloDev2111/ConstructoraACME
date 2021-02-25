package Modelo.Suministros;

import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.IUnidadDao;

/* @author MeloDev */
public class LogicaUnidad implements IDBAccess{
    IUnidadDao dao = fabrica.getUnidadDao();
    
    public Unidad buscarUnidad(Unidad u){
        return dao.buscar(u.getIdUnidad());
    }
}
