/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import com.httprequest.HttpRequest;
import model.Account;
import model.AnswerBase;
import model.Quiz;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Administrator
 */
public class LmsGetAnswerBaseValue {

    private final static String URL_GET_ANSWER_BASE = "%s/ilias.php?ref_id=%s&active_id=&pass=0&evaluation=%s&cmd=outCorrectSolution&cmdClass=iltestevaluationgui&cmdNode=q4:ll:vx&baseClass=ilRepositoryGUI";


    public static AnswerBase parse(Account account, Quiz quiz, AnswerBase answerBase) throws LmsException {
        String body = getAnswerBaseBody(account, quiz, answerBase);
        Document document = Jsoup.parse(body);
        answerBase = parseAnswerBaseValue(document, answerBase);
        return answerBase;
    }
    
    
    private static AnswerBase parseAnswerBaseValue(Document document, AnswerBase answerBase) throws LmsException {
        try {
            answerBase.setAnswerTexts(parseListAnswerText(document));
            answerBase.setBestSolutionId(parseBestSolutionId(document, answerBase));
            return answerBase;
        } catch (NullPointerException | LmsException e) {
            throw new LmsException("parseAnswerBaseValue->" + e.toString());
        }
    }

    private static String[] parseListAnswerText(Document document) throws LmsException {
        Element elmTable = document.selectFirst("table[class='nobackground middle ilClearFloat']");
        Elements elmsAnswerText = elmTable.select("span");
        if (elmsAnswerText.isEmpty()) {
            throw new LmsException("Không tìm thấy câu hỏi nào!");
        }
        String[] answerText = new String[elmsAnswerText.size()];
        int i = 0;
        for (Element elmAnswerText : elmsAnswerText) {
            answerText[i++] = elmAnswerText.text();
        }
        return answerText;
    }

    
    
    private static int parseBestSolutionId(Document document, AnswerBase answerBase) throws LmsException {
        String name = String.format("multiple_choice_result_q%s_bestsolution", answerBase.getId());
        try {
            String bestSolutionId = document.selectFirst(String.format("input[name='%s'][checked]", name)).attr("value");
            return Integer.parseInt(bestSolutionId);
        } catch (NumberFormatException | NullPointerException e) {
            throw new LmsException("parseBestSolutionId->Không tìm thấy thẻ <input name=%s checked/>!");
        }
    }

    private static String getAnswerBaseBody(Account account, Quiz quiz, AnswerBase answerBase) {
        String baseURL = String.format(URL_GET_ANSWER_BASE, account.getServer().parseURL(), quiz.getId(), answerBase.getId());
        return HttpRequest.get(baseURL).header("cookie", account.getCookie()).body();
    }
}
