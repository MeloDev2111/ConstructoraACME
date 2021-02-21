package Persistencia.FactoriaDAO;

import Negocio.Requerimiento;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IRequerimientoDao extends IDaoCrud<Requerimiento>{
     public abstract ArrayList<Requerimiento> listarRequerimientosxProyecto(String idProyecto);
     public abstract Requerimiento buscar(String idRequerimiento);
}