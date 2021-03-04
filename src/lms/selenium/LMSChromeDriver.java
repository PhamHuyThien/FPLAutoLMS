/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.selenium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.Account;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import util.OS;
import util.Util;

/**
 *
 * @author Administrator
 */
public final class LMSChromeDriver extends LMSDriver {

    private boolean isInit;

    public LMSChromeDriver(Account account) {
        super(account);
    }

    @Override
    public void init() {
        if (isInit) {
            return;
        }
        isInit = !isInit;
        System.setProperty("webdriver.chrome.driver", OS.getScriptDir() + "\\driver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //disable img
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.managed_default_content_settings.images", 2);
        chromeOptions.setExperimentalOption("prefs", prefs);
        //disable infobars
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        //
        ChromeDriverService chromeDriverService = ChromeDriverService.createDefaultService();
        //
        super.webDriver = new ChromeDriver(chromeDriverService, chromeOptions);
        //set width height chrome
//        super.webDriver.manage().window().setSize(new Dimension(700,500));
        super.webDriver.manage().window().setPosition(new Point(-32000,-32000));
        //
        super.webDriver.get(account.getServer().parseURL());
        //Buff cookie
        super.webDriver.manage().addCookie(new Cookie("PHPSESSID", getPHPSESSID()));
        super.webDriver.navigate().refresh();
    }

    public String getPHPSESSID() {
        String[] cookies = Util.regex("PHPSESSID=(.+?);", super.account.getCookie());
        if (cookies.length > 0) {
            return cookies[0].replaceAll("PHPSESSID=|;", "");
        }
        return null;
    }
    
    @Override
    public String getPageSource(){
        init();
        return super.webDriver.getPageSource();
    }

    @Override
    public void close() {
        init();
        super.webDriver.close();
    }
    
}
