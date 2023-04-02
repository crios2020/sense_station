package ar.org.centro35.sense_station.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalTime;
import ar.org.centro35.sense_station.connectors.Connector;

public class TestConnection {
    public static void main(String[] args) {

        //Objetos MOCKS Objetos Simulados

        System.out.println("Iniciando conexión: "+LocalTime.now());
        try (Connection conn=Connector.getConnection()) {
            System.out.println("Conexión obtenida: "+LocalTime.now());
            ResultSet rs=conn.createStatement().executeQuery("select version()");
            if(rs.next()) System.out.println(rs.getString(1));
            System.out.println("Connexión Exitosa");
            System.out.println("Resultado obtenido: "+LocalTime.now());
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Conexión Fallida");
        }
        System.out.println("Conexión cerrada: "+LocalTime.now());
    }
}
