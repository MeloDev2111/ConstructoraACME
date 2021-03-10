package Persistencia.FactoriaDAO;


import Modelo.Compras.Pedido;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IPedidoDao extends IDaoCrud<Pedido>{
    public abstract ArrayList<Pedido> listarPedidosxRequerimiento(String idRequerimiento); 
    public abstract Pedido actualizarObservacion(Pedido obj);
}