package Persistencia.FactoriaDAO;


import Modelo.Proyecto;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IProyectoDao extends IDaoCrud<Proyecto>{
     public abstract ArrayList<Proyecto> listarProyectosxEmpleado(String idEmpleado);
}