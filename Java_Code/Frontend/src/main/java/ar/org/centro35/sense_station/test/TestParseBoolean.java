package ar.org.centro35.sense_station.test;

public class TestParseBoolean {
    public static void main(String[] args) {
        System.out.println(Boolean.parseBoolean("1"));
        System.out.println(Boolean.parseBoolean("0"));
        System.out.println(("0".equals("0")?false:true));
        System.out.println(("1".equals("0")?false:true));
    }
}
