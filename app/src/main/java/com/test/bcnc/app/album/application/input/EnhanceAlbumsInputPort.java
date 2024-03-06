package com.test.bcnc.app.album.application.input;

import com.test.bcnc.app.album.domain.model.Album;
import com.test.bcnc.app.photo.domain.model.Photo;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface EnhanceAlbumsInputPort {
    void enhanceAlbums(Map<Long, Album> albums, Set<Photo> photos);
    void saveAll(Collection<Album> albums);
}
