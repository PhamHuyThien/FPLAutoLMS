/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.selenium;

import lms.LmsSolution;
import lms.LmsUtil;
import model.Account;
import model.Quiz;
import model.QuizState;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Administrator
 */
public class LmsDriverStartQuiz {

    public static boolean start(LmsDriver lmsDriver, Account account, Quiz quiz) {
        //go to start
        String url = String.format(LmsSolution.URL_BASE,
                account.getServer().parseURL(),
                quiz.getId()
        );
        if (lmsDriver.getWebDriver().getCurrentUrl().equals(url)) {
            lmsDriver.getWebDriver().navigate().refresh();
        } else {
            lmsDriver.getWebDriver().navigate().to(url);
        }
        QuizState quizState = LmsUtil.getQuizState(Jsoup.parse(lmsDriver.getPageSource()));
        if (quizState == QuizState.NOT_WORKING) {
            try {
                //button bắt đầu
                WebElement welmStart = lmsDriver.getWebDriver().findElement(By.xpath("//input[@class='btn btn-default btn-primary']"));
                welmStart.click();
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

}
