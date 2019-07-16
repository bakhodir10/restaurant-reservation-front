package reservation_front.domain;

import lombok.Data;

@Data
public class FileStorage {
    private Long id;
    private String name;
    private Long size;
    private byte[] data;
}
