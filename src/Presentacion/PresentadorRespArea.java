package Presentacion;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Modelo.Organizacion.Empleado;
import Modelo.Organizacion.LogicaRequerimientos;
import Modelo.Organizacion.Requerimiento;

/* @author MeloDev */
public class PresentadorRespArea {
    private VResponsableArea vista;
    private Empleado empleado;
    
    private LogicaRequerimientos logica = new LogicaRequerimientos();
    private Formateo format = new Formateo();   
    private Mensajes msg = new Mensajes();
    
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

    void aprobarRequerimiento() {
        Requerimiento req = logica.buscar(vista.getidRequeSeleccionado());
        if (req!=null) {
            if (logica.aprobar(req)) {
               establecerTablaRequerimientos();
            }
            
        }
    }

    void observarRequerimiento() {
        Requerimiento req = logica.buscar(vista.getidRequeSeleccionado());
        
        if (req!=null) {
            if (logica.observar(req)) {
               establecerTablaRequerimientos();
            }
        }
    }

    void mostrarVPedido() {
        Requerimiento req = logica.buscar(vista.getidRequeSeleccionado());
        if (logica.isObservable(req)) {
            VPedido vPedido = new VPedido();

            PresentadorPedidos pPedido = new PresentadorPedidos(vPedido,req,empleado);
            vPedido.setPresentador(pPedido);
            pPedido.configurarRolResponArea();

            vPedido.setTitulo(req.getIdRequerimiento()+"-Etapa "+req.getEtapa());
            vPedido.iniciar();
            this.vista.cerrar();
        }else{
            msg.errorMsg("ESTADO NO PERMITIDO PARA REALIZAR MODIFICACIONES : "
                    +req.getNombreEstado());
        }

    }

}
