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
    @Column(name="idProvisionServicio")
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private Integer id;

    @Column(name="Cliente_idCliente") //controlar asociacion con tabla cliente
    private Cliente cliente;

    @Column(name="Servicio_idServicio") //controlar asociacion con tabla servicio
    private Servicio servicio;

    @Column(name="fechaDeContrato")
    private Date fechaDeContrato;

    @Column(name="fechaDeVencimiento")
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
        System.out.println("Crear Codigo del metodo");
        return true;
    }
}
