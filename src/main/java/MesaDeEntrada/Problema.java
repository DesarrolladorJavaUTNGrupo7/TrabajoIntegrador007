package MesaDeEntrada;

import RRHH.Tecnico;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Optional;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "problema")
@Getter @Setter
public class Problema {
    @Id
    @Column(name = "id_problema")
    @GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "tipo", referencedColumnName = "id_tipo_problema")
    private TipoProblema tipo;

    @Column(name = "es_complejo")
    private Boolean esComplejo;

    @Column(name = "colchon_horas")
    private Double colchonHoras;

    @Column(name = "tiempo_de_resolucion")
    private Double tiempoDeResolucion;

    public Problema(String descripcion, Boolean esComplejo, TipoProblema tipo, Double colchonHoras) {
        this.descripcion = descripcion;
        this.esComplejo = esComplejo;
        this.tipo = tipo;
        this.setColchonHoras(colchonHoras);
    }

    private void setTiempoDeResolucion(Tecnico tecnico) {
        Optional<Double> aux = tecnico.tieneTiempoPersonalizado(this.tipo);

        this.tiempoDeResolucion = aux.orElse(this.tipo.getTiempoDeResolucionMaximo());
    }

    public Double getTiempoDeResolucion(Tecnico tecnico) {
        this.setTiempoDeResolucion(tecnico);

        return this.tiempoDeResolucion + this.colchonHoras;
    }

    public void setColchonHoras(Double colchonHoras) {
        if (this.esComplejo) {
            this.colchonHoras = colchonHoras;
        } else {
            this.colchonHoras = 0.0;
        }
    }
}

