package org.example.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class CoordoneesPage {

    private WebDriver driver;

    @FindBy(id = "user.phone_number")
    WebElement tel;

    @FindBy(id = "user.civility-madam")
    WebElement civility;

    @FindBy(id = "user.first_name")
    WebElement firstName;

    @FindBy(id = "user.last_name")
    WebElement lastName;
    @FindBy(id = "button_next")
    WebElement btnNext;



    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public CoordoneesPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void email()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Attendre que l'élément soit présent et visible
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user.email")));
        // Saisir l'adresse e-mail
        emailInput.sendKeys(generateRandomString(10));
    }

    public void telephone(String number)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Attendre que l'élément soit présent et visible
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user.phone_number")));
        // Saisir l'adresse e-mail
        emailInput.sendKeys(number);
    }

    public void postCivility()
    {
        civility.click();
    }
    public void postFirstName(String fName)
    {
        firstName.click();
        firstName.sendKeys(fName);
    }

    public void postLAstName(String lName)
    {
        lastName.click();
        lastName.sendKeys(lName);
    }

    public void nextStep()
    {
        btnNext.click();
    }

    //cette méthode permet de générer a random String
    // je l'utilise pour générarer un email
    public static String generateRandomString(int length) {

        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString().concat("test@papernest.com");

    }
}
