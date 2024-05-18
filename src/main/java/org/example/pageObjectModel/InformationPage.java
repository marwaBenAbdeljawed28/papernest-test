package org.example.pageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {


    @FindBy(id = "button_next_summary")
    WebElement btnNextPage;

    private WebDriver driver;

    public InformationPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void nextPage() throws InterruptedException {

        // Scroller jusqu'à l'élément
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnNextPage);
        // Attendre un petit moment pour que le scroll se termine
        Thread.sleep(500);
        // Cliquer sur le bouton
        btnNextPage.click();
    }
}
