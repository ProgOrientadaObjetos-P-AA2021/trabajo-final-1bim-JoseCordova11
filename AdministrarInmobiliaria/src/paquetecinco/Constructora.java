package paquetecinco;
import java.io.Serializable;

/**
 *
 * @author Jose Cordova
 */
public class Constructora implements Serializable {
    private String nombre;
    private String idEmpresa;
    
    public Constructora (){
          
    }
    public void setNombre(String n){
        nombre = n;
    }
    public void setIdEmpresa(String id){
        idEmpresa = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getIdEmpresa(){
        return idEmpresa;
    }
    
    public String toString() {
        String cadena = String.format("Información de la Constructora: \n"
                + "Nombre de la constructora: %s\n"
                + "Id de la empresa: %s\n",
                getNombre(),
                getIdEmpresa());
        return cadena;
    }
    
    
}
