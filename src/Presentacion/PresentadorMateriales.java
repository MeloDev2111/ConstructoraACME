package Presentacion;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Modelo.LogicaPedidos;
import Modelo.Pedido;
import Modelo.Requerimiento;
import Modelo.Suministros.LogicaMaterial;
import Modelo.Suministros.Material;

/* @author MeloDev */
public class PresentadorMateriales {
    
    private Material material;
    private VMateriales vista;
    
    private Pedido pedido;
    private LogicaMaterial logica = new LogicaMaterial();
    private LogicaPedidos logicaPed = new LogicaPedidos();
    private Formateo format = new Formateo();
    private Mensajes msg = new Mensajes();
    
    public PresentadorMateriales(Material material, VMateriales vista) {
        this.material = material;
        this.vista = vista;
    }

    public PresentadorMateriales(VMateriales vista, Pedido pedido) {
        this.vista = vista;
        this.pedido = pedido;
        material = new Material();
    }

    void establecerTablaMateriales() {
        vista.setTablaMateriales(
            format.formatoJtableMateriales(
                logica.cargarMateriales()
            )
        );
    }

    void volverVPedidosEmpleado() {
        VPedido vPedido = new VPedido();
        Requerimiento req = pedido.getRequerimiento();
        
        PresentadorPedidos pPedido = new PresentadorPedidos(vPedido, req);
        vPedido.setPresentador(pPedido);
        pPedido.configurarRolEmpleado();
        vPedido.setTitulo(req.getIdRequerimiento()+"-Etapa "+req.getEtapa());
        vPedido.iniciar();
        this.vista.cerrar();
    }

    void agregarPedido() {
        material.setIdMaterial(vista.getidPedidoSeleccionado());
        pedido.setMaterial(logica.buscarMaterial(material));
        pedido.setCantidadTotal(vista.getCantidad());
        pedido.setCantidadRestante(vista.getCantidad());
        
        logicaPed.guardar(pedido);
        msg.OKMsg("Pedido Realizado!");
    }
    
    
}
