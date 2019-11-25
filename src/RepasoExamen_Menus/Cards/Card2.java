package RepasoExamen_Menus.Cards;

import javax.swing.*;
import java.awt.*;

public class Card2 extends JPanel {
    // Elementos
    JPanel panelTop;
    JLabel labelTexto;
    // Lanzadores
    public Card2() {
        initGUI();
    }
    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void instancias() {
        panelTop = new JPanel();
        labelTexto = new JLabel("Pruebas en la pestaña 2");
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
