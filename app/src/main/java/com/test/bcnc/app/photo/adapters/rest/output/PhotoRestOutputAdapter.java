package com.test.bcnc.app.photo.adapters.rest.output;

import com.test.bcnc.app.photo.application.output.PhotoRestOutputPort;
import com.test.bcnc.app.photo.domain.model.Photo;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class PhotoRestOutputAdapter implements PhotoRestOutputPort {

    private final PhotoRestOutputRepository photoRepository;

    @Override
    public Set<Photo> getPhotos() {
        return photoRepository.getAll();
    }
}
