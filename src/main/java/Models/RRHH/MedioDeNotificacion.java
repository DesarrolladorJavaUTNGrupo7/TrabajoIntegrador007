package Models.RRHH;

import Models.MesaDeEntrada.Notificacion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "medio_de_notificacion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter
public abstract class MedioDeNotificacion {

    @Id
    @Column(name="id_medio_de_notificacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="medio")
    private String medio;

    public MedioDeNotificacion(String nombre, String medio) {
        this.nombre = nombre;
        this.medio = medio;
    }

    public MedioDeNotificacion() {

    }

    @Override
    public String toString() {
        return "MedioDeNotificacion{" +
                "id=" + this.id +
                ", nombre='" + this.nombre + '\'' +
                ", medio='" + this.medio + '\'' +
                '}';
    }

    public abstract void enviarNotificacion(Notificacion notificacion);


}


