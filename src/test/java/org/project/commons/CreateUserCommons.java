package org.project.commons;

import org.project.pageobjects.CreateUserPage;
import org.project.pageobjects.DashBoardPage;
import org.testng.Assert;

import java.util.Random;

public class CreateUserCommons {

    public static CreateUserPage createUser(CreateUserPage createUserPage, String password, String newUser) {
        createUserPage.fillUserName(newUser);
        createUserPage.fillPassword(password);
        createUserPage.fillPassword2(password);
        createUserPage.saveContinue();
        createUserPage.check();
        createUserPage.saveContinue();
        return createUserPage;
    }

    public static void changePass(CreateUserPage createUserPage, DashBoardPage dashBoardPage, String newPassword){
        createUserPage.ChangePass();
        createUserPage.fillPassword(newPassword);
        createUserPage.fillPassword2(newPassword);
        createUserPage.save();
        dashBoardPage.LogOut();
        dashBoardPage.LogIn();

    }

    public static void changePassword(CreateUserPage createUserPage, String userName, String password) {
        createUserPage.fillUserName(userName);
        createUserPage.fillPassword(password);
        createUserPage.fillPassword2(password);
        createUserPage.save();
    }





}
