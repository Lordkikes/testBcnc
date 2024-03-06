package com.test.bcnc.app.photo.adapters.persistence.entities;

import com.test.bcnc.app.album.adapters.persistence.entities.AlbumEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(insertable=false, updatable=false)
    private Long albumId;
    private String title;
    private String url;
    private String thumbnailUr;

    @ManyToOne
    @JoinColumn(name = "albumId")
    private AlbumEntity album;
}
