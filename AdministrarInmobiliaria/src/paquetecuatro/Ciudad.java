package paquetecuatro;
import java.io.Serializable;

/**
 *
 * @author Jose Cordova
 */
public class Ciudad implements Serializable {
    private String nombreCiudad;
    private String nombreProvin;
    
    public Ciudad(){
        
    }    
    public void setNombreCiudad(String nc){
        nombreCiudad = nc;
    }
    public void setNombreProvin(String np){
        nombreProvin = np;
    }
    
    public String getNombreCiudad(){
        return nombreCiudad;
    }
    public String getNombreProvin(){
        return nombreProvin;
    }
    @Override
    public String toString() {
        return nombreCiudad + "\n" + nombreProvin + "\n";
    }
    
}
