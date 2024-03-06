package com.test.bcnc.app.album.application.input;

import com.test.bcnc.app.album.domain.model.Album;

import java.util.Map;

public interface GetInternalAlbumsInputPort {
    Map<Long, Album> getInternalAlbums();
}
