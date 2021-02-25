package Presentacion;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Modelo.Empleado;
import Modelo.LogicaRequerimientos;
import Modelo.Proyecto;
import Modelo.Requerimiento;

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
                format.formatoJtableReqs( logica.cargarRequerimientosProyecto(mProyecto) )
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
        logica.enviarParaAprobacion( logica.buscar( vista.getidRequeSeleccionado() ) );
        establecerTablaRequerimientos();
    }
    
}
