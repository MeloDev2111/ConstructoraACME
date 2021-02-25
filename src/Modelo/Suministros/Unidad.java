package Modelo.Suministros;

/* @author MeloDev */
public class Unidad {
    private String idUnidad;
    private String nombreUnidad;
    private String abrevUnidad;

    public String getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(String idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public String getAbrevUnidad() {
        return abrevUnidad;
    }

    public void setAbrevUnidad(String abrevUnidad) {
        this.abrevUnidad = abrevUnidad;
    }

    @Override
    public String toString() {
        return "Unidad{" + "idUnidad=" + idUnidad + ", nombreUnidad=" + nombreUnidad + ", abrevUnidad=" + abrevUnidad + '}';
    }
    

}
