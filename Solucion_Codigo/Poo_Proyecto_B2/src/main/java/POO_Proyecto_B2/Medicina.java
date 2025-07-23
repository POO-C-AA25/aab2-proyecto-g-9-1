package POO_Proyecto_B2;

public class Medicina extends Carrera {

    public Medicina() {
        super("Medicina", "ADMISION", 85.0, 20);
    }

    @Override
    public void procesarAdmisiones() {
        validarAdmision();
    }
}
