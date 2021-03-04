/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import com.httprequest.HttpRequest;
import model.Account;
import model.Form;
import model.Quiz;
import model.QuizState;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import util.Util;

/**
 *
 * @author Administrator
 */
public abstract class LMSSolution implements Runnable{

    protected static final String URL_BASE = "%s/ilias.php?ref_id=%s&cmd=infoScreen&cmdClass=ilobjtestgui&cmdNode=q4:ll&baseClass=ilRepositoryGUI";
    protected static final String URL_POST_ANSWER_BASE = "%s/ilias.php?ref_id=%s&sequence=%s&pmode=edit&cmd=post&cmdClass=iltestplayerfixedquestionsetgui&cmdNode=q4:ll:wm&baseClass=ilRepositoryGUI&fallbackCmd=submitIntermediateSolution&rtoken=%s&test_answer_changed=1";
    
    protected Account account;
    protected Quiz quiz;
    
    protected int progress;

    public LMSSolution(Account account, Quiz quiz) {
        this.account = account;
        this.quiz = quiz;
    }
    
    public abstract void start();
    public abstract  int getProgress();
}
