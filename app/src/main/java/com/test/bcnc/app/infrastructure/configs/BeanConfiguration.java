package com.test.bcnc.app.infrastructure.configs;

import com.test.bcnc.app.album.adapters.persistence.AlbumPersistenceOutputAdapter;
import com.test.bcnc.app.album.adapters.persistence.mappers.AlbumMapper;
import com.test.bcnc.app.album.adapters.persistence.repositories.AlbumRepository;
import com.test.bcnc.app.album.adapters.rest.output.AlbumRestOutputAdapter;
import com.test.bcnc.app.album.adapters.rest.output.AlbumRestOutputRepository;
import com.test.bcnc.app.album.application.output.GetAlbumsPersistenceOutputPort;
import com.test.bcnc.app.album.application.output.GetAlbumsRestOutputPort;
import com.test.bcnc.app.album.application.output.SaveAlbumPersistenceOutputPort;
import com.test.bcnc.app.album.domain.service.AlbumService;
import com.test.bcnc.app.photo.adapters.rest.output.PhotoRestOutputAdapter;
import com.test.bcnc.app.photo.adapters.rest.output.PhotoRestOutputRepository;
import com.test.bcnc.app.photo.application.output.PhotoRestOutputPort;
import com.test.bcnc.app.photo.domain.service.PhotoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public AlbumPersistenceOutputAdapter albumPersistenceOutputAdapter(
            AlbumRepository albumRepository, AlbumMapper albumMapper) {
        return new AlbumPersistenceOutputAdapter(albumRepository, albumMapper);
    }

    @Bean
    public AlbumRestOutputAdapter albumRestOutputAdapter(AlbumRestOutputRepository albumRepository) {
        return new AlbumRestOutputAdapter(albumRepository);
    }

    @Bean
    public PhotoRestOutputAdapter photoRestOutputPort(PhotoRestOutputRepository photoRepository) {
        return new PhotoRestOutputAdapter(photoRepository);
    }

    @Bean
    public AlbumService albumService(SaveAlbumPersistenceOutputPort albumPersistenceOutputPort,
                                     GetAlbumsPersistenceOutputPort getAlbumsPersistenceOutputPort,
                                     GetAlbumsRestOutputPort albumRestOutputPort) {
        return new AlbumService(albumPersistenceOutputPort, getAlbumsPersistenceOutputPort, albumRestOutputPort);
    }

    @Bean
    public PhotoService photoService(PhotoRestOutputPort photoRestOutputPort) {
        return new PhotoService(photoRestOutputPort);
    }
}
