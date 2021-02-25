package Pruebas;
import Modelo.Suministros.LogicaMaterial;
import Modelo.Suministros.Material;
import Persistencia.*;
import Presentacion.*;
import java.sql.Connection;

/* @author MeloDev */
public class pruebas {
    public static void main(String[] args) {
//        Connection con = ConexionCleverCloud.getInstance();
//        con = ConexionCleverCloud.getInstance();
        
        Material material = new Material();
        VMateriales vistaM = new VMateriales();
        PresentadorMateriales pMat = new PresentadorMateriales(material, vistaM);
        vistaM.setPresentador(pMat);
        vistaM.iniciar();
        
        
    }
}
