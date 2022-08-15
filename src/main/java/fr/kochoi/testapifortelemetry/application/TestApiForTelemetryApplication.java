package fr.kochoi.testapifortelemetry.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "fr.kochoi.testapifortelemetry")

public class TestApiForTelemetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApiForTelemetryApplication.class, args);
    }

}
