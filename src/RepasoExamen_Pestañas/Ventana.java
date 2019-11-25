package RepasoExamen_Pestañas;

import RepasoExamen_Pestañas.Pestañas.Pestaña1;
import RepasoExamen_Pestañas.Pestañas.Pestaña2;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{
    // Pestañas
    Pestaña1 pestañaUno;
    Pestaña2 pestañaDos;
    JTabbedPane panelPestanias;
    // Contenedor
    Container container;
    // Metodo lanzador
    public void initGUI() {
        this.setTitle("Proyecto CV");
        this.setSize(new Dimension(700, 500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        instancias();
        configurarContainer();
    }
    private void instancias() {
        // Pestañas
        pestañaDos = new Pestaña2();
        pestañaUno = new Pestaña1();
        panelPestanias = new JTabbedPane(SwingConstants.TOP);
        // Contenedor
        container = this.getContentPane();
    }
    private void configurarContainer() {
        container.add(panelPestanias);
        panelPestanias.addTab("Pestaña 1",pestañaUno);
        panelPestanias.addTab("Pestaña 2",pestañaDos);
    }

}
