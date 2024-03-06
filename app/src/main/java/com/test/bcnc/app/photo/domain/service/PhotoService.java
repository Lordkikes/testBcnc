package com.test.bcnc.app.photo.domain.service;

import com.test.bcnc.app.photo.application.input.GetPhotosInputPort;
import com.test.bcnc.app.photo.application.output.PhotoRestOutputPort;
import com.test.bcnc.app.photo.domain.model.Photo;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class PhotoService implements GetPhotosInputPort {

    private final PhotoRestOutputPort photoRestOutputPort;

    @Override
    public Set<Photo> getPhotos() {
        return photoRestOutputPort.getPhotos();
    }

}
