package com.test.bcnc.app.album.adapters.rest.output;

import com.test.bcnc.app.album.domain.model.Album;

import java.util.Set;

public interface AlbumRestOutputRepository {

    Set<Album> getAll();

}
