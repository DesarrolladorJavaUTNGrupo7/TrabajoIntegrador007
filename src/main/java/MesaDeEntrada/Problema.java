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

    public void setTiempoDeResolucion(Tecnico tecnico){
        //TODO
    }

    public Double getTiempoDeResolucion(){
        return 0.0; //TODO
    }

