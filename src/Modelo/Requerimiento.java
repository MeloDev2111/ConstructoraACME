package Modelo;

import java.time.LocalDate;

/* @author MeloDev */
public class Requerimiento {
    private String idRequerimiento;
    private String etapa;
    private Proyecto proyecto;
    private Area area;
    private EstadoRequerimiento estado;
    private LocalDate fechaAprobacion;
    
    
    public String getNombreEstado(){
        return estado.name();
    }
    
    public void setEstado(String estado){
        this.estado = EstadoRequerimiento.valueOf(estado);
    }
    
    public String getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(String idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public EstadoRequerimiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoRequerimiento estado) {
        this.estado = estado;
    }

    public LocalDate getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(LocalDate fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }
            
    
    
}
