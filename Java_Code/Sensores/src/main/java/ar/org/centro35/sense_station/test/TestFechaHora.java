package ar.org.centro35.sense_station.test;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestFechaHora {
    public static void main(String[] args) {
        LocalDate ld=LocalDate.now();
        System.out.println(ld);
        LocalTime lt=LocalTime.now();
        System.out.println(lt.toString());
    }
}
