package Presentacion;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Modelo.Compras.DetalleOrden;
import Modelo.Compras.LogicaDetallesOrden;
import Modelo.Compras.OrdenCompra;

/* @author MeloDev */
public class PDetalleOrden {
    private VDetalleOrden vista;
    private DetalleOrden detalle;
    private OrdenCompra orden;
    
    private Mensajes msg = new Mensajes();
    private Formateo format = new Formateo();
    private LogicaDetallesOrden logica = new LogicaDetallesOrden();
    
    public PDetalleOrden(VDetalleOrden vista, DetalleOrden detalle) {
        this.vista = vista;
        this.detalle = detalle;
    }
    
    public PDetalleOrden(VDetalleOrden vista, OrdenCompra orden) {
        this.vista = vista;
        this.detalle = new DetalleOrden();
        this.orden = orden;
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
            format.formatoJtableDetalleOrden(
                logica.cargarDetallesOrden(orden)
            )
        );
    }
    
    public void mostrarVOrdenCompra(){
        VOrdenCompra vOrdenCompra = new VOrdenCompra();
                    
        PresentadorOrdenCompra pOrdenCompra = new PresentadorOrdenCompra(vOrdenCompra);
        vOrdenCompra.setPresentador(pOrdenCompra);

        vOrdenCompra.iniciar();
        this.vista.cerrar();
    }

   
}
