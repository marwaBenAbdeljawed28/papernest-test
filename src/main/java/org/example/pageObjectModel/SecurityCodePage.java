package org.example.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurityCodePage {

    private WebDriver driver;

    @FindBy(id = "poste-subscription.confirmation_code_destination-home")
    WebElement home;


    public SecurityCodePage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void homeChoice()
    {
        home.click();
    }
}
