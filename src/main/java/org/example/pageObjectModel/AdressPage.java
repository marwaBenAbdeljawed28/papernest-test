package org.example.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdressPage {

    @FindBy(id = "old_housing.address")
    WebElement oldAdress;

    @FindBy(id = "housing.address")
    WebElement newAdress;

    @FindBy(id = "button_next")
    WebElement btnOk;
    private WebDriver driver;
    public AdressPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public void oldHouse(String oldHouse)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(oldAdress));
        oldAdress.sendKeys(oldHouse);
        WebElement listItem = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li[p[text()='44 Rue Diderot 92500 Rueil-Malmaison']]")));
        // Cliquer sur l'élément
        listItem.click();
    }

    public void newHouse(String oldHouse)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(newAdress));
        newAdress.sendKeys(oldHouse);
        WebElement liElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li[p[text()='1 Rue du Tir 92000 Nanterre']]")));
        // Cliquer sur l'élément
        liElement.click();

    }

    public void nextPage() throws InterruptedException
    {
        // Scroller jusqu'à l'élément
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnOk);
        // Attendre un petit moment pour que le scroll se termine
        Thread.sleep(500);
        // Cliquer sur le bouton
        btnOk.click();
    }
}
