/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.selenium;

import lms.LmsSolution;
import lms.LmsUtil;
import model.Quiz;
import model.QuizState;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Administrator
 */
public class LmsDriverSolution extends LmsSolution implements Runnable{

    private final LmsDriver lmsDriver;

    public LmsDriverSolution(LmsDriver lmsDriver, Quiz quiz) {
        super(lmsDriver.getAccount(), quiz);
        this.lmsDriver = lmsDriver;
    }

    @Override
    public void start() {
        //go to start
        String url = String.format(LmsSolution.URL_BASE,
                super.getAccount().getServer().parseURL(),
                super.getQuiz().getId()
        );
        if (lmsDriver.getWebDriver().getCurrentUrl().equals(url)) {
            lmsDriver.getWebDriver().navigate().refresh();
        } else {
            lmsDriver.getWebDriver().navigate().to(url);
        }
        QuizState quizState = LmsUtil.getQuizState(Jsoup.parse(lmsDriver.getPageSource()));
        if (quizState == QuizState.FINISH_WORK) {
            super.progress = -1;
            return;
        }
        if (quizState == QuizState.NOT_WORKING) {
            super.progress = -2;
            return;
        }
        if (quizState == QuizState.NOT_WORKING) {
            super.progress = -3;
            return;
        }
        //button bắt đầu
        WebElement welmStart = lmsDriver.getWebDriver().findElement(By.xpath("//input[@class='btn btn-default btn-primary']"));
        welmStart.click();
        //load qua tất cả các câu hỏi
        for (int i = 0; i < getTotalProgress(); i++) {
            //select radio best choice
            int bestSolutionId = super.getQuiz().getAnswerBases()[i].getBestSolutionId();
            WebElement welmBestChoice = lmsDriver.getWebDriver().findElement(By.xpath("//input[@type='radio'][@value='" + bestSolutionId + "']"));
            welmBestChoice.click();
            try {
                WebElement welmButtonNext = lmsDriver.getWebDriver().findElement(By.xpath("//a[@id='bottomnextbutton']"));
                welmButtonNext.click();

            } catch (Exception e) {
                WebElement welmButtonEnd = lmsDriver.getWebDriver().findElement(By.xpath("//a[@class='ilTstNavElem btn btn-default']"));
                welmButtonEnd.click();
                super.progress = getTotalProgress();
                break;
            }
            super.progress += 1;
        }
        try {
            WebElement welmYesFinish = lmsDriver.getWebDriver().findElement(By.xpath("//input[@class='btn btn-default']"));
            welmYesFinish.click();
        } catch (Exception e) {
        }
    }

    @Override
    public int getProgress() {
        return super.progress;
    }

    @Override
    public int getTotalProgress() {
        if (super.getQuiz() != null && super.getQuiz().getAnswerBases() != null) {
            return super.getQuiz().getAnswerBases().length;
        }
        return -1;
    }

    @Override
    public void run() {
        start();
    }
}
