package Modelo;

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

}
