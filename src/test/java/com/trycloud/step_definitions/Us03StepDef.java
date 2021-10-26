package com.trycloud.step_definitions;

import com.sun.xml.internal.ws.policy.AssertionSet;
import com.trycloud.pages.CommonPOM;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Us03StepDef {

    CommonPOM newObj = new CommonPOM();

    @Then("User click Files module")
    public void userClickFilesModule() {
        newObj.clickFilesBtn();
    }

    @Then("Verify the page title is {string}")
    public void verifyThePageTitleIs(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Then("click the checkbox of the table")
    public void clickTheCheckboxOfTheTable() {
        newObj.clickAllCheckbox();
    }

    @Then("Assert all the files are selected")
    public void assertAllTheFilesAreSelected() {
        List<WebElement> checkBoxElements = Driver.getDriver().findElements(By.xpath("//tr[contains(@class, 'selected')]"));
        for (WebElement eachElement : checkBoxElements) {
            String element = eachElement.getAttribute("class");
            boolean actualResult = element.contains("selected");
           assertTrue(actualResult);
            System.out.println(actualResult);
        }
    }


}
