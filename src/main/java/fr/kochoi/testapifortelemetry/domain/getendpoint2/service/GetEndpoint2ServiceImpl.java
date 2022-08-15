package fr.kochoi.testapifortelemetry.domain.getendpoint2.service;

import fr.kochoi.testapifortelemetry.domain.getendpoint2.port.GetEndpoint2RepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetEndpoint2ServiceImpl implements GetEndpoint2Service{
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    private final GetEndpoint2RepositoryPort getEndpoint2RepositoryPort;
    @Override
    public String getEndpoint2Value() {
        logger.info("GetEndpoint2ServiceImpl.getEndpoint2Value()...");
        return getEndpoint2RepositoryPort.getEndpoint2Value();
    }
}
