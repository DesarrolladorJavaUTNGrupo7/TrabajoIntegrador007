package MesaDeEntrada;

import Comercial.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Notificacion {
    private String titulo;
    private String cuerpo;
    private Incidente incidente;
    private boolean fueEnviado;
    private LocalDate fechaEnvioNotificacion;

    public Notificacion(String titulo, String cuerpo, Incidente incidente) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.incidente = incidente;
        this.fueEnviado = false;
        //this.fechaEnvioNotificacion = fechaEnvioNotificacion;
    }



    @Override
    public String toString() {
        return "Notificacion{" +
                "titulo='" + titulo + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                ", incidente=" + incidente +
                ", fueEnviado=" + fueEnviado +
                ", fechaEnvioNotificacion=" + fechaEnvioNotificacion +
                '}';
    }
}
