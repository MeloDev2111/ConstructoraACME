package Modelo.Compras;

/* @author MeloDev */
public class OrdenCompra {
    private String idOrden;
    private CentroCosto centro;
    private String tipoPago;
    private String formaPago;
    private Proveedor proveedor;

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
    
    
}
