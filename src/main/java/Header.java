import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {

    WebDriver driver;

    @FindBy(css = "#contains_all > header > a.hh_logo")
    WebElement retourHome;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/header/div[4]/div/div[2]/span[1]")
    WebElement nbrCombat;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openHomePage(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(retourHome));
        retourHome.click();
        return new HomePage(driver);
    }

    public boolean combatNecessaire(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(nbrCombat));
        if (nbrCombat.getText().equals("0")) {
            return false;
        } else {
            return true;
        }

    }
}
