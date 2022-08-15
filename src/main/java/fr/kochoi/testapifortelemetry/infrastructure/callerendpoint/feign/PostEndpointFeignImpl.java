package fr.kochoi.testapifortelemetry.infrastructure.callerendpoint.feign;

import fr.kochoi.testapifortelemetry.domain.callerendpoint.exception.CallerEndpointException;
import fr.kochoi.testapifortelemetry.domain.callerendpoint.port.PostEndpointFeign;
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
public class PostEndpointFeignImpl implements PostEndpointFeign {

    private static final String URL = "http://localhost:8080/test/post";

    private final RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger("jsonLogger");

    @Override
    public void postValue(int value) throws CallerEndpointException {
        logger.info("PostEndpointFeignImpl.postValue()...");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("value", String.valueOf(value));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, request , String.class );
        if(responseEntity.getStatusCode().is5xxServerError())
            throw new CallerEndpointException("Error while posting value to endpoint");
    }
}
