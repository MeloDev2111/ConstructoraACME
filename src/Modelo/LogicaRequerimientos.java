package Modelo;

import Apoyo.Mensajes;
import Persistencia.FactoriaDAO.IRequerimientoDao;
import java.util.ArrayList;

public class LogicaRequerimientos implements IDBAccess{
    private IRequerimientoDao dao = fabrica.getRequerimientoDao();
    private Mensajes msg = new Mensajes();
    
    private LogicaArea logiArea = new LogicaArea();
    public ArrayList<Requerimiento> cargarRequerimientosProyecto (Proyecto p){
        return dao.listarRequerimientosxProyecto(p.getIdProyecto());
    }
    
    public ArrayList<Requerimiento> cargarRequerimientosResponsableArea (Empleado emp){
        Area a = logiArea.buscarAreaDeEmpleado(emp);
        if (a!=null) {
            return dao.listarRequerimientosxArea(a.getIdArea());
        }
        msg.advertenciaMsg("OJO", "no tiene requerimiento por revisar");
        return null;
    }
    
    public Requerimiento buscar(String idRequeriSeleccionado){
        return dao.buscar(idRequeriSeleccionado);
    }

    public void enviarParaAprobacion(Requerimiento req) {
        if (isEnviablexEmpleado(req)) {
            req.setEstado(EstadoRequerimiento.PENDIENTE);
            dao.actualizar(req);
            msg.OKMsg("Requerimiento enviado");
        }else{
            msg.errorMsg("ESTADO NO PERMITIDO PARA SOLICITAR APROBACION : "
                    +req.getNombreEstado());
        }
        
    }
    
    public boolean isEnviablexEmpleado(Requerimiento req){
        switch (req.getEstado()) {
            case APROBADO:
                return false;
                
            case CERRADO:
                return false;
                
            case CREADO:
                return true;
                
            case OBSERVADO:
                return true;
                
            case PENDIENTE:
                return false;
                
            default:
                throw new AssertionError();
        }
    }
    

}
