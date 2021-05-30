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
public class Departamento implements Serializable {
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrado;
    private double valorMensual;
    private double costoFinal;
    private double precio;
    private Ubicacion ubicacion;
    private Ciudad ciudad;
    private String nombreEdificio;
    private String ubiDeparEnEdificio;
    private Constructora constructora;
    
    public Departamento(){
        
    }

    public Departamento(Propietario pro, double precioMC, int numeroMC, double valorMensual, Ubicacion ubi, Ciudad ciu, String nomEdi, String ubiDepEdi, Constructora con) {
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
    public void setValorMensual(double vm){
        valorMensual = vm;
    }
    public void setCostoFinal(){
        costoFinal = (numeroMetrosCuadrado * precioMetroCuadrado) + (valorMensual * 12);
    }
    public void setPrecio(double pre){
        precio = pre;
    }
    public void setUbicacion(Ubicacion ubi){
        ubicacion = ubi;
    }
    public void setCiudad(Ciudad c){
        ciudad = c;
    }
    public void setNombreEdificio(String ne){
        nombreEdificio = ne;
    }
    public void setUbiDepar(String ude){
        ubiDeparEnEdificio = ude;
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
    public double getValorMensual(){
        return valorMensual;
    }
    public double getCostoFinal(){
        return costoFinal;
    }
    public double getPrecio(){
        return precio;
    }
    public Ubicacion getUbicacion(){
        return ubicacion;
    }
    public Ciudad getCiudad (){
        return ciudad;
    }
    public String getNombreEdifico(){
        return nombreEdificio;
    }
    public String getUbiDepar(){
        return ubiDeparEnEdificio;
    }
    public Constructora getConstructora(){
        return constructora;
    }
}
