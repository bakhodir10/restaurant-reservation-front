package reservation_front.service;

import reservation_front.domain.FileStorage;

import java.util.List;

public interface FileStorageService {

    FileStorage get(Long id);

    List<FileStorage> getAll();

    void add(FileStorage p);

    void update(Long id, FileStorage p);

    void delete(Long id);
}
