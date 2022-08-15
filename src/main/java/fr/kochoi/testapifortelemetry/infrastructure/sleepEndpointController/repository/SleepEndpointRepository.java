package fr.kochoi.testapifortelemetry.infrastructure.sleepEndpointController.repository;

import fr.kochoi.testapifortelemetry.domain.sleependpoint.exception.SleepEndpointException;
import fr.kochoi.testapifortelemetry.domain.sleependpoint.port.SleepEndpointRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SleepEndpointRepository implements SleepEndpointRepositoryPort {

    Logger logger = LoggerFactory.getLogger("jsonLogger");

    @Override
    public void sleep(int time) throws SleepEndpointException {
        logger.info("SleepEndpointRepository.sleep()...");
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            throw new SleepEndpointException(e.getMessage(), e.getCause());
        }
    }
}
