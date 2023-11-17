package Comercial;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "servicio")
@Getter @Setter
public class Servicio{

    @Id
    @Column(name="idServicio")
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    public Servicio(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Servicio() {
    }
}
