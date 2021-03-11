package Presentacion;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Modelo.Compras.LogicaOrdenCompra;
import Modelo.Compras.OrdenCompra;

/* @author MeloDev */
public class PresentadorOrdenCompra {
    private OrdenCompra orden;
    private VOrdenCompra vista;
    
    private Mensajes msg = new Mensajes();
    private LogicaOrdenCompra logica = new LogicaOrdenCompra();
    private Formateo format = new Formateo();
    
    public PresentadorOrdenCompra(VOrdenCompra vista) {
        this.orden = new OrdenCompra();
        this.vista = vista;
    }
    public PresentadorOrdenCompra(OrdenCompra orden, VOrdenCompra vista) {
        this.orden = orden;
        this.vista = vista;
    }
    
    public void backToLogin() {
        VLogin vistaLogin = new VLogin();
        
        PresentadorLogin presentador = new PresentadorLogin(vistaLogin);
        vistaLogin.setPresentador(presentador);
        
        vistaLogin.iniciar();
        this.vista.cerrar();
    }
    
    public void establecerTablaOrdenes() {
        vista.setTablaOrdenes(
            format.formatoJtableOrdenesCompra(
                logica.cargarOrdenesCompra()
            )
        );
    }
    
    public void mostrarVDetalles() {
        orden = logica.buscar(vista.getidSeleccionado());
        VDetalleOrden vDetalle = new VDetalleOrden();
        PDetalleOrden pDetalle = new PDetalleOrden(vDetalle, orden);
        vDetalle.setPresentador(pDetalle);
        
        vDetalle.iniciar();
        this.vista.cerrar();
    }
    
    public void mostarVCrearOrdenCompra(){
        VCrearEditarOrden vModOrden = new VCrearEditarOrden();
        PCrearEditarOrden pModOrden = new PCrearEditarOrden(vModOrden);
        vModOrden.setPresentador(pModOrden);
        vModOrden.deshabilitarBotones();
        vModOrden.habilitarBtnsEmpleadoAgregar();
        pModOrden.cargarOpciones();
        
        vModOrden.iniciar();
        
        establecerTablaOrdenes();
    }
    
    public void mostarEditarOrdenCompra(){
        orden = logica.buscar(vista.getidSeleccionado());
        VCrearEditarOrden vModOrden = new VCrearEditarOrden();
        PCrearEditarOrden pModOrden = new PCrearEditarOrden(vModOrden, orden);
        vModOrden.setPresentador(pModOrden);
        vModOrden.deshabilitarBotones();
        vModOrden.habilitarBtnsEmpleadoModificar();
        pModOrden.cargarOpciones();
        
        pModOrden.cargarDatos();
        vModOrden.iniciar();
        
        establecerTablaOrdenes();
    }
    
    public void aprobar(){
        OrdenCompra ord = logica.buscar(vista.getidSeleccionado());
        if (ord!=null) {
            if (logica.aprobar(ord)) {
                establecerTablaOrdenes();
            }
        }
    }
    
    public void anular(){
        OrdenCompra ord = logica.buscar(vista.getidSeleccionado());
        if (ord!=null) {
            if (logica.anular(ord)) {
                establecerTablaOrdenes();
            }
        }
    }
    
}
