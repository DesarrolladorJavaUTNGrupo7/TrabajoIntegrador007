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

    @Column(name="Cliente_id_cliente") //controlar asociacion con tabla cliente TODO
    private Cliente cliente;

    @Column(name="Servicio_id_servicio") //controlar asociacion con tabla servicio TODO
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
