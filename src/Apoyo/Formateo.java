package Apoyo;

import Modelo.Proyecto;
import Modelo.Requerimiento;
import Modelo.Suministros.Material;
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
    
    public Object[][] formatoJtableMateriales(ArrayList<Material> materiales){
        Object[][] M = new Object[materiales.size()][5];
        
        int i=0;
        for (Material m : materiales) {
            M[i][0]=m.getIdMaterial();
            M[i][1]=m.getNombreMaterial();
            M[i][2]=m.getGrupo().getNombreGrupo();
            M[i][3]=m.getUnidad().getNombreUnidad();
            M[i][4]=m.getTipo();
            i++;
        }
       
        return M;
    }
 /*   
     public Object[][] formatoJtableMateriales(ArrayList<> materiales){
        Object[][] M = new Object[materiales.size()][4];
        
        int i=0;
        for (Material m : materiales) {
            M[i][0]=m.get;
            M[i][1]=m.get;
            M[i][2]=m.get;
            M[i][3]=m.get;
            i++;
        }
       
        return M;
    }   
    */
}
