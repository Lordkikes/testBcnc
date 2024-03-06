package com.test.bcnc.app.album.application.output;

import com.test.bcnc.app.album.domain.model.Album;

import java.util.List;

public interface GetAlbumsPersistenceOutputPort {
    List<Album> getAlbums();
}
