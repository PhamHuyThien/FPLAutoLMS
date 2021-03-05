/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.pool;

import lms.LmsUtil;
import model.Account;
import model.Quiz;
import model.QuizState;

/**
 *
 * @author Administrator
 */
public class LMSPoolGetQuizState implements Runnable{
    private final Account account;
    private final Quiz quiz;

    public LMSPoolGetQuizState(Account account, Quiz quiz) {
        this.account = account;
        this.quiz = quiz;
    }

    public Quiz getQuiz() {
        return quiz;
    }
    
    @Override
    public void run() {
        QuizState quizState = LmsUtil.getQuizState(this.account, this.quiz);
        quiz.setQuizState(quizState);
    }
    
}
