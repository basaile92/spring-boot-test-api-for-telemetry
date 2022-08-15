package fr.kochoi.testapifortelemetry.infrastructure.getendpoint2.repository;

import fr.kochoi.testapifortelemetry.domain.getendpoint2.port.GetEndpoint2RepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class GetEndpoint2RepositoryMock implements GetEndpoint2RepositoryPort {
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    @Override
    public String getEndpoint2Value() {
        logger.info("GetEndpoint2RepositoryMock.getEndpoint2Value()...");
        return "Endpoint2Value";
    }
}
