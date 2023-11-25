package RRHH;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
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

    @OneToMany(mappedBy = "tecnico")
    @JoinColumn(name = "especialidades", referencedColumnName = "id_especialidad")
    private List<Especialidad> especialidades;

    @ManyToOne
    @JoinColumn(name = "medio_de_notificacion_preferido", referencedColumnName = "id_medio_de_notificacion")
    private MedioDeNotificacion medioDeNotificacionPreferido;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tiempo_personalizado")
    private List<TiempoEstimadoPorTipoProblema> tiemposPersonalizados;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "esta_disponible")
    private Boolean estaDisponible;

    @Column(name = "notificaciones")
    private List<MedioDeNotificacion> notificaciones;

    public Tecnico(String cuit, List<Especialidad> especialidades, MedioDeNotificacion medioDeNotificacionPreferido, String nombre, List<TiempoEstimadoPorTipoProblema> tiemposPersonalizados, String apellido, LocalDate fechaNacimiento, Boolean estaDisponible, List<MedioDeNotificacion> notificaciones) {
        this.cuit = cuit;
        this.especialidades = especialidades;
        this.medioDeNotificacionPreferido = medioDeNotificacionPreferido;
        this.nombre = nombre;
        this.tiemposPersonalizados = tiemposPersonalizados;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.estaDisponible = estaDisponible;
        this.notificaciones = notificaciones;
    }
}