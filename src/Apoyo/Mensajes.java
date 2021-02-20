package Apoyo;

import javax.swing.JOptionPane;

/* @author MeloDev */
public class Mensajes {
    
    public void errorMsg(String formato){
        JOptionPane.showMessageDialog(null,
        formato,
        "ERROR",JOptionPane.ERROR_MESSAGE);
    }
    
    public void advertenciaMsg(String titulo, String msg){
        JOptionPane.showMessageDialog(null,
                msg,
                titulo,JOptionPane.WARNING_MESSAGE);
    }
    
}
