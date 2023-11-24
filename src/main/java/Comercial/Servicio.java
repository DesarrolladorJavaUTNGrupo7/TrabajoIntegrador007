package Comercial;

import MesaDeEntrada.TipoProblema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "servicio")
@Getter @Setter
public class Servicio{

    @Id
    @Column(name="id_servicio")
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name = "tipo_problemas")
    private TipoProblema tipoProblemas;

    public Servicio(String nombre, String descripcion, TipoProblema tipoProblemas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoProblemas = tipoProblemas;
    }
}
