package Negocio;

public class Usuario {
    protected String idUsuario;
    protected String tipoUsuario;
    protected String nombreUsuario;
    protected String contraseña;

    public Usuario() {
    }
    
    public Usuario(String idUsuario, String nombreCuenta, String contraseña, String tipoCuenta) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreCuenta;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoCuenta;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipodeCuenta) {
        this.tipoUsuario = tipodeCuenta;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreCuenta=" + nombreUsuario + ", contrase\u00f1a=" + contraseña + ", tipoCuenta=" + tipoUsuario + '}';
    }
    
}
