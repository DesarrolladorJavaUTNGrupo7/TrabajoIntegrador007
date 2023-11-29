package Service;

import Config.DBConfig;
import Models.RRHH.Mail;
import Models.RRHH.MedioDeNotificacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MedioNotificacionService {
    public void crearMail(String nombre, String medio) {
        EntityManager entityManager = DBConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            MedioDeNotificacion medioNotificacion = new Mail(nombre, medio);
            medioNotificacion.setNombre("EMAIL");
            medioNotificacion.setMedio("Email");

            entityManager.persist(medioNotificacion);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de excepciones, puede variar según tu aplicación
        } finally {
            entityManager.close(); // Cerrar el EntityManager después de su uso
        }
    }
}

