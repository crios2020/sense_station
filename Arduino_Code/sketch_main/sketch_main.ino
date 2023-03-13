#include "DHT.h"                          //Busca la libreria en el path del proyecto

//Configuración del sensor DHT
#define DHTPIN 2                          //Sensor DHT en port Digital 2  
#define DHTTYPE DHT11                     //Sensor Instalado DHT11
DHT dht(DHTPIN, DHTTYPE);                 //Se crea un objeto del tipo DHT

/*
 *  Diseño del Buffer serial a Java version 1
 *  
 *  v1  v2  v3  v4  v5  v6  v7  v8  v9  v10
 *  
 *  v1: versión del buffer, rango 1 - 100, La idea es que el receptor del buffer pueda identificar la versión correctamente.
 *  
 *  v2: medición de temperatura, rango 0 - 50, para el sensor DHT-11
 * 
 *  v3: medición de temperatura, rango 10 - 90, para el sensor DHT-11
 *  
 *  v4: medición de sensor MQ-5, rango 0 - 1023
 *  
 *  v5: medición de sensor MQ-7, rango 0 - 1023
 *  
 *  v6: medición de sensor BigSound KY-037, rango 0 - 1       0 bajo el umbral de activación    1 arriba del umbral de activación
 *  
 *  v7: medición de sensor Flame KY-026,    rango 0 - 1       0 bajo el umbral de activación    1 arriba del umbral de activación
 *  
 *  v8: medicion de sensor Luz KY-018,      rango 0 - 1       0 bajo el umbral de activación    1 arriba del umbral de activación
 *  
 *  
 */

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

  leerSensorLuzK018();                // v8                  

  delay(2000);

}

void calentarSensores(){
  //Algunos de los sensores necesitan 60s para calentarse y poder medir correctamente (MQ-5, MQ-7)
  delay(60000);
}
void version(){                       // v1
  Serial.println(1);
}

void leerTemperaturaDHT11(){          // v2
  float temperatura = dht.readTemperature();
  Serial.println(temperatura);
}

void leerHumedadDHT11(){              // v3
  float humedad = dht.readHumidity();
  Serial.println(humedad);
}

void leerGasMQ5(){                       // v4
  Serial.println(0);
}

void leerGasMQ7(){                       // v5
  Serial.println(0);
}

void leerBigSoundKY037(){               // v6
  Serial.println(0);
}

void leerSensorFlameKY026(){            // v7
  Serial.println(0);
}

void leerSensorLuzK018(){               // v8
  Serial.println(0);
}
