package ExamenT2.Paneles;

import Repaso8_PracticaFinal.Utiles.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Card1 extends JPanel {
    // Elementos
    JLabel labelNombre, labelApellidos, labelMatricula;
    JTextField textNombre, textApellidos, textMatricula;
    // Paneles
    JPanel panelCentro;
    // Listas
    // Lista
    ArrayList listaPersonas;

    // Lanzadores
    public Card1() {
        initGUI();
    }
    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void instancias() {
        panelCentro = new JPanel();
        labelNombre = new JLabel("Nombre");
        labelApellidos = new JLabel("Apellidos");
        labelMatricula = new JLabel("Matricula");
        textNombre = new JTextField();
        textApellidos = new JTextField();
        textMatricula = new JTextField();
    }

    private void acciones() {
        textNombre.addKeyListener(new ManejoTeclasString());
        textApellidos.addKeyListener(new ManejoTeclasString());
        textMatricula.addKeyListener(new ManejoTeclasInteger());
    }

    private void configurarPanel() {
        this.setLayout(new GridLayout(3,2));
        this.add(labelNombre);
        this.add(textNombre);
        this.add(labelApellidos);
        this.add(textApellidos);
        this.add(labelMatricula);
        this.add(textMatricula);
    }
    public void recogerDatos(){
        // Formar Persona
        String nombreRecogido = textNombre.getText().toString();
        String apellidosRecogido = textApellidos.getText().toString();
        String matriculaRecogida = textMatricula.getText().toString();
        // Rellenar lista
        //listaPersonas.add(nombreRecogido,apellidosRecogido,matriculaRecogida);
    }
    public ArrayList getListaNombres() {
        return listaPersonas;
    }

    // Restricciones teclas
    class ManejoTeclasString extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            char tecla = e.getKeyChar();
            if (Character.isDigit(tecla)) {
                e.consume();
            } else if (textNombre.getText().length() == 20 || textApellidos.getText().length() == 20) {
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
            } else if (textMatricula.getText().length() == 20) {
                e.consume();
            }
        }
    }
}
