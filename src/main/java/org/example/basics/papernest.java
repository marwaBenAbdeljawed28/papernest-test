package org.example.basics;

import org.example.pageObjectModel.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// cette annotation permet de contrôler l'ordre d'exécution des méthodes
@TestMethodOrder(MethodOrderer.MethodName.class)
public class papernest {
    private static WebDriver driver;
    private static AccountPage accountPage;

    private static AdressPage adressPage;

    private static PostePage postePage;

    private static CoordoneesPage coordoneesPage;

    private static SecurityCodePage securityCodePage;

    private static InformationPage informationPage;


    @BeforeAll
    public static void setUp()
    {
        driver= new ChromeDriver();
        driver.get("https://app.papernest.com/onboarding?anonymous&anonymousId=test&id_text=1&destination=newspaper");
        driver.manage().window().maximize();

        //grace à l'annotation @BeforeAll je fais une instance des mes PageObject avant de commencer le scénario
        accountPage = new AccountPage(driver);
        adressPage = new AdressPage(driver);
        postePage = new PostePage(driver);
        coordoneesPage = new CoordoneesPage(driver);
        securityCodePage = new SecurityCodePage(driver);
        informationPage = new InformationPage(driver);

    }

    //cliquer sur le bouton commencer afin de commencer le process de changement d'adresse
    @Test
    public void test_001()
    {
        accountPage.clickCheckout();
        Assertions.assertTrue(accountPage.getAccountPageUrl().contains("https://app.papernest.com/account/mail/1"));

    }


    //choisir la date de demangement
    // selectionner une date à partir d'un date picker
    @Test
    public void test_002()
    {
        accountPage.clickDatePicker();
        accountPage.selectDate();
        Assertions.assertTrue(accountPage.getAccountPageUrl().contains("https://app.papernest.com/account/mail/1"));
    }


    //saisir l'ancienne adresse ainsi que la nouvelle adresse et passer à l'étape suivante
    @Test
    public void test_003() throws InterruptedException {

        adressPage.oldHouse("44 Rue Diderot 92500 ");
       adressPage.newHouse("1 Rue du Tir");
        adressPage.nextPage();
        Assertions.assertTrue(accountPage.getAccountPageUrl().contains("https://app.papernest.com/account/mail/3"));

    }

    // choisir combien de temps la poste devra rediriger les courriers(6 mois ou une année)
    @Test
    public void test_004()
    {
        postePage.choisirDuree();
       // Assertions.assertTrue(accountPage.getAccountPageUrl().contains("https://app.papernest.com/account/mail/4"));
    }

    // remplir les information de l'utilisateur
    @Test
    public void test_005() throws InterruptedException {
         coordoneesPage.email();
        coordoneesPage.telephone("0758889209");
        coordoneesPage.postCivility();
        coordoneesPage.postFirstName("Marwa");
        coordoneesPage.postLAstName("Ben Abdeljawed");
        //ici j'ai réutilisé le bouton next qui est définit dans la page Object adressPage
        // reutilisabilité du code déja éxistant
        adressPage.nextPage();
        Assertions.assertTrue(accountPage.getAccountPageUrl().contains("https://app.papernest.com/account/mail/5"));
    }

    //envoi d'un code de securité par la poste
    @Test
    public void test_006() throws InterruptedException
    {
        securityCodePage.homeChoice();
        // de même j'ai utilisé le code existant dans adress page pour le bouton next vu qu'il s'agit du même id
        adressPage.nextPage();
        Assertions.assertTrue(accountPage.getAccountPageUrl().contains("https://app.papernest.com/account/mail/6"));

    }

    //finalement page de verification des informations et passage au payment
        @Test
        public void test_007() throws InterruptedException
        {
            informationPage.nextPage();
            Assertions.assertTrue(accountPage.getAccountPageUrl().contains("https://app.papernest.com/account/mail/7"));
        }

}
