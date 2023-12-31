package Models.RRHH;

import Models.MesaDeEntrada.Notificacion;
import javax.persistence.*;

@Entity
@DiscriminatorValue("whatsapp")
public class Whatsapp extends MedioDeNotificacion {

    public Whatsapp(String nombre, String medio) {
        super(nombre, medio);
    }

    @Override
    public void enviarNotificacion(Notificacion notificacion) {
        System.out.println("Notificacion enviada por Whatsapp al numero " + super.getMedio() + " con el mensaje: " + notificacion.toString());
    }
}
