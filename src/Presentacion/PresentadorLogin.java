package Presentacion;

import Apoyo.Mensajes;
import Negocio.Empleado;
import Negocio.ServicioEmpleados;
import Negocio.ServicioLogin;
import Negocio.Usuario;

public class PresentadorLogin {
    private Usuario user;
    private VLogin vista;
    
    private Mensajes msg = new Mensajes();
    private ServicioLogin servicioLogin = new ServicioLogin();
    private ServicioEmpleados servicioEmpleados = new ServicioEmpleados();
    public PresentadorLogin(VLogin vista) {
        this.user = new Usuario();
        this.vista = vista;
    }
    
    public void iniciarSesion(){
        user.setNombreCuenta(vista.getNombreCuenta());
        user.setContraseña(vista.getContraseña());
        
        user = servicioLogin.iniciarSesion(user);
        
        mostrarVentanaUsuario();
    }
    
    private void mostrarVentanaUsuario(){
        if (user.getIdUsuario()!=null) {
            System.out.println("LOGGING...");
            switch (user.getTipoUsuario()) {
                case ADMINISTRADOR:
                    msg.advertenciaMsg("Mensajito!","PRONTO DISPONIBLE VISTA ADMINISTRADOR, C;");
                    break;
                case EMPLEADO:
                    
                    VEmpleado vEmpleados = new VEmpleado();
                    Empleado emp = servicioEmpleados.buscarEmpleado(user);
                    
                    PresentadorEmpleado pEmpleado = new PresentadorEmpleado(vEmpleados, emp);
                    vEmpleados.setPresentador(pEmpleado);
                    vEmpleados.setTitulo(emp.getNombre());
                    
                    vEmpleados.iniciar();
                    this.vista.cerrar();
                    break;
                case RESPONSABLEAREA:
                    msg.advertenciaMsg("Mensajito!","PRONTO DISPONIBLE VISTA RESPONSABLEAREA, C;");
                    break;
                case RESPONSABLECOMPRA:
                    msg.advertenciaMsg("Mensajito!","PRONTO DISPONIBLE VISTA RESPONSABLECOMPRA, C;");
                    break;  
                default:
                    msg.advertenciaMsg("Mensajito!","SU VISTA AUN NO HA SIDO CREADA");
                    break;
            }
            
        }
        
    }
}
