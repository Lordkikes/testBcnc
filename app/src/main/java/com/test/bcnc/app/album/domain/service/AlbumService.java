package com.test.bcnc.app.album.domain.service;

import com.test.bcnc.app.album.application.input.EnhanceAlbumsInputPort;
import com.test.bcnc.app.album.application.input.GetExternalAlbumsInputPort;
import com.test.bcnc.app.album.application.input.GetInternalAlbumsInputPort;
import com.test.bcnc.app.album.application.output.GetAlbumsPersistenceOutputPort;
import com.test.bcnc.app.album.application.output.GetAlbumsRestOutputPort;
import com.test.bcnc.app.album.application.output.SaveAlbumPersistenceOutputPort;
import com.test.bcnc.app.album.domain.model.Album;
import com.test.bcnc.app.photo.domain.model.Photo;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AlbumService implements EnhanceAlbumsInputPort, GetExternalAlbumsInputPort, GetInternalAlbumsInputPort {

    private final SaveAlbumPersistenceOutputPort saveAlbumPersistenceOutputPort;
    private final GetAlbumsPersistenceOutputPort getAlbumsPersistenceOutputPort;
    private final GetAlbumsRestOutputPort getAlbumsRestOutputPort;

    @Override
    public void enhanceAlbums(Map<Long, Album> albums, Set<Photo> photos) {
        if (photos == null || albums == null) {
            throw new IllegalArgumentException("Albums or photos cannot be null");
        }
        photos.stream().parallel().forEach(photo -> {
            Album album = albums.get(photo.getAlbumId());
            if (album != null) {
                album.getPhotos().add(photo);
            }
        });
    }

    @Override
    public void saveAll(Collection<Album> albums) {
        albums.stream().parallel().forEach(saveAlbumPersistenceOutputPort::saveAlbum);
    }

    @Override
    public Map<Long, Album> getExternalAlbums() {
        return transformAlbums2Map(getAlbumsRestOutputPort.getAlbums());
    }

    @Override
    public Map<Long, Album> getInternalAlbums() {
        return transformAlbums2Map(getAlbumsPersistenceOutputPort.getAlbums());
    }

    private Map<Long, Album> transformAlbums2Map(Collection<Album> albums) {
        return albums.stream().parallel().collect(Collectors.toMap(Album::getId, album -> album));
    }
}
