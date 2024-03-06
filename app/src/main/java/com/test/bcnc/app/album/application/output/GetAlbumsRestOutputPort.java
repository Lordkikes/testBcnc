package com.test.bcnc.app.album.application.output;

import com.test.bcnc.app.album.domain.model.Album;

import java.util.Set;

public interface GetAlbumsRestOutputPort {
    Set<Album> getAlbums();
}