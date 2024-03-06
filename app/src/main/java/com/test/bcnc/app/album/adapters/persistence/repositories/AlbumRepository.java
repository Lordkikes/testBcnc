package com.test.bcnc.app.album.adapters.persistence.repositories;

import com.test.bcnc.app.album.adapters.persistence.entities.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

}
