package POO_Proyecto_B2;

public class Postulante {

    String nombre;
    String cedula;
    Carrera carreraDeseada;
    double puntajeExamen;
    String tipoMerito;

    public Postulante(String nombre, String cedula, Carrera carreraDeseada, double puntajeExamen, String tipoMerito) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.carreraDeseada = carreraDeseada;
        this.puntajeExamen = puntajeExamen;
        this.tipoMerito = tipoMerito;
    }

    public double calcularMeritos() {
        double adicional = 0;
        if (tipoMerito.equalsIgnoreCase("Abanderado")) {
            adicional += 5;
        } else if (tipoMerito.equalsIgnoreCase("Bachiller afín")) {
            adicional += 2;
        } else if (tipoMerito.equalsIgnoreCase("Capacidad especial")) {
            adicional += 3;
        }
        return adicional;
    }

    public double calcularPuntajeTotal() {
        return puntajeExamen + calcularMeritos();
    }

    public boolean requiereNivelacion() {
        return carreraDeseada.tipoAdmision.equalsIgnoreCase("DIAGNOSTICO") && puntajeExamen < carreraDeseada.puntajeNivelacion;
    }
}
