package Presentacion;

import Modelo.Compras.LogicaPedidos;
import Modelo.Compras.Pedido;
import Modelo.Organizacion.Requerimiento;

/* @author MeloDev */
public class PModificarPedido {
    private VModificarPedido vista;
    private Pedido ped;
    
    private LogicaPedidos logica = new LogicaPedidos();
    public PModificarPedido(VModificarPedido vista, Pedido ped) {
        this.vista = vista;
        this.ped = ped;
    }
    
    public void cargar(){
        vista.setMedida( ped.getMaterial().getUnidad().getNombreUnidad());  
        vista.setCantidad( ped.getCantidadTotal() );
    }
    
    public void modificar(){
        ped.setCantidadTotal(vista.getCantidad());
        ped.setCantidadRestante(vista.getCantidad());
        
        logica.actualizar(ped);
        this.vista.cerrar();
    }
    
    public void volverVPedidosEmpleado(){
        VPedido vPedido = new VPedido();
        Requerimiento req = ped.getRequerimiento();
        
        PresentadorPedidos pPedido = new PresentadorPedidos(vPedido, req);
        vPedido.setPresentador(pPedido);
        pPedido.configurarRolEmpleado();
        vPedido.setTitulo(req.getIdRequerimiento()+"-Etapa "+req.getEtapa());
        vPedido.iniciar();
        
        this.vista.cerrar();
    }
}
