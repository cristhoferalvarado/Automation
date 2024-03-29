package org.project.commons;

import org.project.pageobjects.DashBoardPage;
import org.project.pageobjects.LoginPage;
import org.testng.Assert;

public class LoginCommons {

    public static void login(LoginPage loginPage, String userName, String password) {
        loginPage.fillUserName(userName);
        loginPage.fillPassword(password);
        DashBoardPage dashBoardPage = loginPage.submit();
        Assert.assertTrue(dashBoardPage.isChangePasswordDisplayed(),
                "NO se mostro el link para cambio de contrasena");
    }
}
