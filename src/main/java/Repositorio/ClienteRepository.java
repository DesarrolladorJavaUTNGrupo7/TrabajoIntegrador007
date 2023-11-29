package Repositorio;

import Dao.ClientsDao;
import Models.Comercial.Cliente;

import java.util.List;

public class ClienteRepository {
    private ClientsDao dao = new ClientsDao();

    public void create(Cliente unCliente){
        if(validate(unCliente))
            dao.create(unCliente);
    }

    private boolean validate(Cliente unCliente) {
        return true;
    }

    public Cliente findOne(int id){
        return dao.findOne(id);
    }

    public List<Cliente> findAll(){
        return dao.findAll();
    }

    public void closeEntityManager() {
    }
}
