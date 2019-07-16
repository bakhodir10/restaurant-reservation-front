package reservation_front.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reservation_front.domain.FileStorage;
import reservation_front.service.FileStorageService;

import java.util.List;

@Service
public class FileStorageServiceProxy implements FileStorageService {

    @Autowired
    private RestTemplate restTemplate;

    private final String ONE_URL = "http://localhost:8088/file-storage/{id}";
    private final String ALL_URL = "http://localhost:8088/file-storage";


    @Override
    public FileStorage get(Long id) {
        return null;
    }

    @Override
    public List<FileStorage> getAll() {
        return null;
    }

    @Override
    public void add(FileStorage p) {
        restTemplate.postForObject(ALL_URL, p, FileStorage.class);
    }

    @Override
    public void update(Long id, FileStorage p) {

    }

    @Override
    public void delete(Long id) {

    }
}
