/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.selenium;

import model.Account;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Administrator
 */
public abstract class LMSDriver {

    protected WebDriver webDriver;
    protected Account account;

    public LMSDriver(Account account) {
        this.account = account;
    }

    public abstract void init();
    public abstract String getPageSource();
    public abstract  void close();
}
