package Presentacion;

import Negocio.ServicioLogin;
import Negocio.Usuario;

public class PresentadorLogin {
    private Usuario user;
    private VLogin vista;

    public PresentadorLogin(VLogin vista) {
        this.user = new Usuario();
        this.vista = vista;
    }
    
    public void iniciarSesion(){
        ServicioLogin servicioLogin = new ServicioLogin();
        user.setNombreUsuario(vista.getNombreCuenta());
        user.setContraseña(vista.getContraseña());
        
        user = servicioLogin.iniciarSesion(user);
        
        mostrarVentanaUsuario();
    }
    
    private void mostrarVentanaUsuario(){
        if (user.getIdUsuario()!=null) {
            System.out.println("LOGGING...");
            switch (user.getTipoUsuario()) {
                case "ADMINISTRADOR":
                    vista.mostrarMensajeAdvertencia("PRONTO DISPONIBLE VISTA ADMINISTRADOR, C;");
                    break;
                case "RECEPCIONISTA":
                    //AQUI PROXIMAMENTE IRA LA CLASE RECEPCIONISTA -- SE VIENEN BASTANTES CAMBIOS
//                    VistaRecepcion vistaRecep = new VistaRecepcion();
//
//                    PresentadorRecepcion presentadorRecep = new PresentadorRecepcion(user,vistaRecep);
//                    vistaRecep.setPresentador(presentadorRecep);
//
//                    vistaRecep.iniciar();
//                    vistaRecep.setNombreCuenta(user.getNombreUsuario());

                    vista.cerrar();
                    break;
                case "HUESPED":
                    vista.mostrarMensajeAdvertencia("PRONTO DISPONIBLE VISTA HUESPED, C;");
                    break;
                default:
                    vista.mostrarMensajeError("SU VISTA AUN NO HA SIDO CREADA");
            } 
        }
        
    }
}
