package Presentacion;

import Apoyo.Mensajes;
import Modelo.Empleado;
import Modelo.LogicaEmpleados;
import Modelo.Login.LogicaLogin;
import Modelo.Login.Usuario;

public class PresentadorLogin {
    private Usuario user;
    private VLogin vista;
    
    private Mensajes msg = new Mensajes();
    private LogicaLogin logiLogin = new LogicaLogin();
    private LogicaEmpleados logiEmpleados = new LogicaEmpleados();
    
    public PresentadorLogin(VLogin vista) {
        this.user = new Usuario();
        this.vista = vista;
    }
    
    public void iniciarSesion(){
        user.setNombreCuenta(vista.getNombreCuenta());
        user.setContraseña(vista.getContraseña());
        
        user = logiLogin.iniciarSesion(user);
        
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
                    Empleado emp = logiEmpleados.buscarEmpleado(user);
                    
                    PresentadorEmpleado pEmpleado = new PresentadorEmpleado(vEmpleados, emp);
                    vEmpleados.setPresentador(pEmpleado);
                    vEmpleados.setTitulo(emp.getNombre());
                    
                    vEmpleados.iniciar();
                    this.vista.cerrar();
                    break;
                case RESPONSABLEAREA:
                    
                    VResponsableArea vRespArea = new VResponsableArea();
                    Empleado empRespArea = logiEmpleados.buscarEmpleado(user);
                    
                    PresentadorRespArea pRespArea = new PresentadorRespArea(vRespArea, empRespArea);
                    vRespArea.setPresentador(pRespArea);
                    vRespArea.setTitulo(empRespArea.getNombre());
                    
                    vRespArea.iniciar();
                    this.vista.cerrar();
                    
                    
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
