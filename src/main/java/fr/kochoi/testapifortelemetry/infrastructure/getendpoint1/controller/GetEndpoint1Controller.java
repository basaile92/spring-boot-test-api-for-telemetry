package fr.kochoi.testapifortelemetry.infrastructure.getendpoint1.controller;

import fr.kochoi.testapifortelemetry.domain.getendpoint1.service.GetEndpoint1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetEndpoint1Controller {
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    private final GetEndpoint1Service getEndpoint1Service;

    @GetMapping("/test/get1")
    public ResponseEntity<String> getEndpoint1() {
        logger.info("GetEndpoint1Controller.getEndpoint1()...");
        return ResponseEntity.ok(getEndpoint1Service.getEndpoint1Value());
    }

}
