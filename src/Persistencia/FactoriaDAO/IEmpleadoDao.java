package Persistencia.FactoriaDAO;


import Negocio.Empleado;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IEmpleadoDao extends IDaoCrud<Empleado>{
     public abstract Empleado buscarxIdUsuario(String idUsuario);
     public abstract Empleado buscar(String idEmpleado);
}