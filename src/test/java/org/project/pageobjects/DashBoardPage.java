package org.project.pageobjects;

import org.openqa.selenium.support.PageFactory;
import org.project.locators.DashBoardLocators;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends DashBoardLocators {

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isChangePasswordDisplayed(){
        return this.getBot().isElementDisplayed(this.changePasswordElement);
    }

    public boolean isLogOutDisplayed(){
        return this.getBot().isElementDisplayed(this.logOutElementElement);
    }

    public void LogOut(){
        this.logOutElementElement.click();
    }

    public void LogIn(){
        this.logInElementElement.click();
    }

    public void Folder(){
        this.folderElement.click();
    }


}
