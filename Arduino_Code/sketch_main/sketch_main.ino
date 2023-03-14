#include "DHT.h"                          //Busca la libreria en el path del proyecto

//Configuración del sensor DHT
#define DHTPIN 2                          //Sensor DHT en port Digital 2  
#define DHTTYPE DHT11                     //Sensor Instalado DHT11
DHT dht(DHTPIN, DHTTYPE);                 //Se crea un objeto del tipo DHT

/*
    Diseño del Buffer serial Arduino a Java version 1

    v1  v2  v3  v4  v5  v6  v7  v8  v9  v10

    v1: versión del buffer, rango 1 - 100, La idea es que el receptor del buffer pueda identificar la versión correctamente.

    v2: medición de temperatura, rango 0 - 50, para el sensor DHT-11

    v3: medición de temperatura, rango 10 - 90, para el sensor DHT-11

    v4: medición de sensor MQ-5, rango 0 - 1023

    v5: medición de sensor MQ-7, rango 0 - 1023

    v6: medición de sensor BigSound KY-037,   rango 0 - 1       0 bajo el umbral de activación    1 arriba del umbral de activación

    v7: medición de sensor Flame KY-026,      rango 0 - 1       0 bajo el umbral de activación    1 arriba del umbral de activación

    v8: medición de sensor Luz KY-018,        rango 0 - 1023

    v9: medición de sensor Obstáculos KY-032, rango 0 - 1       0 bajo el umbral de activación    1 arriba del umbral de activación

    v10:medición de Inclinación KY-017,       rango 0 - 1       0 bajo el umbral de activación    1 arriba del umbral de activación

*/

/*

   Configuración de puertos de placa Arduino UNO

   Puertas Digitales

   0 -   RX

   1 -   TX

   2 -   DHT 11

   3 -   BigSound KY-037

   4 -   Flame KY-026

   5 -   Obstáculos KY-032

   6 -   Inclinación KY-017

   7 -

   8 -

   9 -

   10-

   11-

   12-

   13-


   Puertas Analógicos

   A0 - MQ-5

   A1 - MQ-7

   A2 - Luz KY-018

   A3 -

   A4 -

   A5 -

*/

//DIGITALES
const int BIGSOUND = 3;         //Mic KY-037 Digital
const int FLAME = 4;            //Flame KY-026 Sensor Digital
const int AVOID = 5;            //Obstáculos KY-032 Sensor Digital
const int INCLINACION = 6;      //Light Cup KY-017 Sensor Digital

//ANALÓGICOS

const int MQ5 = 0;              //MQ5 Sensor Analógico
const int MQ7 = 1;              //MQ7 Sensor Analógico
const int LUZ = 2;              //PhotoResistor KY-018 Sensor Analógico

void setup() {
  dht.begin();
  Serial.begin(9600);
  calentarSensores();
}

void loop() {

  version();                          // v1

  leerTemperaturaDHT11();             // v2

  leerHumedadDHT11();                 // v3

  leerGasMQ5();                       // v4

  leerGasMQ7();                       // v5

  leerBigSoundKY037();                // v6

  leerSensorFlameKY026();             // v7

  leerSensorLuzKY018();               // v8

  leerSensorAvoidKY032();             // v9



  delay(2000);

}

void calentarSensores() {
  //Algunos de los sensores necesitan 60s para calentarse y poder medir correctamente (MQ-5, MQ-7)
  delay(60000);
}
void version() {                              // v1
  Serial.println(1);
}

void leerTemperaturaDHT11() {                 // v2
  float temperatura = dht.readTemperature();
  Serial.println(temperatura);
}

void leerHumedadDHT11() {                     // v3
  float humedad = dht.readHumidity();
  Serial.println(humedad);
}

void leerGasMQ5() {                           // v4
  int gas = analogRead(MQ5);
  Serial.println(gas);
}

void leerGasMQ7() {                           // v5
  int gas = analogRead(MQ7);
  Serial.println(gas);
}

void leerBigSoundKY037() {                    // v6
  if (digitalRead(BIGSOUND) == HIGH) {
    Serial.println(1);
  } else {
    Serial.println(0);
  }
}

void leerSensorFlameKY026() {                 // v7
  if (digitalRead(FLAME) == HIGH) {
    Serial.println(1);
  } else {
    Serial.println(0);
  }
}

void leerSensorLuzKY018() {                   // v8
  int luz = analogRead(LUZ);
  Serial.println(luz);
}

void leerSensorAvoidKY032() {                 // v9
  if (digitalRead(AVOID) == HIGH) {
    Serial.println(1);
  } else {
    Serial.println(0);
  }
}
