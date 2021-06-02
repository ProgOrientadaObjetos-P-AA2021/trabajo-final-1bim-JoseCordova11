package paqueteseis;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoLecturaDepar {
    private ObjectInputStream entrada;
    private ArrayList<Departamento> depar;
    private String nombreArchivo;

    public ArchivoLecturaDepar(String nA) {
        nombreArchivo = nA;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(nA));
            } catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaDepar() {
        // 
        depar = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    depar.add(registro);
                } catch (EOFException endOfFileException) {
                    return;

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);
                    break;
                }
            }
        }

    }

    public ArrayList<Departamento> obtenerListaDepar() {
        return depar;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Departamentos\n";
        for (int i = 0; i < obtenerListaDepar().size(); i++) {
            Departamento d = obtenerListaDepar().get(i);
            cadena = String.format("%s\nDepartamento %s\n"
                    + "Propietario: \n"
                    + "Nombre: %s - "
                    + "Apellido: %s - "
                    + "Identificación: %s\n"
                    + "Precio por metro Cuadrado: %.2f\n"
                    + "Numero de metro cuadrado: %.2f\n"
                    + "Valor Alícuota Mensual: %.2f\n"
                    + "Costo Final: %.2f\n"
                    + "Precio: %.2f\n"
                    + "Ubicacion: \nNúmero de casa: %s - "
                    + "Nombre del barrio: %s - "
                    + "Referencia: %s\n"
                    + "Ciudad:\nNombre ciudad: %s - "
                    + "Provincia: %s\n"
                    + "Nombre del edificio: %s\n"
                    + "Ubicacion depar en Edidicio: %s\n"
                    + "Constructora:\nNombre de constructora: %s - "
                    + "Id empresa: %s\n",
                    cadena, i+1,
                    d.getPropietario().getNombrePro(),
                    d.getPropietario().getApellidoPro(),
                    d.getPropietario().getIdPro(),
                    d.getPrecioMC(),
                    d.getNumeroMC(),
                    d.getValorMensual(),
                    d.getCostoFinal(),
                    d.getPrecio(),
                    d.getUbicacion().getNumeroCasa(),
                    d.getUbicacion().getNombreBarrio(),
                    d.getUbicacion().getReferencia(),
                    d.getCiudad().getNombreCiudad(),
                    d.getCiudad().getNombreProvin(),
                    d.getNombreEdifico(),
                    d.getUbiDepar(),
                    d.getConstructora().getNombreCons(),
                    d.getConstructora().getIdEmpresa());
        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
    
}
