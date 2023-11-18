package RRHH;

import MesaDeEntrada.Incidente;
import MesaDeEntrada.Notificacion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "tecnico")
@Setter
@Getter
public class Tecnico {

    @Id
    @Column(name = "id_tecnico")
    @GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
    private Integer id;

    @Column(name = "cuit")
    private String cuit;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "medio_de_notificacion_id_medio_de_notificacion")
    private MedioDeNotificacion medioDeNotificacionPreferido;

    @OneToMany(mappedBy = "tecnico")
    private List<Especialidad> especialidades;

    @OneToMany(mappedBy = "tecnico")
    private List<Incidente> incidentes;
    private Notificacion notificacion;

    public Tecnico(String cuit, String nombre, MedioDeNotificacion medioDeNotificacionPreferido, List<Especialidad> especialidades, List<Incidente> incidentes) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.medioDeNotificacionPreferido = medioDeNotificacionPreferido;
        this.especialidades = especialidades;
        this.incidentes = incidentes;
    }

    public void setMedioDeNotificacionPreferido(String medioDeNotificacionPreferido) {
        //TODO

    }

    public void notificarProblema(Notificacion notificacion) {
        this.notificacion = notificacion;
        //TODO

    }
}