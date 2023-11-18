package MesaDeEntrada;

import Comercial.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Notificacion {
    private String descripcion;
    private Cliente cliente;
    private Problema problema;

    public Notificacion(String descripcion, Cliente cliente, Problema problema) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.problema = problema;
    }

    @Override
    public String toString() {
        return "Notificacion{" +
                "cliente= CUIT " + cliente.getCuit() + " Razon Social: " + cliente.getRazonSocial() + '\'' +
                ", descripcion= " + descripcion + '\'' +
                ", problema=" + problema.toString() +
                '}';
    }
}
