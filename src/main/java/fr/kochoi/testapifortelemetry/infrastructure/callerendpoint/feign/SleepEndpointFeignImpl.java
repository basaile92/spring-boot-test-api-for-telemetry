package fr.kochoi.testapifortelemetry.infrastructure.callerendpoint.feign;

import fr.kochoi.testapifortelemetry.domain.callerendpoint.exception.CallerEndpointException;
import fr.kochoi.testapifortelemetry.domain.callerendpoint.port.SleepEndpointFeign;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Repository
@RequiredArgsConstructor
public class SleepEndpointFeignImpl implements SleepEndpointFeign {

    private static final String URL = "http://localhost:8080/test/sleep";

    private final RestTemplate restTemplate;
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    @Override
    public void sleep(int time) throws CallerEndpointException {
        logger.info("SleepEndpointFeignImpl.sleep()...");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("time", String.valueOf(time));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(URL, request , String.class );
        if(response.getStatusCode().is5xxServerError())
            throw new CallerEndpointException("Error while sleeping");

    }
}
