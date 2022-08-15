package fr.kochoi.testapifortelemetry.domain.callerendpoint.port;

import fr.kochoi.testapifortelemetry.domain.callerendpoint.exception.CallerEndpointException;

public interface GetEndpoint1Feign {

    String getValue() throws CallerEndpointException;
}
