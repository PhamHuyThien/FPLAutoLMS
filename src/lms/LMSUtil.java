/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import com.httprequest.HttpRequest;
import java.util.Arrays;
import java.util.HashMap;
import model.Account;
import model.Form;
import model.Quiz;
import model.QuizState;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import util.Util;

/**
 *
 * @author Administrator
 */
public class LMSUtil {

    public static Form[] buildForm(Document document) {
        Elements elmsForm = document.select("form");
        Form[] forms = new Form[elmsForm.size()];
        for (int i = 0; i < forms.length; i++) {
            try {
                forms[i] = new Form();
                forms[i].setMethod(elmsForm.get(i).attr("method"));
                forms[i].setUrl(elmsForm.get(i).attr("action"));
                Elements elmsInput = elmsForm.get(i).select("input");
                HashMap<String, String> hashMap = new HashMap<>();
                for(int j=0; j<elmsInput.size(); j++){
                    hashMap.put(elmsInput.get(j).attr("name"), elmsInput.get(j).attr("value"));
                }
                forms[i].setParam(hashMap);
            } catch (NullPointerException e) {
            }
        }
        return forms;
    }

    public static QuizState getQuizState(Account account, Quiz quiz) {
        final String URL_BASE = "%s/ilias.php?ref_id=%s&cmd=infoScreen&cmdClass=ilobjtestgui&cmdNode=q4:ll&baseClass=ilRepositoryGUI";
        String url = String.format(URL_BASE, account.getServer().parseURL(), quiz.getId());
        String body = HttpRequest.get(url).header("cookie", account.getCookie()).body();
        Document document = Jsoup.parse(body);
        return getQuizState(document);
    }

    public static QuizState getQuizState(Document document) {
        try {
            String value = document.selectFirst("input[class='btn btn-default btn-primary']").attr("value");
            if (value.trim().equals("Bắt đầu bài kiểm tra")) {
                return QuizState.NOT_WORKING;
            }
            if (value.trim().equals("Tiếp tục bài kiểm tra")) {
                return QuizState.WORKING;
            }
            if (value.trim().equals("Start New Test Pass")) {
                return QuizState.NEW_WORK;
            }
        } catch (NullPointerException e) {
            return QuizState.FINISH_WORK;
        }
        return null;
    }

    public static int parseRefId(String href) {
        String[] strRefs = Util.regex("ref_id=([0-9]+)&", href);
        if (strRefs == null) {
            return -1;
        }
        return Integer.parseInt(strRefs[0].replaceAll("ref_id=|&", ""));
    }

}
