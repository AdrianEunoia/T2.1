package Tablas.Paneles;

import Tablas.Utiles.DatosPersona;
import Tablas.Utiles.Persona;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PanelBajas extends JPanel implements ItemListener, ActionListener {
    // Elementos
    JLabel labelClave, labelNombre, labelApellidos, labelEdad, labelCalle, labelNumero, labelCodigoPostal;
    JTextField  nombreText, apellidoText, edadText,calleText,numeroText,codigoPostalText;
    JButton btnBaja;
    JPanel panelclave,panelInferior,panelCentro,panelSuperior;
    TitledBorder tituloPersona,tituloDireccion,tituloClave;
    // Spinner
    DefaultComboBoxModel modeloCombo;
    JComboBox comboPersonas;

    // Constructor
    public PanelBajas() {
        initGUI();
    }
    // Lanzador
    public void initGUI(){
        instancias();
        configurarPanel();
        configurarModeloCombo();
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
        comboPersonas = new JComboBox(modeloCombo);
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
        apellidoText = new JTextField();
        apellidoText.setEnabled(false);
        edadText = new JTextField();
        edadText.setEnabled(false);
        calleText = new JTextField();
        calleText.setEnabled(false);
        numeroText = new JTextField();
        numeroText.setEnabled(false);
        codigoPostalText = new JTextField();
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
        panelclave.add(comboPersonas);
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
        comboPersonas.addItemListener(this);
        btnBaja.addActionListener(this);
    }
    // Combo
    public void configurarModeloCombo() {
        modeloCombo.removeAllElements();
        for (String personaEncontrada: DatosPersona.cogerClaves()) {
            modeloCombo.addElement(personaEncontrada);
            System.out.println("Persona añadida a combo de bajas con nombre: "+DatosPersona.encontrarPersona(personaEncontrada).getNombre());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboPersonas) {
            if (comboPersonas.getModel().getSelectedItem() != null) {
                Persona aux = DatosPersona.encontrarPersona((String) comboPersonas.getModel().getSelectedItem());
                System.out.println(aux.getNombre());
                nombreText.setText(aux.getNombre());
                apellidoText.setText(aux.getApellido());
                edadText.setText(String.valueOf(aux.getEdad()));
                calleText.setText(aux.getCalle());
                numeroText.setText(String.valueOf(aux.getNumeroTelf()));
                codigoPostalText.setText(String.valueOf(aux.getCp()));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBaja) {
            int numeroPersonas = comboPersonas.getItemCount();
            if(numeroPersonas > 1) {
                System.out.println("Borrando persona");
                String claveBorrar = (String) comboPersonas.getSelectedItem();
                DatosPersona.eliminarPersona(claveBorrar);
            }else{
                JOptionPane.showMessageDialog(this, "No puedes dejar la lista totalmente vacia!", "Atencion!", JOptionPane.WARNING_MESSAGE, null);
            }
            configurarModeloCombo();
        }
    }
}
