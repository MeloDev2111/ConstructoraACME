package Negocio;

import Apoyo.Mensajes;
import Persistencia.FactoriaDAO.IRequerimientoDao;
import java.util.ArrayList;

public class LogicaRequerimientos implements IDBAccess{
    IRequerimientoDao dao = fabrica.getRequerimientoDao();
    Mensajes msg = new Mensajes();
    
    
    public ArrayList<Requerimiento> cargarRequerimientos (Proyecto p){
        return dao.listarRequerimientosxProyecto(p.getIdProyecto());
    }

}
