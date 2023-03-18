package ar.org.centro35.sense_station.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ar.org.centro35.sense_station.entities.Registro;
import ar.org.centro35.sense_station.repositories.interfaces.I_RegistroRepository;

public class RegistroRepository implements I_RegistroRepository {

    private Connection conn;

    public RegistroRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Registro registro) {
        if(registro==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
            "insert into registros "+
            "(fecha,hora,temperatura,humedad,mq5,mq7,bigsound,flame,luz,obstaculo,inclinado) "+
            "values "+
            "(?,?,?,?,?,?,?,?,?,?,?)",
            PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, registro.getFecha());
            ps.setString(2, registro.getHora());
            ps.setInt(3, registro.getTemperatura());
            ps.setInt(4, registro.getHumedad());
            ps.setInt(5, registro.getMq5());
            ps.setInt(6, registro.getMq7());
            ps.setBoolean(7, registro.isBigsound());
            ps.setBoolean(8, registro.isFlame());
            ps.setInt(9, registro.getLuz());
            ps.setBoolean(10, registro.isObstaculo());
            ps.setBoolean(11, registro.isInclinado());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) registro.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }    
    }

    @Override
    public Registro getLast() {
        Registro registro = new Registro();
        String sql="select * from registros where id=(select max(id) from registros)";
        try (ResultSet rs=conn.createStatement().executeQuery(sql)){
            if(rs.next()){
                registro.setId(rs.getInt("id"));
                registro.setFecha(rs.getString("fecha"));
                registro.setHora(rs.getString("hora"));
                registro.setTemperatura(rs.getInt("temperatura"));
                registro.setHumedad(rs.getInt("humedad"));
                registro.setMq5(rs.getInt("mq5"));
                registro.setMq7(rs.getInt("mq7"));
                registro.setBigsound(rs.getBoolean("bigSound"));
                registro.setFlame(rs.getBoolean("flame"));
                registro.setLuz(rs.getInt("luz"));
                registro.setObstaculo(rs.getBoolean("obstaculo"));
                registro.setInclinado(rs.getBoolean("inclinado"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return registro;
    }

    @Override
    public Registro getAvgDay() {
        Registro registro = new Registro();
        String sql=
            "select fecha,hora,avg(temperatura) temperatura, avg(humedad) humedad, "+
                "avg(mq5) mq5, avg(mq7) mq7, avg(luz) luz  from registros where fecha = curdate()";
        try (ResultSet rs=conn.createStatement().executeQuery(sql)){
            if(rs.next()){
                registro.setId(0);
                registro.setFecha(rs.getString("fecha"));
                registro.setHora(rs.getString("hora"));
                registro.setTemperatura(rs.getInt("temperatura"));
                registro.setHumedad(rs.getInt("humedad"));
                registro.setMq5(rs.getInt("mq5"));
                registro.setMq7(rs.getInt("mq7"));
                registro.setBigsound(false);
                registro.setFlame(false);
                registro.setLuz(rs.getInt("luz"));
                registro.setObstaculo(false);
                registro.setInclinado(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return registro;
    }

    @Override
    public Registro getAvgMonth() {
        Registro registro = new Registro();
        String sql=
            "select fecha,hora,avg(temperatura) temperatura, avg(humedad) humedad, "+
                "avg(mq5) mq5, avg(mq7) mq7, avg(luz) luz  from registros where month(fecha) = month(curdate())";
        try (ResultSet rs=conn.createStatement().executeQuery(sql)){
            if(rs.next()){
                registro.setId(0);
                registro.setFecha(rs.getString("fecha"));
                registro.setHora(rs.getString("hora"));
                registro.setTemperatura(rs.getInt("temperatura"));
                registro.setHumedad(rs.getInt("humedad"));
                registro.setMq5(rs.getInt("mq5"));
                registro.setMq7(rs.getInt("mq7"));
                registro.setBigsound(false);
                registro.setFlame(false);
                registro.setLuz(rs.getInt("luz"));
                registro.setObstaculo(false);
                registro.setInclinado(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return registro;
    }

    @Override
    public Registro getAvgYear() {
        Registro registro = new Registro();
        String sql=
            "select fecha,hora,avg(temperatura) temperatura, avg(humedad) humedad, "+
                "avg(mq5) mq5, avg(mq7) mq7, avg(luz) luz  from registros where year(fecha) = year(curdate())";
        try (ResultSet rs=conn.createStatement().executeQuery(sql)){
            if(rs.next()){
                registro.setId(0);
                registro.setFecha(rs.getString("fecha"));
                registro.setHora(rs.getString("hora"));
                registro.setTemperatura(rs.getInt("temperatura"));
                registro.setHumedad(rs.getInt("humedad"));
                registro.setMq5(rs.getInt("mq5"));
                registro.setMq7(rs.getInt("mq7"));
                registro.setBigsound(false);
                registro.setFlame(false);
                registro.setLuz(rs.getInt("luz"));
                registro.setObstaculo(false);
                registro.setInclinado(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return registro;
    }
    
}
