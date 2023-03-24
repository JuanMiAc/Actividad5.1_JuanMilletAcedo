
package clases;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jumia
 */
public class TablaModeloPersona extends AbstractTableModel{
    
    private static final int DNI = 0;
    private static final int NOMBRE = 1;
    private static final int APE1 = 2;
    private static final int APE2 = 3;
    private static final int FENAC = 4;
    private static final int EMAIL = 5;
    private static final int PWD = 6;
    
    private ArrayList<Persona> listaPersonas;
    
    private static final String[] columns = new String[]{"Dni", "Nombre", "Ape1", "Ape2", "Fecha_Nac", "email", "Password"};
    private static final Class<?>[] clase = { String.class, String.class, String.class, String.class,String.class,String.class, String.class};

    
    private String[] columnNames = {"Dni", "Nombre", "Ape1", "Ape2", "Fecha_Nac", "email", "Password"};
    
    private int rowToHighlight = -1; // Por defecto, no se resalta ninguna fila
    
    public TablaModeloPersona(ArrayList<Persona> listaPersonas){
        this.listaPersonas=listaPersonas;
    }
    
    @Override
    public int getRowCount() {
        return listaPersonas.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    } 
    
  
    @Override  // Devuelve valor de la celda que s esta en la fila rowIndex y en la columna columnIndex
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona a = getPersona(rowIndex);

        if(a != null) {
            switch (columnIndex) {
                case DNI:
                    return a.getDni();
                case NOMBRE:
                    return a.getNombre();
                case APE1:
                    return a.getApellido1();
                case APE2:
                    return a.getApellido2();
                 case FENAC:
                    return a.getfechaNac();
                case EMAIL:
                    return a.getEmail();
                case PWD:
                    return a.getPassword();
               }
        }
        return "";
    }
    
    public Color getRowColor(int rowIndex, int colorIndex) {
    if (rowIndex  != -1) // cambiar color solo para filas pares
        { 
           
        }
       return Color.RED; 
    }
   
    
    @Override  // Escribe valor en la celda que esta en la fila rowIndex y en la columna columnIndex
    public void setValueAt(Object valor,int rowIndex, int columnIndex) {
        Persona a = getPersona(rowIndex);

        if(a != null) {
            switch (columnIndex) {
                case DNI:
                     a.setDni(valor.toString());
                case NOMBRE:
                     a.setNombre(valor.toString());
                case APE1:
                     a.setApellido1(valor.toString());
                case APE2:
                     a.setApellido2(valor.toString());
                 case FENAC:
                     a.setfechaNac(valor.toString());
                case EMAIL:
                     a.setEmail(valor.toString());
                case PWD:
                     a.setPassword(valor.toString());
               }
        }   
    }
    
    
    public void setValueRow(Persona a,int rowIndex) {
        Persona modificar = getPersona(rowIndex);

        if(modificar != null) {
            modificar.setDni(a.getDni());
            modificar.setNombre(a.getNombre());
            modificar.setApellido1(a.getApellido1());
            modificar.setApellido2(a.getApellido2());
            modificar.setfechaNac(a.getfechaNac());
            modificar.setEmail(a.getEmail());
            modificar.setPassword(a.getPassword());
            this.fireTableDataChanged();
           }
    }
  
    
     public Persona getPersona(int rowIndex) {
        if (getRowCount() > rowIndex && rowIndex >= 0) {
            return listaPersonas.get(rowIndex);
        }
        return null;
    }
     

    public ArrayList<Persona> getlistaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
        this.fireTableDataChanged(); //informa que la tabla ha cambiado.
    }

    public void setPersona(Persona sb){
        listaPersonas.add(sb);
        this.fireTableRowsInserted(listaPersonas.size()-1, listaPersonas.size()-1);
    }
    
     public void delPersona(int rowIndex){
        listaPersonas.remove( rowIndex);
        this.fireTableDataChanged();
    }
    
   @Override
    public Class<?> getColumnClass(int columnIndex) {
        return clase[columnIndex];
    }
    
    @Override 
    public String getColumnName(int index) { 
        return columnNames[index]; 
    } 

   
    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }
}
