package Persistencia.FactoriaDAO;


import Modelo.Pedido;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IPedidoDao extends IDaoCrud<Pedido>{
     public abstract ArrayList<Pedido> listarPedidosxRequerimiento(String idRequerimiento);     
}