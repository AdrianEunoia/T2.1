package Repaso8_PracticaFinal;

import Repaso8_PracticaFinal.Paneles.Buscar;
import Repaso8_PracticaFinal.Paneles.Introducir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

// Extiende de JFrame
public class VentanaPrincipal extends JFrame implements ActionListener {
    // Elementos
        // Menu
        JMenuBar barraMenu;
        JMenu menuOpciones;
        JMenuItem itemIntroducir, itemBuscar;
        // Contenedor
        Container container;
        // Cardlayout
        CardLayout cardLayout;
        // Paneles
        JPanel panelCentro;
        Introducir panelIntroducir;
        Buscar panelBuscar;
    // Metodo lanzador
    public void initGUI(){
        this.setTitle("Proyecto CV");
        this.setSize(new Dimension(700,500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        instancias();
        acciones();
        configurarContainer();
        configurarMenu();
    }
    private void instancias() {
        //Menu
        barraMenu = new JMenuBar();
        menuOpciones = new JMenu("Opciones");
        itemIntroducir = new JMenuItem("Introducir CV", KeyEvent.VK_1);
        itemBuscar = new JMenuItem("Buscar CV", KeyEvent.VK_2);
        // Container
        container = getContentPane();
        // CardLayout
        cardLayout = new CardLayout();
        // Paneles
        panelCentro = new JPanel();
        panelIntroducir = new Introducir();
        panelBuscar = new Buscar();
    }
    private void configurarMenu() {
        barraMenu.add(menuOpciones);
        menuOpciones.add(itemIntroducir);
        menuOpciones.addSeparator();
        menuOpciones.add(itemBuscar);
        this.setJMenuBar(barraMenu);
    }
    private void acciones() {
        itemBuscar.addActionListener(this);
        itemIntroducir.addActionListener(this);
    }
    // Metodos para configurar centro y CardLayout
    private void configurarContainer() {
        container.setLayout(new BorderLayout()); // Le especificas BorderLayout
        container.add(configurarCentro(), BorderLayout.CENTER); // Le dices que el centro que se basará en cardlayout será center
    }
    private JPanel configurarCentro() {
        panelCentro.setLayout(cardLayout);
        panelCentro.add(panelIntroducir, Constantes.TAG_P1); // Necesario hacer extender de JPanel a las clases llamadas.
        panelCentro.add(panelBuscar, Constantes.TAG_P2); // Necesario hacer extender de JPanel a las clases llamadas.
        return panelCentro;
    }
    // Actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemIntroducir) {
            System.out.println("Cargando pestaña introducir");
            cardLayout.show(panelCentro, Constantes.TAG_P1);
        } else if (e.getSource() == itemBuscar) {
            System.out.println("Cargando pestaña buscar");
            cardLayout.show(panelCentro, Constantes.TAG_P2);
        }
    }
    // Lista
}
