package Persistencia.FactoriaDAO;

import java.util.ArrayList;

/*@author MelioDev*/
public interface IDaoCrud<T> {
    public abstract T registrar(T obj);
    
    public abstract ArrayList<T> listado();

    public abstract T actualizar(T obj);
    
    public abstract T eliminar(T obj);
}
