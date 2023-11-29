package Models.RRHH;

import Models.MesaDeEntrada.TipoProblema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "tiempo_estimado_por_tipo_problema")
@Getter @Setter
public class TiempoEstimadoPorTipoProblema {
    @Id
    @Column(name = "id_tiempo_estimado_por_tipo_problema")
    @GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tipo_problema", referencedColumnName = "id_tipo_problema")
    private TipoProblema tipoProblema;

    @Column(name = "tiempo_estimado")
    private Double tiempoEstimado;
}
