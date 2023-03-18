package ar.org.centro35.sense_station.app;

import java.time.LocalDate;
import java.time.LocalTime;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import com.panamahitek.PanamaHitek_MultiMessage;
import ar.org.centro35.sense_station.connectors.Connector;
import ar.org.centro35.sense_station.entities.Registro;
import ar.org.centro35.sense_station.repositories.interfaces.I_RegistroRepository;
import ar.org.centro35.sense_station.repositories.jdbc.RegistroRepository;
import jssc.SerialPortEvent;
import jssc.SerialPortException;

public class AplicationServer {
    public static void main(String[] args) {
        System.out.println("Servidor Serial Java Encendido ......");

        I_RegistroRepository rr=new RegistroRepository(Connector.getConnection());

        // Objeto para la conexión con Arduino
        PanamaHitek_Arduino ino = new PanamaHitek_Arduino();

        // Se crea un buffer para la clasificación de mensajes
        PanamaHitek_MultiMessage multi = new PanamaHitek_MultiMessage(2, ino);
        try {
            ino.arduinoRX("/dev/ttyUSB0", 9600, (SerialPortEvent serialPortEvent) -> {
                try {
                    if (multi.dataReceptionCompleted()) {
                        System.out.println("Recibiendo nuevoBuffer de Arduino");
                        System.out.println("Versión de protocolo: "+multi.getMessage(0));
                        Registro registro=new Registro(
                                    LocalDate.now().toString(), 
                                    LocalTime.now().toString(),
                                    Integer.parseInt(multi.getMessage(1)), 
                                    Integer.parseInt(multi.getMessage(2)),
                                    Integer.parseInt(multi.getMessage(3)),
                                    Integer.parseInt(multi.getMessage(4)), 
                                    (multi.getMessage(5).equals("0")?false:true), 
                                    (multi.getMessage(6).equals("0")?false:true),  
                                    Integer.parseInt(multi.getMessage(7)),
                                    (multi.getMessage(8).equals("0")?false:true),
                                    (multi.getMessage(9).equals("0")?false:true)
                                );
                        rr.save(registro);
                        System.out.println(registro);
                        multi.flushBuffer();
                    }
                } catch (ArduinoException | SerialPortException e) {
                    System.out.println(e);
                }
            });
        } catch (ArduinoException | SerialPortException e) {
            System.out.println(e);
        }
    }
}
