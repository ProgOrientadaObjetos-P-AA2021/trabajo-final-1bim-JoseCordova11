package paquetecuatro;
import java.io.Serializable;

/**
 *
 * @author Jose Cordova
 */
public class Ciudad implements Serializable {
    private String nombreCiudad;
    private String nombreProvin;
    
    public Ciudad (String nomCiu,String nomProvi){
        nombreCiudad = nomCiu;
        nombreProvin = nomProvi;
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
        String cadena = String.format("Nombre de la ciudad: %s\n"
                + "Nombre de la provincia: %s\n",
                getNombreCiudad(),
                getNombreProvin());
        return cadena;
    }
  
}
