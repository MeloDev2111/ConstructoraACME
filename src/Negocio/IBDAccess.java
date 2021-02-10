package Negocio;

import Persistencia.FactoriaDAO.ETiposFabricaDao;
import Persistencia.FactoriaDAO.FabricaDao;

/*@author MelioDev*/

public interface IBDAccess {
    FabricaDao fabrica = FabricaDao.getDAOFactory(ETiposFabricaDao.MYSQL);
}
