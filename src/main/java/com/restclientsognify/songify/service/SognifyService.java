package com.restclientsognify.songify.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restclientsognify.songify.dto.request.CreateSongRequestDto;
import com.restclientsognify.songify.dto.response.CreateSongResponseDto;
import com.restclientsognify.songify.proxy.SampleSongifyProxy;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SognifyService {

    SampleSongifyProxy sampleSongifyClient;

    public SognifyService(SampleSongifyProxy sampleSongifyClient) {
        this.sampleSongifyClient = sampleSongifyClient;
    }

    public void testClient() throws JsonProcessingException {
        CreateSongResponseDto postSong = sampleSongifyClient.makePostRequest(new CreateSongRequestDto("song5", "Madonna"));
        if (postSong != null) {
            log.info("Song created: " + postSong);
        }
    }
}