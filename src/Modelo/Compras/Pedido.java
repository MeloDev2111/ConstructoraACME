package Modelo.Compras;

import Modelo.Requerimiento;
import Modelo.Suministros.Material;

/* @author MeloDev */
public class Pedido {
    private String idPedido;
    private Material material;
    private double cantidadTotal;
    private double cantidadRestante;
    private String Observaciones;
    private Requerimiento requerimiento;

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(double cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public double getCantidadRestante() {
        return cantidadRestante;
    }

    public void setCantidadRestante(double cantidadRestante) {
        this.cantidadRestante = cantidadRestante;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", material=" + material + ", cantidadTotal=" + cantidadTotal + ", cantidadRestante=" + cantidadRestante + ", Observaciones=" + Observaciones + ", requerimiento=" + requerimiento + '}';
    }
    
    
}
