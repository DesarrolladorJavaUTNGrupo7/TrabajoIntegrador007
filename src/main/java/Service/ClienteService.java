package Service;

import Config.DBConfig;
import Models.Comercial.Cliente;
import Models.RRHH.MedioDeNotificacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ClienteService {
    public void crearCliente(String cuit, String razonSocial, MedioDeNotificacion medioDeNotificacion) {
        EntityManager entityManager = DBConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Cliente cliente = new Cliente();
            cliente.setCuit(cuit);
            cliente.setRazonSocial(razonSocial);
            cliente.setMedioNotificacion(medioDeNotificacion); // Asociar el medio de notificación al cliente

            entityManager.persist(cliente);

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