package paquetetres;
import java.io.Serializable;

/**
 *
 * @author Jose Cordova 
 */
public class Ubicacion implements Serializable{
    
    private String nombreBarrio;
    private String numeroCasa;
    private String referencia;
    
    public Ubicacion(String nomB,String ref){
        nombreBarrio = nomB;
        referencia = ref;
    }
    public Ubicacion(String nomB,String nuCasa,String ref){
        nombreBarrio = nomB;
        numeroCasa = nuCasa;
        referencia = ref;
    }
    
    public void setNombreBarrio(String nb){
        nombreBarrio = nb;
    }
    public void setNumeroCasa(String nc){
        numeroCasa = nc;
    }
    public void setReferencia(String re){
        referencia = re;
    }
    
    public String getNombreBarrio(){
        return nombreBarrio;
    }
    public String getNumeroCasa(){
        return numeroCasa;
    }
    public String getReferencia(){
        return referencia;
    }
    
    @Override
    public String toString() {
        String cadena = String.format("Nombre del barrio: %s\n"
                + "Numero de casa: %s\n"
                + "Referencia: %s\n",
                getNombreBarrio(),
                getNumeroCasa(),
                getReferencia());
        return cadena;
    }
}
