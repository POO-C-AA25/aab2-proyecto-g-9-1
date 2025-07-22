package POO_Proyecto_B2;

import java.util.ArrayList;
import java.util.List;

public class Estadistica {

    List<Carrera> carrerasBajoCupo = new ArrayList<>();
    List<Carrera> carrerasRechazadas = new ArrayList<>();

    public void analizar(List<Carrera> carreras) {
        for (Carrera c : carreras) {
            if (c.admitidos.size() < c.cupos / 2) {
                carrerasBajoCupo.add(c);
            }
            if (c.postulantes.size() > c.cupos && c.admitidos.size() < c.postulantes.size()) {
                carrerasRechazadas.add(c);
            }
        }
    }

    public void mostrarEstadisticas() {
        System.out.println("Carreras con menos del 50% de cupos cubiertos:");
        for (Carrera c : carrerasBajoCupo) {
            System.out.println("- " + c.nombre);
        }

        System.out.println("\nCarreras que rechazaron postulantes por falta de cupos:");
        for (Carrera c : carrerasRechazadas) {
            System.out.println("- " + c.nombre);
        }
    }
}
