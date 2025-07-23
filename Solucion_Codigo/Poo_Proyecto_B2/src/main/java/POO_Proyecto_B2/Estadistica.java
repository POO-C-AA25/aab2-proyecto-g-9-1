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

    public String mostrarCarrerasMenorMitad() {
        String salida = null;
        for (Carrera c : carrerasBajoCupo)
             salida += ("- " + c.nombre);
        return salida;
    }
    public String mostrarCarrerasRechazaron {
        String salida = null; 
        for (Carrera c : carrerasRechazadas) 
            salida += ("- " + c.nombre);
        return salida;
    }
}
