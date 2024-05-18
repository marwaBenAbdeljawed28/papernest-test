package org.example.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccountPage {
    private WebDriver driver;


    @FindBy(id = "popin-poste-classic")
    WebElement btnCommencer;

    @FindBy(id = "poste-subscription.begin_date")
    WebElement datepicker;

    @FindBy(css = ".mat-calendar-body-cell")
    List<WebElement> dates;

    public AccountPage(WebDriver webDriver) {
        this.driver = webDriver;
        //utilisation du page factory
        PageFactory.initElements(webDriver, this);
    }

    public void clickCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(btnCommencer));
        this.btnCommencer.click();
    }

    public String getAccountPageUrl() {
        return driver.getCurrentUrl();
    }

    public void clickDatePicker() {
        this.datepicker.click();
    }

    public void selectDate() {
        for (WebElement date : dates) {
            String ariaLabel = date.getAttribute("aria-label");
            if (ariaLabel.equals("24 mai 2024")) {
                date.click();
                break;
            }
        }

    }
}
