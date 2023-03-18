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
        PanamaHitek_MultiMessage multi = new PanamaHitek_MultiMessage(2, ino);
        try {
            ino.arduinoRX("/dev/ttyUSB0", 9600, (SerialPortEvent serialPortEvent) -> {
                try {
                    if (multi.dataReceptionCompleted()) {
                        System.out.println(multi.getMessage(0));
                        System.out.println(multi.getMessage(1));
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
