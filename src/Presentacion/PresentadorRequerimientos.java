package Presentacion;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Modelo.Organizacion.Empleado;
import Modelo.Organizacion.LogicaRequerimientos;
import Modelo.Organizacion.Proyecto;
import Modelo.Organizacion.Requerimiento;

/* @author MeloDev */
public class PresentadorRequerimientos {
    private Proyecto mProyecto;
    private VRequerimiento vista;
    
    private LogicaRequerimientos logica = new LogicaRequerimientos();
    
    private Formateo format = new Formateo();
    private Mensajes msg = new Mensajes();
    
    public PresentadorRequerimientos(Proyecto mProyecto, VRequerimiento vista) {
        this.mProyecto = mProyecto;
        this.vista = vista;
    }

    public void establecerTablaRequerimientos() {
        vista.setTablaRequerimientos(
                format.formatoJtableReqs( logica.cargarRequerimientosProyectoEmpleado(mProyecto) )
        );
    }

    void backVEmpleado() {
        
        VEmpleado vEmpleados = new VEmpleado();
        Empleado emp = mProyecto.getEmpleado();

        PresentadorEmpleado pEmpleado = new PresentadorEmpleado(vEmpleados, emp);
        vEmpleados.setPresentador(pEmpleado);
        vEmpleados.setTitulo(emp.getNombre());

        vEmpleados.iniciar();
        this.vista.cerrar();
        
    }

    void mostrarVPedidos() {
        Requerimiento req = logica.buscar(vista.getidRequeSeleccionado());
        if (logica.isEnviablexEmpleado(req)) {
            VPedido vPedido = new VPedido();

            PresentadorPedidos pPedido = new PresentadorPedidos(vPedido, req);
            vPedido.setPresentador(pPedido);
            pPedido.configurarRolEmpleado();

            vPedido.setTitulo(req.getIdRequerimiento()+"-Etapa "+req.getEtapa());
            vPedido.iniciar();
            this.vista.cerrar();
        }else{
            msg.errorMsg("ESTADO NO PERMITIDO PARA REALIZAR MODIFICACIONES : "
                    +req.getNombreEstado());
        }

    }

    public void solicitarAprobacion() {
        Requerimiento req = logica.buscar(vista.getidRequeSeleccionado());
        if (req!=null) {
            if (logica.enviarParaAprobacion(req)) {
               establecerTablaRequerimientos();
            }
        }
        
    }

    public void mostrarVAgregarRequerimiento() {
        VAgregarEditarRequerimiento vAddReq = new VAgregarEditarRequerimiento();
        PAgregarEditarRequerimiento pAddReq = new PAgregarEditarRequerimiento(vAddReq, mProyecto);
        vAddReq.setPresentador(pAddReq);
        vAddReq.deshabilitarBotones();
        vAddReq.habilitarBtnsEmpleadoAgregar();
        pAddReq.cargarListadoAreas();
        
        vAddReq.iniciar();
        //terminando el registro
        establecerTablaRequerimientos();
    }
    
    public void mostrarVModificarRequerimiento() {
        Requerimiento req = logica.buscar(vista.getidRequeSeleccionado());
        VAgregarEditarRequerimiento vAddHab = new VAgregarEditarRequerimiento();
        PAgregarEditarRequerimiento pAddHab = 
                new PAgregarEditarRequerimiento(vAddHab,req);
        vAddHab.setPresentador(pAddHab);
        vAddHab.deshabilitarBotones();
        vAddHab.habilitarBtnsEmpleadoModificar();
        pAddHab.cargarListadoAreas();
        
        pAddHab.cargarDatos();
        vAddHab.iniciar();
        //terminando el registro
        establecerTablaRequerimientos();
    }
    
}
