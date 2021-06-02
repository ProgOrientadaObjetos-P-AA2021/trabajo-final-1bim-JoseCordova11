package paquetedos;
import java.io.Serializable;
/**
 *
 * @author Jose Cordova 
 */
public class Propietario implements Serializable{
    String nombrePro;
    String apellidoPro;
    String idPro;
    
    public Propietario(String np, String ap, String id){
        nombrePro = np;
        apellidoPro = ap;
        idPro = id;
    }
    
    public void setNombrePro(String np){
        nombrePro = np;
    }
    public void setApellidoPro(String ap){
        nombrePro = ap;
    }
    public void setIdPro(String id){
        idPro = id;
    }
    public String getNombrePro(){
        return nombrePro;
    }
    public String getApellidoPro(){
        return apellidoPro;
    }
    public String getIdPro(){
        return idPro;
    }
    
    @Override
    public String toString() {
        String cadena = String.format("Nombre propietario: %s\n"
                + "Apellido propietario: %s\n"
                + "Identificacion propietario: %s\n",
                getNombrePro(),
                getApellidoPro(),
                getIdPro());
        return cadena;
    }

}
