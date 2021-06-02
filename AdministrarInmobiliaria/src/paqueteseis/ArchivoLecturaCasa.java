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
public class ArchivoLecturaCasa {

    private ObjectInputStream entrada;
    private ArrayList<Casa> casa;
    private String nombreArchivo;

    public ArchivoLecturaCasa(String nA) {
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

    public void establecerListaCasa() {
        casa = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    casa.add(registro);
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

    public ArrayList<Casa> obtenerListaCasa() {
        return casa;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista Casas\n";
        for (int i = 0; i < obtenerListaCasa().size(); i++) {
            Casa cas = obtenerListaCasa().get(i);
            cadena = String.format("%s\nCasa %s\n"
                    + "Propietario: \nNombre: %s - "
                    + "Apellido: %s -"
                    + "Identificacion: %s\n"
                    + "Precio del metro cuadrado: %.2f\n"
                    + "Número de metros cuadrados: %.2f\n"
                    + "Costo final: %.2f\n"
                    + "Ubicacion: \nNombre del barrio: %s - "
                    + "Referencia: %s\n"
                    + "Ciudad: \nNombre de la ciudad: %s - "
                    + "Nombre provincia: %s\n"
                    + "Número de cuartos: %d\n"
                    + "Constructora: \nNombre Constructora: %s - "
                    + "Id empresa: %s\n",
                    cadena,
                    i + 1,
                    cas.getPropietarioCasa().getNombrePro(),
                    cas.getPropietarioCasa().getApellidoPro(),
                    cas.getPropietarioCasa().getIdPro(),
                    cas.getPrecioMC(),
                    cas.getNumeroMC(),
                    cas.getCostoFinal(),
                    cas.getUbicacion().getNombreBarrio(),
                    cas.getUbicacion().getReferencia(),
                    cas.getCiudad().getNombreCiudad(),
                    cas.getCiudad().getNombreProvin(),
                    cas.getNumeroCuartos(),
                    cas.getConstructora().getNombreCons(),
                    cas.getConstructora().getIdEmpresa());
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
