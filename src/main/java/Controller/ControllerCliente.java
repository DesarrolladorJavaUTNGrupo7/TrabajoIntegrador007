package Controller;

import Models.Comercial.Cliente;
import Models.RRHH.MedioDeNotificacion;
import Repositorio.ClienteRepository;

public class ControllerCliente {
    public static void inicializar(MedioDeNotificacion medioNuevo) {
        ClienteRepository clienteRepository = new ClienteRepository();
        Cliente cliente1 = new Cliente("93629231", "Martin");
        cliente1.setMedioNotificacion(medioNuevo);
        System.out.println(cliente1);
        clienteRepository.create(cliente1);

        System.out.println(clienteRepository.findAll());

        clienteRepository.closeEntityManager();
    }
}
