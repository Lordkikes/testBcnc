package com.test.bcnc.app.album.domain.model;

import com.test.bcnc.app.photo.domain.model.Photo;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Album {

    private Long userId;
    private Long id;
    private String title;
    @Builder.Default
    private List<Photo> photos = new ArrayList<>();

    public <E> Album(long l, String s, ArrayList<E> es) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Album photo = (Album) o;
        return Objects.equals(this.id, photo.id);
    }
}
