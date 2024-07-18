package com.restclientsognify;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restclientsognify.songify.service.SognifyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RestClientSognifyApplication {

    private final SognifyService sognifyService;
    SognifyService songifyService;

    public RestClientSognifyApplication(SognifyService songifyService, SognifyService sognifyService) {
        this.songifyService = songifyService;
        this.sognifyService = sognifyService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestClientSognifyApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() throws JsonProcessingException {
        sognifyService.testClient();
    }
}
