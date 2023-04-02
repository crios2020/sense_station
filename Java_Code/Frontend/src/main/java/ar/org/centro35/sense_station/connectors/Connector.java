package ar.org.centro35.sense_station.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private static String driver="org.mariadb.jdbc.Driver";
    
    //localhost
    private static String url="jdbc:mariadb://localhost:3306/sense_station";
    private static String user="root";
    private static String pass="";

    //db4free
    // private static String url="jdbc:mariadb://db4free.net:3306/basegeneral";
    // private static String user="basegeneral";
    // private static String pass="basegeneral";

    private static Connection conn=null;

    private Connector(){}

    public static synchronized Connection getConnection(){
        try {
            if(conn==null || conn.isClosed()){
                try{
                    conn=DriverManager.getConnection(url, user, pass);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

}
