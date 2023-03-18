package ar.org.centro35.sense_station.demos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.plot.ThermometerPlot;
import com.panamahitek.liveinterfaces.PanamaHitek_ThermometerChart;

public class SensoresDemo2 extends javax.swing.JFrame {
    private JPanel jPanel1;
    public SensoresDemo2() {
        initComponents();

        try {
            PanamaHitek_ThermometerChart chart = new PanamaHitek_ThermometerChart("Temperatura - Sensor DHT22");
            chart.setThermometerUnit(ThermometerPlot.UNITS_CELCIUS);
            chart.setChartLimitValues(0, 50);
            chart.setColorDistribuition(50, 20, 30); //Distribución porcentual de colores verde, amarillo y rojo
            chart.insertToPanel(jPanel1);
            //chart.setValue(40);

            //Crea la conexión al arduino, pero debe estar configurado para enviar un solo dato
            chart.createArduinoFollowUp("/dev/ttyUSB0", 9600);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents(){
        jPanel1=new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(360,450);
        this.getContentPane().add(jPanel1);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public static void main(String[] args) {
        new SensoresDemo2().setVisible(true);
    }
}
