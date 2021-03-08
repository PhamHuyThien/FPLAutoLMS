/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.selenium;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.Account;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.OS;

/**
 *
 * @author Administrator
 */
public final class LmsChromeDriver extends LmsDriver {

    private static final String PATH_DRIVER = "\\driver\\chromedriver.exe";

    public LmsChromeDriver(Account account) {
        super(account);
    }

    public LmsChromeDriver(Account account, boolean autoInit) throws FileNotFoundException {
        super(account);
        if (autoInit) {
            init();
        }
    }

    @Override
    public void init() throws FileNotFoundException {
        if (!checkDriverExists()) {
            throw new FileNotFoundException("ChromeDriver not exist!");
        }
        System.setProperty("webdriver.chrome.driver", OS.getScriptDir() + PATH_DRIVER);
        ChromeOptions chromeOptions = new ChromeOptions();
        //disable img
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.managed_default_content_settings.images", 2);
        chromeOptions.setExperimentalOption("prefs", prefs);
        //disable infobars
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        //
        super.setWebDriver(new ChromeDriver(chromeOptions));
        //set width height chrome
//        super.getWebDriver().manage().window().setSize(new Dimension(700,500));
        super.getWebDriver().manage().window().setPosition(new Point(-32000, -32000));
        //
        super.getWebDriver().get(super.getAccount().getServer().parseURL());
        //Buff cookie
        Cookie[] cookies = LmsDriverUtil.parseCookies(super.getAccount().getCookie());
        for (Cookie cookie : cookies) {
            super.getWebDriver().manage().addCookie(cookie);
        }
        super.getWebDriver().navigate().refresh();
    }

    @Override
    public String getPageSource() {
        return super.getWebDriver().getPageSource();
    }

    @Override
    public void close() {
        super.getWebDriver().close();
    }

    @Override
    public boolean checkDriverExists() {
        return new File(OS.getScriptDir() + PATH_DRIVER).exists();
    }

}
