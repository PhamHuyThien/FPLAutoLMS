/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.pool;

import lms.LmsException;
import lms.LmsGetAnswerBaseValue;
import model.Account;
import model.AnswerBase;
import model.Quiz;
import util.Console;

/**
 *
 * @author Administrator
 */
public class LMSPoolGetAnswerBaseValue implements Runnable {

    private final Account account;
    private final Quiz quiz;
    private AnswerBase answerBase;

    public LMSPoolGetAnswerBaseValue(Account account, Quiz quiz, AnswerBase answerBase) {
        this.account = account;
        this.quiz = quiz;
        this.answerBase = answerBase;
    }

    public AnswerBase getAnswerBase() {
        return answerBase;
    }

    @Override
    public void run() {
        try {
            this.answerBase = LmsGetAnswerBaseValue.parse(this.account, this.quiz, this.answerBase);
        } catch (LmsException e) {
            Console.debug("LMSPoolGetAnswerBaseValue->", LmsGetAnswerBaseValue.class, e);
        }
    }

}
