import Comercial.Cliente;
import Comercial.Servicio;
import MesaDeEntrada.Incidente;
import MesaDeEntrada.Notificacion;
import MesaDeEntrada.Problema;
import MesaDeEntrada.TipoProblema;
import RRHH.Especialidad;
import RRHH.Informe;
import RRHH.Mail;
import RRHH.MedioDeNotificacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Especialidad> listaEspecialidades = new ArrayList<>();
        Especialidad EspecialidadAplicaciones = new Especialidad("Aplicacones","especialista en aplicaciones");
        listaEspecialidades.add(EspecialidadAplicaciones);

        TipoProblema tipoProblema1 = new TipoProblema("SAP", "Aplicacion SAP no funciona", 3.5, listaEspecialidades);
        Servicio servicio1 = new Servicio("Aplicaciones","servicio para Aplicaciones",tipoProblema1);
        List<Servicio> serviciosContratados = new ArrayList<>();
        serviciosContratados.add(servicio1);


        Problema problema1 = new Problema("problema1",true,2.3,tipoProblema1);

        //Posible dependencia ciclica entre cliente y notificacion!!
        /*
        Cliente cliente1 = new Cliente("20-30225678-2","Pepito", medioNotificacionEMail,serviciosContratados,);
        Notificacion notificaion1 = new Notificacion("primer Notificacion",cliente1,problema1);
        List<Notificacion> notificaciones = new ArrayList<>();
        MedioDeNotificacion medioNotificacionEMail = new Mail("mensaje1","email");
        */


        LocalDateTime FechaIngresoINC1 = LocalDateTime.now();
        LocalDateTime FechaCierreINC1 = FechaIngresoINC1.plusDays(3);

        // Incidente INC1 = new Incidente(FechaIngresoINC1, false, "Incidente de prueba", "Este es el primer INC", FechaCierreINC1,);
    }

}