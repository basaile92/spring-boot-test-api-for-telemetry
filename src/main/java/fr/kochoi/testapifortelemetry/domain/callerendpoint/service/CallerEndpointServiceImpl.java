package fr.kochoi.testapifortelemetry.domain.callerendpoint.service;

import fr.kochoi.testapifortelemetry.domain.callerendpoint.exception.CallerEndpointException;
import fr.kochoi.testapifortelemetry.domain.callerendpoint.port.GetEndpoint1Feign;
import fr.kochoi.testapifortelemetry.domain.callerendpoint.port.GetEndpoint2Feign;
import fr.kochoi.testapifortelemetry.domain.callerendpoint.port.PostEndpointFeign;
import fr.kochoi.testapifortelemetry.domain.callerendpoint.port.SleepEndpointFeign;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CallerEndpointServiceImpl implements CallerEndpointService{

    Logger logger = LoggerFactory.getLogger("jsonLogger");

    private final GetEndpoint1Feign getEndpoint1Feign;
    private final GetEndpoint2Feign getEndpoint2Feign;
    private final PostEndpointFeign postEndpointFeign;
    private final SleepEndpointFeign sleepEndpointFeign;

    @Override
    public void callEndpoint() throws CallerEndpointException {
        logger.info("CallerEndpointServiceImpl.callEndpoint()...");
        String res1 = getEndpoint1Feign.getValue();
        logger.info("Value from endpoint1 retrieved: value={}", res1);
        String res2 = getEndpoint2Feign.getValue();
        logger.info("Value from endpoint2 retrieved: value={}", res2);
        int valueToPost = 10;
        postEndpointFeign.postValue(valueToPost);
        logger.info("Value posted: value={}", valueToPost);
        sleepEndpointFeign.sleep(60);
        logger.info("Sleep ended");
    }
}
