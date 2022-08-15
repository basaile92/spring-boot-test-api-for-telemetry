package fr.kochoi.testapifortelemetry.domain.callerendpoint.port;

import fr.kochoi.testapifortelemetry.domain.callerendpoint.exception.CallerEndpointException;

public interface PostEndpointFeign {
    void postValue(int s) throws CallerEndpointException;
}
