package com.restclientsognify.songify.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restclientsognify.songify.dto.request.PartiallyUpdateSongRequestDto;
import com.restclientsognify.songify.dto.response.*;
import com.restclientsognify.songify.dto.request.UpdateSongRequestDto;
import com.restclientsognify.songify.dto.request.CreateSongRequestDto;
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
//        CreateSongResponseDto postSong = sampleSongifyClient.makePostRequest(new CreateSongRequestDto("song5", "Madonna"));
//        if (postSong != null) {
//            log.info("Song created: " + postSong);
//        }
//
//        GetSongResponseDto getSong = sampleSongifyClient.makeGetSongRequest(1);
//        if (getSong != null) {
//            log.info("Song: " + getSong);
//        }
//
//        GetAllSongsResponseDto getAllSongs = sampleSongifyClient.makeGetAllRequest();
//        if (getAllSongs != null) {
//            log.info("All songs: " + getAllSongs);
//        }
//
//        DeleteSongResponseDto deleteSong = sampleSongifyClient.makeDeleteRequest(1);
//        if (deleteSong != null) {
//            log.info("Song deleted: " + deleteSong);
//        }
//
        UpdateSongResponseDto updateSong = sampleSongifyClient.makePutRequest(5, new UpdateSongRequestDto(null, "Shawn Mendes"));
        if (updateSong != null) {
            log.info("Song updated: " + updateSong);
        }

//        PartiallyUpdateSongResponseDto partiallyUpdateSong = sampleSongifyClient.makePatchRequest(5, new PartiallyUpdateSongRequestDto(null, "Madonna"));
//        if (partiallyUpdateSong != null) {
//            log.info("Song partially updated: " + partiallyUpdateSong);
//        }
    }
}
