package Modelo;

import Persistencia.FactoriaDAO.ETiposFabricaDao;
import Persistencia.FactoriaDAO.FabricaDao;

/*@author MelioDev*/

public interface IDBAccess {
    FabricaDao fabrica = FabricaDao.getDAOFactory(ETiposFabricaDao.MYSQL);
}
