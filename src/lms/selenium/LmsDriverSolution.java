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
import util.Util;

/**
 *
 * @author Administrator
 */
public class LmsDriverSolution extends LmsSolution implements Runnable {

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
        if (quizState == QuizState.NEW_WORK) {
            super.progress = -3;
            return;
        }
        boolean firstSolution = true;
        //button bắt đầu
        WebElement welmStart = lmsDriver.getWebDriver().findElement(By.xpath("//input[@class='btn btn-default btn-primary']"));
        welmStart.click();
        //load qua tất cả các câu hỏi
        for (int i = 0; i < getTotalProgress(); i++) {
            //select radio best choice
            int bestSolutionIds[] = super.getQuiz().getAnswerBases()[i].getBestSolutionIds();
            String inputType = bestSolutionIds.length > 1 ? "checkbox" : "radio";
            for (int j = 0; j < bestSolutionIds.length; j++) {
                String XPATH = "//input[@type='%s'][@value='%d']";
                XPATH = String.format(XPATH, inputType, bestSolutionIds[j]);
                WebElement welmBestChoice = lmsDriver.getWebDriver().findElement(By.xpath(XPATH));
                welmBestChoice.click();
                Util.sleep(200);
            }
            try { // click next
                WebElement welmButtonNext = lmsDriver.getWebDriver().findElement(By.xpath("//a[@id='bottomnextbutton']"));
                welmButtonNext.click();
            } catch (Exception e) { // next not found
                //click end of test 
                WebElement welmButtonEnd = lmsDriver.getWebDriver().findElement(By.xpath("//li[@class='ilToolbarStickyItem']"));
                welmButtonEnd.click();
                //
                super.progress = getTotalProgress();
                break;
            }
            if (firstSolution) {
                firstSolution = !firstSolution;
                Util.sleep(500);
                try {
                    //turn off notifications 
                    WebElement welmDontShowMes = lmsDriver.getWebDriver().findElement(By.xpath("//input[@type='checkbox']"));
                    welmDontShowMes.click();
                    WebElement welmSend = lmsDriver.getWebDriver().findElement(By.xpath("//a[@id='tst_save_on_navigation_button']"));
                    welmSend.click();
                } catch (Exception e) {
                }
            }

            super.progress += 1;
        }
        try { // click yes, i am want to finish
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
