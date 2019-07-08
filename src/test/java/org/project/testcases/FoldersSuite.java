package org.project.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.project.commons.FolderCommons;
import org.project.commons.LoginCommons;
import org.project.configurations.selenium.TestCaseBase;
import org.project.pageobjects.CreateUserPage;
import org.project.pageobjects.DashBoardPage;
import org.project.pageobjects.FoldersPage;
import org.project.pageobjects.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class FoldersSuite extends TestCaseBase {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    int maximum =1000, minimum = 0, randomNum;
    String _FolderName="";


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        dashBoardPage = PageFactory.initElements(this.getDriver(),DashBoardPage.class);
        loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
    }

    @Test(groups = {"folders","full_regression"})
    @Parameters({"folderName","username", "password"})
    public void createFolder(String folderName, String userName, String password) {
        LoginCommons.login(loginPage,userName,password);
        dashBoardPage.Folder();
        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        randomNum =  minimum + i;
        _FolderName=folderName+randomNum;
        FoldersPage folderPage = PageFactory.initElements(this.getDriver(), FoldersPage.class);
        FolderCommons.createFolder(folderPage,_FolderName);
    }


    @Test(dependsOnMethods = {"createFolder"},groups = {"folders","full_regression"})
    @Parameters({"username", "password"})
    public void EditFolder(String userName, String password) {
        LoginCommons.login(loginPage,userName,password);
        dashBoardPage.Folder();
        FoldersPage folderPage = PageFactory.initElements(this.getDriver(), FoldersPage.class);
        //WebElement editBtn = folderPage.getDriver().findElement(By.xpath("tr[@data-folder-name=\'"+_FolderName+"\']//td[@class=\'column-action\']//a[@title=\'Change folder details\']"));
        String OldFolderName = _FolderName;
        _FolderName = _FolderName+"2";
        FolderCommons.editFolder(folderPage,OldFolderName, _FolderName);
    }

    @Test(dependsOnMethods = {"EditFolder"},groups = {"login","full_regression"})
    @Parameters({"username", "password"})
    public void DeleteFolder(String userName, String password) {
        LoginCommons.login(loginPage,userName,password);
        dashBoardPage.Folder();
        FoldersPage folderPage = PageFactory.initElements(this.getDriver(), FoldersPage.class);
        FolderCommons.deleteFolder(folderPage, _FolderName);
    }
}
