package Presentacion;

import Apoyo.Formateo;
import Modelo.LogicaPedidos;
import Modelo.Pedido;
import Modelo.Proyecto;
import Modelo.Requerimiento;

/* @author MeloDev */
public class PresentadorPedidos {
    private Requerimiento requerimiento;
    private VPedido vista;
    
    private Pedido pedido;
    private LogicaPedidos logica = new LogicaPedidos();
    
    private Formateo format = new Formateo();

    public PresentadorPedidos(Pedido mPedido, VPedido vista) {
        this.pedido = mPedido;
        this.vista = vista;
    }

    public PresentadorPedidos(VPedido vista, Requerimiento requerimiento) {
        this.vista = vista;
        this.requerimiento = requerimiento;
    }
    
    public void configurarRolEmpleado(){
        vista.configurarBtnsEmpleado();
    }
    
    public void configurarRolResponArea(){
        vista.configurarBtnsResponsableArea();
    }

    public void establecerTablaPedidos() {
        vista.setTablaPedidos(
                format.formatoJtablePedidos(
                        logica.cargarPedidos(requerimiento)
                )
        );
    }

    public void backVRequerimiento() {
        Proyecto proyecto = requerimiento.getProyecto();
        VRequerimiento vReq = new VRequerimiento();
        PresentadorRequerimientos pReq = new PresentadorRequerimientos(proyecto, vReq);
        vReq.setPresentador(pReq);
        vReq.iniciar();
        this.vista.cerrar();
        
    }

    public void mostrarListaMateriales() {
        pedido = new Pedido();
        pedido.setRequerimiento(requerimiento);
        
        VMateriales vistaM = new VMateriales();
        
        PresentadorMateriales pMat = new PresentadorMateriales(vistaM, pedido);
        vistaM.setPresentador(pMat);
        
        String titulo = pedido.getRequerimiento().getIdRequerimiento()+"-"+pedido.getRequerimiento().getEtapa();
        vistaM.setTitulo(titulo);
        vistaM.iniciar();
        
        this.vista.cerrar();
        
    }
    
    
}
