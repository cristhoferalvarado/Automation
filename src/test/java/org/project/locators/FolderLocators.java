package org.project.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.project.configurations.selenium.PageObjectBase;

public class FolderLocators extends PageObjectBase {
    public FolderLocators(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[href^='/admin/filer/folder/make_folder/?parent_id=']")
    protected WebElement AddfolderElement;

    @FindBy(id="id_name")
    protected WebElement folderNameElement;

    @FindBy(name="_save")
    protected WebElement folderSaveElement;

    @FindBy(xpath="//input[@type='submit']")
    protected WebElement DeleteElement;

    protected String rowTabla = "//table//tbody/tr[id=%s]/td";

}
