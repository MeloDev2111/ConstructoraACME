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
    
    public void mostarVCrearOrdenCompra(){
        msg.advertenciaMsg("PRONTO!", "IN PROCESS");
    }
    public void mostarEditarOrdenCompra(){
        msg.advertenciaMsg("PRONTO!", "IN PROCESS");
    }
    
    public void aprobar(){
        OrdenCompra ord = logica.buscar(vista.getidSeleccionado());
        if (ord!=null) {
            if (logica.aprobar(orden)) {
                establecerTablaOrdenes();
            }
        }
    }
    
    public void anular(){
        OrdenCompra ord = logica.buscar(vista.getidSeleccionado());
        if (ord!=null) {
            if (logica.anular(orden)) {
                establecerTablaOrdenes();
            }
        }
    }

    void mostrarVDetalles() {
        msg.advertenciaMsg("PRONTO!", "IN PROCESS");
    }

    
}
