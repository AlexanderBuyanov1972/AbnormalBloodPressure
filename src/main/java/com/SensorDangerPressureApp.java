package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Sensor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.function.Consumer;

@SpringBootApplication
public class SensorDangerPressureApp {
    ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        SpringApplication.run(SensorDangerPressureApp.class, args);

    }

    @Bean
    Consumer<Sensor> receive() {
       return this::printJsonSensor;
    }

    private Sensor getSensor(String line) {
        Sensor sensor = null;
        try {
            sensor = mapper.readValue(line, Sensor.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sensor;
    }

    private void printJsonSensor(Sensor sensor) {
        System.out.println("sensor number : " + sensor.id);
        System.out.println("data time : " + sensor.time);
        System.out.println("UPPER BLOOD PRESSURE: " + sensor.dataUBP);
        System.out.println("LOWER BLOOD PRESSURE: " + sensor.dataLBP);
        System.out.println("pulls : " + sensor.dataPulls);
        System.out.println("sugar in blood : " + sensor.dataSugar);
        System.out.println("*********************************************");
    }

}
