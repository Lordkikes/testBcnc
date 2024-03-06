package com.test.bcnc.app.album.domain.service;

import com.test.bcnc.app.album.application.output.GetAlbumsPersistenceOutputPort;
import com.test.bcnc.app.album.application.output.GetAlbumsRestOutputPort;
import com.test.bcnc.app.album.application.output.SaveAlbumPersistenceOutputPort;
import com.test.bcnc.app.album.domain.model.Album;
import com.test.bcnc.app.photo.domain.model.Photo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlbumServiceTest {
    private AlbumService albumService;
    @Mock
    private SaveAlbumPersistenceOutputPort saveAlbumPersistenceOutputPort;
    @Mock
    private GetAlbumsPersistenceOutputPort getAlbumsPersistenceOutputPort;
    @Mock
    private GetAlbumsRestOutputPort getAlbumsRestOutputPort;
    @Mock
    private Map<Long, Album> albumsMap;
    @Mock
    private Album album;
    @Mock
    private List<Photo> photos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.albumService = new AlbumService(
                saveAlbumPersistenceOutputPort, getAlbumsPersistenceOutputPort, getAlbumsRestOutputPort);
    }

    @Test()
    void givenNullAlbums_whenEnrichAlbums_thenIllegalArgumentException() throws IOException {
        // GIVEN
        Set<Photo> photos = Collections.emptySet();
        // WHEN
        Executable enrichAlbums = () -> albumService.enhanceAlbums(null, photos);
        // THEN
        assertThrows(
                IllegalArgumentException.class,
                enrichAlbums,
                "Albums or photos cannot be null"
        );
    }

    @Test()
    void givenNullPhotos_whenEnrichAlbums_thenIllegalArgumentException() throws IOException {
        // WHEN
        Executable enrichAlbums = () -> albumService.enhanceAlbums(albumsMap, null);
        // THEN
        assertThrows(
                IllegalArgumentException.class,
                enrichAlbums,
                "Albums or photos cannot be null"
        );
    }

    @Test
    void givenEmptyPhotos_whenEnrichAlbums_thenNoAlbumIsGotten() throws IOException {
        // GIVEN
        Set<Photo> photos = Collections.emptySet();
        // WHEN
        albumService.enhanceAlbums(albumsMap, photos);
        // THEN
        verify(albumsMap, times(0)).get(anyLong());
    }

    @Test
    void given2PhotosInAlbum1_whenEnrichAlbums_then2PhotosAddedToAlbum() throws IOException {
        // GIVEN
        Photo photo1 = Photo.builder()
                .id(1L)
                .albumId(1L)
                .title("Photo 1 in Album 1")
                .url("https://via.placeholder.com/600/771796")
                .thumbnailUr("https://via.placeholder.com/150/771796")
                .build();
        Photo photo2 = Photo.builder()
                .id(2L)
                .albumId(1L)
                .title("Photo 2 in Album 1")
                .url("https://via.placeholder.com/600/771796")
                .thumbnailUr("https://via.placeholder.com/150/771796")
                .build();
        Set<Photo> givenPhotos = Stream.of(photo1, photo2).collect(Collectors.toSet());
        // WHEN
        when(albumsMap.get(anyLong())).thenReturn(album);
        when(album.getPhotos()).thenReturn(photos);
        when(photos.add(any())).thenReturn(true);
        albumService.enhanceAlbums(albumsMap, givenPhotos);
        // THEN
        verify(photos, times(2)).add(any());
    }

}