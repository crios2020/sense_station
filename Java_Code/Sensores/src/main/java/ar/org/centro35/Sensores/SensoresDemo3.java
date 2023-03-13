package ar.org.centro35.Sensores;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import com.panamahitek.PanamaHitek_MultiMessage;

import jssc.SerialPortEvent;
import jssc.SerialPortException;

public class SensoresDemo3 extends javax.swing.JFrame {
    private JPanel panel;
    private JLabel lblTemp;
    private JTextField txtTemp;
    private JLabel lblHum;
    private JTextField txtHum;

    public SensoresDemo3() {
        initComponents();
        sensar();
    }

    public void sensar() {
        // Objeto para la conexión con Arduino
        PanamaHitek_Arduino ino = new PanamaHitek_Arduino();

        // Se crea un buffer para la clasificación de mensajes
        PanamaHitek_MultiMessage multi = new PanamaHitek_MultiMessage(2, ino);
        try {
            ino.arduinoRX("/dev/ttyUSB0", 9600, (SerialPortEvent serialPortEvent) -> {
                try {
                    if (multi.dataReceptionCompleted()) {
                        // System.out.println(multi.getMessage(0));
                        // System.out.println(multi.getMessage(1));
                        txtTemp.setText(multi.getMessage(0));
                        txtHum.setText(multi.getMessage(1));
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

    private void initComponents() {
        panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(360, 450);
        this.getContentPane().add(panel);
        this.setTitle("Lector de sensores de Arduino");
        // this.setLayout();
        // this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Temperatura
        lblTemp = new JLabel();
        lblTemp.setText("Temperatura: ");
        panel.add(lblTemp);
        txtTemp = new JTextField();
        txtTemp.setEditable(false);
        txtTemp.setText("100.0");
        panel.add(txtTemp);

        // Humedad
        lblHum = new JLabel();
        lblHum.setText("Humedad: ");
        panel.add(lblHum);
        txtHum = new JTextField();
        txtHum.setEditable(false);
        txtHum.setText("100.0");
        panel.add(txtHum);

    }

    public static void main(String[] args) {
        new SensoresDemo3().setVisible(true);
    }
}
