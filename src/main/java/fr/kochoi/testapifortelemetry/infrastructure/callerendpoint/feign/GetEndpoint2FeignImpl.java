package fr.kochoi.testapifortelemetry.infrastructure.callerendpoint.feign;

import fr.kochoi.testapifortelemetry.domain.callerendpoint.exception.CallerEndpointException;
import fr.kochoi.testapifortelemetry.domain.callerendpoint.port.GetEndpoint1Feign;
import fr.kochoi.testapifortelemetry.domain.callerendpoint.port.GetEndpoint2Feign;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@RequiredArgsConstructor
public class GetEndpoint2FeignImpl implements GetEndpoint2Feign {

    private static final String URL = "http://localhost:8080/test/get2";
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    private final RestTemplate restTemplate;

    @Override
    public String getValue() throws CallerEndpointException {
        logger.info("GetEndpoint2FeignImpl.getValue()...");
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
        if(response.getStatusCode().is5xxServerError())
            throw new CallerEndpointException("Error while getting value to endpoint1");
        return response.getBody();
    }
}
