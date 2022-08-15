package fr.kochoi.testapifortelemetry.domain.sleependpoint.service;

import fr.kochoi.testapifortelemetry.domain.sleependpoint.exception.SleepEndpointException;
import fr.kochoi.testapifortelemetry.domain.sleependpoint.port.SleepEndpointRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SleepEndpointServiceImpl implements SleepEndpointService{

    Logger logger = LoggerFactory.getLogger("jsonLogger");

    private final SleepEndpointRepositoryPort sleepEndpointRepositoryPort;

    @Override
    public void sleep(int time) throws SleepEndpointException {
        logger.info("SleepEndpointServiceImpl.sleep()...");
        sleepEndpointRepositoryPort.sleep(time);
    }
}
