package MesaDeEntrada;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "problema")
@Getter @Setter
public class Problema {
    @Id
    @Column(name="id_problema")
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "es_complejo")
    private Boolean esComplejo;

    @Column(name = "colchon_horas")
    private Double colchonHoras;

    @OneToOne
    @JoinColumn(name="tipo", referencedColumnName="id_tipo_problema")
    private TipoProblema tipo;

    public Problema(String descripcion, Boolean esComplejo, Double colchonHoras, TipoProblema tipo) {
        this.descripcion = descripcion;
        this.esComplejo = esComplejo;
        this.colchonHoras = colchonHoras;
        this.tipo = tipo;
    }

    public void setColchonDeHoras(Double horas){
        //TODO
    }
}
