package Modelo.Compras;

/* @author MeloDev */
public class OrdenCompra {
    private String idOrden;
    private CentroCosto centro;
    private String tipoPago;
    private String formaPago;
    private Proveedor proveedor;
    private EstadoOrden estado;
    
    public String getNombreEstado(){
        return estado.name();
    }
    
    public void setEstado(String estado){
        this.estado = EstadoOrden.valueOf(estado);
    }

    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public CentroCosto getCentro() {
        return centro;
    }

    public void setCentro(CentroCosto centro) {
        this.centro = centro;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }
}
