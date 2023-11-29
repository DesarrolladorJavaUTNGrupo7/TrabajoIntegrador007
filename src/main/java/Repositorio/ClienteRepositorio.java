package Repositorio;

import Models.Comercial.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClienteRepositorio {

    private EntityManager entityManager;

    public ClienteRepositorio() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA_PU");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    public Cliente findById(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    public List<Cliente> findAll() {
        return entityManager.createQuery("SELECT e FROM YourEntity e", Cliente.class).getResultList();
    }

    public void close() {
        entityManager.close();
    }

}
