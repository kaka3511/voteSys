package com.kaka.common;

public class UtilCache {
    public static Integer userid;

    public UtilCache() {
    }

    public static String username;

    public static Integer getUserid() {
        return userid;
    }

    public static void setUserid(Integer userid) {
        UtilCache.userid = userid;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UtilCache.username = username;
    }
}
