/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import model.Account;
import model.Quiz;

/**
 *
 * @author Administrator
 */
public abstract class LmsSolution implements Runnable{

    public static final String URL_BASE = "%s/ilias.php?ref_id=%s&cmd=infoScreen&cmdClass=ilobjtestgui&cmdNode=q4:ll&baseClass=ilRepositoryGUI";
    protected static final String URL_POST_ANSWER_BASE = "%s/ilias.php?ref_id=%s&sequence=%s&pmode=edit&cmd=post&cmdClass=iltestplayerfixedquestionsetgui&cmdNode=q4:ll:wm&baseClass=ilRepositoryGUI&fallbackCmd=submitIntermediateSolution&rtoken=%s&test_answer_changed=1";
    
    private final Account account;
    private final Quiz quiz;
    
    protected int progress;
   
    public LmsSolution(Account account, Quiz quiz) {
        this.account = account;
        this.quiz = quiz;
    }
    
    public Account getAccount() {
        return account;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    
    public abstract void start();
    public abstract int getProgress();
    public abstract int getTotalProgress();
}
