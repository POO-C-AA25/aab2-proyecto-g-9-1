package POO_Proyecto_B2;

import java.util.*;
import java.util.List;

public class Ejecutor_SistemaAdmisiones {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner in = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de estudiantes: ");
        int limite = in.nextInt();
        Carrera programacion = new Programacion();
        Carrera medicina = new Medicina();
        Carrera telecomunicaciones = new Telecomunicaciones();

        List<Carrera> carreras = new ArrayList<>();
        carreras.add(programacion);
        carreras.add(medicina);
        carreras.add(telecomunicaciones);
        List<Postulante> postulantes = new ArrayList<>();

        for (int i = 0; i < limite; i++) {
            System.out.println("ingrese el nombre del estudiante ");
            String nombre = in.next();
            System.out.println("ingrese su cedula: ");
            String cedula = in.next();
            Carrera carreraDeseada = null;
            int sel;
            do {
                System.out.println("A que carrera desea ingresar?\n [1] Medicina \n [2] Programacion \n [3] Telecomunicaciones \n [0] salir");
                sel = in.nextInt();
                switch (sel) {
                    case 1 ->
                        carreraDeseada = medicina;
                    case 2 ->
                        carreraDeseada = programacion;
                    case 3 ->
                        carreraDeseada = telecomunicaciones;
                    default ->
                        System.out.println("");
                }
            } while (sel != 0);

            System.out.println("Ingrese su puntaje del examen: ");
            double puntajeExamen = in.nextDouble();
            System.out.println("Ingrese su tipo de merito: ");
            String tipoMerito = in.next();
            Postulante e = new Postulante(nombre, cedula, carreraDeseada, puntajeExamen, tipoMerito);
            e.calcularMeritos();
            e.calcularPuntajeTotal();
            e.requiereNivelacion();
            postulantes.add(e);
        }
        int sel;
        do {
            System.out.println("--Menu--");
            System.out.println("[1] Crear archivo postulantes.csv y enviar informacion");
            System.out.println("[2] Cargar desde archivo");
            System.out.println("[0] Finalizar");
            sel = in.nextInt();
            switch (sel) {
                case 1 ->
                    sistema.crearTablaPostulantesCSV("postulantes.csv", postulantes, carreras);
                case 2 ->
                    sistema.cargarPostulantesDesdeCSV("postulantes.csv", postulantes, carreras);
                default ->
                    System.out.println("");
            }
        } while (sel != 0);

        for (Carrera carrera : carreras) {
            carrera.procesarAdmisiones();
            System.out.println("Admitidos en " + carrera.nombre + ": " + carrera.admitidos.size());
        }

        Estadistica estadistica = new Estadistica();

        estadistica.analizar(carreras);
        System.out.println("Carreras con menos del 50% de cupos cubiertos:");
        System.out.println(estadistica.mostrarCarrerasMenorMitad());
        System.out.println("\nCarreras que rechazaron postulantes por falta de cupos:");
        System.out.println(estadistica.mostrarCarrerasRechazaron());
    }
}
