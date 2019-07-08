package org.project.configurations.selenium;

import org.project.botstyle.BotStyle;
import org.openqa.selenium.WebDriver;

public class PageObjectBase {

    private WebDriver driver;
    private BotStyle bot;

    public PageObjectBase(WebDriver driver) {
        this.driver = driver;
        this.bot = new BotStyle(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public BotStyle getBot() {
        return bot;
    }

    public void setBot(BotStyle bot) {
        this.bot = bot;
    }

}
