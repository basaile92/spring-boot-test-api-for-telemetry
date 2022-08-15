package fr.kochoi.testapifortelemetry.domain.getendpoint1.service;

import fr.kochoi.testapifortelemetry.domain.getendpoint1.port.GetEndpoint1RepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetEndpoint1ServiceImpl implements GetEndpoint1Service{
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    private final GetEndpoint1RepositoryPort getEndpoint1RepositoryPort;
    @Override
    public String getEndpoint1Value() {
        logger.info("GetEndpoint1ServiceImpl.getEndpoint1Value()...");
        return getEndpoint1RepositoryPort.getEndpoint1Value();
    }
}
