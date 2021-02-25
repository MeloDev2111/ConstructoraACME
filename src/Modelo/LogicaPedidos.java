package Modelo;

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

}
