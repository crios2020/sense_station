package ar.org.centro35.sense_station.app;

import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import com.panamahitek.PanamaHitek_MultiMessage;

import ar.org.centro35.sense_station.connectors.Connector;
import ar.org.centro35.sense_station.entities.Registro;
import ar.org.centro35.sense_station.repositories.interfaces.I_RegistroRepository;
import ar.org.centro35.sense_station.repositories.jdbc.RegistroRepository;
import ar.org.centro35.sense_station.threads.HoraThread;
import jssc.SerialPortEvent;
import jssc.SerialPortException;

/**
 * UI App Lite protocolo versión 2
 * 
 * @author carlos
 */
public class UIAPPLite extends javax.swing.JFrame {
    private I_RegistroRepository rr=new RegistroRepository(Connector.getConnection());
    /**
     * Creates new form UIAPPLite
     */
    public UIAPPLite() {
        initComponents();
        inicializarComponentes();
    }

    private void inicializarComponentes(){

        //Inicializar prbTemperatura
        prbTemperatura.setMinimum(-40);
        prbTemperatura.setMaximum(125);
        prbTemperatura.setStringPainted(true);

        //Inicializar prbHumedad
        prbHumedad.setMinimum(0);
        prbHumedad.setMaximum(100);
        prbHumedad.setStringPainted(true);

        //Inicializar prbGases
        prbGases.setMinimum(0);
        prbGases.setMaximum(1023);
        prbGases.setStringPainted(true);

        //Inicializar prbIluminacion
        prbIluminacion.setMinimum(0);
        prbIluminacion.setMaximum(1023);
        prbIluminacion.setStringPainted(true);

        //inicializador de fecha y hora
        new Thread(new HoraThread(txtFecha,txtHora)).start();

        //Lector de buffer de Arduino
        // Objeto para la conexión con Arduino
        PanamaHitek_Arduino ino = new PanamaHitek_Arduino();

        txtEstado.setText("Preparando Sensores!");
        txtEstado.setForeground(Color.red);

        // Se crea un buffer para la clasificación de mensajes
        PanamaHitek_MultiMessage multi = new PanamaHitek_MultiMessage(10, ino);

        try {
                ino.arduinoRX("/dev/ttyUSB0", 9600, (SerialPortEvent serialPortEvent) -> {
                    try {
                        if (multi.dataReceptionCompleted()) {
                            // System.out.println("Recibiendo nuevoBuffer de Arduino");
    
                            Registro registro = new Registro(
                                    LocalDate.now().toString(),
                                    LocalTime.now().toString(),
                                    (int) Double.parseDouble(multi.getMessage(1)),
                                    (int) Double.parseDouble(multi.getMessage(2)),
                                    (int) Double.parseDouble(multi.getMessage(3)),
                                    (int) Double.parseDouble(multi.getMessage(4)),
                                    (multi.getMessage(5).equals("0") ? false : true),
                                    (multi.getMessage(6).equals("0") ? false : true),
                                    Integer.parseInt(multi.getMessage(7)),
                                    (multi.getMessage(8).equals("0") ? false : true),
                                    (multi.getMessage(9).equals("0") ? false : true));
    
                            rr.save(registro);
                            txtEstado.setText("Estación Activa!");
                            txtEstado.setForeground(Color.BLUE);
    
                            // Protocolo
                            txtVersion.setText(multi.getMessage(0));
    
                            // Temperatura
                            int temp = registro.getTemperatura();
                            prbTemperatura.setValue(registro.getTemperatura());
                            prbTemperatura.setString(temp+" C");
                            
                            if (temp < 10) {
                                prbTemperatura.setForeground(Color.blue);
                            }
                            if (temp >= 10 && temp < 20) {
                                prbTemperatura.setForeground(Color.cyan);
                           }
                            if (temp >= 20 && temp < 25) {
                                prbTemperatura.setForeground(Color.green);
                            }
                            if (temp >= 25 && temp < 30) {
                                prbTemperatura.setForeground(Color.orange);
                            }
                            if (temp >= 30) {
                                prbTemperatura.setForeground(Color.red);
                            }
    
                            // Humedad
                            int humedad=registro.getHumedad();
                            prbHumedad.setString(humedad + " %");
                            prbHumedad.setValue(humedad);
                            if (humedad < 10) {
                                prbHumedad.setForeground(Color.blue);
                            }
                            if (humedad >= 10 && temp < 20) {
                                prbHumedad.setForeground(Color.cyan);
                           }
                            if (humedad >= 20 && temp < 40) {
                                prbHumedad.setForeground(Color.green);
                            }
                            if (humedad >= 50 && temp < 70) {
                                prbHumedad.setForeground(Color.orange);
                            }
                            if (humedad >= 70) {
                                prbHumedad.setForeground(Color.red);
                            }

                            // MQ7
                            int mq7 = registro.getMq7();
                            prbGases.setValue(mq7);
                            prbGases.setString(mq7+"");
                            if (mq7 >= 160) {
                                prbGases.setForeground(Color.red);
                            } else {
                                prbGases.setForeground(Color.green);
                            }
    
    
                            // Luz
                            int luz = registro.getLuz();
                            prbIluminacion.setValue(luz);
                            if (luz < 200) {
                                prbIluminacion.setString(registro.getLuz() + ": Ambiente muy oscuro");
                                prbIluminacion.setForeground(Color.black);
                            }
                            if (luz >= 200 && luz < 400) {
                                prbIluminacion.setString(registro.getLuz() + ": Ambiente oscuro");
                                prbIluminacion.setForeground(Color.gray);
                            }
                            if (luz >= 400 && luz < 600) {
                                prbIluminacion.setString(registro.getLuz() + ": Ambiente iluminado");
                                prbIluminacion.setForeground(Color.lightGray);
                            }
                            if (luz >= 600) {
                                prbIluminacion.setString(registro.getLuz() + ": Ambiente muy iluminado");
                                prbIluminacion.setForeground(Color.white);
                            }
    
                            multi.flushBuffer();
                        }
                    } catch (ArduinoException | SerialPortException e) {
                        System.out.println(e);
                        txtEstado.setText("Fallo de conexión!");
                        txtEstado.setForeground(Color.RED);
                    }
                });
            } catch (ArduinoException | SerialPortException e) {
                System.out.println(e);
                txtEstado.setText("Fallo de conexión!");
                txtEstado.setForeground(Color.RED);
            } catch (Exception e) {
                System.out.println(e);
                txtEstado.setText("Error de sensores!");
                txtEstado.setForeground(Color.RED);
            }
                                   

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtVersion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        prbTemperatura = new javax.swing.JProgressBar();
        prbHumedad = new javax.swing.JProgressBar();
        prbGases = new javax.swing.JProgressBar();
        prbIluminacion = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sense_Station");

        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Estado del dispositivo:");

        txtEstado.setEditable(false);
        txtEstado.setForeground(new java.awt.Color(51, 51, 255));
        txtEstado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Versión de protocolo:");

        txtVersion.setEditable(false);
        txtVersion.setForeground(new java.awt.Color(51, 51, 255));
        txtVersion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha:");

        txtFecha.setEditable(false);
        txtFecha.setForeground(new java.awt.Color(51, 51, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Hora:");

        txtHora.setEditable(false);
        txtHora.setForeground(new java.awt.Color(51, 51, 255));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Temperatura:");

        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Humedad:");

        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Gases Peligrosos:");

        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Iluminación");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37,
                                                        Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prbGases, javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prbIluminacion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prbTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prbHumedad, javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtVersion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel8)
                                                .addComponent(prbTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(prbHumedad, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel10))
                                        .addComponent(prbGases, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(prbIluminacion, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        //Se quito la piel ninbus por que no permite cambiar los colores en los componentes JProgressBar

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIAPPLite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar prbGases;
    private javax.swing.JProgressBar prbHumedad;
    private javax.swing.JProgressBar prbIluminacion;
    private javax.swing.JProgressBar prbTemperatura;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtVersion;
    // End of variables declaration//GEN-END:variables
}
