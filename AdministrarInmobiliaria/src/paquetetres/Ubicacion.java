package paquetetres;
import java.io.Serializable;

/**
 *
 * @author Jose Cordova 
 */
public class Ubicacion implements Serializable{
    
    private String nombreBarrio;
    private int numeroCasa;
    private String referencia;
    
    public Ubicacion(){
        
    } 
    public void setNombreBarrio(String nb){
        nombreBarrio = nb;
    }
    public void setNumeroCasa(int nc){
        numeroCasa = nc;
    }
    public void setReferencia(String re){
        referencia = re;
    }
    
    public String getNombreBarrio(){
        return nombreBarrio;
    }
    public int getNumeroCasa(){
        return numeroCasa;
    }
    public String getReferencia(){
        return referencia;
    }
    
    @Override
    public String toString() {
        return nombreBarrio + "\n" + numeroCasa + "\n" + referencia+ "\n";
    }
}
