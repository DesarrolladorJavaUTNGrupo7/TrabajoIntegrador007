import Controller.ControllerCliente;
import Controller.ControllerInicializar;
import Models.RRHH.MedioDeNotificacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        MedioDeNotificacion medioNuevo = ControllerInicializar.inicializar();

        ControllerCliente.inicializar(medioNuevo);

    }
}