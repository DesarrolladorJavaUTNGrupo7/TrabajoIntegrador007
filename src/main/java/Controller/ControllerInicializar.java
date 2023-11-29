package Controller;

import Dao.MedioNotificacionDao;
import Models.Comercial.Cliente;
import Models.RRHH.Mail;
import Models.RRHH.MedioDeNotificacion;
import Repositorio.ClienteRepository;
import Repositorio.MedioNotificacionRepository;

public class ControllerInicializar {
    public static void inicializar() {
        MedioNotificacionRepository medioRepository = new MedioNotificacionRepository();
        MedioDeNotificacion medio = new Mail("email2@hotmail.com", "Email");
        System.out.println(medio.toString());
        medioRepository.create(medio);

        // Obtener el medio de notificación guardado
        MedioDeNotificacion medioGuardado = medioRepository.findOne(medio.getId());

        // Crear el cliente usando el medio de notificación guardado
        ClienteRepository clienteRepository = new ClienteRepository();
        Cliente cliente = new Cliente("93629231", "Martin", medioGuardado);
        clienteRepository.create(cliente);

        // Cerrar EntityManagers después de realizar las operaciones
        clienteRepository.closeEntityManager();
        medioRepository.closeEntityManager();
    }
}


