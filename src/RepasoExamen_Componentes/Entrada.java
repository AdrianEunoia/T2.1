package RepasoExamen_Componentes;

import javax.swing.*;

public class Entrada {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana ventanaPrincipal = new Ventana();
                ventanaPrincipal.initGUI();
            }
        });
    }
}