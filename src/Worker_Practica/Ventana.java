package Worker_Practica;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    // Var
    Container container;
    ObjetoPanel primerPanel;
    ObjetoPanel segundoPanel;

    // Metodo lanzador
    public void initGUI(){
        this.setTitle("Primos");
        this.setSize(new Dimension(700,600));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        instancias();
        configurarContainer();
    }

    private void instancias() {
        container = getContentPane();
        primerPanel = new ObjetoPanel();
        segundoPanel = new ObjetoPanel();
    }

    private void configurarContainer() {
        container.setLayout(new GridLayout(1,2));
        container.add(primerPanel,Constantes.TAG_P1);
        container.add(segundoPanel,Constantes.TAG_P2);
    }
}
