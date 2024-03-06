package com.test.bcnc.app.photo.application.output;

import com.test.bcnc.app.photo.domain.model.Photo;

import java.util.Set;

public interface PhotoRestOutputPort {
    Set<Photo> getPhotos();
}
