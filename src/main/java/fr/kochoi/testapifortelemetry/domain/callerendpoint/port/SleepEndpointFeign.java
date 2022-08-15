package fr.kochoi.testapifortelemetry.domain.callerendpoint.port;

import fr.kochoi.testapifortelemetry.domain.callerendpoint.exception.CallerEndpointException;

public interface SleepEndpointFeign {
    void sleep(int time) throws CallerEndpointException;
}
