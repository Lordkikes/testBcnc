package com.test.bcnc.app.photo.adapters.rest.output;

import com.test.bcnc.app.photo.domain.model.Photo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@Repository
@RequiredArgsConstructor
public class PhotoRestOutputRepositoryImpl implements PhotoRestOutputRepository {

    private final RestTemplate restTemplate;

    @Override
    public Set<Photo> getAll() {
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/photos",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Set<Photo>>() {
                        })
                .getBody();
    }
}
