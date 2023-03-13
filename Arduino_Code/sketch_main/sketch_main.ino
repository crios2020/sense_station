#include "DHT.h"                          //Busca la libreria en el path del proyecto

//Configuración del sensor DHT
#define DHTPIN 2                          //Sensor DHT en port Digital 2  
#define DHTTYPE DHT11                     //Sensor Instalado DHT11
DHT dht(DHTPIN, DHTTYPE);                 //Se crea un objeto del tipo DHT

void setup() {
  dht.begin();
  Serial.begin(9600);
}

void loop() {
  
  leerTemperaturaDHT11();

  leerHumedadDHT11();

  delay(2000);

}

void leerTemperaturaDHT11(){
  float temperatura = dht.readTemperature();
  Serial.println(temperatura);
}

void leerHumedadDHT11(){
  float humedad = dht.readHumidity();
  Serial.println(humedad);
}
