package Comercial;

import MesaDeEntrada.TipoProblema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinColumn(name = "tipo_problemas", referencedColumnName = "id_tipo_problema")
    private List<TipoProblema> tipoProblemas;

    public Servicio(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoProblemas = new ArrayList<>();
    }

    public void agregarTipoProblema(TipoProblema tipoProblema){
        this.tipoProblemas.add(tipoProblema);
    }
}
