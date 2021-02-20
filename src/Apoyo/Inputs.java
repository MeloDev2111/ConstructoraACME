package Apoyo;

import javax.swing.JOptionPane;

/* @author MeloDev */
public class Inputs {
    private Validacion validar = new Validacion();
    private Mensajes msg = new Mensajes();
      
    public double inDoublePositivo(String titulo){
        double entrada = -1;
        boolean valido = false;
        do {
            String input = JOptionPane.showInputDialog(titulo);
            
            if (validar.isDouble(input)) {
                entrada = Double.valueOf(input);
            }else{
                continue;
            }
            
            if (entrada<=0){
                msg.errorMsg("Debe ingresar un valor numerico mayor a 0");
            }else{
                valido = true;
            }
        }while (!valido);
        return entrada;
    }
}
