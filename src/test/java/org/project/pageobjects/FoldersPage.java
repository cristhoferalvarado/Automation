package org.project.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.project.locators.FolderLocators;

public class FoldersPage extends FolderLocators {
    WebDriver _driver;
    public FoldersPage(WebDriver driver) {
        super(driver);
        _driver = driver;
    }

    public void clickAddFolder() {
        this.AddfolderElement.click();
    }

    public void fillFolderName(String folderNameName) {
        this.folderNameElement.clear();
        this.folderNameElement.sendKeys(folderNameName);
    }

    public void saveFolder() {
        this.folderSaveElement.click();
    }

    public void deleteFolder() {
        this.DeleteElement.submit();
    }

    public void nada(String nombre) {
        WebElement x =this.getDriver().findElement(By.xpath(String.format(this.rowTabla,nombre)));
        this.getBot().isElementDisplayed(x);
    }


}
