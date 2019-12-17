package ExamenT2.Paneles;

import javax.swing.*;
import java.awt.*;

public class Card2 extends JPanel {
    // Elementos
    JLabel labelDI, labelPMDM, labelPSP, labelAD;
    // Spinner
    JSpinner spinner1,spinner2,spinner3,spinner4;
    SpinnerNumberModel modeloSpinner1,modeloSpinner2,modeloSpinner3,modeloSpinner4;
    // Paneles
    JPanel panelCentral;
    // Lista
        // Lista pasada
    //listaPersonasRecogida = objetoEntero.getListaPersonas();
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
        panelCentral = new JPanel();
        // Labels
        labelAD = new JLabel("AD");
        labelDI = new JLabel("DI");
        labelPMDM = new JLabel("PMDM");
        labelPSP = new JLabel("PSP");
        // Spinner
        modeloSpinner1 = new SpinnerNumberModel(0,0,99,1);
        spinner1 = new JSpinner(modeloSpinner1);
        modeloSpinner2 = new SpinnerNumberModel(0,0,99,1);
        spinner2 = new JSpinner(modeloSpinner2);
        modeloSpinner3 = new SpinnerNumberModel(0,0,99,1);
        spinner3 = new JSpinner(modeloSpinner3);
        modeloSpinner4 = new SpinnerNumberModel(0,0,99,1);
        spinner4 = new JSpinner(modeloSpinner4);
    }

    private void acciones() {
    }

    private void configurarPanel() {
        this.setLayout(new GridLayout(4,2));
        this.add(labelDI);
        this.add(spinner1);
        this.add(labelAD);
        this.add(spinner2);
        this.add(labelPMDM);
        this.add(spinner3);
        this.add(labelPSP);
        this.add(spinner4);
    }

}
