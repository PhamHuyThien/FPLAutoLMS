/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Administrator
 */
public class Util {
    
    public static String URLEncoder(String url) {
        String encoder = null;
        try {
            encoder = URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        return encoder;
    }

    public static String base64Encode(String inp) {
        BASE64Encoder b64 = new BASE64Encoder();
        return b64.encodeBuffer(inp.getBytes());
    }

    public static long toSecond() {
        return new Date().getTime() / 1000;
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
        }
    }

    public static String[] regex(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        ArrayList<String> alValue = new ArrayList<>();
        while (matcher.find()) {
            alValue.add(matcher.group());
        }
        if (alValue.isEmpty()) {
            return null;
        }
        String[] strValues = new String[alValue.size()];
        int i = 0;
        for (String s : alValue) {
            strValues[i] = alValue.get(i);
            i++;
        }
        return strValues;
    }
}
