package Modelo.Suministros;

/* @author MeloDev */
public class Material {
    private String idMaterial;
    private String nombreMaterial;
    private Grupo grupo;
    private Unidad unidad;
    private String tipo;

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Material{" + "idMaterial=" + idMaterial + ", nombreMaterial=" + nombreMaterial + ", grupo=" + grupo + ", unidad=" + unidad + ", tipo=" + tipo + '}';
    }
    
    
}
