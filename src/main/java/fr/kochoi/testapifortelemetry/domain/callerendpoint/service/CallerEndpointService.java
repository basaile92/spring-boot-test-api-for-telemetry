package fr.kochoi.testapifortelemetry.domain.callerendpoint.service;

import fr.kochoi.testapifortelemetry.domain.callerendpoint.exception.CallerEndpointException;

public interface CallerEndpointService {
    void callEndpoint() throws CallerEndpointException;
}
