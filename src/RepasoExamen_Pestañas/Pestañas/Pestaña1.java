package RepasoExamen_Pestañas.Pestañas;

import javax.swing.*;
import java.awt.*;

public class Pestaña1 extends JPanel {
    // Elementos
    JPanel panelTop;
    JLabel labelTexto;
    // Lanzadores
    public Pestaña1() {
        initGUI();
    }
    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void instancias() {
        panelTop = new JPanel();
        labelTexto = new JLabel("Pruebas en la pestaña 1");
    }

    private void acciones() {
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configurarPanelTop(), BorderLayout.NORTH);
    }

    private JPanel configurarPanelTop() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelTop.add(labelTexto);
        return panelTop;
    }
}
