
package actividad_5_1;

/*--------------Actividad 5.1 Juan Millet Acedo-----------------*/

import clases.VentanaInicio;
import clases.FormCapturaPersonas;
import clases.GeneradorXML;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;


public class actividad_5_1 {

  private static VentanaInicio  aplicacion;  
 // static FormCapturaPersonas formPersonas;

  private static void initComponents() {
      
   aplicacion = new VentanaInicio();
    
 }

  public void actividad_5_1(){}
  
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        /* Create and display the form */
          initComponents();
         aplicacion.setSize(800, 600);
         aplicacion.setResizable(true);
         aplicacion.getContentPane().setLayout(new BorderLayout());
       //  aplicacion.setLocationRelativeTo(null);
       //  aplicacion.setPreferredSize(new Dimension(800, 600));
       //  aplicacion.pack();
         aplicacion.setVisible(true);
        
    //    aplicacion.getContentPane().add(formPersonas);

    }
    /*
     public static void hola() throws Exception{
        GeneradorXML generador = new GeneradorXML();
        System.out.println("Hola desde el main");
        generador.generarDocumento();
        generador.generarXML();
    }
   */
}
