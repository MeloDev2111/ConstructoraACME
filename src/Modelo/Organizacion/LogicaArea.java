package Modelo.Organizacion;

import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.IAreaDao;
import java.util.ArrayList;

/* @author MeloDev */
public class LogicaArea implements IDBAccess{
    IAreaDao dao = fabrica.getAreaDao();
    
    public Area buscarArea(String id){
        return dao.buscar(id);
    }
    public Area buscarAreaDeEmpleado(Empleado e){
        return dao.buscarxEmpleado(e);
    }
    
    public ArrayList<Area> cargarListaAreas(){
        return dao.listado();
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
