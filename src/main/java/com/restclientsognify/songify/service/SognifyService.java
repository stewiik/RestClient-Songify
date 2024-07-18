package com.restclientsognify.songify.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restclientsognify.songify.dto.response.DeleteSongResponseDto;
import com.restclientsognify.songify.dto.response.UpdateSongResponseDto;
import com.restclientsognify.songify.dto.request.UpdateSongRequestDto;
import com.restclientsognify.songify.dto.response.GetAllSongsResponseDto;
import com.restclientsognify.songify.dto.request.CreateSongRequestDto;
import com.restclientsognify.songify.dto.response.CreateSongResponseDto;
import com.restclientsognify.songify.dto.response.GetSongResponseDto;
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

        GetSongResponseDto getSong = sampleSongifyClient.makeGetSongRequest(100);
        if (getSong != null) {
            log.info("Song: " + getSong);
        }

        GetAllSongsResponseDto getAllSongs = sampleSongifyClient.makeGetAllRequest();
        if (getAllSongs != null) {
            log.info("All songs: " + getAllSongs);
        }

        DeleteSongResponseDto deleteSong = sampleSongifyClient.makeDeleteRequest(100);
        if (deleteSong != null) {
            log.info("Song deleted: " + deleteSong);
        }

        UpdateSongResponseDto updateSong = sampleSongifyClient.makePutRequest(5, new UpdateSongRequestDto("lala", "Madonna"));
        if (updateSong != null) {
            log.info("Song updated: " + updateSong);
        }
    }
}
