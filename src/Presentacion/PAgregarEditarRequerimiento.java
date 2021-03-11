package Presentacion;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Modelo.Organizacion.EstadoRequerimiento;
import Modelo.Organizacion.LogicaArea;
import Modelo.Organizacion.LogicaRequerimientos;
import Modelo.Organizacion.Proyecto;
import Modelo.Organizacion.Requerimiento;

/* @author MeloDev */
public class PAgregarEditarRequerimiento {
    private VAgregarEditarRequerimiento vista;
    private Requerimiento r;
    
    private Proyecto proy;
    private LogicaArea logiArea = new LogicaArea();
    private LogicaRequerimientos logiReq = new LogicaRequerimientos();
    private Formateo format = new Formateo();
    private Mensajes msg = new Mensajes();
    
    public PAgregarEditarRequerimiento(VAgregarEditarRequerimiento vista, Requerimiento r) {
        this.vista = vista;
        this.r = r;
    }

    public PAgregarEditarRequerimiento(VAgregarEditarRequerimiento vista, Proyecto p) {
        this.vista = vista;
        r = new Requerimiento();
        proy = p;
    }
    
    public boolean guardarRequerimiento(){
        
        if (proy==null) {
            return false;
        }
        
        r.setProyecto(proy);
        
        r.setEstado(EstadoRequerimiento.CREADO);
        
        r.setEtapa(vista.getEtapaSeleccionada());
                
        r.setArea( logiArea.buscarArea( vista.getAreaSeleccionada() ) );
      
        logiReq.guardar(r);
        
        this.vista.cerrar();
        return true;
    }
    
    public boolean modificarRequerimiento(){
        r.setEtapa(vista.getEtapaSeleccionada());
                
        r.setArea( logiArea.buscarArea( vista.getAreaSeleccionada() ) );
      
        logiReq.actualizar(r);
        
        this.vista.cerrar();
        return true;
    }
    
    public void cargarDatos(){
        if (r!=null) {
            vista.setEtapa(r.getEtapa());
            vista.setArea(r.getArea().getIdArea(), r.getArea().getNombreArea());
        }
    }
    
    public void cargarListadoAreas(){
        vista.mostrarListaAreas(
            format.formatoCboxAreas(
                    logiArea.cargarListaAreas()
            )
        );
    }
    
}
