package com.yueyang.tt.utis;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;

public class HtmlUtils {

    private HtmlUtils() {
    }

    /**
     * 取出html内容里面的src的Imgurl地址
     */
    public static List<String> getImgSrc(String content) {
        Pattern NUMBER_PATTERN = compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)");
        if (content == null) {
            return null;
        }
        String img = "";
        List<String> pics = new ArrayList<>();
        String regExImg = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        Pattern pimage = compile(regExImg, CASE_INSENSITIVE);
        Matcher mImage = pimage.matcher(content);
        while (mImage.find()) {
            img = img + "," + mImage.group();
            Matcher m = NUMBER_PATTERN.matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        return pics;
    }

    /**
     * 替换标签
     */
    public static String coverTag(String content, Map<String, List<String>> map) {
        if (!CollectionUtils.isEmpty(map)) {
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                if (!CollectionUtils.isEmpty(map.get(key))) {
                    int i = 0;
                    Document document = Jsoup.parse(content);
                    Elements elements = document.select(key);
                    for (Element element : elements) {
                        element.attr("src", map.get(key).get(i));
                        i++;
                    }
                    content = document.body().toString().replace("<body>", "").replace("</body>", "");
                }
            }
        }
        return content;
    }

    public static Map<String, String> getTagUrl(String content, String tag) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        Document document = Jsoup.parse(content);
        Elements imgElements = document.select(tag);
        for (Element element : imgElements) {
            String imgSrc = element.attr("src");
            String fileName = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
            String encodeUrl = imgSrc.substring(0, imgSrc.lastIndexOf("/") + 1) + URLEncoder.encode(fileName, "UTF-8");
            map.put(imgSrc, StringUtils.replace(encodeUrl, "+", "%20"));
        }
        return map;
    }

}
