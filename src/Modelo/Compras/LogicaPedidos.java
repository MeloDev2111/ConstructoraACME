package Modelo.Compras;

import Modelo.IDBAccess;
import Modelo.Organizacion.Requerimiento;
import Persistencia.FactoriaDAO.IPedidoDao;
import java.util.ArrayList;

public class LogicaPedidos implements IDBAccess{
    IPedidoDao dao = fabrica.getPedidoDao();
    
    
    public ArrayList<Pedido> cargarPedidos (Requerimiento r){
        return dao.listarPedidosxRequerimiento(r.getIdRequerimiento());
    }
   

    public Pedido buscar(String idPedidoSeleccionado) {
        return dao.buscar(idPedidoSeleccionado);
    }

    public void guardar(Pedido pedido) {
        dao.registrar(pedido);
    }

    public void actualizarObservacion(Pedido pedido) {
        dao.actualizarObservacion(pedido);
    }
    
    public void actualizar(Pedido pedido) {
        dao.actualizar(pedido);
    }
    
    public void eliminar(Pedido pedido){
        dao.eliminar(pedido);
    }
    
    

}
