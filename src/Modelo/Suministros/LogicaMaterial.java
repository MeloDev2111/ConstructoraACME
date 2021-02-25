package Modelo.Suministros;

import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.IMaterialDao;
import java.util.ArrayList;

/* @author MeloDev */
public class LogicaMaterial implements IDBAccess{
    IMaterialDao dao = fabrica.getMaterialDao();
    
    public ArrayList<Material> cargarMateriales(){
        return dao.listado();
    }
    
    
    public Material buscarMaterial(Material m){
        return dao.buscar(m.getIdMaterial());
    }
}
