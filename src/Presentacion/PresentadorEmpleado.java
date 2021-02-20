package Presentacion;

import Negocio.Empleado;
import Negocio.ServicioProyectos;

/* @author MeloDev */
public class PresentadorEmpleado {
    private VEmpleado vista;
    private Empleado empleado;
    
    private ServicioProyectos servicio = new ServicioProyectos();
            
    public PresentadorEmpleado(VEmpleado vista, Empleado empleado) {
        this.vista = vista;
        this.empleado = empleado;
    }

    public void backToLogin() {
        VLogin vistaLogin = new VLogin();
        
        PresentadorLogin presentador = new PresentadorLogin(vistaLogin);
        vistaLogin.setPresentador(presentador);
        
        vistaLogin.iniciar();
        this.vista.cerrar();
    }

    public void establecerTablaProyectos() {
        vista.setListaProyectos(servicio.listarProyectos(empleado));
    }
    
    
    
    
}
