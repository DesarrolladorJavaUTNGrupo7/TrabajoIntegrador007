package MesaDeEntrada;

import Comercial.Cliente;
import Comercial.Servicio;
import RRHH.Tecnico;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table (name = "incidente")
@Setter @Getter
public class Incidente {
    @Id
    @Column(name="id_incidente")
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private Integer id;

    @Column(name="fecha_ingreso")
    private Date fechaIngreso;

    @Column(name="esta_resuelto")
    private boolean estaResuelto;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="consideracion")
    private String consideracion;

    @Column(name="fecha_cliente")
    private Date fechaCliente;

    @Column(name="cliente_id_cliente")
    private Cliente cliente;

    @Column(name="tecnico_id_tecnico")
    private Tecnico tecnico;

    @Column(name="servicio_id_servicio")
    private Servicio servicio;

    @OneToMany
    @JoinColumn(name="problemas", referencedColumnName="id_problema")
    private List<Problema> problemas;

    @Column(name="tiempo_de_resolucion_especifico")
    private double tiempoDeResolucionEspecifico;


    public Incidente(Date fechaIngreso, boolean estaResuelto, String descripcion, String consideracion, Date fechaCliente, Cliente cliente, Tecnico tecnico, Servicio servicio, List<Problema> problemas, double tiempoDeResolucionEspecifico) {
        this.fechaIngreso = fechaIngreso;
        this.estaResuelto = estaResuelto;
        this.descripcion = descripcion;
        this.consideracion = consideracion;
        this.fechaCliente = fechaCliente;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.servicio = servicio;
        this.problemas = problemas;
        this.tiempoDeResolucionEspecifico = tiempoDeResolucionEspecifico;
    }

    public /*List<Tecnico>*/ void obtenerTecnicos(TipoProblema tipoProblema){

        //TODO

        //logica para obtener  lista

        //return new List<Tecnico>(new Tecnico());
    }



    public /*Notificacion*/ void generarNotificacion(Cliente cliente, Problema problema, String descripcion){
        //TODO
        // Notificacion notificacion = new Notificacion(descripcion,cliente,problema);

        //return new Notificacion();
    }

    public void calcularTiempoResolucionEspecifico(){
        System.out.println("Tiempo de resolución específico: " + getTiempoDeResolucionEspecifico());
    }

    public void incidenteResuelto(String consideracion){

        //TODO

        this.setConsideracion(consideracion);
        this.setEstaResuelto(true);
    }

    public Cliente obtenerCliente(String razonSocial, String Cuit){

        //TODO

        return getCliente();
    }
}
