/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import model.Account;
import model.Course;
import model.Quiz;
import org.http.simple.JHttp;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Administrator
 */
public class LmsGetQuiz {

    private static final String URL_QUIZ_BASE = "%s/ilias.php?ref_id=%s&cmd=view&cmdClass=ilrepositorygui&cmdNode=q4&baseClass=ilRepositoryGUI";

    public static Quiz[] parse(Account account, Course course) throws LmsException {
        String body = getListQuizBody(account, course);
        Document document = Jsoup.parse(body);
        Quiz[] quizs = parseQuizs(document);
        return quizs;
    }

    private static String getListQuizBody(Account account, Course course) {
        String urlBase = String.format(URL_QUIZ_BASE, account.getServer().parseURL(), course.getId());
        return JHttp.get(urlBase).cookie(account.getCookie()).body();
    }

    private static Quiz[] parseQuizs(Document document) throws LmsException {
        Elements elmsItemContent = document.select("div[class='ilContainerListItemContent ']");
        if (elmsItemContent.isEmpty()) {
            throw new LmsException("parseQuizs-> Quiz empty!");
        }
        try {
            Quiz[] quizs = new Quiz[elmsItemContent.size()];
            int i = 0;
            for (Element elmItemContent : elmsItemContent) {
                Element elmLink = elmItemContent.selectFirst("a");
                Element elmDesc = elmItemContent.selectFirst("div[class='ilListItemSection il_Description']");
                quizs[i] = new Quiz();
                quizs[i].setId(LmsUtil.parseRefId(elmLink.attr("href")));
                quizs[i].setName(elmLink.text().trim());
                quizs[i].setAutomationSupport(elmDesc.text().trim().equals(""));
                i++;
            }
            return quizs;
        } catch (NullPointerException e) {
            throw new LmsException("parseQuizs-> Tag <a> or <> is null!");
        }
    }
}
