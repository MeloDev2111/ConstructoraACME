package Modelo.Organizacion;

import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.IProyectoDao;
import java.util.ArrayList;

public class LogicaProyectos implements IDBAccess{
    IProyectoDao dao = fabrica.getProyectoDao();
    
    
    public ArrayList<Proyecto> cargarProyectos (Empleado e){
        return dao.listarProyectosxEmpleado(e.getIdEmpleado());
    }
   

    public Proyecto buscar(String idProyectoSeleccionado) {
        return dao.buscar(idProyectoSeleccionado);
    }
    
    public void guardar(Proyecto obj){
        dao.registrar(obj);
    }
    
    public void actualizar(Proyecto obj){
        dao.actualizar(obj);
    }
    
    public void eliminar(Proyecto obj){
        dao.eliminar(obj);
    }

}
