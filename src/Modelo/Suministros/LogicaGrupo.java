package Modelo.Suministros;

import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.IGrupoDao;

/* @author MeloDev */
public class LogicaGrupo implements IDBAccess{
    IGrupoDao dao = fabrica.getGrupoDao();
    
    public Grupo buscarGrupo(Grupo g){
        return dao.buscar(g.getIdGrupo());
    }
}
