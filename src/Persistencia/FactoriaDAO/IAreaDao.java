package Persistencia.FactoriaDAO;

import Modelo.Area;
import Modelo.Empleado;

/*@author MelioDev*/
public interface IAreaDao extends IDaoCrud<Area>{
    public Area buscarxEmpleado(Empleado emp);
}