package paquetecinco;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author Jose Cordova
 */
public class ArchivoLecturaConstructora {
    private ObjectInputStream entrada;
    private ArrayList<Constructora> ciud;
    private String nombreArchivo;
    private Constructora buscarObjeto;
    private boolean booleanBuscado;
    
    public ArchivoLecturaConstructora(String nA) {
        nombreArchivo = nA;
        File f = new File(getNombreArchivo());
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(nA));
            } catch (IOException ioException) {
                System.err.println("Error al abrir el archivo." + ioException);
            }
        }
    }
    
    public void setNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public void setListaCons() {
        ciud = new ArrayList<>();
        File f = new File(getNombreArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    ciud.add(registro);
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
    
      public void setBuscarObjeto(String n) {
        setListaCons();
        ArrayList<Constructora> listaCons = getListaCons();
        for (int i = 0; i < listaCons.size(); i++) {
            Constructora co = listaCons.get(i);
            if (co.getIdEmpresa().equals(n)) {
                buscarObjeto = co;
            }
        }
    }

    public void setBooleanBuscado() {
        boolean bandera = true;
        if (buscarObjeto != null) {
            bandera = false;
        }
        booleanBuscado = bandera;
    }

    public ArrayList<Constructora> getListaCons() {
        return ciud;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public Constructora getBuscarObjeto() {
        return buscarObjeto;
    }

    public boolean getBooleanBuscado() {
        return booleanBuscado;
    }

    
 
    public void cerrarArchivo() throws IOException {
        if (entrada != null) {
            entrada.close();
        } 
    }

    @Override
    public String toString() {
        String cadena = "Lista Constructoras\n";
        for (int i = 0; i < getListaCons().size(); i++) {
            Constructora co = getListaCons().get(i);
            cadena = String.format("%sConstructora %d:\n"
                    + "Nombre construcota: %s --- "
                    + "Id empresa %s\n",
                    cadena, i + 1,
                    co.getNombreCons(),
                    co.getIdEmpresa());
        }
        return cadena;
    }
    
}

    

