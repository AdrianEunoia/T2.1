package Worker_Practica;

//import Worker_Practica.Workers.MiWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ObjetoPanel extends JPanel implements ActionListener {
    // Var paneles
    JPanel panelSuperior;
    // Var elementos
    JTextArea textArea;
    JProgressBar barraProgreso;
    JLabel labelCalcular;
    JTextField fieldCalcular;
    JButton buttonCalcular;
    ObjetoPanel objetoPanel;

    public ObjetoPanel() {
        // Llamas metodo initgui como en la clase ventana
        initGUI();
    }
    private void initGUI() {
        instancias();
        acciones();
        configurarPanel();
    }

    private void instancias() {
        barraProgreso = new JProgressBar();
        panelSuperior = new JPanel();
        textArea = new JTextArea();
        fieldCalcular = new JTextField();
        labelCalcular = new JLabel("¿Cuantos primos quieres calcular?");
        buttonCalcular = new JButton("Calcular");
        textArea.setEnabled(false);
    }
    private void acciones() {
        buttonCalcular.addActionListener(this);
    }

    private void configurarPanel() {
        this.setBorder(BorderFactory.createTitledBorder("Primos"));
        this.setLayout(new BorderLayout());
        this.add(configPanelSuperior(), BorderLayout.NORTH);
        this.add(new JScrollPane(textArea), BorderLayout.CENTER);
        this.add(barraProgreso, BorderLayout.SOUTH);
    }

    private JPanel configPanelSuperior() {
        panelSuperior.setLayout(new GridBagLayout());
        configurarGridBag(0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, labelCalcular);
        configurarGridBag(1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, fieldCalcular);
        configurarGridBag(0, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 2, 1, buttonCalcular);
        return panelSuperior;
    }

    private void configurarGridBag(int posX, int posY,int fill, int anchor,double pesX, double pesY, int tamX, int tamY, JComponent component){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.fill = fill ;
        constraints.anchor= anchor;
        constraints.weightx = pesX;
        constraints.weighty = pesY;
        constraints.gridwidth= tamX;
        constraints.gridheight= tamY;
        panelSuperior.add(component,constraints);
    }

    public JProgressBar getBarraProgreso() {
        return barraProgreso;
    }

    public JTextField getFieldCalcular() {
        return fieldCalcular;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonCalcular) {
            String primoIntroducido = fieldCalcular.getText();
            System.out.println("Calculando números primos desde "+primoIntroducido);
            /*WorkerPropio workerPropio= new WorkerPropio(barraProgreso);
            workerPropio.execute();*/
            //MiWorker miWorker = new MiWorker(objetoPanel);

        }
    }

    class WorkerPropio extends SwingWorker<Boolean,Integer>{
        JProgressBar barra;
        WorkerPropio(JProgressBar barra){
            this.barra = barra;
        }
        @Override
        protected Boolean doInBackground() throws Exception {
            for (int i = 0;i<101;i++){
                barraProgreso.setValue(i);
                Thread.sleep(100);
                publish(i);
            }
            return true;
        }
        //Siempre se ejecuta al terminar el doinbackground
        @Override
        protected void done() {
            super.done();
            JOptionPane.showMessageDialog(objetoPanel,"tarea completada","tarea compleatada",JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        protected void process(List<Integer> chunks) {
            super.process(chunks);
            textArea.append(String.valueOf(chunks.get(0))+"\n");
        }
    }
}
