package Dao;


import Config.DBConfig;
import Models.Comercial.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ClientsDao {

    private EntityManager entityManager;

    public ClientsDao() {
        entityManager = DBConfig.getEntityManager();
    }

    public void create(Cliente entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(entity);
        tx.commit();
    }

    public Cliente update(Cliente entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Cliente entityMerged = entityManager.merge(entity);
        tx.commit();
        return entityMerged;
    }

    public void delete(Cliente entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(entity);
        tx.commit();
    }

    public Cliente findOne(int id) {
        return entityManager.find(Cliente.class, id);
    }

    public List<Cliente> findAll(){
        return entityManager.createQuery("from " + Cliente.class.getName()).getResultList();
    }

    public void closeEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}