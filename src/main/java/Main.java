import Comercial.Cliente;
import Comercial.Servicio;
import MesaDeEntrada.Incidente;
import MesaDeEntrada.Notificacion;
import MesaDeEntrada.Problema;
import MesaDeEntrada.TipoProblema;
import RRHH.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


       /* List<Especialidad> listaEspecialidades = new ArrayList<>();
        Especialidad EspecialidadAplicaciones = new Especialidad("Aplicacones","especialista en aplicaciones");
        listaEspecialidades.add(EspecialidadAplicaciones);

        List<TiempoEstimadoPorTipoProblema> tiemposEstimadosPorTipoDeProblema = new ArrayList<>();
        TiempoEstimadoPorTipoProblema tiempoEstimadoPorTipoDeProblemaAplicacion = new TiempoEstimadoPorTipoProblema();
        tiemposEstimadosPorTipoDeProblema.add(tiempoEstimadoPorTipoDeProblemaAplicacion);


        TipoProblema tipoProblema1 = new TipoProblema("SAP", "Aplicacion SAP no funciona", 3.5, listaEspecialidades);
        List<TipoProblema> tiposProblemas = new ArrayList<>();
        tiposProblemas.add(tipoProblema1);
        Servicio servicio1 = new Servicio("Aplicaciones","servicio para Aplicaciones",tiposProblemas);
        List<Servicio> serviciosContratados = new ArrayList<>();
        serviciosContratados.add(servicio1);

        Problema problema1 = new Problema("problema1",true,2.3,tipoProblema1);

        List<Problema> listaproblemas = new ArrayList<>();


        MedioDeNotificacion medioNotificacionEMail = new Mail("mensaje1","email");
        Cliente cliente1 = new Cliente("20-30225678-2","Pepito",medioNotificacionEMail);
        LocalDate nacimientoTecnico= LocalDate.of(1980, 03, 07);
        Tecnico tecnico = new Tecnico("20-20227655-2", listaEspecialidades, medioNotificacionEMail, "Pepe",tiemposEstimadosPorTipoDeProblema, "lalo", nacimientoTecnico, true);


        LocalDateTime fechaIngresoINC1 = LocalDateTime.now();
        LocalDateTime fechaCierreINC1 = fechaIngresoINC1.plusDays(3);

         Incidente INC1 = new Incidente(fechaIngresoINC1, false, "Incidente de prueba", "Este es el primer INC", fechaCierreINC1, cliente1, tecnico, servicio1, listaproblemas, 4);
        LocalDate fechaEnvioNotificacion = LocalDate.now();
         Notificacion notificaion1 = new Notificacion("primer notificacion","Este es un cuerpo de notificacion",INC1);
        List<Notificacion> notificaciones = new ArrayList<>();
        notificaciones.add(notificaion1);*/
    }

}