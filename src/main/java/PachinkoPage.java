import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PachinkoPage extends HentaiHeroesPage {

    public PachinkoPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#pachinko_left > div.right_part > div:nth-child(2) > button.blue_text_button.left_pck1")
    private WebElement pachinkoGratuit;

    @FindBy(xpath = "//*[@id=\"playzone-replace-info\"]/div[3]/button[1]")
    private WebElement reperePatchinko;

    @FindBy(css = "#pachinko_rewards > button")
    private WebElement genial;

    public void collectPachinkoGratuit(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(reperePatchinko));
        reperePatchinko.click();

        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(genial));
        genial.click();
        getHeader().openHomePage(driver);
    }

}
