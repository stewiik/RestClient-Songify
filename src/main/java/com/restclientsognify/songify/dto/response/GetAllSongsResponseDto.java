package com.restclientsognify.songify.dto.response;

import com.restclientsognify.songify.model.Song;
import java.util.Map;

public record GetAllSongsResponseDto(Map<Integer, Song> songs) {
}
