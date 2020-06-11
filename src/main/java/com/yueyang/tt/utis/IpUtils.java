package com.yueyang.tt.utis;

import javax.servlet.http.HttpServletRequest;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class IpUtils {

    private static final String IP_REGEX = "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
    private static final Pattern PATTERN = Pattern.compile("^(?:" + IP_REGEX + "\\.){3}" + IP_REGEX + "$");

    private IpUtils() {
    }

    public static String getIpFromRequest(HttpServletRequest request) {
        String ip;
        boolean found = false;
        if ((ip = request.getHeader("x-forwarded-for")) != null) {
            StringTokenizer tokenizer = new StringTokenizer(ip, ",");
            while (tokenizer.hasMoreTokens()) {
                ip = tokenizer.nextToken().trim();
                if (isIp4Valid(ip) && !isIp4Private(ip)) {
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private static boolean isIp4Valid(String ip) {
        return PATTERN.matcher(ip).matches();
    }

    private static boolean isIp4Private(String ip) {
        long longIp = ip4ToLong(ip);
        return (longIp >= ip4ToLong("10.0.0.0") && longIp <= ip4ToLong("10.255.255.255")) || (
            longIp >= ip4ToLong("172.16.0.0") && longIp <= ip4ToLong("172.31.255.255")) || (
            longIp >= ip4ToLong("192.168.0.0") && longIp <= ip4ToLong("192.168.255.255"));
    }

    private static long ip4ToLong(String ip) {
        String[] octets = ip.split("\\.");
        return (Long.parseLong(octets[0]) << 24) + (Long.parseLong(octets[1]) << 16) + (Long.parseLong(octets[2]) << 8)
            + (Long.parseLong(octets[3]) << 3);
    }

}
