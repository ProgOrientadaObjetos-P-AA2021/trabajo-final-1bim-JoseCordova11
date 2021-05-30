package paqueteseis;
import java.io.Serializable;
import paquetedos.Propietario;
import paquetetres.Ubicacion;
import paquetecuatro.Ciudad;
import paquetecinco.Constructora;

/**
 *
 * @author Jose Cordova
 */
public class Casa implements Serializable{
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrado;
    private double costoFinal;
    private Ubicacion ubicacion;
    private Ciudad ciudad;
    private int numeroCuartos;
    private Constructora constructora;
    
    public Casa (){
        
    }

    public Casa(Propietario pro, double precioMC, int numeroMC, Ubicacion ubi, Ciudad ci, int nCuartos, Constructora con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setPropietario(Propietario pro){
        propietario = pro;
    }
    public void setPrecioMC(double pmc){
        precioMetroCuadrado = pmc;
    }
    public void setNumeroMC(double nmc){
        numeroMetrosCuadrado = nmc;
    }
    public void setCostoFinal(){
        costoFinal = precioMetroCuadrado * numeroMetrosCuadrado;
    }
    public void setUbicacion(Ubicacion ubi){
        ubicacion = ubi;
    }
    public void setCiudad(Ciudad c){
        ciudad = c;
    }
    public void setNcuartos(int ncu){
        numeroCuartos = ncu;
    }
    public void setConstructora(Constructora cons){
        constructora = cons;
    }
    
    public Propietario getPropietario(){
        return propietario;
    }
    public double getPrecioMC(){
        return precioMetroCuadrado;
    }
    public double getNumeroMC(){
        return numeroMetrosCuadrado;
    }
    public double getCostoFinal(){
        return costoFinal;
    }
    public Ubicacion getUbicacion(){
        return ubicacion;
    }
    public Ciudad getCiudad (){
        return ciudad;
    }
    public int getNumeroCuartos(){
        return numeroCuartos;
    }
    public Constructora getConstructora(){
        return constructora;
    }
    
    
    
}
