package Tablas.Paneles;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelBajas extends JPanel {
    // Elementos
    JLabel labelClave, labelNombre, labelApellidos, labelEdad, labelCalle, labelNumero, labelCodigoPostal;
    JTextField  nombreText, apellidoText, edadText,calleText,numeroText,codigoPostalText;
    JButton btnBaja;
    JPanel panelclave,panelInferior,panelCentro,panelSuperior;
    TitledBorder tituloPersona,tituloDireccion,tituloClave;
    // Spinner
    DefaultComboBoxModel modeloCombo;
    JComboBox clave;

    // Constructor
    public PanelBajas() {
        initGUI();
    }
    // Lanzador
    public void initGUI(){
        instancias();
        configurarPanel();
        //configurarModeloCombo();
        acciones();
    }
    // Instancias
    private void instancias() {
        // Titulos
        tituloPersona = new TitledBorder("Datos Personales");
        tituloDireccion = new TitledBorder("Direccion");
        tituloClave = new TitledBorder("Seleccion Clave");
        // Spinner
        modeloCombo = new DefaultComboBoxModel();
        clave = new JComboBox(modeloCombo);
        // Elementos
        labelClave = new JLabel("Clave");
        labelNombre = new JLabel("Nombre: ");
        labelApellidos = new JLabel("Apellidos: ");
        labelEdad = new JLabel("Edad: ");
        labelCalle = new JLabel("Calle: ");
        labelNumero = new JLabel("Número: ");
        labelCodigoPostal = new JLabel("Codigo Postal: ");
        nombreText = new JTextField();
        nombreText.setEnabled(false);
        nombreText.setBackground(Color.lightGray);
        apellidoText = new JTextField();
        apellidoText.setEnabled(false);
        apellidoText.setBackground(Color.lightGray);
        edadText = new JTextField();
        edadText.setEnabled(false);
        edadText.setBackground(Color.lightGray);
        calleText = new JTextField();
        calleText.setEnabled(false);
        calleText.setBackground(Color.lightGray);
        numeroText = new JTextField();
        numeroText.setEnabled(false);
        numeroText.setBackground(Color.lightGray);
        codigoPostalText = new JTextField();
        codigoPostalText.setBackground(Color.lightGray);
        codigoPostalText.setEnabled(false);
        btnBaja = new JButton("Dar de Baja");
        panelInferior = new JPanel();
        panelSuperior = new JPanel();
        panelclave = new JPanel();
        panelCentro = new JPanel();
    }
    // Paneles
    public void configurarConstraint(int posX, int posY,int fill, int anchor, double pesX, double pesY, int tamX, int tamY, JComponent component){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.fill = fill ;
        constraints.anchor= anchor;
        constraints.weightx = pesX;
        constraints.weighty = pesY;
        constraints.gridwidth= tamX;
        constraints.gridheight= tamY;
        add(component,constraints);
    }
    private void configurarPanel() {
        this.setLayout(new GridBagLayout());
        configurarConstraint(0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,0.3,0.3,1,1,configurarPanelClave());
        configurarConstraint(0,1,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,0.3,0.3,1,1,configurarPanelArriba());
        configurarConstraint(0,2,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,0.3,0.3,1,1,configurarPanelCentro());
        configurarConstraint(0,3,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,0,0,1,1,configurarPanelAbajo());
    }
    private JPanel configurarPanelClave() {
        panelclave.setBorder(BorderFactory.createTitledBorder("Selección clave"));
        panelclave.setLayout(new GridLayout(1,2));
        panelclave.add(new JLabel("Clave: "));
        panelclave.add(clave);
        return panelclave;
    }
    private JPanel configurarPanelArriba(){
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Datos Personales"));
        panelSuperior.setLayout(new GridLayout(3,2,5,5));
        panelSuperior.add(labelNombre);
        panelSuperior.add(nombreText);
        panelSuperior.add(labelApellidos);
        panelSuperior.add(apellidoText);
        panelSuperior.add(labelEdad);
        panelSuperior.add(edadText);
        return panelSuperior;
    }
    private JPanel configurarPanelCentro(){
        panelCentro.setBorder(BorderFactory.createTitledBorder("Dirección"));
        panelCentro.setLayout(new GridLayout(3,2,5,5));
        panelCentro.add(labelCalle);
        panelCentro.add(calleText);
        panelCentro.add(labelNumero);
        panelCentro.add(numeroText);
        panelCentro.add(labelCodigoPostal);
        panelCentro.add(codigoPostalText);
        return panelCentro;
    }
    private JPanel configurarPanelAbajo(){
        panelInferior.add(btnBaja);
        return panelInferior;
    }
    // Acciones
    private void acciones() {

    }
}
