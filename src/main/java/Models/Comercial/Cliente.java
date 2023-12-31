package Models.Comercial;

import Models.MesaDeEntrada.Notificacion;
import Models.RRHH.MedioDeNotificacion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="cliente")
@Setter @Getter
public class Cliente {

    @Id
    @Column(name="id_cliente")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="cuit")
    private String cuit;

    @Column(name="razon_social")
    private String razonSocial;

    @OneToOne
    @JoinColumn(name = "medio_notificacion")
    private MedioDeNotificacion medioNotificacion;

    @OneToMany(mappedBy = "cliente")
    private List<Servicio> listaServicio;

    @OneToMany(mappedBy = "cliente")
    private List<Notificacion> notificaciones;

    public Cliente(String cuit, String razonSocial) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
//        this.medioNotificacion = medioNotificacion;
        this.listaServicio = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    public Cliente() {

    }


    public void agregarServicio(Servicio servicio){
        this.listaServicio.add(servicio);
    }

    public void agregarMensajeYNotificar(Notificacion notificacion){
        this.notificaciones.add(notificacion);
        this.medioNotificacion.enviarNotificacion(notificacion);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cuit='" + cuit + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", medioNotificacion=" + medioNotificacion +
                '}';
    }
}
