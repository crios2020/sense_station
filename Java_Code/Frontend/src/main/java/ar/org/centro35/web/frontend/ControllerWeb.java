package ar.org.centro35.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro35.sense_station.connectors.Connector;
import ar.org.centro35.sense_station.entities.Registro;
import ar.org.centro35.sense_station.repositories.interfaces.I_RegistroRepository;
import ar.org.centro35.sense_station.repositories.jdbc.RegistroRepository;

@Controller
public class ControllerWeb {
    
    private I_RegistroRepository rr=new RegistroRepository(Connector.getConnection());

    @GetMapping("/")
	public String index(@RequestParam(name="query", required=false, defaultValue="ultima") String query, Model model){
        Registro registro=rr.getLast();
        if(query.equalsIgnoreCase("hora")) registro=rr.getAvgHour();
        if(query.equalsIgnoreCase("dia")) registro=rr.getAvgDay();
        if(query.equalsIgnoreCase("mes")) registro=rr.getAvgMonth();
        if(query.equalsIgnoreCase("anio")) registro=rr.getAvgYear();
        model.addAttribute("fecha", registro.getFecha());
        model.addAttribute("hora",registro.getHora());
        model.addAttribute("temperatura",registro.getTemperatura());
        model.addAttribute("humedad",registro.getHumedad());
        model.addAttribute("gases", registro.getMq7());
        model.addAttribute("luz", registro.getLuz());
        String estadoGases="";
        if(registro.getMq7()<160) estadoGases="baja presencia de gases peligrosos";
        else estadoGases="alta presencia de gases peligrosos";
        model.addAttribute("estadoGases", estadoGases);


        // Luz
        int luz = registro.getLuz();
        String estadoLuz="";
        if (luz < 200) {
            estadoLuz="Ambiente muy oscuro";
        }
        if (luz >= 200 && luz < 400) {
            estadoLuz=" Ambiente oscuro";
        }
        if (luz >= 400 && luz < 600) {
            estadoLuz="Ambiente iluminado";
        }
        if (luz >= 600) {
            estadoLuz="Ambiente muy iluminado";
        }
        model.addAttribute("estadoLuz", estadoLuz);
		return "index";
	}
}
