/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.selenium;

import java.io.FileNotFoundException;
import model.Account;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Administrator
 */
public abstract class LmsDriver {

    private final Account account;
    private WebDriver webDriver;

    public LmsDriver(Account account) {
        this.account = account;
    }

    protected Account getAccount() {
        return account;
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }

    protected void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public abstract void init() throws FileNotFoundException;
    public abstract boolean checkDriverExists();
    public abstract String getPageSource();
    public abstract void close();
}
