package RRHH;

import MesaDeEntrada.TipoProblema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TiempoEstimadoPorTipoProblema {
    private TipoProblema tipoProblema;

    private Double tiempoEstimado;
}
