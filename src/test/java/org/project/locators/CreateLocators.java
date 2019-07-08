package org.project.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.project.configurations.selenium.PageObjectBase;

public class CreateLocators extends PageObjectBase {
    public CreateLocators(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="id_username")
    protected WebElement userNameElement;

    @FindBy(id="id_password1")
    protected WebElement passwordElement;

    @FindBy(id="id_password2")
    protected WebElement passwordElement2;

    @FindBy(id="id_is_staff")
    protected WebElement checkBox;

   // @FindBy(name="_save")
   // protected WebElement submitElement;

    @FindBy(css="[type='submit']")
    protected WebElement submitElement;

    @FindBy(name="_continue")
    protected WebElement submitElementContinue;

    @FindBy(css="div.field-password div div.help a")
    protected WebElement changePassElement;

    @FindBy(id="id_new_password2")
    protected WebElement newPassword2Element;
}
