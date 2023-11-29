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
        MedioDeNotificacion medio = new Mail("Email", "email2@hotmail.com");
        medioRepository.create(medio);

        // Obtener el medio de notificación guardado
        MedioDeNotificacion medioGuardado = medioRepository.findOne(medio.getId());
        System.out.println(medioGuardado);



        // Crear el cliente usando el medio de notificación guardado
//        ClienteRepository clienteRepository = new ClienteRepository();
        Cliente cliente1 = new Cliente("93629231", "Martin");
        System.out.println(cliente1);
//        clienteRepository.create(cliente1);

//        System.out.println(clienteRepository.findAll());

        // Cerrar EntityManagers después de realizar las operaciones
//        clienteRepository.closeEntityManager();
        medioRepository.closeEntityManager();

    }
}


