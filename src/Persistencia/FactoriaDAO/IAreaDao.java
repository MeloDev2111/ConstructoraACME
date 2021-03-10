package Persistencia.FactoriaDAO;

import Modelo.Organizacion.Area;
import Modelo.Organizacion.Empleado;

/*@author MelioDev*/
public interface IAreaDao extends IDaoCrud<Area>{
    public Area buscarxEmpleado(Empleado emp);
}