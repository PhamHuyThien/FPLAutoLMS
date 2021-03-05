/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.selenium;

import org.openqa.selenium.Cookie;

/**
 *
 * @author Administrator
 */
public class LmsDriverUtil {

    public static Cookie[] parseCookies(String cookie) {
        String[] strCookies = cookie.replaceAll("\\s|cookie:", "").split(";");
        Cookie[] cookies = new Cookie[strCookies.length];
        for (int i = 0; i < cookies.length; i++) {
            String[] pairs = strCookies[i].split("=");
            cookies[i] = new Cookie(pairs[0].trim(), pairs.length > 1 ? pairs[1].trim() : "");
        }
        return cookies;
    }
}
