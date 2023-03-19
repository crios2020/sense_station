package ar.org.centro35.sense_station.app;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JTextField;

public class HoraThread implements Runnable{

    private JTextField txtFecha;
    private JTextField txtHora; 

    public HoraThread(JTextField txtFecha, JTextField txtHora) {
        this.txtFecha = txtFecha;
        this.txtHora = txtHora;
    }

    @Override
    public void run() {
        while(true){
            LocalDate ld=LocalDate.now();
            txtFecha.setText(ld.toString());
            LocalTime lt=LocalTime.now();
            DecimalFormat df=new DecimalFormat("00");
            
            String hora=df.format(lt.getHour())+":"+df.format(lt.getMinute())+":"+df.format(lt.getSecond());
            txtHora.setText(hora);
            try{
                Thread.sleep(1000);
            }catch(Exception e){}
        }
    }
    
}
