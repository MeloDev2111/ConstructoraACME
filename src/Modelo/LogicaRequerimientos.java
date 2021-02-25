package Modelo;

import Persistencia.FactoriaDAO.IRequerimientoDao;
import java.util.ArrayList;

public class LogicaRequerimientos implements IDBAccess{
    IRequerimientoDao dao = fabrica.getRequerimientoDao();
    
    
    public ArrayList<Requerimiento> cargarRequerimientos (Proyecto p){
        return dao.listarRequerimientosxProyecto(p.getIdProyecto());
    }

}
