package paquetecinco;
import java.io.Serializable;

/**
 *
 * @author Jose Cordova
 */
public class Constructora implements Serializable {
    private String nombreCon;
    private String idEmpresa;
    
    public Constructora (String n,String id){
        nombreCon = n;
        idEmpresa = id;
    }
    public void setNombreCons(String n){
        nombreCon = n;
    }
    public void setIdEmpresa(String id){
        idEmpresa = id;
    }
    
    public String getNombreCons(){
        return nombreCon;
    }
    
    public String getIdEmpresa(){
        return idEmpresa;
    }
    
    public String toString() {
        String cadena = String.format("Nombre de constructora: %s\n"
                + "Id de la empresa: %s\n",
                getNombreCons(),
                getIdEmpresa());
        return cadena;
    }
    
    
}
