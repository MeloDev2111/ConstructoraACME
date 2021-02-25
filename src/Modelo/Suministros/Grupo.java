package Modelo.Suministros;

/* @author MeloDev */
public class Grupo {
    private String idGrupo;
    private String nombreGrupo;

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    @Override
    public String toString() {
        return "Grupo{" + "idGrupo=" + idGrupo + ", nombreGrupo=" + nombreGrupo + '}';
    }
    
    
}
