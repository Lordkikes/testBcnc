package com.test.bcnc.app.album.adapters.persistence.mappers;

import com.test.bcnc.app.album.adapters.persistence.entities.AlbumEntity;
import com.test.bcnc.app.album.domain.model.Album;
import org.mapstruct.Mapper;

@Mapper
public interface AlbumMapper {
    Album toAlbum(AlbumEntity entity);

    AlbumEntity toEntity(Album album);
}