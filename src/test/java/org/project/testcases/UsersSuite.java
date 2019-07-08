package org.project.testcases;

import jxl.read.biff.BiffException;
import org.openqa.selenium.support.PageFactory;
import org.project.commons.CreateUserCommons;
import org.project.configurations.selenium.TestCaseBase;
import org.project.pageobjects.DashBoardPage;
import org.project.pageobjects.CreateUserPage;
import org.project.commons.LoginCommons;
import org.project.pageobjects.LoginPage;
import org.project.utils.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;
public class UsersSuite extends TestCaseBase {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    int maximum =1000, minimum = 0, randomNum;
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        dashBoardPage = PageFactory.initElements(this.getDriver(),DashBoardPage.class);
        loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
    }

    @Test(groups = {"full_regression","login"} )
    @Parameters({"username", "password", "newUser", "newPassword"})
    public void createUser(String userName, String password, String newUser, String newPassword) {
        LoginCommons.login(loginPage,userName,password);
        loginPage.create();
        CreateUserPage createUserPage = PageFactory.initElements(this.getDriver(), CreateUserPage.class);
        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        randomNum = minimum + i;
        newUser =  newUser+randomNum;
        CreateUserCommons.changePass(CreateUserCommons.createUser(createUserPage,password,newUser),dashBoardPage,newPassword);
        LoginCommons.login(loginPage,newUser,newPassword);

        // verificar que el login fue exitoso
        //Assert.assertTrue(dashBoardPage.isChangePasswordDisplayed(), "NO se mostro el link para cambio de contrasena");
        //Assert.assertTrue(dashBoardPage.isLogOutDisplayed(), "NO se mostro el link para cerrar session");
    }



    @DataProvider(name = "dataProviderEjemploXLS")
    public static Object[][] dataProviderEjemploXLS() throws IOException, BiffException {
        return new ExcelUtility("src/test/resources/Excel/testXLS.xls").getData();
    }

    @Test(description = "Este test case va probar a usar un data provider que lee un Excel",
            groups = {"full_regression","usuarios"},
            dataProvider = "dataProviderEjemploXLS")
    public void createUserExcel(String newUser, String password) {
        LoginCommons.login(loginPage, "automation", "Automation123$");
        loginPage.create();
        CreateUserPage createUserPage = PageFactory.initElements(this.getDriver(), CreateUserPage.class);
        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        randomNum = minimum + i;
        newUser =  newUser+randomNum;
        String newPassword = password +randomNum;
        CreateUserCommons.changePass(CreateUserCommons.createUser(createUserPage,password,newUser),dashBoardPage,newPassword);
        LoginCommons.login(loginPage,newUser,newPassword);
    }


    @Test(description = "Este test case va probar a usar un data provider que lee una matriz",
            groups = {"full_regression","login"},
            dataProvider = "dataProviderEjemploMatriz")
    public void createUserMatriz(String newUser, String password) {
        LoginCommons.login(loginPage,"automation", "Automation123$");
        // llenar el formulario de login
        loginPage.create();
        CreateUserPage createUserPage = PageFactory.initElements(this.getDriver(), CreateUserPage.class);
        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        randomNum = minimum + i;
        newUser =  newUser+randomNum;
        String newPassword = password +randomNum;
        CreateUserCommons.changePass(CreateUserCommons.createUser(createUserPage,password,newUser),dashBoardPage,newPassword);
        LoginCommons.login(loginPage,newUser,newPassword);
    }

    @DataProvider(name = "dataProviderEjemploMatriz")
    public static Object[][] credentials() {
        return new Object[][]{
                {"automation2", "Auto123$"},
                {"automation3", "Auto123$"},
                {"automation4", "Auto123$"},
                {"automation1", "Auto123$"},
        };
    }

}
