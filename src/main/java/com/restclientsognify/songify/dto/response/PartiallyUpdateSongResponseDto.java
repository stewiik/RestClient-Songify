package com.restclientsognify.songify.dto.response;

import com.restclientsognify.songify.model.Song;

public record PartiallyUpdateSongResponseDto(Song updatedSong) {
}