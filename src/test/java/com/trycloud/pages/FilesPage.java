package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FilesPage {
    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[normalize-space(.)='Files']/../..")
    public WebElement filesBtn;

    public void clickFilesBtn(){
        filesBtn.click();
        BrowserUtil.waitFor(3);
    }

    @FindBy(xpath = "//tr[@data-file='Talk']//span[.='Actions']/..")  // need change to dynamic according to file's name
    public WebElement actionIcon;

    public boolean isFavoriteFile(String fileName){
        boolean result= true;
        try{
            String sXpath="//tr[@data-file='"+fileName+"']//span[.='Favorited']";
            Driver.getDriver().findElement(By.xpath(sXpath)).getText().equals("Favorited");
        }catch (Exception e){
            result=false;
        }
        return result;
    }

    @FindBy(xpath = "//li[@class='action-0']")
    public WebElement addToFavorite;

    @FindBy(xpath = "//li[@class=' action-favorite-container']")
    public WebElement removeFromFavorite;
  
    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement createNewFolderBtn;

    @FindBy(xpath = "//span[.='New folder']")
    public WebElement newFolder;

    @FindBy(id = "view13-input-folder")
    public WebElement newFolderInputNameBox;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement newFolderInputNameSubmitBtn;

    @FindBy(xpath = "(//div[@style='background-image: url(\"/index.php/apps/theming/img/core/filetypes/folder.svg?v=0\");'])[3]")
    public WebElement newFolderCreatedImg;

    @FindBy(xpath = "//div[@class='activitysubject']")
    public WebElement youCreatedNewFolderConfirmMsg;

    @FindBy(xpath = "//tbody[@id='fileList']/tr")
    List<WebElement> allFilesList;

    public void refreshCurrentPage(){
        filesBtn.sendKeys(Keys.F5);
    }

    @FindBy(xpath = "//div[@id='app-content-favorites']//tbody[@id='fileList']/tr")
    List<WebElement> allFavoriteFilesList;

    public List<String> allFilesList1(){
        List<String> list= new ArrayList<>();
        for (WebElement each : allFilesList) {
           list.add( each.getAttribute("data-file"));
        }
        return list;
    }

    public static String removedFileName;
    public void clickRemoveFromFavorite(){//issue method, need modify
        String fileName = "";
        for (WebElement eachFile : allFilesList) {
            BrowserUtil.waitFor(3);
            fileName = eachFile.getAttribute("data-file");
            if (isFavoriteFile(fileName)){
                removedFileName=fileName;
                String fileNameXpath="//tr[@data-file='"+fileName+"']//span[.='Actions']/..";
                Driver.getDriver().findElement(By.xpath(fileNameXpath)).click();
                removeFromFavorite.click();
                break;
            }
        }
        System.out.println("Removed file name: "+removedFileName);
    }

    @FindBy(xpath = "//a[.='Favorites']")
    WebElement favoriteTab;

    public void clickFavoriteTab(){
        BrowserUtil.waitFor(3);
        favoriteTab.click();
    }

    public boolean checkIsSameFileInFavoriteList(){
        favoriteList();
        BrowserUtil.waitFor(3);
        System.out.println("Favorite list: "+favoriteList());
        return favoriteList().contains(removedFileName);
    }

    public List<String> favoriteList(){
         List<String> favoriteFileNameList = new ArrayList<>();
        for (WebElement each : allFavoriteFilesList) {
            favoriteFileNameList.add( each.getAttribute("data-file"));
        }
        return favoriteFileNameList;
    }

    @FindBy(xpath = "//*[@id=\"controls\"]/div[2]/a")
    public WebElement plusIcon;

    @FindBy(css = "#file_upload_start")
    public WebElement hiddenFileUpload;





}
