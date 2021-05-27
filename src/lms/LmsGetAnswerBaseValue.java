/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import model.Account;
import model.AnswerBase;
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
            answerBase.setBestSolutionIds(parseBestSolutionId(document, answerBase));
            return answerBase;
        } catch (LmsException | NullPointerException e) {
            throw new LmsException("parseAnswerBaseValue->" + e.toString());
        }
    }

    private static String[] parseListAnswerText(Document document) throws LmsException {
        Element elmTable = document.selectFirst("table[class='nobackground middle ilClearFloat']");
        if(elmTable == null){
            elmTable = document.selectFirst("table[class='nobackground ilClearFloat']");
        }
        Elements elmsRows = elmTable.select("tr");
        String[] answerText = new String[elmsRows.size()];
        int i = 0;
        for (Element elmRow : elmsRows) {
            Elements elmsCols = elmRow.select("td");
            if(elmsCols.size()>1){
                answerText[i++] = elmsCols.get(1).text();
            }
        }
        return answerText;
    }

    
    
    private static int[] parseBestSolutionId(Document document, AnswerBase answerBase) throws LmsException {
        String name = String.format("multiple_choice_result_q%s_bestsolution", answerBase.getId());
        try {
            Elements ElmsBestSolutionIds = document.select(String.format("input[name='%s'][checked]", name));
            int[] bestSolutionIds = new int[ElmsBestSolutionIds.size()];
            for(int i=0; i<bestSolutionIds.length; i++){
                Element elmSolutionId = ElmsBestSolutionIds.get(i);
                String solutionId = elmSolutionId.attr("value");
                bestSolutionIds[i] = Integer.parseInt(solutionId);
            }
            return bestSolutionIds;
        } catch (NumberFormatException | NullPointerException e) {
            throw new LmsException("parseBestSolutionId->Không tìm thấy thẻ <input name=%s checked/>!");
        }
    }

    private static String getAnswerBaseBody(Account account, Quiz quiz, AnswerBase answerBase) {
        String baseURL = String.format(URL_GET_ANSWER_BASE, account.getServer().parseURL(), quiz.getId(), answerBase.getId());
        return JHttp.get(baseURL).cookie(account.getCookie()).body();
    }
}
