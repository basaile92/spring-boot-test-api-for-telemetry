package fr.kochoi.testapifortelemetry.infrastructure.sleepEndpointController.controller;

import fr.kochoi.testapifortelemetry.domain.sleependpoint.exception.SleepEndpointException;
import fr.kochoi.testapifortelemetry.domain.sleependpoint.service.SleepEndpointService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SleepEndpointController {

    Logger logger = LoggerFactory.getLogger("jsonLogger");

    private final SleepEndpointService sleepEndpointService;

    @PostMapping(value = "/test/sleep")
    public ResponseEntity<HttpStatus> sleepEndpoint(@RequestParam("time") int time)  {
        logger.info("SleepEndpointController.postEndpoint()...");
        try {
            sleepEndpointService.sleep(time);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (SleepEndpointException e) {
            return ResponseEntity.internalServerError()
                    .body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
