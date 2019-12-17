package Tablas;

import Tablas.Paneles.PanelAltas;
import Tablas.Paneles.PanelBajas;
import Tablas.Paneles.PanelModificaciones;
import Tablas.Paneles.PanelResumen;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    // VAR Elementos
    // Container
    Container container;
    // Paneles
    PanelAltas panelAltas;
    PanelBajas panelBajas;
    PanelModificaciones panelModificaciones;
    PanelResumen panelResumen;
    // Pestañas
    JTabbedPane panelPestanias;

    public void initGUI(){
        this.setSize(new Dimension(500,500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        instancias();
        configurarContainer();
    }
    private void instancias() {
        // Pestañas
        panelPestanias = new JTabbedPane(SwingConstants.TOP);
        // Container
        container = this.getContentPane();
        // Paneles
        panelBajas = new PanelBajas();
        panelModificaciones = new PanelModificaciones();
        panelResumen = new PanelResumen();
        panelAltas = new PanelAltas(panelBajas,panelModificaciones,panelResumen);
    }
    private void configurarContainer() {
        container.add(panelPestanias);
        panelPestanias.addTab("Altas", panelAltas);
        panelPestanias.addTab("Bajas", panelBajas);
        //panelPestanias.addTab("Modificaciones", panelModificaciones);
        //panelPestanias.addTab("Resumen", panelResumen);
    }
}
