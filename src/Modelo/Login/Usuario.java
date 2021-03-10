package Modelo.Login;

public class Usuario {
    private String idUsuario;
    private TiposUsuario tipoUsuario;
    private String nombreUsuario;
    private String nombreCuenta;
    private String contraseña;
    private boolean activo;
    
    public Usuario() {
    }
    
    public Usuario(String idUsuario, String nombreCuenta, String contraseña, String tipoCuenta) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreCuenta;
        this.contraseña = contraseña;
        this.tipoUsuario = TiposUsuario.valueOf(tipoCuenta);
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TiposUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TiposUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", tipoUsuario=" + tipoUsuario + ", nombreUsuario=" + nombreUsuario + ", nombreCuenta=" + nombreCuenta + ", contrase\u00f1a=" + contraseña + ", activo=" + activo + '}';
    }

}
