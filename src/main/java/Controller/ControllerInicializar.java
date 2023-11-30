package Controller;

import Dao.MedioNotificacionDao;
import Models.Comercial.Cliente;
import Models.RRHH.Mail;
import Models.RRHH.MedioDeNotificacion;
import Repositorio.ClienteRepository;
import Repositorio.MedioNotificacionRepository;

public class ControllerInicializar {
    public static MedioDeNotificacion inicializar() {
        MedioNotificacionRepository medioRepository = new MedioNotificacionRepository();
        MedioDeNotificacion medio = new Mail("Email", "email2@hotmail.com");
        medioRepository.create(medio);

        // Obtener el medio de notificación guardado
        MedioDeNotificacion medioGuardado = medioRepository.findOne(medio.getId());
        System.out.println(medioGuardado);

        medioRepository.closeEntityManager();
        return medioGuardado;
    }
}


