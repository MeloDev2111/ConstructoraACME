package Presentacion;

import Apoyo.Formateo;
import Negocio.Empleado;
import Negocio.LogicaRequerimientos;
import Negocio.Proyecto;

/* @author MeloDev */
public class PresentadorRequerimientos {
    private Proyecto mProyecto;
    private VRequerimiento vista;
    
    private LogicaRequerimientos logica = new LogicaRequerimientos();
    
    private Formateo format = new Formateo();
    
    public PresentadorRequerimientos(Proyecto mProyecto, VRequerimiento vista) {
        this.mProyecto = mProyecto;
        this.vista = vista;
    }

    public void establecerTablaRequerimientos() {
        vista.setTablaProyectos(
                format.formatoJtableReqs( logica.cargarRequerimientos(mProyecto) )
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
    
    
}
