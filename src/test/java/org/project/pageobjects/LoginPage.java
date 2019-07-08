package org.project.pageobjects;

import org.project.locators.LoginLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginLocators {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUserName(String userName) {
        this.userNameElement.sendKeys(userName);
    }

    public void fillPassword(String password) {
        this.passwordElement.sendKeys(password);
    }

    public DashBoardPage submit(){
        this.submitElement.submit();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }

    public void create(){
        this.addUserElement.click();
        //return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }

    public boolean createUserDisplayed(){
        return this.getBot().isElementDisplayed(this.addUserElement);
    }
}
