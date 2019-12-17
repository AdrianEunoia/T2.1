package ExamenT2.Paneles;

import javax.swing.*;
import java.awt.*;

public class Card3 extends JPanel {
    // Elementos
    // Lista
    // Lista
    JList listaAlumnos;
    DefaultListModel modeloLista;
    ListSelectionModel modeloSeleccionLista;
    // Paneles
    JPanel panelCentral;
    // Lanzadores
    public Card3() {
        initGUI();
    }
    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void instancias() {
        panelCentral = new JPanel();
        // Lista
        modeloLista = new DefaultListModel();
        listaAlumnos = new JList(modeloLista);
        modeloSeleccionLista = listaAlumnos.getSelectionModel();
    }

    private void acciones() {
    }

    private void configurarPanel() {
        this.setLayout(new GridLayout(1,1));
        this.add(new JScrollPane(listaAlumnos));
        modeloLista.addElement("AlumnoEjemplo - 10");

    }
}
