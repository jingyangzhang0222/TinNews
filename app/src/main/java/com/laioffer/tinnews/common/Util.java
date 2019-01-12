package com.laioffer.tinnews.common;

/**
 * Created by jingyangzhang on 12/22/18 in project of TinNews
 */
public class Util {

    private Util() {

    }

    public static boolean isStringEmpty(String string) {
        return string == null || string.length() == 0;
    }
}
