package Persistencia.FactoriaDAO;

import Negocio.Area;

/*@author MelioDev*/
public interface IAreaDao extends IDaoCrud<Area>{
     public abstract Area buscar(String idArea);
     
}