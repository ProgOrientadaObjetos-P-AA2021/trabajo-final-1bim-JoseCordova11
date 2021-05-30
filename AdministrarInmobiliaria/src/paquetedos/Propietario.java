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
    
    public Propietario(){
        
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
        return nombrePro + "\n" + apellidoPro + "\n" + idPro;
    }
}
