package Modelo.Organizacion;

/* @author MeloDev */
public class Area {
    private String idArea;
    private String prefijo;
    private String nombreArea;
    private Empleado empleadoResp;
    
    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public Empleado getEmpleadoResp() {
        return empleadoResp;
    }

    public void setEmpleadoResp(Empleado empleadoResp) {
        this.empleadoResp = empleadoResp;
    }

    
    
}
