package fr.kochoi.testapifortelemetry.infrastructure.postendpoint.controller;

import fr.kochoi.testapifortelemetry.domain.postendpoint.exception.PostEndpointException;
import fr.kochoi.testapifortelemetry.domain.postendpoint.service.PostEndpointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostEndpointController {
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    private final PostEndpointService postEndpointService;

    @PostMapping(value = "/test/post")
    public ResponseEntity<HttpStatus> postEndpoint(@RequestParam("value") int value) {
        logger.info("PostEndpointController.postEndpoint()...");
        try {
            postEndpointService.savePostEndpointValue(value);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (PostEndpointException e) {
            return ResponseEntity.internalServerError()
                    .body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
