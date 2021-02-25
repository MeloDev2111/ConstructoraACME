package Presentacion;

import Apoyo.Formateo;
import Modelo.Empleado;
import Modelo.LogicaRequerimientos;

/* @author MeloDev */
public class PresentadorRespArea {
    private VResponsableArea vista;
    private Empleado empleado;
    
    private LogicaRequerimientos logica = new LogicaRequerimientos();
    private Formateo format = new Formateo();

    public PresentadorRespArea(VResponsableArea vista, Empleado empleado) {
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

    public void establecerTablaRequerimientos() {
        vista.setTablaRequerimientos(
            format.formatoJtableReqsRespArea(
                logica.cargarRequerimientosResponsableArea(empleado)
            )
        );
    }

}
