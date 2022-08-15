package fr.kochoi.testapifortelemetry.infrastructure.getendpoint1.repository;

import fr.kochoi.testapifortelemetry.domain.getendpoint1.port.GetEndpoint1RepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class GetEndpoint1RepositoryMock implements GetEndpoint1RepositoryPort {
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    @Override
    public String getEndpoint1Value() {
        logger.info("GetEndpoint1RepositoryMock.getEndpoint1Value()...");
        return "Endpoint1Value";
    }
}
