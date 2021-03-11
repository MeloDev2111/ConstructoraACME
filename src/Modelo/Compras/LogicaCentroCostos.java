package Modelo.Compras;

import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.ICentroCostoDao;
import java.util.ArrayList;

/* @author MeloDev */
public class LogicaCentroCostos implements IDBAccess{
    private ICentroCostoDao dao = fabrica.getCentroCostoDao();
    
    public ArrayList<CentroCosto> cargarCentrosCosto (){
        return dao.listado();
    }
   
    public CentroCosto buscar(String id) {
        return dao.buscar(id);
    }

    public void guardar(CentroCosto centro) {
        dao.registrar(centro);
    }

    public void actualizar(CentroCosto centro) {
        dao.actualizar(centro);
    }
    
    public void eliminar(CentroCosto centro){
        dao.eliminar(centro);
    }
}
