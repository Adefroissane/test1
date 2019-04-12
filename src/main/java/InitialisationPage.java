import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitialisationPage extends HentaiHeroesPage {

    public InitialisationPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#contains_all > header > div > a:nth-child(1) > img")
    private WebElement connexion;

    @FindBy(css = "#popup_login_form > form > div > input[type=\"text\"]:nth-child(2)")
    private WebElement mail;

    @FindBy(css = "#popup_login_form > form > div > input[type=\"password\"]:nth-child(5)")
    private WebElement password;

    @FindBy(css = "#popup_login_form > form > div > div:nth-child(14) > button")
    private WebElement jouer;

    @FindBy(xpath = "//*[@id=\"starter_offer\"]/close")
    private WebElement pub;


    public HomePage openHomePage(WebDriver driver){

        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
        webDriverWait3.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();

        driver.switchTo().frame("hh_game");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(connexion));
        connexion.click();

        mail.sendKeys("adefroissane@hotmail.fr");
        password.sendKeys("gegegege");
        jouer.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try
        {
            driver.findElement(By.xpath("//*[@id=\"starter_offer\"]/close"));
            if (pub.isDisplayed())
            {
                pub.click();
            }
            return new HomePage(driver);
        }
        catch (NoSuchElementException e)
        {
            return new HomePage(driver);
        }

    }
}
