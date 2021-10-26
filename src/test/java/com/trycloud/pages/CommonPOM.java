package com.trycloud.pages;

import com.github.javafaker.Faker;
//import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CommonPOM {

    @FindBy(xpath = "(//span[@class='unified-search__result-content'])[3]")
    public WebElement searchResult;

    @FindBy(css = "svg[viewBox~='24']")
    public WebElement searchIcon;

    @FindBy(xpath = "(//input)[23]")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']")
    private WebElement logoutDrop;

    @FindBy(xpath = "//li[@ data-id='logout']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//li[@data-id='dashboard']/a")
    private WebElement dashBoardBtn;

    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement textDashBoardBtn;

    @FindBy(xpath = "//li[@data-id='files']/a")
    private WebElement filesBtn;

    @FindBy(xpath = "//span[text()='Files']")
    private WebElement textFilesBtn;

    @FindBy(xpath = "//li[@data-id='photos']/a")
    private WebElement photosBtn;

    @FindBy(xpath = "//span[text()='Photos']")
    private WebElement textPhotosBtn;

    @FindBy(xpath = "//li[@data-id='activity']/a")
    private WebElement activityBtn;

    @FindBy(xpath = "//span[text()='Activity']")
    private WebElement textActivityBtn;

    @FindBy(xpath = "//li[@data-id='spreed']/a")
    private WebElement talkBtn;

    @FindBy(xpath = "//span[text()='Talk']")
    private WebElement textTalkBtn;

    @FindBy(xpath = "//li[@data-id='contacts']/a")
    private WebElement contactsBtn;

    @FindBy(xpath = "//li[@data-id='circles']/a")
    private WebElement circlesBtn;

    @FindBy(xpath = "//span[text()='Contacts']")
    private WebElement textContactBtn;

    @FindBy(xpath = "//li[@data-id='calendar']/a")
    private WebElement calendarBtn;

    @FindBy(xpath = "//span[text()='Calendar']")
    private WebElement textCalendarBtn;

    @FindBy(xpath = "//li[@data-id='deck']/a")
    private WebElement deckBtn;

    @FindBy(xpath = "//span[text()='Calendar']")
    private WebElement textDeckBtn;

    @FindBy(xpath = "//div[contains(@style, 'folder.svg')]")
    public List<WebElement> foldersList;

    @FindBy(xpath = "//li[starts-with(@class, 'nav-files')]")
    private WebElement allFilesFol;

    @FindBy(xpath = "//label[@for='select_all_files']")
    private WebElement allCheckbox;


    public CommonPOM() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void logOut() {
        this.logoutDrop.click();
        BrowserUtil.waitForVisibility(By.xpath("//li[@ data-id='logout']"), 3);
        this.logoutBtn.click();
    }

    public void clickFilesBtn(){
        filesBtn.click();
    }

    public void clickAllCheckbox(){
        allCheckbox.click();
    }

    public List<String> iterableModuleList() {
        //Actions action = new Actions(Driver.getDriver());
        List<String> list = new ArrayList<>();
        //String str1 = this.textDashBoardBtn.getText();

        //action.moveToElement(this.dashBoardBtn).perform();
        //list.add(this.textDashBoardBtn.getText());
        list.add(this.dashBoardBtn.getAttribute("href"));

        //action.moveToElement(this.filesBtn).perform();
        //list.add(this.textFilesBtn.getText());
        list.add(this.filesBtn.getAttribute("href"));

        //action.moveToElement(this.photosBtn).perform();
        //list.add(this.textPhotosBtn.getText());
        list.add(this.photosBtn.getAttribute("href"));

        //action.moveToElement(this.activityBtn).perform();
        //list.add(this.textActivityBtn.getText());
        list.add(this.activityBtn.getAttribute("href"));

        //action.moveToElement(this.talkBtn).perform();
        //list.add(this.textTalkBtn.getText());
        list.add(this.talkBtn.getAttribute("href"));

        //action.moveToElement(this.contactsBtn).perform();
        //list.add(this.textContactBtn.getText());
        list.add(this.contactsBtn.getAttribute("href"));

        list.add(this.circlesBtn.getAttribute("href"));

        //action.moveToElement(this.calendarBtn).perform();
        //list.add(this.textCalendarBtn.getText());
        list.add(this.calendarBtn.getAttribute("href"));

        //action.moveToElement(this.deckBtn).perform();
        //list.add(this.textDeckBtn.getText());
        list.add(this.deckBtn.getAttribute("href"));

        return list;

    }

    public boolean allModulesDisplayed() {
        BrowserUtil.waitForVisibility(By.xpath("//li[@data-id='dashboard']/a"), 5);
        boolean result = false;
        if (this.dashBoardBtn.isDisplayed() &&
                this.filesBtn.isDisplayed() &&
                this.photosBtn.isDisplayed() &&
                this.activityBtn.isDisplayed() &&
                this.talkBtn.isDisplayed() &&
                this.contactsBtn.isDisplayed() &&
                this.contactsBtn.isDisplayed() &&
                this.deckBtn.isDisplayed()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public void clickContact() {
        this.contactsBtn.click();
    }

    /**
     * Common navigation bar module select
     * @param moduleName
     */
    public void clickModule(String moduleName) {

        switch (moduleName) {
            case "Dashboard":
                dashBoardBtn.click();
                break;
            case "Files":
                filesBtn.click();
                break;
            case "Photos":
                photosBtn.click();
                break;
            case "Activity":
                activityBtn.click();
                break;
            case "Talk":
                talkBtn.click();
                break;
            case "Contacts":
                contactsBtn.click();
                break;
            case "Circles":
                circlesBtn.click();
                break;
            case "Calendar":
                calendarBtn.click();
                break;
            case "Deck":
                deckBtn.click();
                break;
            default:
                System.out.println("Invalid module name.");
        }
    }


    public void clickAnyRandomFolder() {
        int filesListSize = foldersList.size();
        Faker faker = new Faker();
        int random = faker.number().numberBetween(0,filesListSize-1);
        foldersList.get(random).click();
    }




    public static void main(String[] args) {
        Faker faker = new Faker();
        LoginPagePOM loginPagePOM = new LoginPagePOM();
        loginPagePOM.goTo();
        loginPagePOM.fillCredentials("user63", "Userpass123");
        loginPagePOM.clickLogin();
        BrowserUtil.waitFor(1);
        CommonPOM commonPOM = new CommonPOM();
        commonPOM.clickAnyRandomFolder();
        BrowserUtil.waitFor(2);
        FilesPage filesPage = new FilesPage();
        filesPage.createNewTextDocument(faker.name().firstName());
        BrowserUtil.waitFor(5);
        filesPage.clickRandomActionBtn();
        BrowserUtil.waitFor(2);
        Driver.getDriver().quit();
    }


}
