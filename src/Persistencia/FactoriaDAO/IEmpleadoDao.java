package Persistencia.FactoriaDAO;


import Modelo.Empleado;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IEmpleadoDao extends IDaoCrud<Empleado>{
     public abstract Empleado buscarxIdUsuario(String idUsuario);
}