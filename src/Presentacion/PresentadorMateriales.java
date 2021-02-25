package Presentacion;

import Apoyo.Formateo;
import Modelo.Suministros.LogicaMaterial;
import Modelo.Suministros.Material;

/* @author MeloDev */
public class PresentadorMateriales {
    private Material material;
    private VMateriales vista;
    
    private LogicaMaterial logica = new LogicaMaterial();
    private Formateo format = new Formateo();
    
    public PresentadorMateriales(Material material, VMateriales vista) {
        this.material = material;
        this.vista = vista;
    }

    void establecerTablaMateriales() {
        vista.setTablaMateriales(
            format.formatoJtableMateriales(
                logica.cargarMateriales()
            )
        );
    }

    void volverVPedidosEmpleado() {
        //ABRIR VPEDIDOS
    }

    void agregarPedido() {
        //Aqui llama a logicaPedido y guarda
    }
    
    
}
