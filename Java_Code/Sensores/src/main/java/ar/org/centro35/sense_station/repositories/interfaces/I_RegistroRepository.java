package ar.org.centro35.sense_station.repositories.interfaces;

import ar.org.centro35.sense_station.entities.Registro;

public interface I_RegistroRepository {
    void save(Registro registro);
    Registro getLast();
    Registro getAvgDay();
    Registro getAvgMonth();
    Registro getAvgYear();
}
