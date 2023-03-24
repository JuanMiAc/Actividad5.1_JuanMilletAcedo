
package clases;

/**
 *
 * @author jumia
 */
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import javax.swing.text.Element;

class Persona {

    static void appendChild(Element Nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        private String dni;
        private String nombre;
	private String apellido1;
        private String apellido2;
	private String fechaNac;
	private String email;
        private String password;
        
        public static String getSHA512(String input){
	String toReturn = null;
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-512");
                digest.reset();
                digest.update(input.getBytes("utf8"));
                toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
            } catch (Exception e) {
                e.printStackTrace();
            }return toReturn;
        }
        
        public void Persona(){}
        
	public void Persona(String dni,String nombre, String apellido1,String apellido2, String fechaNac, String email,String password) {
                this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
                this.apellido2 = apellido2;
		this.fechaNac = fechaNac;
		this.email = email;
                this.password = password;
	}
 
        public String getDni() {
		return dni;
	}
 
	public void setDni(String dni) {
		this.dni = dni;
	} 
        
	public String getNombre() {
		return nombre;
	}
 
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
 
	public String getApellido1() {
		return apellido1;
	}
 
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
        
        public String getApellido2() {
		return apellido2;
	}
 
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
 
	public String getfechaNac() {
		return this.fechaNac;
	}
 
	public void setfechaNac(String fechaNac) {
		this.fechaNac=fechaNac; 
	}
 
	public String getEmail() {
		return this.email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
        public String getPassword() {
		return this.password;
	}
 
	public void setPassword(String password) {
            if(password.isEmpty()) {    
                }else  
                {this.password=getSHA512(password);}
        }
        
        @Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", fechaNac=" + fechaNac + ", email=" + email +", password=" + password + "]";
	}
        
         public String getpersona(){ 
            return  "\n   - DNI: " + this.dni +
             "\n   - Nombre: " + this.nombre +
             "\n   - Apellidos: " +this.apellido1 +
             "\n   - Apellidos: " +this.apellido2 +
             "\n   - Año de nacimiento: " + this.fechaNac +
             "\n   - Correo electrónico: " + this.email +
             "\n   - Password: " + this.password + "\n";
        }
}     
        
	        

    
 
    

