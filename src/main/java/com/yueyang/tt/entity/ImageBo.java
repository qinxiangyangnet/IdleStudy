package com.yueyang.tt.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ImageBo {

    private String uuid;
    private String url;
    private String extension;
    private int size;
    private String base64;

    public static ImageBo createInstance(String url, String extension, int size, String base64) {
        ImageBo imageBo = new ImageBo();
        imageBo.setUuid(UUID.randomUUID().toString());
        imageBo.setExtension(extension);
        imageBo.setUrl(url);
        imageBo.setSize(size);
        imageBo.setBase64(base64);
        return imageBo;
    }

    public String buildPlaceHolderString() {
        return "{img:" + uuid + "}";
    }

}
