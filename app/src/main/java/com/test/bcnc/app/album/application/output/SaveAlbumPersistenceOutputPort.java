package com.test.bcnc.app.album.application.output;

import com.test.bcnc.app.album.domain.model.Album;

public interface SaveAlbumPersistenceOutputPort {
    Album saveAlbum(Album album);
}
