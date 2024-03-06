package com.test.bcnc.app.photo.adapters.rest.output;

import com.test.bcnc.app.photo.domain.model.Photo;

import java.util.Set;

public interface PhotoRestOutputRepository {
    Set<Photo> getAll();
}