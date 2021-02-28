/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.pool;

import lms.LMSException;
import lms.LMSGetAnswerBase;
import lms.LMSGetAnswerBaseValue;
import model.Account;
import model.AnswerBase;
import model.Quiz;
import util.Console;

/**
 *
 * @author Administrator
 */
public class LMSPoolGetAnswerBaseValue implements Runnable{
    private final Account account;
    private final Quiz quiz;
    private AnswerBase answerBase;

    public LMSPoolGetAnswerBaseValue(Account account, Quiz quiz, AnswerBase answerBase) {
        this.account = account;
        this.quiz = quiz;
        this.answerBase = answerBase;
    }

    @Override
    public void run() {
        try {
            this.answerBase = LMSGetAnswerBaseValue.parse(this.account, this.quiz, this.answerBase);
        } catch (LMSException e) {
            Console.debug("LMSPoolGetAnswerBaseValue->", LMSGetAnswerBaseValue.class, e);
        }
    }
    
    
}
