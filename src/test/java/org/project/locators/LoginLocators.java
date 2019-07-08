package org.project.locators;

import org.project.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocators extends PageObjectBase {
    public LoginLocators(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="id_username")
    protected WebElement userNameElement;

    @FindBy(id="id_password")
    protected WebElement passwordElement;

    @FindBy(css="[type='submit']")
    protected WebElement submitElement;

    @FindBy(css="[href='/admin/auth/user/add/']")
    protected WebElement addUserElement;

}
