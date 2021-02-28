/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import util.Util;

/**
 *
 * @author Administrator
 */
public class LMSUtil {

    public static int parseRefId(String href){
        String[] strRefs = Util.regex("ref_id=([0-9]+)&", href);
        if(strRefs == null){
            return -1;
        }
        return Integer.parseInt(strRefs[0].replaceAll("ref_id=|&", ""));
    }
    
}
