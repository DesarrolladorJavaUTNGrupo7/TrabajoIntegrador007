package Comercial;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="provision_servicio")
@Setter @Getter
public class ProvisionServicio {

    @Id
    @Column(name="id_provision_servicio")
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private Integer id;

    @ManyToOne
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name="servicio", referencedColumnName="id_servicio")
    private Servicio servicio;

    @Column(name="fecha_de_contrato")
    private Date fechaDeContrato;

    @Column(name="fecha_de_vencimiento")
    private Date fechaDeVencimiento;

    public ProvisionServicio() {
    }

    public ProvisionServicio(Cliente cliente, Servicio servicio, Date fechaDeContrato, Date fechaDeVencimiento) {
        this.cliente = cliente;
        this.servicio = servicio;
        this.fechaDeContrato = fechaDeContrato;
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public boolean servicioVigente(){

        //TODO

        System.out.println("Crear Codigo del metodo");
        return true;
    }
}
