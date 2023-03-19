package ar.org.centro35.sense_station.demos;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import com.panamahitek.PanamaHitek_MultiMessage;

import jssc.SerialPortEvent;
import jssc.SerialPortException;

public class SensoresDemo {
    public static void main(String[] args) {
        System.out.println("Hola Mundo Sensores!!");

        // Objeto para la conexión con Arduino
        PanamaHitek_Arduino ino = new PanamaHitek_Arduino();

        // Se crea un buffer para la clasificación de mensajes
        PanamaHitek_MultiMessage multi = new PanamaHitek_MultiMessage(10, ino);
        try {
            ino.arduinoRX("/dev/ttyUSB0", 9600, (SerialPortEvent serialPortEvent) -> {
                try {
                    if (multi.dataReceptionCompleted()) {
                        System.out.println("*****************************");
                        System.out.println("Versión del protocolo: "+multi.getMessage(0));
                        System.out.println("Temperatura : "+multi.getMessage(1));
                        System.out.println("Humedad: "+multi.getMessage(2));
                        System.out.println("MQ5: "+multi.getMessage(3));
                        System.out.println("MQ7: "+multi.getMessage(4));
                        System.out.println("BigSound: "+multi.getMessage(5));
                        System.out.println("Flame: "+multi.getMessage(6));
                        System.out.println("Luz: "+multi.getMessage(7));
                        System.out.println("Obstáculos: "+multi.getMessage(8));
                        System.out.println("Inclinación: "+multi.getMessage(9));
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
