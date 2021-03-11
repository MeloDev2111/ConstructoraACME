package Presentacion;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Modelo.Organizacion.Empleado;
import Modelo.Compras.LogicaPedidos;
import Modelo.Compras.Pedido;
import Modelo.Organizacion.Proyecto;
import Modelo.Organizacion.Requerimiento;

/* @author MeloDev */
public class PresentadorPedidos {
    private Requerimiento requerimiento;
    private VPedido vista;
    
    private Empleado empRespArea;
    private Pedido pedido;
    private LogicaPedidos logica = new LogicaPedidos();
    
    private Formateo format = new Formateo();
    private Mensajes msg = new Mensajes();
    
    public PresentadorPedidos(Pedido mPedido, VPedido vista) {
        this.pedido = mPedido;
        this.vista = vista;
    }

    public PresentadorPedidos(VPedido vista, Requerimiento requerimiento) {
        this.vista = vista;
        this.requerimiento = requerimiento;
    }
    
    public PresentadorPedidos(VPedido vista, Requerimiento requerimiento, Empleado e) {
        this.vista = vista;
        this.requerimiento = requerimiento;
        this.empRespArea = e;
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

    void backVRespArea() {
        VResponsableArea vRespArea = new VResponsableArea();

        PresentadorRespArea pRespArea = new PresentadorRespArea(vRespArea, empRespArea);
        vRespArea.setPresentador(pRespArea);
        vRespArea.setTitulo(empRespArea.getNombre());

        vRespArea.iniciar();
        this.vista.cerrar();
    }

    public void consultarObservaciones() {
        pedido = logica.buscar(vista.getidPedidoSeleccionado());
        
        vista.setTextoObservacion(pedido.getObservaciones());
    }

    public void observar() {
        if (pedido!=null) {
            pedido.setObservaciones(vista.getTextoObservacion());
            logica.actualizarObservacion(pedido);
            establecerTablaPedidos();
            pedido =null;
            vista.setTextoObservacion("");
        }else{
            msg.errorMsg("Pedido no elegido");
        }
    }

    public void modificar() {
        pedido = logica.buscar(vista.getidPedidoSeleccionado());
        VModificarPedido vModPedido = new VModificarPedido();
        PModificarPedido pModPedido = new PModificarPedido(vModPedido, pedido);
        vModPedido.setPresentador(pModPedido);
        pModPedido.cargar();
        
        vModPedido.iniciar();        
    }

    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
