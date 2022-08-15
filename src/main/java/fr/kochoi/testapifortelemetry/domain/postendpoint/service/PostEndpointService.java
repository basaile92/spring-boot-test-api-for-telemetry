package fr.kochoi.testapifortelemetry.domain.postendpoint.service;

import fr.kochoi.testapifortelemetry.domain.postendpoint.exception.PostEndpointException;

public interface PostEndpointService {
    void savePostEndpointValue(int value) throws PostEndpointException;
}
