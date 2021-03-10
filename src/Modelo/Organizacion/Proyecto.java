package Modelo.Organizacion;


/* @author MeloDev */
public class Proyecto {
    private String idProyecto;
    private String nombreProyecto;
    private Empleado empleado;
    
    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    } 

    @Override
    public String toString() {
        return "Proyecto{" + "idProyecto=" + idProyecto + ", nombreProyecto=" + nombreProyecto + ", empleado=" + empleado + '}';
    }
    
}
