package Models.RRHH;

import Models.MesaDeEntrada.Notificacion;

public class Mail extends MedioDeNotificacion{


    public Mail(String nombre, String medio) {
        super(nombre, medio);
    }

    @Override
    public void enviarNotificacion(Notificacion notificacion) {
        System.out.println("Notificacion enviada por el email " + super.getMedio() + " con el mensaje: " + notificacion.toString());
    }
}
