package Tablas.Utiles;

import javax.swing.*;
import java.util.ArrayList;

public class DatosPersona {
    static ArrayList<Persona> listaPErsonas = new ArrayList<>();
    // Metodo devolver todas las personas
    public static ArrayList<Persona> obtenerPersonas(){
        // Return lista entera
        return listaPErsonas;
    }
    // Obtener todas las claves de la lista
    public static ArrayList<String> cogerClaves(){
        ArrayList<String> claves = new ArrayList();
        for (Persona personaEncontrada: listaPErsonas) {
            claves.add(personaEncontrada.getClave());
        }
        return claves;
    }
    // Metodo comprobar si esta la persona en la lista
    public static boolean estaPersona(String clave){
        boolean existePersona=false;
        for (Persona personaEncontrada : listaPErsonas) {
            if (personaEncontrada.getClave().equals(clave))
                existePersona=true;
        }
        return existePersona;
    }
    // Metodo añadir la persona
    public static Boolean añadirPersona(Persona persona){
        boolean añadirPersona=false;
        if (!estaPersona(persona.getClave())) {
            listaPErsonas.add(persona);
            añadirPersona = true;
        }
        return añadirPersona;
    }
    // Metodo borrar persona
    public static void eliminarPersona(String clave){
        if (!listaPErsonas.isEmpty()) {
            for (Persona personaEncontrada : listaPErsonas) {
                if (personaEncontrada.getClave().equals(clave)) {
                    listaPErsonas.remove(personaEncontrada);
                }
            }
        }
    }
    // Buscar persona por clave
    public static Persona encontrarPersona(String clave){
        Persona devolverEncontrada = null;
        for (Persona personaEncontrada : listaPErsonas) {
            if (personaEncontrada.getClave().equals(clave))
                devolverEncontrada = personaEncontrada;
        }
        return devolverEncontrada;
    }
    // Futuros
    /*public static void modificar(Persona persona){
        for (Persona item: personas) {
            if (item.getClave().equals(persona.getClave()))
                item = persona;
        }
    }
    public static DefaultComboBoxModel configurarModelos(DefaultComboBoxModel modelo){
        DefaultComboBoxModel modeloCombo=modelo;
        modeloCombo.removeAllElements();
        for (String item: DataSet.cogerClaves()) {
            modeloCombo.addElement(item);
        }
        return modeloCombo;
    }*/
}
