package RepasoExamen_Menus;

import RepasoExamen_Menus.Cards.Card1;
import RepasoExamen_Menus.Cards.Card2;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
    // Menu
    JMenuBar barraMenu;
    JMenu menuIr;
    JMenuItem itemAgregar, itemBuscar;
    // Contenedor
    Container container;
    JPanel panelCentralCards;
    // Cards
    Card1 card1;
    Card2 card2;
    CardLayout cardLayout;

    public void initGUI() {
        this.setTitle("Proyecto CV");
        this.setSize(new Dimension(700, 500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        instancias();
        acciones();
        configurarContainer();
        configurarBarraMenu();
    }

    private void acciones() {
        itemAgregar.addActionListener(this);
        itemBuscar.addActionListener(this);
    }

    private void instancias() {
        // Menu
        barraMenu = new JMenuBar();
        menuIr = new JMenu("Ir a");
        itemAgregar = new JMenuItem("Agregar");
        itemBuscar = new JMenuItem("Buscar");
        // Cards
        cardLayout = new CardLayout();
        card1 = new Card1();
        card2 = new Card2();
        // Panel
        panelCentralCards = new JPanel();
        // Contenedor
        container = this.getContentPane();
    }
    // Contenedor
    private void configurarContainer() {
        container.setLayout(new BorderLayout());
        container.add(configurarCentro(), BorderLayout.CENTER);
    }
    private JPanel configurarCentro() {
        panelCentralCards.setLayout(cardLayout);
        panelCentralCards.add(card1,"Card 1");
        panelCentralCards.add(card2, "Card 2");
        return panelCentralCards;
    }
    // Menu
    private void configurarBarraMenu() {
        barraMenu.add(menuIr);
        menuIr.add(itemAgregar);
        menuIr.addSeparator();
        menuIr.add(itemBuscar);
        setJMenuBar(barraMenu);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == itemAgregar){
            cardLayout.show(panelCentralCards, "Card 1");
        } else if(e.getSource() == itemBuscar){
            cardLayout.show(panelCentralCards, "Card 2");
        }
    }
}
