/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.selenium;

import lms.LMSSolution;
import lms.LMSUtil;
import model.Quiz;
import model.QuizState;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Administrator
 */
public class LMSDriverSolution extends LMSSolution implements Runnable{

    private final LMSDriver lMSDriver;
    private final Quiz quiz;
    private boolean autoStart;

    private boolean isStart;

    public LMSDriverSolution(LMSDriver lMSDriver, Quiz quiz) {
        super(lMSDriver.account, quiz);
        this.lMSDriver = lMSDriver;
        this.quiz = quiz;
    }

    public LMSDriverSolution(LMSDriver lMSDriver, Quiz quiz, boolean autoStart) {
        super(lMSDriver.account, quiz);
        this.lMSDriver = lMSDriver;
        this.quiz = quiz;
        this.autoStart = autoStart;
    }

    public boolean isAutoStart() {
        return autoStart;
    }

    public void setAutoStart(boolean autoStart) {
        this.autoStart = autoStart;
    }

    public boolean isIsStart() {
        return isStart;
    }

    public void setIsStart(boolean isStart) {
        this.isStart = isStart;
    }

    @Override
    public void start() {
        if (isStart) {
            return;
        }
        isStart = !isStart;
        lMSDriver.init();
        //go to start
        String url = String.format(
                LMSSolution.URL_BASE,
                super.account.getServer().parseURL(),
                this.quiz.getId()
        );
        if (lMSDriver.webDriver.getCurrentUrl().equals(url)) {
            lMSDriver.webDriver.navigate().refresh();
        } else {
            lMSDriver.webDriver.navigate().to(url);
        }
        QuizState quizState = LMSUtil.getQuizState(Jsoup.parse(lMSDriver.getPageSource()));
        if (quizState == QuizState.FINISH_WORK) {
            super.progress = -1;
            return;
        }
        if (quizState == QuizState.NOT_WORKING) {
            super.progress = -2;
            return;
        }
        if (quizState == QuizState.NOT_WORKING && autoStart == false) {
            super.progress = -3;
            return;
        }
        //button bắt đầu
        WebElement welmStart = lMSDriver.webDriver.findElement(By.xpath("//input[@class='btn btn-default btn-primary']"));
        welmStart.click();
        //load qua tất cả các câu hỏi
        for (int i = 0; i < getTotalProgress(); i++) {
            int bestSolutionId = quiz.getAnswerBases()[i].getBestSolutionId();
            WebElement welmBestChoice = lMSDriver.webDriver.findElement(By.xpath("//input[@type='radio'][@value='" + bestSolutionId + "']"));
            welmBestChoice.click();
            try {
                WebElement welmButtonNext = lMSDriver.webDriver.findElement(By.xpath("//a[@id='bottomnextbutton']"));
                welmButtonNext.click();

            } catch (Exception e) {
                WebElement welmButtonEnd = lMSDriver.webDriver.findElement(By.xpath("//a[@class='ilTstNavElem btn btn-default']"));
                welmButtonEnd.click();
                super.progress = getTotalProgress();
                break;
            }
            super.progress += 1;
        }
        try {
            WebElement welmYesFinish = lMSDriver.webDriver.findElement(By.xpath("//input[@class='btn btn-default']"));
            welmYesFinish.click();
        } catch (Exception e) {
        }
    }

    @Override
    public int getProgress() {
        return super.progress;
    }

    public int getTotalProgress() {
        if (quiz != null && quiz.getAnswerBases() != null) {
            return quiz.getAnswerBases().length;
        }
        return -1;
    }

    @Override
    public void run() {
        start();
    }
}
