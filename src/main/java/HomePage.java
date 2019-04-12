import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage  extends HentaiHeroesPage {

    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"homepage\"]/a[1]/div/span")
    private WebElement harem;

    @FindBy(className = "orange_button_L")
    private WebElement toutCollecter;

    @FindBy(xpath = "//*[@id=\"homepage\"]/a[7]/div/span")
    private WebElement activite;

    @FindBy(xpath = "//*[@id=\"homepage\"]/a[6]/div/span")
    private WebElement arene;

    @FindBy(xpath = "//*[@id=\"homepage\"]/a[2]/div/span")
    private WebElement aventure;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/header/div[4]/div/div[2]/span[1]")
    private WebElement nbreCombat;

    @FindBy(xpath = "//*[@id=\"homepage\"]/a[10]/div[2]")
    private WebElement pachinkoGratuit;

    @FindBy(xpath = "//*[@id=\"homepage\"]/a[10]/div/span")
    private WebElement pachinko;

    @FindBy(css = "#home_missions_bar1 > div > div.text")
    private WebElement missionNonDisponible;

    @FindBy(css = "#home_missions_bar2 > div > div.backbar.borderbar > div")
    private WebElement missionNonDisponible2;

    @FindBy(xpath = "//*[@id=\"homepage\"]/a[7]/div/span")
    private WebElement mission;

    @FindBy(xpath = "//*[@id=\"homepage\"]/a[8]/div/span")
    private WebElement tourDeLaGloire;


    public HaremPage ouvrirLeHarem(WebDriver driver){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(harem));
        harem.click();
        return new HaremPage(driver);
    }

    public boolean recoltHarem(WebDriver driver){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(harem));
        if(toutCollecter.isDisplayed()){
            return true;
        }
        else {
            return false;
        }
    }

    public AventurePage openAventure(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(aventure));
        aventure.click();
        return new AventurePage(driver);
    }

    public boolean pachinkoGratuitPresent(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(harem));
            try {
                driver.findElement(By.xpath("//*[@id=\"homepage\"]/a[10]/div[2]"));
            } catch (NoSuchElementException e)
            {
                return false;
            }
            return true;
    }

    public PachinkoPage openPachinkoPage (WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(pachinko));
        pachinko.click();
        return new PachinkoPage(driver);
    }

        public boolean missionDisponible(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(harem));
        if(missionNonDisponible.isDisplayed()|| missionNonDisponible2.isDisplayed()){
            return false;
        }
        else {
            return true;
        }
    }

    public MissionPage openMissionPage (WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(mission));
        mission.click();
        return new MissionPage(driver);
    }

    public DuelPage openDuelPage(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(arene));
        arene.click();
        return new DuelPage(driver);
    }

    public TourDeLaGloirePage openTourDeLaGloire(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(tourDeLaGloire));
        tourDeLaGloire.click();
        return new TourDeLaGloirePage(driver);
    }

}
