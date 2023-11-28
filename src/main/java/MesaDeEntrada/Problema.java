package MesaDeEntrada;

import RRHH.Tecnico;
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

    @OneToOne
    @JoinColumn(name="tipo", referencedColumnName="id_tipo_problema")
    private TipoProblema tipo;

    @Column(name = "es_complejo")
    private Boolean esComplejo;

    @Column(name = "colchon_horas")
    private Double colchonHoras;

    @Column(name = "tiempo_de_resolucion")
    private Double tiempoDeResolucion;

    public Problema(String descripcion, Boolean esComplejo, Double colchonHoras, TipoProblema tipo) {
        this.descripcion = descripcion;
        this.esComplejo = esComplejo;
        this.colchonHoras = colchonHoras;
        this.tipo = tipo;
    }

    private void setTiempoDeResolucion(Tecnico tecnico){
        Double tiempoDelTecnico;

        boolean aux = tecnico.getTiemposPersonalizados().stream().anyMatch( elemento -> {
            boolean validador = elemento.getTipoProblema().equals(this.getTipo());

            if (validador) {
                tiempoDelTecnico = elemento.getTiempoEstimado();
                return true;
            }

            return false;
        });

        if (!aux) {
            this.tiempoDeResolucion = this.tipo.getTiempoDeResolucionMaximo();
        } else {
            this.tiempoDeResolucion = tiempoDelTecnico;
        };
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
        };
    }
}
