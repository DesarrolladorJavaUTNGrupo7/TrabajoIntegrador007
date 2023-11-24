package Comercial;

import RRHH.MedioDeNotificacion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="cliente")
@Setter @Getter
public class Cliente {

    @Id
    @Column(name="id_cliente")
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private Integer id;

    @Column(name="cuit")
    private String cuit;

    @Column(name="razon_social")
    private String razonSocial;

    @OneToOne
    @JoinColumn(name = "medio_notificacion", referencedColumnName = "id_medio_de_notificacion")
    private MedioDeNotificacion medioNotificacion;

    @OneToMany
    @JoinColumn(name = "lista_servicio", referencedColumnName = "id_servicio")
    private List<Servicio> listaServicio;

    public Cliente(String cuit, String razonSocial, MedioDeNotificacion medioNotificacion, List<Servicio> listaServicio) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.medioNotificacion = medioNotificacion;
        this.listaServicio = listaServicio;
    }
}
