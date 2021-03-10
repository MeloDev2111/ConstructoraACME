package Apoyo;

import Modelo.Compras.CentroCosto;
import Modelo.Compras.DetalleOrden;
import Modelo.Compras.OrdenCompra;
import Modelo.Compras.Pedido;
import Modelo.Compras.Proveedor;
import Modelo.Organizacion.Proyecto;
import Modelo.Organizacion.Requerimiento;
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
    
    public Object[][] formatoJtableReqsRespArea(ArrayList<Requerimiento> reqs){
        Object[][] R = new Object[reqs.size()][4];
        
        int i=0;
        for (Requerimiento r : reqs) {
            R[i][0]=r.getIdRequerimiento();
            R[i][1]=r.getProyecto().getNombreProyecto();
            R[i][2]=r.getEtapa();
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
    
    public Object[][] formatoJtablePedidos(ArrayList<Pedido> pedidos){
        Object[][] M = new Object[pedidos.size()][5];
        
        int i=0;
        for (Pedido p : pedidos) {
            M[i][0]=p.getIdPedido();
            M[i][1]=p.getMaterial().getNombreMaterial();
            M[i][2]=p.getCantidadTotal();
            M[i][3]=p.getMaterial().getUnidad().getNombreUnidad();
            M[i][4]=p.getObservaciones();
            i++;
        }
       
        return M;
    }   
    
    public Object[][] formatoJtableCentroCostos(ArrayList<CentroCosto> centros){
        Object[][] M = new Object[centros.size()][4];
        
        int i=0;
        for (CentroCosto m : centros) {
//            M[i][0]=m.get;
//            M[i][1]=m.get;
//            M[i][2]=m.get;
//            M[i][3]=m.get;
            i++;
        }
       
        return M;
    }
    
    public Object[][] formatoJtableProveedores(ArrayList<Proveedor> proveedores){
        Object[][] M = new Object[proveedores.size()][4];
        
        int i=0;
        for (Proveedor m : proveedores) {
//            M[i][0]=m.get;
//            M[i][1]=m.get;
//            M[i][2]=m.get;
//            M[i][3]=m.get;
            i++;
        }
       
        return M;
    }
    
    
    
    
    public Object[][] formatoJtableOrdenesCompra(ArrayList<OrdenCompra> ordenes){
        Object[][] M = new Object[ordenes.size()][4];
        
        int i=0;
        for (OrdenCompra m : ordenes) {
            M[i][0]=m.getIdOrden();
            M[i][1]=m.getCentro().getNombreCentro();
//            M[i][2]=m.getTipoPago();
//            M[i][3]=m.getFormaPago();
            M[i][2]=m.getProveedor().getNombre();
            M[i][3]=m.getNombreEstado();
            
            i++;
        }
       
        return M;
    }
    
    public Object[][] formatoJtableDetalleOrden(ArrayList<DetalleOrden> detalles){
        Object[][] M = new Object[detalles.size()][4];
        
        int i=0;
        for (DetalleOrden m : detalles) {
//            M[i][0]=m.get;
//            M[i][1]=m.get;
//            M[i][2]=m.get;
//            M[i][3]=m.get;
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
