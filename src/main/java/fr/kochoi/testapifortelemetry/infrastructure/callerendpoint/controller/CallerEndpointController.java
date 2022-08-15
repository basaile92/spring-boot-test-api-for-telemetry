package fr.kochoi.testapifortelemetry.infrastructure.callerendpoint.controller;

import fr.kochoi.testapifortelemetry.domain.callerendpoint.exception.CallerEndpointException;
import fr.kochoi.testapifortelemetry.domain.callerendpoint.service.CallerEndpointService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CallerEndpointController {

    Logger logger = LoggerFactory.getLogger("jsonLogger");

    private final CallerEndpointService callerEndpointService;

    @PostMapping("/test/caller")
    public ResponseEntity<HttpStatus> callEndpoint() {
        logger.info("CallerEndpointController.callEndpoint()...");
        try {
            callerEndpointService.callEndpoint();
        } catch (CallerEndpointException e) {
            return ResponseEntity.internalServerError()
                    .body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
