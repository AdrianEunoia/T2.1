package Repaso8_PracticaFinal.Paneles;

import Repaso8_PracticaFinal.Utiles.Persona;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Buscar extends JPanel implements ActionListener, ListSelectionListener {
    // Elementos
    JLabel labelTelefono, labelDNI, labelAños, labelSelecciona, labelResultados;
    JTextField textTelefono, textDNI;
    // Paneles
    JPanel panelCentro, panelSur;
    // Botones
    JButton buttonBuscar, buttonSalir;
    // Lista
    JList listaCarreras;
    DefaultListModel modeloLista;
    ListSelectionModel modeloSeleccionLista;
    // Spinner
    JSpinner spinnerAños;
    SpinnerNumberModel modeloSpinner;
    // TextArea
    JTextArea areaResultado;
    public Buscar() {
        // Llamas metodo initgui como en la clase ventana
        initGUI();
    }

    private void initGUI() {
        instancias();
        acciones();
        configurarPanel();
        rellenarLista();
        configurarJList();
    }
    private void instancias() {
        panelCentro = new JPanel();
        panelSur = new JPanel();
        // Elementos
        textTelefono = new JTextField();
        textDNI = new JTextField();
        labelTelefono = new JLabel("Telefono");
        labelDNI = new JLabel("DNI");
        labelAños = new JLabel("Años de experiencia");
        labelSelecciona = new JLabel("Selecciona tus estudios");
        labelResultados = new JLabel("Resultados de la busqueda");
        // Spinner
        modeloSpinner = new SpinnerNumberModel(0,0,99,1);
        spinnerAños = new JSpinner(modeloSpinner);
        // Lista
        modeloLista = new DefaultListModel();
        listaCarreras = new JList(modeloLista);
        modeloSeleccionLista = listaCarreras.getSelectionModel();
        // Botones
        buttonBuscar = new JButton("Buscar");
        buttonSalir = new JButton("Salir");
        // Text Area
        areaResultado = new JTextArea();
    }
    private void acciones() {
        // Botones
        buttonBuscar.addActionListener(this);
        buttonSalir.addActionListener(this);
        // Lista
        listaCarreras.addListSelectionListener(this);
        modeloSeleccionLista.addListSelectionListener(this);
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
    // Paneles
    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configPanelCentro(), BorderLayout.CENTER);
        this.add(configPanelSur(), BorderLayout.SOUTH);
    }
    private JPanel configPanelSur() {
        panelSur.setLayout(new FlowLayout(FlowLayout.CENTER, 20,20 ));
        panelSur.add(buttonBuscar);
        panelSur.add(buttonSalir);
        return panelSur;
    }
    private JPanel configPanelCentro() {
        panelCentro.setLayout(new GridBagLayout());
        configurarGridBagCentro(0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 0, 1, 1, labelTelefono);
        configurarGridBagCentro(0, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 0, 2, 1, textTelefono);
        configurarGridBagCentro(0, 2, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 0, 1, 1, labelDNI);
        configurarGridBagCentro(0, 3, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 0, 2, 1, textDNI);
        configurarGridBagCentro(0, 4, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 0.5, 0, 1, 1, labelAños);
        configurarGridBagCentro(1, 4, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 0.5, 0, 1, 1, spinnerAños);
        configurarGridBagCentro(0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 0, 1, 1, labelSelecciona);
        configurarGridBagCentro(0, 6, GridBagConstraints.BOTH, GridBagConstraints.CENTER, 1, 0, 2, 1,  new JScrollPane(listaCarreras));
        configurarGridBagCentro(0, 7, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 0, 1, 1,  labelResultados);
        configurarGridBagCentro(0, 8, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 0.5, 2, 2,  new JScrollPane(areaResultado));
        return  panelCentro;
    }
    private void configurarGridBagCentro(int posX, int posY,int fill, int anchor,double pesX, double pesY, int tamX, int tamY, JComponent component){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.fill = fill ;
        constraints.anchor= anchor;
        constraints.weightx = pesX;
        constraints.weighty = pesY;
        constraints.gridwidth= tamX;
        constraints.gridheight= tamY;
        panelCentro.add(component,constraints);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonBuscar){
            System.out.println("Buscando datos");
            String TelefonoIntro = textTelefono.getText();
            String dniIntro = textDNI.getText();
            String estudiosIntro = listaCarreras.getSelectedValue().toString();
            int edadIntro = (int) spinnerAños.getValue();
            System.out.println(estudiosIntro);
            if (TelefonoIntro.length()<=0 || dniIntro.length()<=0 || estudiosIntro.length()<=0 || edadIntro == 0){
                System.out.println("Campos no completos");
            }else {
                System.out.println("Procedienco a buscar persona");
                // Buscar Persona
                busquedaDatos(TelefonoIntro,dniIntro);

            }
        }else if(e.getSource()==buttonSalir){
            System.out.println("Vaciando campos");
            vaciarCampos();
        }
    }
    // Metodo limpiar
    public void vaciarCampos(){
        textTelefono.setText("");
        textDNI.setText("");
        textTelefono.setText("");
        listaCarreras.clearSelection();
        spinnerAños.setValue(0);
        areaResultado.setText("");
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()){
            System.out.println("Valor cambiado");
        }
    }
    // Llamar
    private Introducir introducir;
    public void busquedaDatos(String telefono, String dni) {
        Introducir introducir = new Introducir();
        introducir.encontrarDatos(telefono,dni);
    }
    // Recoger datos
    public void pintarDatos(String nombrePasado, String carreraPasada) {
        System.out.println(nombrePasado);
        System.out.println(carreraPasada);
        areaResultado.setText(nombrePasado+" - "+carreraPasada);
    }

}
