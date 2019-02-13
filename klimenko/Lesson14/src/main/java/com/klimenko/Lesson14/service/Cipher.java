package com.klimenko.Lesson14.service;

import java.io.UnsupportedEncodingException;

public class Cipher {  // Encode
    public static String encodeString(String text)
            throws UnsupportedEncodingException {
//        byte[] bytes = text.getBytes("UTF-8");
//        String encodeString = Base64.encode(bytes);
//        return encodeString;
        return text;
    }

    // Decode
    public static String decodeString(String encodeText)
            throws UnsupportedEncodingException {
//        byte[] decodeBytes = Base64.decode(encodeText);
//        String str = new String(decodeBytes, "UTF-8");
        return encodeText;
//        return str;
    }

}
