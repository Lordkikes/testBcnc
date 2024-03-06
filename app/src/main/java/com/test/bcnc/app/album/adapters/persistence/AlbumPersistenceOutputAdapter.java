package com.test.bcnc.app.album.adapters.persistence;

import com.test.bcnc.app.album.adapters.persistence.mappers.AlbumMapper;
import com.test.bcnc.app.album.adapters.persistence.repositories.AlbumRepository;
import com.test.bcnc.app.album.application.output.GetAlbumsPersistenceOutputPort;
import com.test.bcnc.app.album.application.output.SaveAlbumPersistenceOutputPort;
import com.test.bcnc.app.album.domain.model.Album;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AlbumPersistenceOutputAdapter implements SaveAlbumPersistenceOutputPort, GetAlbumsPersistenceOutputPort {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    @Override
    public Album saveAlbum(Album album) {
        return albumMapper.toAlbum(
                albumRepository.save(
                        albumMapper.toEntity(album)));
    }

    @Override
    public List<Album> getAlbums() {
        return albumRepository.findAll().stream()
                .map(albumMapper::toAlbum)
                .toList();
    }
}
