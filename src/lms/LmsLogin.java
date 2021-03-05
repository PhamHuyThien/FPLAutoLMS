/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import com.httprequest.HttpRequest;
import model.Account;
import model.Server;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Administrator
 */
public class LmsLogin {

    private final static String URL_PERSONAL_PROFILE_BASE = "%s/ilias.php?cmdClass=ilpersonalprofilegui&cmdNode=oq:or&baseClass=ilPersonalDesktopGUI";


    public static Account parse(Server server, String cookie) throws LmsException {
        String body = getProfileBody(server, cookie);
        Document document = Jsoup.parse(body);
        //
        try {
            Account account = new Account(server, cookie);
            account.setName(document.selectFirst("input[id='usr_lastname']").attr("value"));
            account.setBirthday(document.selectFirst("input[name='usr_birthday']").attr("value"));
            account.setSex(document.selectFirst("input[name='usr_gender']").attr("value"));
            account.setRole(document.selectFirst("span[id='ne_dr']").text());
            account.setEmail(document.selectFirst("input[id='usr_email']").attr("value"));
            return account;
        } catch (NullPointerException e) {
            throw new LmsException("Không thể lấy dữ liệu tài khoản!");
        }
    }

    private static String getProfileBody(Server server, String cookie) {
        String serverURLProfile = String.format(URL_PERSONAL_PROFILE_BASE, server.parseURL());
        return HttpRequest.get(serverURLProfile).header("cookie", cookie).body();
    }
}
