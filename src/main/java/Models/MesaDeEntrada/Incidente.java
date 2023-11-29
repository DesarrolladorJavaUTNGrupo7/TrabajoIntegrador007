package Models.MesaDeEntrada;

import Models.Comercial.Cliente;
import Models.Comercial.Servicio;
import Models.RRHH.Tecnico;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    //se cambia tipo de dato Date por DateTime para hacer pruebas
    @Column(name="fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @Column(name="esta_resuelto")
    private boolean estaResuelto;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="consideracion")
    private String consideracion;

    //se cambia tipo de dato Date por DateTime para hacer pruebas
    @Column(name = "fecha_cierre")
    private LocalDateTime fechaCierre;

    @OneToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "tecnico", referencedColumnName = "id_tecnico")
    private Tecnico tecnico;

    @OneToOne
    @JoinColumn(name = "servicio", referencedColumnName = "id_servicio")
    private Servicio servicio;

    @OneToMany
    @JoinColumn(name = "problemas")
    private List<Problema> problemas;

    @Column(name="tiempo_de_resolucion_especifico")
    private double tiempoDeResolucionEspecifico;


    //se cambia tipo de dato Date por DateTime para hacer pruebas
    public Incidente(LocalDateTime fechaIngreso, String descripcion, Cliente cliente, Tecnico tecnico, Servicio servicio) {
        this.fechaIngreso = fechaIngreso;
        this.estaResuelto = false;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.servicio = servicio;
        this.problemas = new ArrayList<>();
    }


    public void agregarProblema(Problema problema){
        problemas.add(problema);
  }


    public void generarNotificacion(String titulo){
         Notificacion notificacion = new Notificacion(titulo, this.descripcion,this);

        tecnico.agregarNotificacion(notificacion);
    }

    public void calcularYSetearTiempoResolucionEspecifico(){
        this.tiempoDeResolucionEspecifico=0;
      
        for (Problema x: problemas) {
            this.tiempoDeResolucionEspecifico+= x.getTiempoDeResolucion();
        }
    }

    public void incidenteResuelto(String consideracion){
        this.setConsideracion(consideracion);
        this.setEstaResuelto(true);
    }

    public Cliente obtenerCliente(String razonSocial, String cuit){

        if (razonSocial.equals(cliente.getRazonSocial()) && cuit.equals(cliente.getCuit())){

        return getCliente();
        }

        return null;
    }
}
