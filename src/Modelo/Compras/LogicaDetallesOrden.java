package Modelo.Compras;

import Apoyo.Mensajes;
import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.IDetalleOrdenDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* @author MeloDev */
public class LogicaDetallesOrden implements IDBAccess{
    private IDetalleOrdenDao dao = fabrica.getDetalleOrdenDao();
    
    private Mensajes msg = new Mensajes();
    
    public ArrayList<DetalleOrden> cargarDetallesOrden (OrdenCompra orden){
        List<DetalleOrden> lista = dao.listado();
            
        List<DetalleOrden> listaFiltrada = lista
        .stream()
        .filter(x -> x.getOrden().getIdOrden().equals(orden.getIdOrden()) )
        .collect(Collectors.toList());
        
        if (listaFiltrada==null || listaFiltrada.isEmpty()) {
            msg.advertenciaMsg("OJO", "no tiene requerimiento por revisar");
        }
  
        return (ArrayList<DetalleOrden>) listaFiltrada;
    }
    
    public ArrayList<DetalleOrden> cargarAllDetalles (){
        return dao.listado();
    }
   
    public DetalleOrden buscar(String id) {
        return dao.buscar(id);
    }

    public void guardar(DetalleOrden detalle) {
        dao.registrar(detalle);
    }

    public void actualizar(DetalleOrden detalle) {
        dao.actualizar(detalle);
    }
    
    public void eliminar(DetalleOrden detalle){
        dao.eliminar(detalle);
    }    
}
