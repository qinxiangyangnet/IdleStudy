package com.yueyang.tt.utis;

import com.yueyang.tt.entity.ImageBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownloadUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageDownloadUtils.class);

    private ImageDownloadUtils() {
    }

    public static ImageBo downloadFromUrl(String urlStr) {
        InputStream is = null;
        try {
            String extension = parseImageExtension(urlStr);
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36");
            conn.setConnectTimeout(5000);
            is = conn.getInputStream();
            byte[] bytes = new byte[2048];
            int readSize, totalSize = 0;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while ((readSize = is.read(bytes)) > 0) {
                totalSize += readSize;
                byteArrayOutputStream.write(bytes, 0, readSize);
            }
            String imgInBase64 = Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());
            return ImageBo.createInstance(urlStr, extension, totalSize, imgInBase64);
        } catch (Exception e) {
            LOGGER.error("Failed to download image from [{}]: {}", urlStr, e.getMessage());
            throw new RuntimeException("Error occurred while downloading image from " + urlStr);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                LOGGER.error("Error to close input stream for connection [{}]: {}", urlStr, e.getMessage());
            }
        }
    }

    private static String parseImageExtension(String url) {
        int i = url.indexOf("?");
        if (i != -1) {
            url = url.substring(0, i);
        }
        i = url.lastIndexOf(".");
        return url.substring(i + 1);
    }

}
