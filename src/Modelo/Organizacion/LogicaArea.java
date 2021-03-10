package Modelo.Organizacion;

import Modelo.IDBAccess;
import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.IAreaDao;

/* @author MeloDev */
public class LogicaArea implements IDBAccess{
    IAreaDao dao = fabrica.getAreaDao();
    
    public Area buscarArea(Area a){
        return dao.buscar(a.getIdArea());
    }
    public Area buscarAreaDeEmpleado(Empleado e){
        return dao.buscarxEmpleado(e);
    }
    
    public void guardar(Area obj){
        dao.registrar(obj);
    }
    
    public void actualizar(Area obj){
        dao.actualizar(obj);
    }
    
    public void eliminar(Area obj){
        dao.eliminar(obj);
    }
}
