/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.pool;

import lms.LmsException;
import lms.LmsGetAnswerBase;
import model.Account;
import model.AnswerBase;
import model.Quiz;
import util.Console;

/**
 *
 * @author Administrator
 */
public class LMSPoolGetAnswerBase implements Runnable {

    private final Account account;
    private final Quiz quiz;

    private AnswerBase[] answerBases;

    public LMSPoolGetAnswerBase(Account account, Quiz quiz) {
        this.account = account;
        this.quiz = quiz;
    }

    public AnswerBase[] getAnswerBases() {
        return this.answerBases;
    }

    @Override
    public void run() {
        try {
            this.answerBases = LmsGetAnswerBase.parse(this.account, this.quiz);
        } catch (LmsException ex) {
            Console.debug("LMSPoolGetAnswerBase->", LmsGetAnswerBase.class, ex);
        }
    }
}
