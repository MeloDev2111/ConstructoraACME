package Negocio;

//import Persistencia.DAOUsuarios;
//import Persistencia.DAOUsuariosImpl;
import javax.swing.JOptionPane;

public class ServicioLogin {
//    DAOUsuarios dao = new DAOUsuariosImpl();
    Usuario userBD;
    
    public Usuario iniciarSesion(Usuario usuario){
              
        if (!verificarExistencia(usuario)) {
            mostrarMensajeError("ESTA CUENTA NO EXISTE!");
            return usuario;
        }
        
        //REVISAR SI ESTA ACTIVO(HUESPEDES DESALOJADOS)
        
        if (!verificarContraseña(usuario)) {
            mostrarMensajeError("CONTRASEÑA INCORRECTA!");
            return usuario;
        }
            
        return userBD;
    }
    
    private boolean verificarExistencia(Usuario usuario){
        try {
//            userBD = dao.buscarUsuarioByname(usuario);
        } catch (Exception ex) {
            System.out.println("ERROR al buscar usuario por nombre");
            userBD = new Usuario();
        }
        return (userBD.getIdUsuario()!=null);          
    }
    
    private boolean verificarContraseña(Usuario usuario){
        return userBD.getContraseña().equals(usuario.getContraseña());
    }
    
    private void mostrarMensajeError(String msg){
        JOptionPane.showMessageDialog(null,
                msg,
                "ERROR",JOptionPane.ERROR_MESSAGE);
    }
}
