package Modelo;

import Modelo.Login.Usuario;
import Apoyo.Mensajes;
import Persistencia.FactoriaDAO.IEmpleadoDao;

public class LogicaEmpleados implements IDBAccess{
    IEmpleadoDao dao = fabrica.getEmpleadoDao();
    Mensajes msg = new Mensajes();
    
    public Empleado buscarEmpleado(Usuario u){
        return dao.buscarxIdUsuario(u.getIdUsuario());
    }

}
