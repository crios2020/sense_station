package ar.org.centro35.sense_station.entities;
/*
 * 	id int auto_increment primary key,
    fecha date,
    hora time,
    temperatura tinyint,
    humedad tinyint,
    mq5 smallint,
    mq7 smallint,
    bigsound bool,
    flame bool,
    luz smallint,
    obstaculo bool,
    inclinado bool
 */
public class Registro {
    private int id;
    private String fecha;
    private String hora;
    private int temperatura;
    private int humedad;
    private int mq5;
    private int mq7;
    private boolean bigsound;
    private boolean flame;
    private int luz;
    private boolean obstaculo;
    private boolean inclinado;
    
    public Registro() {
    }

    public Registro(String fecha, String hora, int temperatura, int humedad, int mq5, int mq7, boolean bigsound,
            boolean flame, int luz, boolean obstaculo, boolean inclinado) {
        this.fecha = fecha;
        this.hora = hora;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.mq5 = mq5;
        this.mq7 = mq7;
        this.bigsound = bigsound;
        this.flame = flame;
        this.luz = luz;
        this.obstaculo = obstaculo;
        this.inclinado = inclinado;
    }

    public Registro(int id, String fecha, String hora, int temperatura, int humedad, int mq5, int mq7, boolean bigsound,
            boolean flame, int luz, boolean obstaculo, boolean inclinado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.mq5 = mq5;
        this.mq7 = mq7;
        this.bigsound = bigsound;
        this.flame = flame;
        this.luz = luz;
        this.obstaculo = obstaculo;
        this.inclinado = inclinado;
    }

    @Override
    public String toString() {
        return "Registro [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", temperatura=" + temperatura
                + ", humedad=" + humedad + ", mq5=" + mq5 + ", mq7=" + mq7 + ", bigsound=" + bigsound + ", flame="
                + flame + ", luz=" + luz + ", obstaculo=" + obstaculo + ", inclinado=" + inclinado + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public int getMq5() {
        return mq5;
    }

    public void setMq5(int mq5) {
        this.mq5 = mq5;
    }

    public int getMq7() {
        return mq7;
    }

    public void setMq7(int mq7) {
        this.mq7 = mq7;
    }

    public boolean isBigsound() {
        return bigsound;
    }

    public void setBigsound(boolean bigsound) {
        this.bigsound = bigsound;
    }

    public boolean isFlame() {
        return flame;
    }

    public void setFlame(boolean flame) {
        this.flame = flame;
    }

    public int getLuz() {
        return luz;
    }

    public void setLuz(int luz) {
        this.luz = luz;
    }

    public boolean isObstaculo() {
        return obstaculo;
    }

    public void setObstaculo(boolean obstaculo) {
        this.obstaculo = obstaculo;
    }

    public boolean isInclinado() {
        return inclinado;
    }

    public void setInclinado(boolean inclinado) {
        this.inclinado = inclinado;
    }

}
