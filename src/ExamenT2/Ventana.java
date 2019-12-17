package ExamenT2;

import ExamenT2.Paneles.Card1;
import ExamenT2.Paneles.Card2;
import ExamenT2.Paneles.Card3;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
    // Menu
    JMenuBar barraMenu;
    JMenu menuIr;
    JMenuItem itemRegistro, itemNotas, itemResumen;
    // Menu
    JMenu menuIr2;
    JMenuItem itemValidar;
    // Contenedor
    Container container;
    JPanel panelCentralCards, panelSur;
    // Cards
    Card1 card1;
    Card2 card2;
    Card3 card3;
    CardLayout cardLayout;
    // Elementos
    JLabel labelProgress;
    JProgressBar barraProgreso;

    public void initGUI() {
        this.setTitle("Proyecto CV");
        this.setSize(new Dimension(500, 200));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        instancias();
        acciones();
        configurarContainer();
        configurarBarraMenu();
        configurarBarra();
    }

    private void acciones() {
        itemRegistro.addActionListener(this);
        itemNotas.addActionListener(this);
        itemResumen.addActionListener(this);
        itemValidar.addActionListener(this);
    }

    private void instancias() {
        // Menu
        barraMenu = new JMenuBar();
        menuIr = new JMenu("Cambiar");
        itemRegistro = new JMenuItem("Registro");
        itemNotas = new JMenuItem("Notas");
        itemResumen = new JMenuItem("Resumen");
        // Menu 2
        menuIr2 = new JMenu("Validar");
        itemValidar = new JMenuItem("Valida");
        // Cards
        cardLayout = new CardLayout();
        card1 = new Card1();
        card2 = new Card2();
        card3 = new Card3();
        // Panel
        panelCentralCards = new JPanel();
        panelSur = new JPanel();
        // Contenedor
        container = this.getContentPane();
        // Elementos
        labelProgress = new JLabel("Progress bar");
        barraProgreso = new JProgressBar();
    }
    // Contenedor
    private void configurarContainer() {
        container.setLayout(new BorderLayout());
        container.add(configurarCentro(), BorderLayout.CENTER);
        container.add(configurarSur(), BorderLayout.SOUTH);
    }
    private JPanel configurarCentro() {
        panelCentralCards.setLayout(cardLayout);
        panelCentralCards.add(card1,"Card 1");
        panelCentralCards.add(card2,"Card 2");
        panelCentralCards.add(card3, "Card 3");
        return panelCentralCards;
    }
    private JPanel configurarSur() {
        panelSur.setLayout(new GridLayout(1,1));
        // Añadir progressbar
        panelSur.add(barraProgreso);
        return panelSur;
    }
    // Menu
    private void configurarBarraMenu() {
        barraMenu.add(menuIr2);
        menuIr2.add(itemValidar);
        barraMenu.add(menuIr);
        menuIr.add(itemRegistro);
        menuIr.addSeparator();
        menuIr.add(itemNotas).setEnabled(false);
        menuIr.addSeparator();
        menuIr.add(itemResumen);
        setJMenuBar(barraMenu);
    }
    // Barra
    private void configurarBarra() {
        barraProgreso.setMinimum(0);
        barraProgreso.setMaximum(100);
        barraProgreso.setValue(0);
        barraProgreso.setStringPainted(true);
        barraProgreso.setBorderPainted(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean panelRegistro = card1.isShowing();
        boolean panelNotas = card2.isShowing();
        boolean panelResumen = card3.isShowing();
        if(e.getSource() == itemValidar){
            if(panelRegistro){
                System.out.println("Mostrando card registro");
                itemNotas.setEnabled(true);
                barraProgreso.setValue(50);
            }else if(panelNotas){
                System.out.println("Mostrando card notas");
                barraProgreso.setValue(100);
            }else if(panelResumen){
                System.out.println("Mostrando card resumen");
            }
        }
        else if(e.getSource() == itemRegistro){
            cardLayout.show(panelCentralCards, "Card 1");
        } else if(e.getSource() == itemNotas){
            cardLayout.show(panelCentralCards, "Card 2");
        }else if(e.getSource() == itemResumen){
            cardLayout.show(panelCentralCards, "Card 3");
        }
    }
}
