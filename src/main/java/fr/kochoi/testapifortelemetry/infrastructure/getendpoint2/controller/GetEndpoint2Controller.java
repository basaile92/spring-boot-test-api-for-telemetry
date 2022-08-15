package fr.kochoi.testapifortelemetry.infrastructure.getendpoint2.controller;

import fr.kochoi.testapifortelemetry.domain.getendpoint2.service.GetEndpoint2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetEndpoint2Controller {
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    private final GetEndpoint2Service getEndpoint2Service;

    @GetMapping("/test/get2")
    public ResponseEntity<String> getEndpoint2() {
        logger.info("GetEndpoint2Controller.getEndpoint2()...");
        return ResponseEntity.ok(getEndpoint2Service.getEndpoint2Value());
    }
}
