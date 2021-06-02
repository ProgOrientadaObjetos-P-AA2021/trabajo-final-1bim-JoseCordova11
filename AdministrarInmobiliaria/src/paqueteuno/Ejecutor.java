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
        String nArch = "Propietarios.txt";
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

        ArchivoLecturaPropietario lectura = new ArchivoLecturaPropietario(nArch);
        lectura.setListaPro();
        System.out.println(lectura);

    }

    public static void ingresarUbicacion() {
        Scanner read = new Scanner(System.in);
        String nArchivo = "Ubicacion.txt";
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

        ArchivoLecturaUbicacion lecturaU = new ArchivoLecturaUbicacion(nArchivo);
        lecturaU.setListaUbi();
        System.out.println(lecturaU);
    }

    public static void ingresarCiudad() {
        Scanner read = new Scanner(System.in);
        String nArchivo = "Ciudad.txt";
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

        ArchivoLecturaCiudad lecturaCi = new ArchivoLecturaCiudad(nArchivo);
        lecturaCi.setListaCiu();
        System.out.println(lecturaCi);

    }

    public static void ingresarConstructora() {
        Scanner read = new Scanner(System.in);
        String nArchivo = "Constructora.txt";
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

        ArchivoLecturaConstructora lectura = new ArchivoLecturaConstructora(nArchivo);
        lectura.setListaCons();
        System.out.println(lectura);
    }

    public static void ingresarCasa() {
        Scanner entrada = new Scanner(System.in);
        String nombreArchivo = "casa.txt";
        String pro;
        double precioMC;
        double numeroMC;
        String ubi;
        String nCiu;
        int numeroCuartos;
        String idE;

        System.out.println("Ingrese el precio por metro cuadrado");
        precioMC = entrada.nextDouble();

        System.out.println("Ingrese el número de metros cuadrados");
        numeroMC = entrada.nextInt();

        System.out.println("Ingrese el número de cuartos");
        numeroCuartos = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Ingrese la identificación del propietario");
        pro = entrada.next();

        ArchivoLecturaPropietario lecturaPro = new ArchivoLecturaPropietario("propietarios.txt");
        lecturaPro.setListaPro();
        lecturaPro.setBuscarObjeto(pro);
        Propietario propietario = lecturaPro.getBuscarObjeto();
        if (propietario != null) {
            System.out.println(propietario);
        } else {
            System.out.println("Propietario no registrado");
        }

 
        System.out.println("Ingrese el número de casa");
        ubi = entrada.next();

        ArchivoLecturaUbicacion lecturaUbi = new ArchivoLecturaUbicacion("ubicaciones.txt");
        lecturaUbi.setListaUbi();
        lecturaUbi.setBuscarObjeto(ubi);
        Ubicacion ubicacion = lecturaUbi.getBuscarObjeto();
        if (ubicacion != null) {
            System.out.println(ubicacion);
        } else {
            System.out.println("Ubicacion no registrada");
        }

        entrada.nextLine();


        System.out.println("Ingrese el nombre de la ciudad");
        nCiu = entrada.nextLine();

        ArchivoLecturaCiudad lecturaCiu = new ArchivoLecturaCiudad("ciudades.data");
        lecturaCiu.setListaCiu();
        lecturaCiu.setBuscarObjeto(nCiu);
        Ciudad ciudad = lecturaCiu.getBuscarObjeto();
        if (ciudad != null) {
            System.out.println(ciudad);
        } else {
            System.out.println("Ciudad no registrada");
        }

        System.out.println("Ingrese el ID de la empresa");
        idE = entrada.next();

        ArchivoLecturaConstructora lecturaCons = new ArchivoLecturaConstructora("constructora.data");
        lecturaCons.setListaCons();
        lecturaCons.setBuscarObjeto(idE);
        Constructora constructora = lecturaCons.getBuscarObjeto();
        if (constructora != null) {
            System.out.println(constructora);
        } else {
            System.out.println("Constructora no registrada\n");
        }

        Casa casa = new Casa(propietario, precioMC, numeroMC,
                ubicacion, ciudad, numeroCuartos, constructora);
        casa.setCostoFinal();
        System.out.println(casa);


        ArchivoEscrituraCasa archivo = new ArchivoEscrituraCasa(nombreArchivo);
        archivo.establecerRegistroCasa(casa);
        archivo.establecerSalida();
        archivo.cerrarArchivo();

    }

    public static void ingresarDepartamento() {
        Scanner entrada = new Scanner(System.in);
        String nArchivo = "casas.txt";
        String nArchivo1 = "propietarios.txt";
        String nArchivo2 = "ubicaciones.txt";
        String nArchivo3 = "ciudades.txt";
        String nArchivo4 = "constructoras.txt";
        String nomPro = "";
        String apePro = "";
        String idPro;
        double precioMC;
        double numeroMC;
        String nombreB = "";
        String referencia = "";
        String numeroCasa = "";
        String ciudad;
        String provincia = "";
        String nombreEmp = "";
        String idEmp;
        boolean buscar;
        double valorMensual;
        String nomEdi;
        String ubiDepEdi;
        System.out.println("Ingrese la identificación del Propietario: ");
        idPro = entrada.nextLine();

        ArchivoLecturaPropietario lectura = new ArchivoLecturaPropietario(nArchivo1);
        lectura.setListaPro();
        ArrayList<Propietario> lista = lectura.getListaPro();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdPro().equals(idPro)) {
                nomPro = lista.get(i).getNombrePro();
                apePro = lista.get(i).getApellidoPro();
            }
        }
        Propietario pro = new Propietario(nomPro, apePro, idPro);
        System.out.println("Ingrese el precio por metro cuadrado: ");
        precioMC = entrada.nextDouble();
        System.out.println("Ingrese el número de metros cuadrados: ");
        numeroMC = entrada.nextDouble();
        System.out.println("Ingrese el valor mensual: ");
        valorMensual = entrada.nextDouble();

        System.out.println("Ingrese el número de Casa: ");
        numeroCasa = entrada.next();

        ArchivoLecturaUbicacion lectura2 = new ArchivoLecturaUbicacion(nArchivo2);
        lectura2.setListaUbi();
        ArrayList<Ubicacion> lista2 = lectura2.getListaUbi();
        for (int i = 0; i < lista2.size(); i++) {
            if (numeroCasa.equals(lista2.get(i).getNumeroCasa())) {
            } else {
                nombreB = lista2.get(i).getNombreBarrio();
                referencia = lista2.get(i).getReferencia();
            }
        }
        Ubicacion ubi = new Ubicacion(nombreB, referencia);

        System.out.println("Ingrese el nombre de la ciudad: ");
        ciudad = entrada.nextLine();

        ArchivoLecturaCiudad lectura3 = new ArchivoLecturaCiudad(nArchivo3);
        lectura3.setListaCiu();
        ArrayList<Ciudad> lista3 = lectura3.getListaCiu();
        for (int i = 0; i < lista3.size(); i++) {
            if (lista3.get(i).getNombreCiudad().equals(ciudad)) {
                provincia = lista3.get(i).getNombreProvin();
            }
        }
        Ciudad ciu = new Ciudad(ciudad, provincia);

        System.out.println("Ingrese el nombre del edificio: ");
        nomEdi = entrada.nextLine();
        System.out.println("Ingrese la ubicacion del departamento en el "
                + "edificio: ");
        ubiDepEdi = entrada.nextLine();

        System.out.println("Ingrese ID de constructora: ");
        idEmp = entrada.nextLine();

        ArchivoLecturaConstructora lectura4 = new ArchivoLecturaConstructora(nArchivo4);
        lectura4.setListaCons();
        ArrayList<Constructora> lista4 = lectura4.getListaCons();
        for (int i = 0; i < lista4.size(); i++) {
            if (lista4.get(i).getIdEmpresa().equals(idEmp)) {
                nombreEmp = lista4.get(i).getNombreCons();
            }
        }
        Constructora con = new Constructora(nombreEmp, idEmp);

        Departamento dep1 = new Departamento(pro, precioMC, numeroMC,
                valorMensual, ubi, ciu, nomEdi, ubiDepEdi, con);
        dep1.setCostoFinal();
        ArchivoEscrituraDepar archivo = new ArchivoEscrituraDepar(nArchivo);
        archivo.establecerRegistro(dep1);
        archivo.establecerSalida();
        archivo.cerrarArchivo();
    }

}
