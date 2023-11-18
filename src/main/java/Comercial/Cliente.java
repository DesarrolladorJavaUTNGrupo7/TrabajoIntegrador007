package Comercial;

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

    @OneToMany
    @JoinColumn(name="provision_servicios", referencedColumnName="id_provision_servicio")
    private List<ProvisionServicio> provisionServicios;

    @Column(name="email")
    private String email;

    @Column(name="direccion")
    private String direccion;

    public Cliente() {
    }

    public Cliente(String cuit, String razonSocial, List<ProvisionServicio> provisionServicios, String email, String direccion) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.provisionServicios = provisionServicios;
        this.email = email;
        this.direccion = direccion;
    }

    public void notificarIncidenteSolucionado(){
        //TODO
        System.out.println("Notificar al cliente que el incidente fue solucionado!");
    }
}
