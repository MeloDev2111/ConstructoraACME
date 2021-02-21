package Apoyo;

import Negocio.Proyecto;
import Negocio.Requerimiento;
import java.util.ArrayList;

/* @author MeloDev */
public class Formateo {
    public Object[][] formatoJtable(ArrayList<Proyecto> proyectos){
        Object[][] P = new Object[proyectos.size()][2];
        
        int i=0;
        for (Proyecto p : proyectos) {
            P[i][0]=p.getIdProyecto();
            P[i][1]=p.getNombreProyecto();
            i++;
        }
       
        return P;
    }
    
    public Object[][] formatoJtableReqs(ArrayList<Requerimiento> reqs){
        Object[][] R = new Object[reqs.size()][4];
        
        int i=0;
        for (Requerimiento r : reqs) {
            R[i][0]=r.getIdRequerimiento();
            R[i][1]=r.getEtapa();
            R[i][2]=r.getArea().getNombreArea();
            R[i][3]=r.getNombreEstado();
            i++;
        }
       
        return R;
    }
    
    
}
