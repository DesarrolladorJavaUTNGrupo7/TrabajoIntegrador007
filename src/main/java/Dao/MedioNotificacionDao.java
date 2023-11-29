package Dao;

import Config.DBConfig;
import Models.Comercial.Cliente;
import Models.RRHH.MedioDeNotificacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class MedioNotificacionDao {

    private EntityManager entityManager;

    public MedioNotificacionDao() {
        entityManager = DBConfig.getEntityManager();
    }

    public void create(MedioDeNotificacion entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(entity);
        tx.commit();
    }

    public MedioDeNotificacion update(MedioDeNotificacion entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        MedioDeNotificacion entityMerged = entityManager.merge(entity);
        tx.commit();
        return entityMerged;
    }

    public void delete(MedioDeNotificacion entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(entity);
        tx.commit();
    }



    public MedioDeNotificacion findOne(int id) {
        return entityManager.find(MedioDeNotificacion.class, id);
    }

    public List<MedioDeNotificacion> findAll(){
        return entityManager.createQuery("from " + MedioDeNotificacion.class.getName()).getResultList();
    }

    public void closeEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
