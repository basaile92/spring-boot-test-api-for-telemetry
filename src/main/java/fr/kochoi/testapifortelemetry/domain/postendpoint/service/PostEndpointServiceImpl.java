package fr.kochoi.testapifortelemetry.domain.postendpoint.service;

import fr.kochoi.testapifortelemetry.domain.postendpoint.exception.PostEndpointException;
import fr.kochoi.testapifortelemetry.domain.postendpoint.port.PostEndpointRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostEndpointServiceImpl implements PostEndpointService{
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    private final PostEndpointRepositoryPort postEndpointRepositoryPort;

    @Override
    public void savePostEndpointValue(int value) throws PostEndpointException {
        logger.info("PostEndpointServiceImpl.saveEndpointValue()...");
        sendErrorIfValueIsNegative(value);
        postEndpointRepositoryPort.savePostEndpointValue(value);
    }


    private void sendErrorIfValueIsNegative(int value) throws PostEndpointException {
        if(value < 0) {
            throw new PostEndpointException("Value is negative: value=" + value);
        }
    }
}
