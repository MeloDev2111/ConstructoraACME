package Persistencia.FactoriaDAO;

import Modelo.Requerimiento;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IRequerimientoDao extends IDaoCrud<Requerimiento>{
     public abstract ArrayList<Requerimiento> listarRequerimientosxProyecto(String idProyecto);
}