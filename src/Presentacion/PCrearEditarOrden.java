package Presentacion;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Modelo.Compras.EstadoOrden;
import Modelo.Compras.LogicaCentroCostos;
import Modelo.Compras.LogicaOrdenCompra;
import Modelo.Compras.LogicaProveedores;
import Modelo.Compras.OrdenCompra;

/* @author MeloDev */
public class PCrearEditarOrden {
    private VCrearEditarOrden vista;
    private OrdenCompra ord;
    
//    private Proyecto proy;
    private LogicaProveedores logiPro = new LogicaProveedores();
    private LogicaCentroCostos logiCen = new LogicaCentroCostos();
    private LogicaOrdenCompra logiOrd = new LogicaOrdenCompra();
    private Formateo format = new Formateo();
    private Mensajes msg = new Mensajes();
    
    public PCrearEditarOrden(VCrearEditarOrden vista) {
        this.vista = vista;
        this.ord = new OrdenCompra();
    }
    
    public PCrearEditarOrden(VCrearEditarOrden vista, OrdenCompra ord) {
        this.vista = vista;
        this.ord = ord;
    }
    
    public boolean guardarOrden(){
        ord.setTipoPago(vista.getTipoPagoSeleccionada());
        
        ord.setFormaPago(vista.getFormaPagoSeleccionada());
        
        ord.setCentro( logiCen.buscar( vista.getCentroSeleccionada() ) );
        
        ord.setProveedor( logiPro.buscar( vista.getProveedorSeleccionada() ) );
        
                
        ord.setEstado(EstadoOrden.PENDIENTE);
        
        logiOrd.guardar(ord);
        
        this.vista.cerrar();
        return true;
    }
    
    public boolean modificarOrden(){
        ord.setTipoPago(vista.getTipoPagoSeleccionada());
        
        ord.setFormaPago(vista.getFormaPagoSeleccionada());
        
        ord.setCentro( logiCen.buscar( vista.getCentroSeleccionada() ) );
        
        ord.setProveedor( logiPro.buscar( vista.getProveedorSeleccionada() ) );
      
        logiOrd.actualizar(ord);
        
        this.vista.cerrar();
        return true;
    }
    
    public void cargarDatos(){
        if (ord!=null) {
            vista.setTipoPago(ord.getNombreTipoPago());
            vista.setFormaPago( ord.getNombreFormaPago() );
            vista.setCentro(ord.getCentro().getIdCentro(), ord.getCentro().getNombreCentro());
            vista.setProveedor(ord.getProveedor().getIdProveedor(), ord.getProveedor().getNombre());
        }
    }
    
    public void cargarOpciones(){
        cargarListadoTiposPago();
        cargarListadoFormaPago();
        cargarListadoCentros();
        cargarListadoProveedores();
    }
    
    
    public void cargarListadoTiposPago(){
        vista.mostrarListaTiposPago(format.formatoCboxTiposPago());
    }
    
    public void cargarListadoFormaPago(){
        vista.mostrarListaFormasPago(format.formatoCboxFormaPago());
    }
    
    public void cargarListadoCentros(){
        
        vista.mostrarListaCentros(
            format.formatoCboxCentros(
                    logiCen.cargarCentrosCosto()
            )
        );
    }
    
    public void cargarListadoProveedores(){
        vista.mostrarListaProveedores(
            format.formatoCboxProveedores(
                    logiPro.cargarProveedores()
            )
        );
    }
    
    
}
