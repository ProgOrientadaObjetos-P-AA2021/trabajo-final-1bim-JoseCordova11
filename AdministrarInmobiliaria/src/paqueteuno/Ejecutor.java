package paqueteuno;

import java.util.ArrayList;
import java.util.Scanner;
import paquetedos.ArchivoEscrituraPropietario;
import paquetedos.ArchivoLecturaPropietario;
import paquetedos.Propietario;
import paquetetres.ArchivoEscrituraUbicacion;
import paquetetres.ArchivoLecturaUbicacion;
import paquetetres.Ubicacion;
import paquetecuatro.ArchivoEscrituraCiudad;
import paquetecuatro.ArchivoLecturaCiudad;
import paquetecuatro.Ciudad;
import paquetecinco.ArchivoEscrituraConstructora;
import paquetecinco.ArchivoLecturaConstructora;
import paquetecinco.Constructora;
import paqueteseis.ArchivoEscrituraCasa;
import paqueteseis.ArchivoLecturaCasa;
import paqueteseis.Casa;
import paqueteseis.ArchivoEscrituraDepar;
import paqueteseis.ArchivoLecturaDepar;
import paqueteseis.Departamento;

/**
 *
 * @author Jose Cordova
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int opcion;
        String idPro;
        String nCasa;
        String ciudad;
        String idEmpresa;

        do {
            System.out.println("Ingrese una opcion 1-6 o ingrese 0 para salir:\n"
                    + "1. Ingresar un Propietario\n"
                    + "2. Ingresar una Ubicación\n"
                    + "3. Ingresar una Ciudad\n"
                    + "4. Ingresar una Constructora\n"
                    + "5. Ingresar una Casa\n"
                    + "6. Ingresar un Departamento\n"
                    + "0. Salir\n>>");
            opcion = read.nextInt();
            if ((opcion > 0) && (opcion < 7)) {
                switch (opcion) {
                    case 1:
                        ingresarPropietario();
                        break;

                    case 2:
                        ingresarUbicacion();
                        break;

                    case 3:
                        ingresarCiudad();
                        break;

                    case 4:
                        ingresarConstructora();
                        break;

                    case 5:
                        ingresarCasa();
                        break;

                    case 6:
                        ingresarDepartamento();
                        break;
                }
            } else {
                System.out.println("Opcion Incorrecta");
            }
        } while (opcion == 0);
    }

    public static void ingresarPropietario() {
        Scanner read = new Scanner(System.in);
        String nArch = "propietarios.txt";
        String nomPro;
        String apePro;
        String id;

        System.out.println("Ingrese el nombre: ");
        nomPro = read.next();
        System.out.println("Ingrese sus apellidos ");
        apePro = read.next();
        System.out.println("Ingrese su identificación ");
        id = read.next();

        Propietario p = new Propietario(nomPro, apePro, id);
        ArchivoEscrituraPropietario archivo = new ArchivoEscrituraPropietario(nArch);
        archivo.setRegistro(p);
        archivo.setSalida();
        archivo.cerrarArchivo();

        //se muestra la lista de propietarios
        ArchivoLecturaPropietario lectura = new ArchivoLecturaPropietario(nArch);
        lectura.setListaPro();
        System.out.println(lectura);

    }

    public static void ingresarUbicacion() {
        Scanner read = new Scanner(System.in);
        String nArchivo = "ubicaciones.txt";
        String nombreBarrio;
        String numeroCasa;
        String referencia;

        System.out.println("Ingrese el nombre del barrio");
        nombreBarrio = read.nextLine();
        System.out.println("Ingrese el numero de casa");
        numeroCasa = read.nextLine();
        System.out.println("Ingrese una Referencia");
        referencia = read.nextLine();

        Ubicacion u = new Ubicacion(nombreBarrio, numeroCasa, referencia);
        ArchivoEscrituraUbicacion archivo = new ArchivoEscrituraUbicacion(nArchivo);
        archivo.setRegistro(u);
        archivo.setSalida();
        archivo.cerrarArchivo();

        //se muestra la lista ubicaciones
        ArchivoLecturaUbicacion lecturaU = new ArchivoLecturaUbicacion(nArchivo);
        lecturaU.setListaUbi();
        System.out.println(lecturaU);
    }

    public static void ingresarCiudad() {
        Scanner read = new Scanner(System.in);
        String nArchivo = "ciudades.txt";
        String nCiudad;
        String nProvi;
        System.out.println("Ingrese nombre de la ciudad");
        nCiudad = read.next();
        System.out.println("Ingrese el nombre de la provincia");
        nProvi = read.next();

        Ciudad ci = new Ciudad(nCiudad, nProvi);

        ArchivoEscrituraCiudad archivo = new ArchivoEscrituraCiudad(nArchivo);
        archivo.setRegistro(ci);
        archivo.setSalida();
        archivo.cerrarArchivo();

        //se muestra la lista ciudades
        ArchivoLecturaCiudad lecturaCi = new ArchivoLecturaCiudad(nArchivo);
        lecturaCi.setListaCiu();
        System.out.println(lecturaCi);

    }

    public static void ingresarConstructora() {
        Scanner read = new Scanner(System.in);
        String nArchivo = "constructoras.txt";
        String nCons;
        String idEm;
        System.out.println("Ingrese el nombre de la constructora");
        nCons = read.next();
        System.out.println("Ingrese la id de la empresa");
        idEm = read.next();

        Constructora co = new Constructora(nCons, idEm);

        ArchivoEscrituraConstructora archivo = new ArchivoEscrituraConstructora(nArchivo);
        archivo.setRegistro(co);
        archivo.setSalida();
        archivo.cerrarArchivo();

        //Se muestra la lista de constructoras
        ArchivoLecturaConstructora lectura = new ArchivoLecturaConstructora(nArchivo);
        lectura.setListaCons();
        System.out.println(lectura);
    }

    public static void ingresarCasa() {
        Scanner read = new Scanner(System.in);
        String nombreArchivo = "casa.txt";
        String idPro;
        double precioMC;
        double numeroMC;
        String numCasa;
        String nCiu;
        int nCuartos;
        String idEm;

        System.out.println("Ingrese el precio por metro cuadrado");
        precioMC = read.nextDouble();

        System.out.println("Ingrese el número de metros cuadrados");
        numeroMC = read.nextDouble();

        System.out.println("Ingrese el número de cuartos");
        nCuartos = read.nextInt();

        System.out.println("Ingrese la identificación del propietario");
        idPro = read.next();
        ArchivoLecturaPropietario lecturaPro = new ArchivoLecturaPropietario("propietarios.txt");
        lecturaPro.setListaPro();
        lecturaPro.setBuscarObjeto(idPro);

        ArrayList<Propietario> propi;
        propi = lecturaPro.getListaPro();
        String nomPro = "";
        String apePro = "";
        for (int i = 0; i < propi.size(); i++) {
            if (propi.get(i).getIdPro().equals(idPro)) {
                nomPro = propi.get(i).getNombrePro();
                apePro = propi.get(i).getApellidoPro();
            }
        }
        Propietario pro = new Propietario(nomPro, apePro, idPro);

        //
        System.out.println("Ingrese el número de casa");
        numCasa = read.next();
        ArchivoLecturaUbicacion lecturaUbi = new ArchivoLecturaUbicacion("ubicaciones.txt");
        lecturaUbi.setListaUbi();
        lecturaUbi.setBuscarObjeto(numCasa);

        ArrayList<Ubicacion> ubica;
        ubica = lecturaUbi.getListaUbi();
        String nomBa = "";
        String refe = "";
        for (int i = 0; i < ubica.size(); i++) {
            if (ubica.get(i).getNumeroCasa().equals(numCasa)) {
                nomBa = ubica.get(i).getNombreBarrio();
                refe = ubica.get(i).getReferencia();
            }
        }
        Ubicacion ubicacion = new Ubicacion(numCasa, nomBa, refe);

        //
        System.out.println("Ingrese el nombre de la ciudad");
        nCiu = read.next();
        ArchivoLecturaCiudad lecturaCiu = new ArchivoLecturaCiudad("ciudades.txt");
        lecturaCiu.setListaCiu();
        lecturaCiu.setBuscarObjeto(nCiu);

        ArrayList<Ciudad> ciud;
        ciud = lecturaCiu.getListaCiu();
        String nomProvi = "";
        for (int i = 0; i < ciud.size(); i++) {
            if (ciud.get(i).getNombreCiudad().equals(nCiu)) {
                nomProvi = ciud.get(i).getNombreProvin();
            }
        }
        Ciudad ciudad = new Ciudad(nCiu, nomProvi);

        //
        System.out.println("Ingrese el ID de la empresa");
        idEm = read.next();
        ArchivoLecturaConstructora lecturaCons = new ArchivoLecturaConstructora("constructoras.txt");
        lecturaCons.setListaCons();
        lecturaCons.setBuscarObjeto(idEm);

        ArrayList<Constructora> cons;
        cons = lecturaCons.getListaCons();
        String nomCons = "";
        for (int i = 0; i < lecturaCons.getListaCons().size(); i++) {
            if (cons.get(i).getIdEmpresa().equals(idEm)) {
                nomCons = cons.get(i).getNombreCons();
            }
        }
        Constructora constructora = new Constructora(nomCons, idEm);

        Casa casa = new Casa(pro, precioMC, numeroMC,
                ubicacion, ciudad, nCuartos, constructora);
        casa.setCostoFinal();
        System.out.println(casa);

        ArchivoEscrituraCasa archivo = new ArchivoEscrituraCasa("casa.txt");
        archivo.establecerRegistroCasa(casa);
        archivo.establecerSalida();
        archivo.cerrarArchivo();

        ArchivoLecturaCasa lecturaCasa = new ArchivoLecturaCasa("casa.txt");
        lecturaCasa.establecerListaCasa();
        System.out.println(lecturaCasa);
    }

    public static void ingresarDepartamento() {
        Scanner read = new Scanner(System.in);
        String nArchivo = "departamentos.txt";
        String idPro;
        double precioMC;
        double numeroMC;
        double vMensual;
        String numCasa;
        String nCiu;
        int nCuartos;
        String idEm;
        String nomEdi;
        String ubienEdi;

        System.out.println("Ingrese el precio por metro cuadrado: ");
        precioMC = read.nextDouble();
        System.out.println("Ingrese el número de metros cuadrados: ");
        numeroMC = read.nextDouble();
        System.out.println("Ingrese el valor mensual: ");
        vMensual = read.nextDouble();
        System.out.println("Ingrese el nombre del edificio");
        nomEdi = read.next();
        System.out.println("Ingrese la ubicacion del depar dentro edificio");
        ubienEdi = read.next();
        
        System.out.println("Ingrese la identificación del propietario");
        idPro = read.next();
        ArchivoLecturaPropietario lecturaPro = new ArchivoLecturaPropietario("propietarios.txt");
        lecturaPro.setListaPro();
        lecturaPro.setBuscarObjeto(idPro);

        ArrayList<Propietario> propi;
        propi = lecturaPro.getListaPro();
        String nomPro = "";
        String apePro = "";
        for (int i = 0; i < propi.size(); i++) {
            if (propi.get(i).getIdPro().equals(idPro)) {
                nomPro = propi.get(i).getNombrePro();
                apePro = propi.get(i).getApellidoPro();
            }
        }
        Propietario pro = new Propietario(nomPro, apePro, idPro);
        
        //
        System.out.println("Ingrese el número de casa");
        numCasa = read.next();
        ArchivoLecturaUbicacion lecturaUbi = new ArchivoLecturaUbicacion("ubicaciones.txt");
        lecturaUbi.setListaUbi();
        lecturaUbi.setBuscarObjeto(numCasa);

        ArrayList<Ubicacion> ubica;
        ubica = lecturaUbi.getListaUbi();
        String nomBa = "";
        String refe = "";
        for (int i = 0; i < ubica.size(); i++) {
            if (ubica.get(i).getNumeroCasa().equals(numCasa)) {
                nomBa = ubica.get(i).getNombreBarrio();
                refe = ubica.get(i).getReferencia();
            }
        }
        Ubicacion ubicacion = new Ubicacion(numCasa, nomBa, refe);
 
        //
        System.out.println("Ingrese el nombre de la ciudad");
        nCiu = read.next();
        ArchivoLecturaCiudad lecturaCiu = new ArchivoLecturaCiudad("ciudades.txt");
        lecturaCiu.setListaCiu();
        lecturaCiu.setBuscarObjeto(nCiu);

        ArrayList<Ciudad> ciud;
        ciud = lecturaCiu.getListaCiu();
        String nomProvi = "";
        for (int i = 0; i < ciud.size(); i++) {
            if (ciud.get(i).getNombreCiudad().equals(nCiu)) {
                nomProvi = ciud.get(i).getNombreProvin();
            }
        }
        Ciudad ciudad = new Ciudad(nCiu, nomProvi);

        //
        System.out.println("Ingrese el ID de la empresa");
        idEm = read.next();
        ArchivoLecturaConstructora lecturaCons = new ArchivoLecturaConstructora("constructoras.txt");
        lecturaCons.setListaCons();
        lecturaCons.setBuscarObjeto(idEm);

        ArrayList<Constructora> cons;
        cons = lecturaCons.getListaCons();
        String nomCons = "";
        for (int i = 0; i < lecturaCons.getListaCons().size(); i++) {
            if (cons.get(i).getIdEmpresa().equals(idEm)) {
                nomCons = cons.get(i).getNombreCons();
            }
        }
        Constructora constructora = new Constructora(nomCons, idEm);

        Departamento dep = new Departamento(pro, precioMC, numeroMC,
                vMensual, ubicacion, ciudad, nomEdi, ubienEdi, constructora);
        dep.setCostoFinal();
        ArchivoEscrituraDepar archivo = new ArchivoEscrituraDepar(nArchivo);
        archivo.establecerRegistro(dep);
        archivo.establecerSalida();
        archivo.cerrarArchivo();
        
        ArchivoLecturaDepar lecturaDepar = new ArchivoLecturaDepar("departamento.txt");
        lecturaDepar.establecerListaDepar();
        System.out.println(lecturaDepar);
    }

}
