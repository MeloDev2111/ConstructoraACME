package Modelo;

import Apoyo.Mensajes;
import Persistencia.FactoriaDAO.IRequerimientoDao;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LogicaRequerimientos implements IDBAccess{
    private IRequerimientoDao dao = fabrica.getRequerimientoDao();
    private Mensajes msg = new Mensajes();
    
    private LogicaArea logiArea = new LogicaArea();
    public ArrayList<Requerimiento> cargarRequerimientosProyectoEmpleado (Proyecto p){
        List<Requerimiento> lista = dao.listarRequerimientosxProyecto(p.getIdProyecto());
            
        List<Requerimiento> listaFiltrada = lista
        .stream()
        .filter(x -> x.getEstado() == EstadoRequerimiento.CREADO 
                || x.getEstado() == EstadoRequerimiento.OBSERVADO)
        .collect(Collectors.toList());
        
        if (listaFiltrada==null || listaFiltrada.isEmpty()) {
            msg.advertenciaMsg("OJO", "no tiene requerimiento por revisar");
        }
  
        return (ArrayList<Requerimiento>) listaFiltrada;
    }
    
    public ArrayList<Requerimiento> cargarRequerimientosResponsableArea (Empleado emp){
        Area a = logiArea.buscarAreaDeEmpleado(emp);
        if (a!=null) {
            List<Requerimiento> lista = dao.listarRequerimientosxArea(a.getIdArea());
            
            List<Requerimiento> listaFiltrada = lista
            .stream()
            .filter(x -> x.getEstado() == EstadoRequerimiento.PENDIENTE 
                    || x.getEstado() == EstadoRequerimiento.OBSERVADO )
            .collect(Collectors.toList());

            
            if (listaFiltrada==null || listaFiltrada.isEmpty()) {
                msg.advertenciaMsg("OJO", "no tiene requerimiento por revisar");
            }
            
            return (ArrayList<Requerimiento>) listaFiltrada;
        }
        
        return null;
    }
    
    public Requerimiento buscar(String idRequeriSeleccionado){
        return dao.buscar(idRequeriSeleccionado);
    }

    public boolean enviarParaAprobacion(Requerimiento req) {
        if (isEnviablexEmpleado(req)) {
            req.setEstado(EstadoRequerimiento.PENDIENTE);
            dao.actualizar(req);
            msg.OKMsg("Requerimiento enviado");
            return true;
        }else{
            msg.errorMsg("ESTADO NO PERMITIDO PARA SOLICITAR APROBACION : "
                    +req.getNombreEstado());
            return false;
        }
        
    }
    
    public boolean observar(Requerimiento req) {
        if (isObservable(req)) {
            req.setEstado(EstadoRequerimiento.OBSERVADO);
            dao.actualizar(req);
            msg.OKMsg("Requerimiento Observado");
            return true;
        }else{
            msg.errorMsg("ESTADO NO PERMITIDO PARA SOLICITAR APROBACION : "
                    +req.getNombreEstado());
            return false;
        }
        
    }
     
    public boolean aprobar(Requerimiento req) {
        if (isAprobable(req)) {
            req.setEstado(EstadoRequerimiento.APROBADO);
            dao.actualizar(req);
            msg.OKMsg("Requerimiento Aprobado");
            return true;
        }else{
            msg.errorMsg("ESTADO NO PERMITIDO PARA SOLICITAR APROBACION : "
                    +req.getNombreEstado());
            return false;
        }
        
    } 
    
    
    public boolean isEnviablexEmpleado(Requerimiento req){
        EstadoRequerimiento[] permitidos = {EstadoRequerimiento.OBSERVADO, EstadoRequerimiento.CREADO};
        
        return isPermitido(permitidos, req.getEstado());
    }
    
    public boolean isObservable(Requerimiento req){
        EstadoRequerimiento[] permitidos = {EstadoRequerimiento.PENDIENTE};
        
        return isPermitido(permitidos, req.getEstado());
    }

    private boolean isAprobable(Requerimiento req) {
        EstadoRequerimiento[] permitidos = {EstadoRequerimiento.PENDIENTE};
        
        return isPermitido(permitidos, req.getEstado());
    }
    
    private boolean isPermitido(EstadoRequerimiento[] permitidos, EstadoRequerimiento e){
        return  Arrays.asList(permitidos).contains(e); 
        
        // para todo primitivos incluidos                
//        return Arrays.stream(EstadoRequerimiento.values())
//               .anyMatch("s"::equals);
    }

}
