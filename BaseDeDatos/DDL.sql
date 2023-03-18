/*
 *  Diseño del Buffer serial Arduino a Java version 1
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
 *  v6: medición de sensor BigSound KY-037, 	rango 0 - 1       	0 bajo el umbral de activación    1 arriba del umbral de activación
 *  
 *  v7: medición de sensor Flame KY-026,    	rango 0 - 1       	0 bajo el umbral de activación    1 arriba del umbral de activación
 *  
 *  v8: medición de sensor Luz KY-018,      	rango 0 - 1023
 *  
 *  v9: medición de sensor Obstáculos KY-032, 	rango 0 - 1			0 bajo el umbral de activación    1 arriba del umbral de activación
 *  
 *  v10:medición de Inclinación KY-017,     	rango 0 - 1       	0 bajo el umbral de activación    1 arriba del umbral de activación
 *  
 */
drop database if exists sense_station;
create database sense_station;
use sense_station;
create table registros(
	id int auto_increment primary key,
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
);
