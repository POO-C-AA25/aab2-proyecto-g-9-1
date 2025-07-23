package POO_Proyecto_B2;

public class Postulante {

    String nombre;
    String cedula;
    Carrera carreraDeseada;
    double puntajeExamen;
    String tipoMerito;
    double merito;
    double puntTot;
    boolean niv;

    public Postulante(String nombre, String cedula, Carrera carreraDeseada, double puntajeExamen, String tipoMerito) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.carreraDeseada = carreraDeseada;
        this.puntajeExamen = puntajeExamen;
        this.tipoMerito = tipoMerito;
    }

    public void calcularMeritos() {
        double adicional = 0;
        if (tipoMerito.equalsIgnoreCase("Abanderado")) {
            adicional += 5;
        } else if (tipoMerito.equalsIgnoreCase("Bachiller afín")) {
            adicional += 2;
        } else if (tipoMerito.equalsIgnoreCase("Capacidad especial")) {
            adicional += 3;
        }
        this.merito += adicional;
    }

    public void calcularPuntajeTotal() {
        this.puntTot = puntajeExamen + this.merito;
    }

    public void requiereNivelacion() {
        this.niv = carreraDeseada.tipoAdmision.equalsIgnoreCase("DIAGNOSTICO") && puntajeExamen < carreraDeseada.puntajeNivelacion;
    }
}
