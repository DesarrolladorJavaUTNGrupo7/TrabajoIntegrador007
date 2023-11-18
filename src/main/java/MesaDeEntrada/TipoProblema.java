package MesaDeEntrada;

import RRHH.Especialidad;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "tipo_problema")
@Getter @Setter
public class TipoProblema {
    @Id
    @Column(name="id_tipo_problema")
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tiempo_de_resolucion_maximo")
    private Double tiempoDeResolucionMaximo;

    @OneToMany
    @JoinColumn(name = "especialidades", referencedColumnName = "id_especialidad")
    private List<Especialidad> especialidades;
}
