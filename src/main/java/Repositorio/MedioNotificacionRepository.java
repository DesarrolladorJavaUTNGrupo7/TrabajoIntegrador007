package Repositorio;

import Models.RRHH.MedioDeNotificacion;
import Dao.MedioNotificacionDao;

import java.util.List;

public class MedioNotificacionRepository {
    private MedioNotificacionDao dao = new MedioNotificacionDao();

    public void create(MedioDeNotificacion medioDeNotificacion){
        if(validate(medioDeNotificacion))
            dao.create(medioDeNotificacion);
        System.out.println(validate(medioDeNotificacion));
    }



    private boolean validate(MedioDeNotificacion medioDeNotificacion) {

         //Verifica si el correo no está vacío y si es válido
        System.out.println(isValidEmail(medioDeNotificacion.getMedio()));
        return medioDeNotificacion != null && !medioDeNotificacion.getMedio().isEmpty() && isValidEmail(medioDeNotificacion.getMedio());
        //return true;
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public MedioDeNotificacion findOne(int id){
        return dao.findOne(id);
    }

    public List<MedioDeNotificacion> findAll(){
        return dao.findAll();
    }

    public void closeEntityManager() {
        dao.closeEntityManager();
    }
}
