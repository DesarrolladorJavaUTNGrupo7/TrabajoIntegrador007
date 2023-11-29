package Models.MesaDeEntrada;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "notificacion")
@Getter @Setter
public class Notificacion {

    @Id
    @Column(name = "id_notificacion")
    @GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "cuerpo")
    private String cuerpo;

    @OneToOne
    @JoinColumn(name = "incidente", referencedColumnName = "id_incidente")
    private Incidente incidente;

    @Column(name = "fue_enviado")
    private boolean fueEnviado;

    @Column(name = "fecha_envio_notificacion")
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
        return "Notificacion{" + '\n' +
                "titulo='" + titulo + '\'' + '\n' +
                "cuerpo='" + cuerpo + '\'' + '\n' +
                "incidente='" + incidente + '\'' + '\n' +
                "fueEnviado='" + fueEnviado + '\'' + '\n' +
                "fechaEnvioNotificacion='" + fechaEnvioNotificacion +
                "'}";
    }
}
