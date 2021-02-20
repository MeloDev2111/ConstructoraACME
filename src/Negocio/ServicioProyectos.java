package Negocio;

import Apoyo.Mensajes;
import Persistencia.FactoriaDAO.IProyectoDao;
import java.util.ArrayList;

public class ServicioProyectos implements IDBAccess{
    IProyectoDao dao = fabrica.getProyectoDao();
    Mensajes msg = new Mensajes();
    
    ArrayList<Proyecto> proyectos=null;
    
    public Object[][] listarProyectos (Empleado e){
        proyectos = dao.listarProyectosxEmpleado(e.getIdEmpleado());
         
         return formatoJtable();
    }
    
    public Object[][] formatoJtable(){
        Object[][] P = new Object[proyectos.size()][2];
        
        int i=0;
        for (Proyecto p : proyectos) {
            P[i][0]=p.getIdProyecto();
            P[i][1]=p.getNombreProyecto();
            i++;
        }
       
        return P;
    }

}
