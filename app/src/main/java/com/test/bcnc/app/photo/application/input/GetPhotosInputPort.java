package com.test.bcnc.app.photo.application.input;

import com.test.bcnc.app.photo.domain.model.Photo;

import java.util.Set;

public interface GetPhotosInputPort {
    Set<Photo> getPhotos();
}
