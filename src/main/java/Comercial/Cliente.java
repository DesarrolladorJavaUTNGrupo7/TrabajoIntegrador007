package Comercial;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="cliente")
@Setter @Getter
public class Cliente {

    @Id
    @Column(name="idCliente")
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private Integer id;

    @Column(name="cuit")
    private String cuit;

    @Column(name="razonSocial")
    private String razonSocial;

    @Column(name="") //falta asociar las tablas TODO
    private ArrayList<ProvisionServicio> provisionServicios;

    @Column(name="email")
    private String email;

    @Column(name="direccion")
    private String direccion;

    public Cliente() {
    }

    public Cliente(String cuit, String razonSocial, ArrayList<ProvisionServicio> provisionServicios, String email, String direccion) {
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
