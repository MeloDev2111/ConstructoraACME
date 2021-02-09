package Main;

import Negocio.Usuario;
import Presentacion.PresentadorLogin;
import Presentacion.VLogin;

/* @author MeloDev */
public class App {
    public static void main(String[] args) {
        VLogin vista = new VLogin();
        PresentadorLogin presentador = new PresentadorLogin(vista);
        
    }
}
