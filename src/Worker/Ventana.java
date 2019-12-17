package Worker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ventana extends JFrame implements ActionListener {
    JButton bNormal,bSegundo;
    Container container;
    Ventana ventana;
    JProgressBar barraProgreso;
    public Ventana(){
        initGUI();
    }

    public void initGUI() {
        instancias();
        configurarContainer();
        acciones();
        setVisible(true);
        setBounds(0,0,300,300);

    }

    private void acciones() {
        bNormal.addActionListener(this);
        bSegundo.addActionListener(this);
    }

    private void configurarContainer() {
        container.setLayout(new FlowLayout());
        container.add(bNormal);
        container.add(bSegundo);
        container.add(barraProgreso);
    }

    private void instancias() {
        container = getContentPane();
        bNormal = new JButton("Normal");
        bSegundo = new JButton("Segundo");
        ventana = this;
        barraProgreso = new JProgressBar();
        barraProgreso.setStringPainted(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==bSegundo){
            MiWorker miworker= new MiWorker(barraProgreso);
            miworker.execute();
        }else if (e.getSource()==bNormal){
            barraProgreso.setValue(0);
            System.out.println("El segundo plano no me afecta");
        }
    }
    //devuelve una T que es un booleano, si ha terminado o no, el void(Integer) es el tipo de los valores que va devolviendo, se puede cambiar a cualquier tipo de dato
    class MiWorker extends SwingWorker<Boolean,Integer>{
        JProgressBar barra;
        MiWorker(JProgressBar barra){
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
            JOptionPane.showMessageDialog(ventana,"tarea completada","tarea compleatada",JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        protected void process(List<Integer> chunks) {
            super.process(chunks);
            System.out.println(chunks.get(0));
        }
    }
}

