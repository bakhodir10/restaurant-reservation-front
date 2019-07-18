package reservation_front.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class FileStorage implements Serializable {
    private Long id;
    private String name;
    private Long size;
    private byte[] data;
    private String base64image;
}