package Tablas.Paneles;

import Tablas.Modelos.ModeloTabla;
import Tablas.Utiles.DatosPersona;
import Tablas.Utiles.Persona;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class PanelResumen extends JPanel implements ItemListener, ActionListener {
    // Elementos
    JLabel labelClave, labelNombre, labelApellidos, labelEdad, labelCalle, labelNumero, labelCodigoPostal;
    JTextField claveText, nombreText, apellidoText, edadText, calleText, numeroText, codigoPostalText;
    JButton btnBaja, btnAlta;
    JPanel panelclave,panelInferior,panelCentro,panelSuperior;
    TitledBorder tituloPersona,tituloDireccion,tituloClave;
    // Spinner
    DefaultComboBoxModel modeloCombo;
    JComboBox comboPersonas;
    // Paneles colegas
    PanelAltas panelAltas;
    // Tabla
    JTable tablaInfo;
    ModeloTabla modeloTabla;
    // Lista
    ArrayList<Persona> listaPersonas;
    // Paneles colegas

    // Constructor
    public PanelResumen() {
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
        apellidoText = new JTextField();
        edadText = new JTextField();
        calleText = new JTextField();
        numeroText = new JTextField();
        codigoPostalText = new JTextField();
        claveText = new JTextField();
        btnBaja = new JButton("Dar de Baja");
        btnAlta = new JButton("Dar de Alta");
        panelInferior = new JPanel();
        panelSuperior = new JPanel();
        panelclave = new JPanel();
        panelCentro = new JPanel();
        // Tabla
        ArrayList listaPersonas = DatosPersona.obtenerPersonas();
        modeloTabla = new ModeloTabla(listaPersonas);
        tablaInfo = new JTable(modeloTabla);

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
        configurarConstraint(0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,0.3,0.3,1,1,tablaInfo);
        configurarConstraint(0,1,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,0.3,0.3,1,1,configurarPanelArriba());
        configurarConstraint(0,3,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,0,0,1,1,configurarPanelAbajo());
    }

    private JPanel configurarPanelArriba(){
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Datos"));
        panelSuperior.setLayout(new GridLayout(7,2,5,5));
        panelSuperior.add(labelClave);
        panelSuperior.add(claveText);
        panelSuperior.add(labelNombre);
        panelSuperior.add(nombreText);
        panelSuperior.add(labelApellidos);
        panelSuperior.add(apellidoText);
        panelSuperior.add(labelEdad);
        panelSuperior.add(edadText);
        panelSuperior.add(labelCalle);
        panelSuperior.add(calleText);
        panelSuperior.add(labelNumero);
        panelSuperior.add(numeroText);
        panelSuperior.add(labelCodigoPostal);
        panelSuperior.add(codigoPostalText);
        return panelSuperior;
    }
    private JPanel configurarPanelAbajo(){
        panelInferior.add(btnBaja);
        panelInferior.add(btnAlta);
        return panelInferior;
    }
    // Acciones
    private void acciones() {
        btnBaja.addActionListener(this);
        btnAlta.addActionListener(this);
        tablaInfo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String claveSeleccionada = tablaInfo.getModel().getValueAt(tablaInfo.getSelectedRow(), 0).toString();
                System.out.println(claveSeleccionada);
                Persona personaEncontrada = DatosPersona.encontrarPersona(claveSeleccionada);
                System.out.println(personaEncontrada.getNombre());
                claveText.setText(personaEncontrada.getClave());
                nombreText.setText(personaEncontrada.getNombre());
                apellidoText.setText(personaEncontrada.getApellido());
                edadText.setText(String.valueOf(personaEncontrada.getEdad()));
                calleText.setText(personaEncontrada.getCalle());
                numeroText.setText(String.valueOf(personaEncontrada.getNumeroTelf()));
                codigoPostalText.setText(String.valueOf(personaEncontrada.getCp()));
            }
        });
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
                Persona personaEncontrada = DatosPersona.encontrarPersona((String) comboPersonas.getModel().getSelectedItem());
                System.out.println(personaEncontrada.getNombre());
                nombreText.setText(personaEncontrada.getNombre());
                apellidoText.setText(personaEncontrada.getApellido());
                edadText.setText(String.valueOf(personaEncontrada.getEdad()));
                calleText.setText(personaEncontrada.getCalle());
                numeroText.setText(String.valueOf(personaEncontrada.getNumeroTelf()));
                codigoPostalText.setText(String.valueOf(personaEncontrada.getCp()));
            }
        }
    }
    public void refrescarDatos() {
        modeloTabla = new ModeloTabla(listaPersonas);
        modeloTabla.fireTableDataChanged();
        System.out.println("Refrescando datos de la tabla");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBaja) {
                System.out.println("Borrando persona desde resumen");
                String claveBorrar = (String) claveText.getText();
                DatosPersona.eliminarPersona(claveBorrar);
            panelAltas.configurarModelComboBajas();
            panelAltas.configurarModelComboModificaciones();
            refrescarDatos();
            // Vacio campos
            nombreText.setText("");
            claveText.setText("");
            apellidoText.setText("");
            calleText.setText("");
            edadText.setText("");
            codigoPostalText.setText("");
            numeroText.setText("");
        }
        else if (e.getSource() == btnAlta){
            // Introduzco persona
            if (DatosPersona.añadirPersona(new Persona(nombreText.getText(), claveText.getText(), apellidoText.getText(), calleText.getText(), Integer.valueOf(edadText.getText()),
                    Integer.valueOf(codigoPostalText.getText()), Integer.valueOf(numeroText.getText())))) {
                // Notifico cambio en modelo combo
                panelAltas.configurarModelComboBajas();
                panelAltas.configurarModelComboModificaciones();
                refrescarDatos();
                // Vacio campos
                nombreText.setText("");
                claveText.setText("");
                apellidoText.setText("");
                calleText.setText("");
                edadText.setText("");
                codigoPostalText.setText("");
                numeroText.setText("");
            }
        }
    }
}
