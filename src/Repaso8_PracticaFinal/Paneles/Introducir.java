package Repaso8_PracticaFinal.Paneles;

import Repaso8_PracticaFinal.Utiles.Persona;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Introducir extends JPanel implements ListSelectionListener, ChangeListener, ActionListener {
    // Elementos
    JLabel labelTitulo;
    JLabel labelNombre, labelDireccion, labelTelefono, labelDNI, labelSelecciona, labelAños;
    JTextField textNombre, textDireccion, textTelefono, textDni;
    // Paneles
    JPanel panelSuperior, panelCentro;
    JPanel panelCentroIzquierdo, panelCentroDerecho;
    // Lista
    JList listaCarreras;
    DefaultListModel modeloLista;
    ListSelectionModel modeloSeleccionLista;
    // Radio
    JRadioButton radioSoltero, radioCasado, radioDivorciado;
    ButtonGroup grupoRadios;
    // Spinner
    JSpinner spinnerAños;
    SpinnerNumberModel modeloSpinner;
    // Botones
    JButton buttonInsertar, buttonSalir;
    // Recogida de datos
    String radioSeleccionado = "Soltero";
    // Lista
    ArrayList <Persona> listaPersonas;
    public Introducir() {
        // Llamas metodo initgui como en la clase ventana
        initGUI();
    }
    private void initGUI() {
        instancias();
        acciones();
        configurarPanel();
        rellenarLista();
        configurarJList();
        configurarRadio();
    }
    private void instancias() {
        // Paneles
        panelSuperior = new JPanel();
        panelCentro = new JPanel();
        panelCentroIzquierdo = new JPanel();
        panelCentroDerecho = new JPanel();
        // Elementos
        labelTitulo = new JLabel("POR FAVOR, RELLENA LOS DATOS DE TU CURRICULUM");
        labelNombre = new JLabel("Nombre");
        labelDireccion = new JLabel("Direccion");
        labelTelefono = new JLabel("Telefono");
        labelDNI = new JLabel("DNI");
        labelSelecciona = new JLabel("Selecciona tus estudios");
        labelAños = new JLabel("Años de experiencia");
        textNombre = new JTextField();
        textDireccion = new JTextField();
        textTelefono = new JTextField();
        textDni = new JTextField();
        // Lista
        modeloLista = new DefaultListModel();
        listaCarreras = new JList(modeloLista);
        modeloSeleccionLista = listaCarreras.getSelectionModel();
        // Radio
        radioSoltero = new JRadioButton("Soltero", true);
        radioCasado = new JRadioButton("Casado", false);
        radioDivorciado = new JRadioButton("Divorciado", false);
        grupoRadios = new ButtonGroup();
        // Spinner
        modeloSpinner = new SpinnerNumberModel(0,0,99,1);
        spinnerAños = new JSpinner(modeloSpinner);
        // Botones
        buttonInsertar = new JButton("Insertar Datos");
        buttonSalir = new JButton("Salir");
        // Lista
        listaPersonas = new ArrayList();
    }
    private void acciones() {
        // Lista
        listaCarreras.addListSelectionListener(this);
        modeloSeleccionLista.addListSelectionListener(this);
        // Radios
        radioCasado.addChangeListener(this);
        radioSoltero.addChangeListener(this);
        radioDivorciado.addChangeListener(this);
        // Botones
        buttonSalir.addActionListener(this);
        buttonInsertar.addActionListener(this);
    }
    // Lista
    private void rellenarLista(){
        modeloLista.addElement("Ingenieria informatica");
        modeloLista.addElement("Ingenieria industrial");
        modeloLista.addElement("Ingenieria telecomunicaciones");
        modeloLista.addElement("Arquitectura");
        modeloLista.addElement("Derecho");
        modeloLista.addElement("Historia");
    }
    private void configurarJList(){
        listaCarreras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    // Radio
    private void configurarRadio(){
        grupoRadios.add(radioSoltero);
        grupoRadios.add(radioCasado);
        grupoRadios.add(radioDivorciado);
    }
    // Paneles
    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configPanelSuperior(), BorderLayout.NORTH);
        this.add(configPanelCentro(), BorderLayout.CENTER);
    }
    private JPanel configPanelSuperior() {
        panelSuperior.add(labelTitulo);
        return panelSuperior;
    }
    private JPanel configPanelCentro() {
        panelCentro.setLayout(new GridLayout(1,2,10,10));
        panelCentro.add(configurarPanelCentroIzquierdo(), "Panel izquierdo");
        panelCentro.add(configurarPanelCentroDerecho(), "Panel derecho");
        return  panelCentro;
    }
    private JPanel configurarPanelCentroIzquierdo() {
        panelCentroIzquierdo.setLayout(new GridBagLayout());
        configurarGridBagIzquierdo(0, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, labelNombre);
        configurarGridBagIzquierdo(0, 2, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, textNombre);
        configurarGridBagIzquierdo(0, 3, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, labelDireccion);
        configurarGridBagIzquierdo(0, 4, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, textDireccion);
        configurarGridBagIzquierdo(0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, labelTelefono);
        configurarGridBagIzquierdo(0, 6, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, textTelefono);
        configurarGridBagIzquierdo(0, 7, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, labelDNI);
        configurarGridBagIzquierdo(0, 8, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, textDni);
        return panelCentroIzquierdo;
    }
    private JPanel configurarPanelCentroDerecho() {
        panelCentroDerecho.setLayout(new GridBagLayout());
        configurarGridBagDerecho(0, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, labelSelecciona);
        configurarGridBagDerecho(0, 2, GridBagConstraints.BOTH, GridBagConstraints.CENTER, 2, 2, 3, 1, new JScrollPane(listaCarreras));
        configurarGridBagDerecho(0, 3, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, radioSoltero);
        configurarGridBagDerecho(1, 3, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, radioCasado);
        configurarGridBagDerecho(2, 3, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, radioDivorciado);
        configurarGridBagDerecho(0, 4, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, labelAños);
        configurarGridBagDerecho(1, 4, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, spinnerAños);
        configurarGridBagDerecho(0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, buttonInsertar);
        configurarGridBagDerecho(2, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 1, 1, 1, buttonSalir);
        return panelCentroDerecho;
    }
    private void configurarGridBagIzquierdo(int posX, int posY,int fill, int anchor,double pesX, double pesY, int tamX, int tamY, JComponent component){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.fill = fill ;
        constraints.anchor= anchor;
        constraints.weightx = pesX;
        constraints.weighty = pesY;
        constraints.gridwidth= tamX;
        constraints.gridheight= tamY;
        panelCentroIzquierdo.add(component,constraints);
    }
    private void configurarGridBagDerecho(int posX, int posY,int fill, int anchor,double pesX, double pesY, int tamX, int tamY, JComponent component){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.fill = fill ;
        constraints.anchor= anchor;
        constraints.weightx = pesX;
        constraints.weighty = pesY;
        constraints.gridwidth= tamX;
        constraints.gridheight= tamY;
        panelCentroDerecho.add(component,constraints);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()){
            System.out.println("Valor cambiado");
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == radioSoltero) {
            radioSeleccionado = "Soltero";
            System.out.println(radioSeleccionado);
        }else if((e.getSource() == radioCasado)){
            radioSeleccionado = "Casado";
            System.out.println(radioSeleccionado);
        }else if((e.getSource() == radioDivorciado)){
            radioSeleccionado = "Divorciado";
            System.out.println(radioSeleccionado);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonInsertar){
            System.out.println("Insertando datos");
            String nombreIntro = textNombre.getText();
            String direccionIntro = textDireccion.getText();
            String TelefonoIntro = textTelefono.getText();
            String dniIntro = textDni.getText();
            String estudiosIntro = listaCarreras.getSelectedValue().toString();
            String estadoIntro = radioSeleccionado;
            int edadIntro = (int) spinnerAños.getValue();
            if (nombreIntro.length()<=0 || direccionIntro.length()<=0 || TelefonoIntro.length()<=0 || dniIntro.length()<=0 || estudiosIntro.length()<=0 || estadoIntro.length()<=0
            || edadIntro == 0){
                System.out.println("Campos no completos");
            }else {
                System.out.println("Procedienco a insertar persona");
                // Formar Persona
                listaPersonas.add(new Persona(nombreIntro,direccionIntro,TelefonoIntro,dniIntro,estudiosIntro,estadoIntro,edadIntro));
            }
        }else if(e.getSource()==buttonSalir){
            System.out.println("Vaciando campos");
            vaciarCampos();
        }
    }
    // Metodo limpiar
    public void vaciarCampos(){
        textNombre.setText("");
        textDni.setText("");
        textDireccion.setText("");
        textTelefono.setText("");
        listaCarreras.clearSelection();
        spinnerAños.setValue(0);
        grupoRadios.clearSelection();
    }
    // Llamar
    public void encontrarDatos(String telefonoPasado, String dniPasado) {
        System.out.println(telefonoPasado);
        System.out.println(dniPasado);
        if (!listaPersonas.isEmpty()) {
            for (Persona personaEncontrada : listaPersonas) {
                if (personaEncontrada.getTelefono().equals(telefonoPasado) && personaEncontrada.getDni().equals(dniPasado))
                    System.out.println(personaEncontrada.getNombre());
                    System.out.println(personaEncontrada.getNombre());
                    String nombreEncontrado = personaEncontrada.getNombre();
                    String carreraEncontrada = personaEncontrada.getEstudios();
                    inserccionDatos(nombreEncontrado,carreraEncontrada);
            }
        }
    }
    // Pasar datos a lista
    private Buscar buscar;
    public void inserccionDatos(String nombre, String carrera) {
        Buscar buscar = new Buscar();
        buscar.pintarDatos(nombre,carrera);
    }
}
