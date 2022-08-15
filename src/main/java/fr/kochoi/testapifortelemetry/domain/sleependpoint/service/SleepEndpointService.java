package fr.kochoi.testapifortelemetry.domain.sleependpoint.service;

import fr.kochoi.testapifortelemetry.domain.sleependpoint.exception.SleepEndpointException;

public interface SleepEndpointService {
    void sleep(int time) throws SleepEndpointException;
}
