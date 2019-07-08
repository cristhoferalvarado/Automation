package org.project.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.project.locators.CreateLocators;

public class CreateUserPage extends CreateLocators {

    public CreateUserPage(WebDriver driver) {
        super(driver);
    }

    public void fillUserName(String userName) {
        this.userNameElement.sendKeys(userName);
    }

    public void fillPassword(String password) {
        this.passwordElement.sendKeys(password);
    }

    public void fillPassword2(String password2) {
        this.passwordElement2.sendKeys(password2);
    }

    public void check() {
        this.checkBox.click();
    }



    //public DashBoardPage submit(){
      //  this.submitElement.submit();
      //  return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    //}



    public void saveContinue() {
        this.submitElementContinue.click();
    }

    public void save() {
        this.submitElement.submit();
    }


    public void ChangePass(){
        this.changePassElement.click();
        //return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }

}
