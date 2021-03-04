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
public class LMSGetAnswerBase {
    
    private static final String URL_HACKQUIZ_BASE = "%s/ilias.php?ref_id=%s&active_id=&pass=0&cmd=outUserPassDetails&cmdClass=iltestevaluationgui&cmdNode=q4:ll:vx&baseClass=ilRepositoryGUI";
    
    
    public static AnswerBase[] parse(Account account, Quiz quiz) throws LMSException{
        
        String body = getAnswerBaseBody(account, quiz.getId());
        Document document = Jsoup.parse(body);
        AnswerBase[] answerBases = getAnswerBases(document);
        return answerBases;
    }
    
    
    private static String getAnswerBaseBody(Account account, int refIdQuiz){
        String baseURL = String.format(URL_HACKQUIZ_BASE, account.getServer().parseURL(), refIdQuiz);
        return HttpRequest.get(baseURL).header("cookie", account.getCookie()).body();
    }
    
    private static AnswerBase[] getAnswerBases(Document document) throws LMSException{
        try {
            Element elmTbody = document.selectFirst("tbody");
            Elements elmsTr = elmTbody.select("tr");
            AnswerBase[] answerBases = new AnswerBase[elmsTr.size()];
            int i=0;
            for(Element elmTr: elmsTr){
                Elements elmsTd = elmTr.select("td");
                answerBases[i] = new AnswerBase();
                answerBases[i].setId(Integer.parseInt(elmsTd.get(1).text()));
                answerBases[i].setQuestion(elmsTd.get(2).selectFirst("a").text());
                i++;
            }
            return answerBases;
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new LMSException("getAnswerBases->thẻ <tbody> <tr> <td> <a> có thể không tồn tại!");
        }
    }
}
