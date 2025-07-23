package POO_Proyecto_B2;

public class Programacion extends Carrera {

    public Programacion() {
        super("Programación", "ADMISION", 60.0, 30);
    }

    @Override
    public void procesarAdmisiones() {
        validarAdmision();
    }
}
