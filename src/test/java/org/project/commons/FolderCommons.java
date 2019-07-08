package org.project.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.project.pageobjects.FoldersPage;

public class FolderCommons {

    public static FoldersPage createFolder(FoldersPage folderPage, String _FolderName) {
        folderPage.clickAddFolder();
        folderPage.getDriver().switchTo().window(folderPage.getDriver().getWindowHandles().toArray()[1].toString());
        folderPage.fillFolderName(_FolderName);
        folderPage.saveFolder();
        return folderPage;
    }

    public static FoldersPage editFolder(FoldersPage folderPage, String _FolderName, String _NewFolderName) {
        WebElement editBtn = folderPage.getDriver().findElement(By.xpath("//tr[@data-folder-name='"+_FolderName+"']//td[@class='column-action']//a[@title='Change folder details']"));
        editBtn.click();
        folderPage.fillFolderName(_NewFolderName);
        folderPage.saveFolder();
        return folderPage;
    }

    public static FoldersPage deleteFolder(FoldersPage folderPage, String _FolderName) {
        WebElement deleteBtn = folderPage.getDriver().findElement(By.xpath("//tr[@data-folder-name='"+_FolderName+"']//td[@class='column-action']//a[@title='Remove folder']"));
        deleteBtn.click();
        folderPage.deleteFolder();
        return folderPage;
    }


}
