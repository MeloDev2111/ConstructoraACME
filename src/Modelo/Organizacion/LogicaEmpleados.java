package Modelo.Organizacion;

import Modelo.Login.Usuario;
import Apoyo.Mensajes;
import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.IEmpleadoDao;

public class LogicaEmpleados implements IDBAccess{
    IEmpleadoDao dao = fabrica.getEmpleadoDao();
    Mensajes msg = new Mensajes();
    
    public Empleado buscarEmpleado(Usuario u){
        return dao.buscarxIdUsuario(u.getIdUsuario());
    }

    public void guardar(Empleado obj){
        dao.registrar(obj);
    }
    
    public void actualizar(Empleado obj){
        dao.actualizar(obj);
    }
    
    public void eliminar(Empleado obj){
        dao.eliminar(obj);
    }
}
