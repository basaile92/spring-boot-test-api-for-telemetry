package fr.kochoi.testapifortelemetry.infrastructure.postendpoint.repository;

import fr.kochoi.testapifortelemetry.domain.postendpoint.port.PostEndpointRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PostEndpointRepositoryMock implements PostEndpointRepositoryPort {
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    @Override
    public void savePostEndpointValue(int value) {
        logger.debug("PostEndpointRepositoryMock.savePostEndpointValue(): value={}", value);
    }
}
