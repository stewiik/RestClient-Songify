package com.restclientsognify.songify.proxy;

import com.restclientsognify.songify.dto.request.CreateSongRequestDto;
import com.restclientsognify.songify.dto.response.CreateSongResponseDto;
import com.restclientsognify.songify.dto.response.DeleteSongResponseDto;
import com.restclientsognify.songify.dto.response.GetAllSongsResponseDto;
import com.restclientsognify.songify.dto.response.GetSongResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Log4j2
public class SampleSongifyProxy {

    RestTemplate restTemplate;

    public SampleSongifyProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${songify-server.service.url}")
    String url;

    @Value("${songify-server.service.port}")
    int port;

    public CreateSongResponseDto makePostRequest(CreateSongRequestDto request) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("/songs");

        HttpEntity<CreateSongRequestDto> httpEntity = new HttpEntity<>(request);
        try {
            ResponseEntity<CreateSongResponseDto> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.POST,
                    httpEntity,
                    CreateSongResponseDto.class
            );
            return response.getBody();
        } catch (HttpClientErrorException exception) {
            log.error(exception.getMessage());
        } catch (RestClientException exception) {
            log.error(exception.getMessage());
        }
        return null;
    }

    public GetAllSongsResponseDto makeGetAllRequest() {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("/songs");
        try {
            ResponseEntity<GetAllSongsResponseDto> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    null,
                    GetAllSongsResponseDto.class
            );
            return response.getBody();
        } catch (HttpClientErrorException exception) {
            log.error(exception.getMessage());
        } catch (RestClientException exception) {
            log.error(exception.getMessage());
        }
        return null;
    }

    public GetSongResponseDto makeGetSongRequest(Integer id) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("/songs/{id}");
        try {
            ResponseEntity<GetSongResponseDto> response = restTemplate.exchange(
                    builder.buildAndExpand(id).toUri(),
                    HttpMethod.GET,
                    null,
                    GetSongResponseDto.class
            );
            return response.getBody();
        } catch (HttpClientErrorException exception) {
            log.error(exception.getMessage());
        } catch (RestClientException exception) {
            log.error(exception.getMessage());
        }
        return null;
    }

    public DeleteSongResponseDto makeDeleteRequest(Integer id) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("/songs/{id}");
        try {
            ResponseEntity<DeleteSongResponseDto> response = restTemplate.exchange(
                    builder.buildAndExpand(id).toUri(),
                    HttpMethod.DELETE,
                    null,
                    DeleteSongResponseDto.class
            );
            return response.getBody();
        } catch (HttpClientErrorException exception) {
            log.error(exception.getMessage());
        } catch (RestClientException exception) {
            log.error(exception.getMessage());
        }
        return null;
    }
}
