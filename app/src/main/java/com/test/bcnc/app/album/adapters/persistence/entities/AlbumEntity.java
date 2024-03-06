package com.test.bcnc.app.album.adapters.persistence.entities;

import com.test.bcnc.app.photo.adapters.persistence.entities.PhotoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String title;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<PhotoEntity> photos;

    public AlbumEntity(long l, String s) {

    }
}
