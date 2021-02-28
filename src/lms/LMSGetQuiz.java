/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import com.httprequest.HttpRequest;
import model.Account;
import model.Course;
import model.Quiz;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Administrator
 */
public class LMSGetQuiz {

    private static final String URL_QUIZ_BASE = "%s/ilias.php?ref_id=%s&cmd=view&cmdClass=ilrepositorygui&cmdNode=q4&baseClass=ilRepositoryGUI";

    public static Quiz[] parse(Account account, Course course) throws LMSException {
        String body = getListQuizBody(account, course);
        Document document = Jsoup.parse(body);
        Quiz[] quizs = parseListQuiz(document);
        return quizs;
    }

    private static String getListQuizBody(Account account, Course course) {
        String urlBase = String.format(URL_QUIZ_BASE, account.getServer().parseURL(), course.getId());
        return HttpRequest.get(urlBase).header("cookie", account.getCookie()).body();
    }

    private static Quiz[] parseListQuiz(Document document) throws LMSException {
        Elements elmsListQuiz = document.select("h4[class='il_ContainerItemTitle']");
        int i = 0;
        try {
            if (elmsListQuiz.isEmpty()) {
                throw new LMSException("parseListQuiz->Không có quiz nào!");
            }
            Quiz[] quizs = new Quiz[elmsListQuiz.size()];
            for (Element elmQuiz : elmsListQuiz) {
                Element elm = elmQuiz.selectFirst("a");
                String href = elm.attr("href");
                int id = LMSUtil.parseRefId(href);
                if (id == -1) {
                    continue;
                }
                String name = elm.text();
                quizs[i] = new Quiz();
                quizs[i].setId(id);
                quizs[i].setName(name);
                i++;
            }
            return quizs;
        } catch (NullPointerException e) {
            throw new LMSException("parseListQuiz->Không tìm thấy thẻ <a/>!");
        }
    }
}
