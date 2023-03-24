package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GeneradorXML {
     private Document documentoXML;
     private ArrayList<Persona> listaPersonas3;
     Persona persona2 = new Persona();
 
     
    public GeneradorXML() throws Exception{
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        documentoXML = builder.newDocument();
    }  
    
    public void generarDocumento(ArrayList<Persona> listaPersonas){
          this.listaPersonas3=listaPersonas;
          Element persona = (Element) documentoXML.createElement("Listadopersonas"); 
          documentoXML.appendChild(persona);

          for(int i=0;i< listaPersonas3.size();i++){
          String posicion= String.valueOf(i);
          persona2 = listaPersonas3.get(i);

          Element DNI = (Element) documentoXML.createElement("DNI"); 
          persona.appendChild(DNI);
         DNI.appendChild(documentoXML.createTextNode(persona2.getDni()));
         System.out.println(persona2.getDni());
          
          Element nombre = (Element) documentoXML.createElement("nombre"); 
          persona.appendChild(nombre );
           nombre.appendChild(documentoXML.createTextNode(persona2.getNombre()));
          
          Element apellido1 = (Element) documentoXML.createElement("apellido1"); 
          persona.appendChild(apellido1);
          apellido1.appendChild(documentoXML.createTextNode(persona2.getApellido1()));
          
          Element apellido2 = (Element) documentoXML.createElement("apellido1"); 
          persona.appendChild(apellido2);
          apellido2.appendChild(documentoXML.createTextNode(persona2.getApellido1()));
          
          Element fechaNac = (Element) documentoXML.createElement("fechaNac"); 
          persona.appendChild(fechaNac);
           fechaNac.appendChild(documentoXML.createTextNode(persona2.getfechaNac()));
          
          Element email = (Element) documentoXML.createElement("email"); 
          persona.appendChild(email);
          email.appendChild(documentoXML.createTextNode(persona2.getEmail()));
          
          Element password = (Element) documentoXML.createElement("password"); 
          persona.appendChild(password );
         password.appendChild(documentoXML.createTextNode(persona2.getPassword()));
          } 
    }
      
    public void generarXML() throws Exception{
            Source origen = new DOMSource(documentoXML);
            File ruta = new File("./UsuariosXML.xml");
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);
            Result resultado = new StreamResult(pw);
           
            TransformerFactory factoria = TransformerFactory.newInstance();
            Transformer transformer = factoria.newTransformer();
            transformer.transform(origen, resultado);/*Nos pide Origen y destino*/
    }    
}
