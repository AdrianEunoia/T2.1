package Tablas.Modelos;

import Tablas.Utiles.Persona;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTabla extends AbstractTableModel {
    String[] columnas;
    Object[][] datos;
    ArrayList<Persona> listaPersonas;
    Class[] tipos={String.class,String.class,String.class,Integer.class};

    public ModeloTabla(String[] columnas, Object[][] datos) {
        this.columnas = columnas;
        this.datos = datos;
    }

    public ModeloTabla(ArrayList datosLista){
        this.listaPersonas=datosLista;
        columnas = new String[]{"Clave","Nombre","Apellidos","Edad"};
    }

    @Override
    public int getRowCount() {
        return listaPersonas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    public void addPersona(Persona persona){
        listaPersonas.add(persona);
        fireTableDataChanged();
    }
    public void removePersona(int index){
        listaPersonas.remove(index);
        fireTableDataChanged();
    }
    public Persona[] getPersonaMultiple(int[] index){
        Persona[] personas = new Persona[index.length];
        for(int i=0;i<index.length;i++){
            personas[i]= getPersona(i);
        }
        return personas;
    }
    public Persona getPersona(int index){
        return listaPersonas.get(index);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona aux = listaPersonas.get(rowIndex);
        switch (columnIndex){
            case 0:
                return aux.getClave();
            case 1:
                return aux.getNombre();
            case 2:
                return aux.getApellido();
            case 3:
                return aux.getEdad();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tipos[columnIndex];
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
