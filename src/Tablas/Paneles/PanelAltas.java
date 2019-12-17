package Tablas.Paneles;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAltas extends JPanel implements ActionListener {
    // Var elementos
        // Panel donde añadimos los demas paneles, los declaramos
        // Paneles
    PanelBajas panelBajas;
    PanelModificaciones panelModificaciones;
    PanelResumen panelResumen;
    // Elementos
    JLabel labelClave, labelNombre, labelApellidos, labelEdad, labelCalle, labelNumero, labelCodigoPostal;
    JTextField claveText, nombreText, apellidoText, edadText, calleText, numeroText, codigoPostalText;
    JButton btnAlta;
    // Paneles propios
    JPanel panelSuperior, panelInferior, panelCentro;
    // Tittles
    TitledBorder tituloPersonal, tituloDireccion;

    // Constructor
    public PanelAltas(PanelBajas panelBajas, PanelModificaciones panelModificaciones, PanelResumen panelResumen) {
        initGUI();
        this.panelModificaciones = panelModificaciones;
        this.panelBajas = panelBajas;
        this.panelResumen= panelResumen;
    }
    // Lanzador
    private void initGUI() {
        instancias();
        configurarContainer();
        acciones();
    }
    // Instancias
    private void instancias() {
        // Titulos
        tituloPersonal = new TitledBorder("Datos Personales");
        tituloDireccion = new TitledBorder("Direccion");
        // Label
        labelClave = new JLabel("Clave: ");
        labelNombre = new JLabel("Nombre: ");
        labelApellidos = new JLabel("Apellidos: ");
        labelEdad = new JLabel("Edad: ");
        labelCalle = new JLabel("Calle: ");
        labelNumero = new JLabel("Número: ");
        labelCodigoPostal = new JLabel("Codigo Postal: ");
        // Texts
        claveText = new JTextField();
        nombreText = new JTextField();
        apellidoText = new JTextField();
        edadText = new JTextField();
        calleText = new JTextField();
        numeroText = new JTextField();
        codigoPostalText = new JTextField();
        // Buttons
        btnAlta = new JButton("Dar de Alta");
        // Paneles
        panelInferior = new JPanel();
        panelSuperior = new JPanel();
        panelCentro = new JPanel();
    }
    // Paneles
    private void configurarContainer() {
        this.setLayout(new BorderLayout());
        this.add(configurarSuperior(), BorderLayout.NORTH);
        this.add(configurarCentro(), BorderLayout.CENTER);
        this.add(configurarInferior(), BorderLayout.SOUTH);
    }
    private JPanel configurarSuperior() {
        panelSuperior.setLayout(new GridLayout(4, 2, 40, 5));
        panelSuperior.setBorder(tituloPersonal);
        panelSuperior.add(labelClave);
        panelSuperior.add(claveText);
        panelSuperior.add(labelNombre);
        panelSuperior.add(nombreText);
        panelSuperior.add(labelApellidos);
        panelSuperior.add(apellidoText);
        panelSuperior.add(labelEdad);
        panelSuperior.add(edadText);
        return panelSuperior;
    }
    private JPanel configurarCentro() {
        panelCentro.setLayout(new GridLayout(3, 2, 40, 10));
        panelCentro.setBorder(tituloDireccion);
        panelCentro.add(labelCalle);
        panelCentro.add(calleText);
        panelCentro.add(labelNumero);
        panelCentro.add(numeroText);
        panelCentro.add(labelCodigoPostal);
        panelCentro.add(codigoPostalText);
        panelCentro.add(configurarInferior(), BorderLayout.SOUTH);
        return panelCentro;
    }
    private JPanel configurarInferior() {
        panelInferior.add(btnAlta);
        return panelInferior;
    }
    // Acciones
    private void acciones() {
        btnAlta.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
