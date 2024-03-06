package com.test.bcnc.app.album.adapters.rest.output;

import com.test.bcnc.app.album.application.output.GetAlbumsRestOutputPort;
import com.test.bcnc.app.album.domain.model.Album;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class AlbumRestOutputAdapter implements GetAlbumsRestOutputPort {

    private final AlbumRestOutputRepository albumRepository;

    @Override
    public Set<Album> getAlbums() {
        return albumRepository.getAll();
    }
}
