package fr.kochoi.testapifortelemetry.domain.sleependpoint.port;

import fr.kochoi.testapifortelemetry.domain.sleependpoint.exception.SleepEndpointException;

public interface SleepEndpointRepositoryPort {
    void sleep(int time) throws SleepEndpointException;
}
