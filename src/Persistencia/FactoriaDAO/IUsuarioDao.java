package Persistencia.FactoriaDAO;

import Negocio.Usuario;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IUsuarioDao extends IDaoCrud<Usuario>{
    public abstract Usuario buscarxID(String idUsuario);
    public abstract Usuario buscarxNombre(String nombreUsuario);
    public abstract ArrayList<Usuario> filtrar(String palabraClave);
}
