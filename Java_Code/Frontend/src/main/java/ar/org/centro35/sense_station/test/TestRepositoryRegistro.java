package ar.org.centro35.sense_station.test;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.org.centro35.sense_station.connectors.Connector;
import ar.org.centro35.sense_station.entities.Registro;
import ar.org.centro35.sense_station.repositories.interfaces.I_RegistroRepository;
import ar.org.centro35.sense_station.repositories.jdbc.RegistroRepository;

public class TestRepositoryRegistro {
    public static void main(String[] args) {
        I_RegistroRepository rr=new RegistroRepository(Connector.getConnection());

        Registro registro=new Registro(
            //"2023/04/02",
            LocalDate.now().toString(), 
            //"15:10", 
            LocalTime.now().toString(),
            50, 
            63, 
            180, 
            170, 
            true, 
            false, 
            270, 
            true, 
            false
        );

        rr.save(registro);
        System.out.println(registro);

        System.out.println("***************************************");
        System.out.println(rr.getLast());

        // System.out.println("***************************************");
        // System.out.println(rr.getAvgHour());

        // System.out.println("***************************************");
        // System.out.println(rr.getAvgDay());

        // System.out.println("***************************************");
        // System.out.println(rr.getAvgMonth());

        // System.out.println("***************************************");
        // System.out.println(rr.getAvgYear());

    }
}
