/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Administrator
 */
public class Util {

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
