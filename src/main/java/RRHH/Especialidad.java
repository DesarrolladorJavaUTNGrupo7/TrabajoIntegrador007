package RRHH;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "especialidad")
@Getter @Setter
public class Especialidad {
    @Id
    @Column(name = "id_especialidad")
    @GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    public Especialidad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
