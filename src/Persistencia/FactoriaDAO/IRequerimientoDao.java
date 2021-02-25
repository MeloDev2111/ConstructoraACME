package Persistencia.FactoriaDAO;

import Modelo.Requerimiento;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IRequerimientoDao extends IDaoCrud<Requerimiento>{
     public ArrayList<Requerimiento> listarRequerimientosxProyecto(String idProyecto);
     public ArrayList<Requerimiento> listarRequerimientosxArea(String idArea);
}