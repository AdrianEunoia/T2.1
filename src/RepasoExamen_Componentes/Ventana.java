package RepasoExamen_Componentes;

import Repaso8_PracticaFinal.Constantes;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ventana extends JFrame implements ActionListener, FocusListener {
    // Variables
    // Elementos contenedores
    Container container;
    JPanel panelNorte,panelCentro, panelSur;
    // Elementos
    JLabel labelTitulo;
    JLabel labelSpinner;
    JLabel labelElementos, labelNumeros, labelLetras,labelLista;
    JLabel labelCombo;
    JTextField textElemento, textNumeros, textLetras;
    // Botones
    JButton botonEjecutar;
    // Spinner
    SpinnerListModel modeloListaSpinner;
    JSpinner spinnerLista;
    ArrayList datosSpinner;
    // Combo
    JComboBox comboNormal;
    DefaultComboBoxModel modeloCombo;
    // Lista
    JList listaRellenable;
    DefaultListModel modeloLista;
    ListSelectionModel modeloSeleccionLista;

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
        configurarSpinnerList();
    }
    private void instancias() {
        // Elementos paneles
        panelNorte = new JPanel();
        panelCentro = new JPanel();
        panelSur = new JPanel();
        container = getContentPane();
        // Elementos
        labelTitulo = new JLabel("Ejercicio repaso examen");
        labelSpinner = new JLabel("Spinner contenedor de elementos");
        labelElementos = new JLabel("Introduce un elemento");
        labelCombo = new JLabel("Combo contenedor de elementos");
        textElemento = new JTextField();
        textNumeros = new JTextField();
        textLetras = new JTextField();
        labelNumeros = new JLabel("Introduccion solo numeros");
        labelLetras = new JLabel("Introduccion solo numeros");
        labelLista = new JLabel("Lista de elementos");
        // Botones
        botonEjecutar = new JButton("Ejecutar acciones");
        // Spinner
        modeloListaSpinner = new SpinnerListModel();
        spinnerLista = new JSpinner(modeloListaSpinner);
        datosSpinner = new ArrayList();
        // Combo
        modeloCombo = new DefaultComboBoxModel();
        comboNormal = new JComboBox(modeloCombo);
        // Lista
        modeloLista = new DefaultListModel();
        listaRellenable = new JList(modeloLista);
        modeloSeleccionLista = listaRellenable.getSelectionModel();
    }
    private void acciones() {
        botonEjecutar.addActionListener(this);
        // Textfield y restricciones
        textLetras.addFocusListener(this);
        textNumeros.addFocusListener(this);
        textLetras.addKeyListener(new ManejoTeclasString());
        textNumeros.addKeyListener(new ManejoTeclasInteger());

    }
    // Metodos para configurar centro y CardLayout
    private void configurarContainer() {
        container.setLayout(new BorderLayout()); // Le especificas BorderLayout
        container.add(configurarNorte(), BorderLayout.NORTH); // Le dices que el centro que se basará en cardlayout será center
        container.add(configurarCentro(), BorderLayout.CENTER); // Le dices que el centro que se basará en cardlayout será center
        container.add(configurarSur(), BorderLayout.SOUTH); // Le dices que el centro que se basará en cardlayout será center
    }
    private JPanel configurarNorte() {
        panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelNorte.add(labelTitulo);
        return panelNorte;
    }
    private JPanel configurarSur() {
        panelSur.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSur.add(botonEjecutar);
        return panelSur;
    }
    private JPanel configurarCentro() {
        panelCentro.setLayout(new GridLayout(6,2));
        panelCentro.add(labelElementos);
        panelCentro.add(textElemento);
        panelCentro.add(labelSpinner);
        panelCentro.add(spinnerLista);
        panelCentro.add(labelCombo);
        panelCentro.add(comboNormal);
        panelCentro.add(labelLetras);
        panelCentro.add(textLetras);
        panelCentro.add(labelNumeros);
        panelCentro.add(textNumeros);
        panelCentro.add(labelLista);
        panelCentro.add(new JScrollPane(listaRellenable));
        return panelCentro;
    }
    // Spinner
    public void configurarSpinnerList(){
        datosSpinner.add("Nombre1");
        datosSpinner.add("Nombre2");
        datosSpinner.add("Nombre3");
        datosSpinner.add("Nombre4");
        modeloListaSpinner.setList(datosSpinner);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonEjecutar){
            System.out.println("Ejecutando acciones");
            datosSpinner.add(textElemento.getText().toString());
            modeloCombo.addElement(textElemento.getText().toString());
            modeloLista.addElement(textElemento.getText().toString());
        }
    }
    // Focus textsfield
    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == textLetras) {
            if (textLetras.getText().equals("String"))
                textLetras.setText("");
        } else if (e.getSource() == textNumeros) {
            if (textNumeros.getText().equals("Integer"))
                textNumeros.setText("");
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == textLetras) {
            if (textLetras.getText().length() == 0)
                textLetras.setText("String");
        } else if (e.getSource() == textNumeros) {
            if (textNumeros.getText().length() == 0)
                textNumeros.setText("Integer");
        }
    }
    // Restricciones teclas
    class ManejoTeclasString extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            char tecla = e.getKeyChar();
            if (Character.isDigit(tecla)) {
                e.consume();
            } else if (textLetras.getText().length() == 10) {
                e.consume();
            }
        }
    }
    // Restricciones teclas 2
    class ManejoTeclasInteger extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            char tecla = e.getKeyChar();
            if (!Character.isDigit(tecla)) {
                e.consume();
            } else if (textNumeros.getText().length() == 10) {
                e.consume();
            }
        }
    }
}
