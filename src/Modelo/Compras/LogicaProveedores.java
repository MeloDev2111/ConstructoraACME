package Modelo.Compras;

import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.IProveedorDao;
import java.util.ArrayList;

/* @author MeloDev */
public class LogicaProveedores implements IDBAccess{
    IProveedorDao dao = fabrica.getProveedorDao();
    
    
    public ArrayList<Proveedor> cargarProveedores (){
        return dao.listado();
    }
   

    public Proveedor buscar(String id) {
        return dao.buscar(id);
    }

    public void guardar(Proveedor pro) {
        dao.registrar(pro);
    }

    public void actualizar(Proveedor pro) {
        dao.actualizar(pro);
    }
    
    public void eliminar(Proveedor pro){
        dao.eliminar(pro);
    }
}
