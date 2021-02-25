package Presentacion;

import Apoyo.Formateo;
import Modelo.Empleado;
import Modelo.Proyecto;
import Modelo.LogicaProyectos;

/* @author MeloDev */
public class PresentadorEmpleado {
    private VEmpleado vista;
    private Empleado empleado;
    
    private LogicaProyectos logica = new LogicaProyectos();
    private Formateo format = new Formateo();
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
        vista.setListaProyectos( 
                format.formatoJtable( logica.cargarProyectos(empleado) ) 
        );
    }

    public void mostrarVRequerimientos() {
        Proyecto proyecto = logica.buscar(vista.getidProyectoSeleccionado());
        VRequerimiento vReq = new VRequerimiento();
        PresentadorRequerimientos pReq = new PresentadorRequerimientos(proyecto, vReq);
        vReq.setPresentador(pReq);
        vReq.iniciar();
        this.vista.cerrar();
    }
    
}
