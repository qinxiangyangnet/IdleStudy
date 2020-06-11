package com.yueyang.tt.utis;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class HttpUtils {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);

    public static String httpGet(String url) {
        String result = "";
        try {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)//设置链接超时
                .writeTimeout(10, TimeUnit.SECONDS) // 设置写数据超时
                .readTimeout(30, TimeUnit.SECONDS) // 设置读数据超时
                .build();
            Request request = new Request.Builder().url(url).build();
            Response response = okHttpClient.newCall(request).execute(); // 返回实体
            result = !ObjectUtils.isEmpty(response.body()) ? response.body().string() : "";
        } catch (Exception e) {
            LOGGER.error("get请求异常", e);
        }
        return result;
    }

    public static String httpJsonPost(String url, String value) {
        String result = "";
        try {
            RequestBody requestBody = RequestBody.create(JSON, value);
            OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)//设置链接超时
                .writeTimeout(10, TimeUnit.SECONDS) // 设置写数据超时
                .readTimeout(30, TimeUnit.SECONDS) // 设置读数据超时
                .build();
            Request request =
                new Request.Builder().url(url).post(requestBody).addHeader("Content-Type", "application/json").build();
            Response response = client.newCall(request).execute();
            result = !ObjectUtils.isEmpty(response.body()) ? response.body().string() : "";
        } catch (IOException e) {
            LOGGER.error("post-json请求", e);
        }
        return result;
    }

    public static String httpDataPost(String url, File file) {
        String result = "";
        try {
            MultipartBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(),
                    RequestBody.create(MediaType.parse("multipart/form-data"), file)).build();
            OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)//设置链接超时
                .writeTimeout(10, TimeUnit.SECONDS) // 设置写数据超时
                .readTimeout(30, TimeUnit.SECONDS) // 设置读数据超时
                .build();
            Request request = new Request.Builder().url(url).post(requestBody).build();
            Response response = client.newCall(request).execute();
            result = ObjectUtils.isEmpty(response.body()) ? "" : response.body().string();
        } catch (IOException e) {
            LOGGER.error("post-data请求异常", e);
        }
        return result;
    }

    /**
     * 上传永久素材
     */
    public static String uploadPermanentMaterial(String url, File file) {
        String result = null;
        try {
            URL uploadUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)uploadUrl.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Cache-Control", "no-cache");
            String boundary = "-----------------------------" + System.currentTimeMillis();
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            OutputStream output = conn.getOutputStream();
            output.write(("--" + boundary + "\r\n").getBytes());
            output.write(
                String.format("Content-Disposition: form-data; name=\"media\"; filename=\"%s\"\r\n", file.getName())
                    .getBytes());
            output.write("Content-Type: video/mp4 \r\n\r\n".getBytes());
            byte[] data = new byte[1024];
            int len;
            FileInputStream input = new FileInputStream(file);
            while ((len = input.read(data)) > -1) {
                output.write(data, 0, len);
            }
            output.write(("\r\n--" + boundary + "--\r\n\r\n").getBytes());
            output.flush();
            output.close();
            input.close();
            InputStream resp = conn.getInputStream();
            StringBuilder sb = new StringBuilder();
            while ((len = resp.read(data)) > -1) {
                sb.append(new String(data, 0, len, StandardCharsets.UTF_8));
            }
            resp.close();
            result = sb.toString();
        } catch (IOException e) {
            LOGGER.error("上传封面图异常", e);
        }
        return result;
    }

}
