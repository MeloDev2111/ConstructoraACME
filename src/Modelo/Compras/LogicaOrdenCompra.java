package Modelo.Compras;

import Apoyo.Mensajes;
import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.IOrdenCompraDao;
import java.util.ArrayList;
import java.util.Arrays;

/* @author MeloDev */
public class LogicaOrdenCompra implements IDBAccess {
    private IOrdenCompraDao dao = fabrica.getOrdenCompraDao();
    
    private Mensajes msg = new Mensajes();
    private LogicaDetallesOrden logiDetalle = new LogicaDetallesOrden();
    private LogicaPedidos logiPedido = new LogicaPedidos();  
    
    public ArrayList<OrdenCompra> cargarOrdenesCompra (){
        return dao.listado();
    }
    
    public OrdenCompra buscar(String id) {
        return dao.buscar(id);
    }

    public void guardar(OrdenCompra centro) {
        dao.registrar(centro);
    }

    public void actualizar(OrdenCompra centro) {
        dao.actualizar(centro);
    }
    
    public void eliminar(OrdenCompra centro){
        dao.eliminar(centro);
    }
    
    public boolean aprobar(OrdenCompra ord) {
        if (isAprobable(ord)) {
            ord.setEstado(EstadoOrden.APROBADO);
            dao.actualizar(ord);
            msg.OKMsg("Orden de Compra Aprobado");
            verificarPedidosCerrados(ord);
            return true;
        }else{
            msg.errorMsg("ESTADO NO PERMITIDO PARA SOLICITAR APROBACION : "
                    +ord.getNombreEstado());
            return false;
        }
    } 
    
    
    public boolean anular(OrdenCompra ord){
        if (isAnulable(ord)) {
            ord.setEstado(EstadoOrden.ANULADO);
            this.restablecerPedidos(ord);
            dao.actualizar(ord);
            msg.OKMsg("Orden de Compra Anulado!");
            return true;
        }else{
            msg.errorMsg("ESTADO NO PERMITIDO PARA SOLICITAR APROBACION : "
                    +ord.getNombreEstado());
            return false;
        }
    }
    
    
    private void verificarPedidosCerrados(OrdenCompra ord) {
        for (DetalleOrden detalle : logiDetalle.cargarDetallesOrden(ord)) {
            Pedido p = detalle.getPedido();
            double valorActual = p.getCantidadRestante();
            double valorDetalle = detalle.getCantidadCompra();
            p.setCantidadRestante(valorActual + valorDetalle);
            logiPedido.actualizar(p);
        }
    }
        
    private void restablecerPedidos(OrdenCompra ord) {
        //por trabajar
//        for (DetalleOrden detalle : logiDetalle.cargarDetallesOrden(ord)) {
//            Pedido p = detalle.getPedido();
//            double valorActual = p.getCantidadRestante();
//            double valorDetalle = detalle.getCantidadCompra();
//            p.setCantidadRestante(valorActual + valorDetalle);
//            logiPedido.actualizar(p);
//        }
        
    }
    
    public boolean isAnulable(OrdenCompra ord){
        EstadoOrden[] permitidos = {EstadoOrden.PENDIENTE};
        
        return isPermitido(permitidos, ord.getEstado());
    }
    
    public boolean isAprobable(OrdenCompra ord){
        EstadoOrden[] permitidos = {EstadoOrden.PENDIENTE};
        
        return isPermitido(permitidos, ord.getEstado());
    }

    
    private boolean isPermitido(EstadoOrden[] permitidos, EstadoOrden o){
        return  Arrays.asList(permitidos).contains(o); 
    }


}
