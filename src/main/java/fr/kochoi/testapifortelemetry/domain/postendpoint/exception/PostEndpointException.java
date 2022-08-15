package fr.kochoi.testapifortelemetry.domain.postendpoint.exception;

import fr.kochoi.testapifortelemetry.domain.postendpoint.service.PostEndpointService;

public class PostEndpointException extends Exception{

    public PostEndpointException(String error) {
        super(error);
    }
}
