package Modelo.Compras;

/* @author MeloDev */
public class OrdenCompra {
    private String idOrden;
    private CentroCosto centro;
    private ETipoPago tipoPago;
    private EFormaPago formaPago;
    private Proveedor proveedor;
    private EstadoOrden estado;
    
    
    public String getNombreEstado(){
        return estado.name();
    }
    
    public void setEstado(String estado){
        this.estado = EstadoOrden.valueOf(estado);
    }
    
    public String getNombreTipoPago() {
        return tipoPago.name();
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = ETipoPago.valueOf(tipoPago);
    }
    
    public String getNombreFormaPago() {
        return formaPago.name();
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = EFormaPago.valueOf(formaPago);
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

    public ETipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(ETipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public EFormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(EFormaPago formaPago) {
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
