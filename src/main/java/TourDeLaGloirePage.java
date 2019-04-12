import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TourDeLaGloirePage extends HentaiHeroesPage {

    public TourDeLaGloirePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"leagues_right\"]/div/div[7]/button")
    private WebElement defi;

    @FindBy(xpath = "//*[@id=\"battle_middle\"]/button[1]")
    private WebElement affronter;

    @FindBy(xpath = "//*[@id=\"battle_middle\"]/button[2]")
    private WebElement passer;

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/button")
    private WebElement ok;

    @FindBy(xpath = "//*[@id=\"leagues_left\"]/div/div[8]/div/div[2]/span[1]")
    private WebElement ptdeDefi;

    @FindBy(xpath = "//*[@id=\"leagues_middle\"]/div[4]/button")//*[@id="rewards_popup"]/button
    private WebElement recup;

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/button")
    private WebElement ok2;


    public boolean defiNecessaire(WebDriver driver)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(ptdeDefi));
        if (ptdeDefi.getText().equals("0")) {
            return false;
        } else {
            return true;
        }
    }

    public void lancerDefi(WebDriver driver)
    {
        boolean defiAFaire = defiNecessaire(driver);
        if (defiAFaire == true)
        {
            if (recup.isDisplayed()) {
                recup.click();
                ok2.click();
            }
            List<WebElement> myElements = driver.findElements(By.xpath("//*[@id=\"leagues_middle\"]/div[3]/div[2]/table/tbody/tr[*]/td[4]"));
            System.out.println("nbre ennemis =" + myElements.size());
            JavascriptExecutor js = (JavascriptExecutor) driver;
            ArrayList combats = new ArrayList<WebElement>();
            for (WebElement e : myElements) {
                js.executeScript("arguments[0].scrollIntoView();", e);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ab) {
                    ab.printStackTrace();
                }
                System.out.println(e.getText());
                if (e.getText().equals("0/3") || e.getText().equals("1/3") ||e.getText().equals("2/3"))
                {
                    combats.add(e);
                }
            }
            int i = combats.size();
            int a = i-1;
            WebElement adversaire = (WebElement) combats.get(a);
            js.executeScript("arguments[0].scrollIntoView();", adversaire);
            WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
            webDriverWait.until(ExpectedConditions.visibilityOf(adversaire));
            adversaire.click();

            WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
            webDriverWait2.until(ExpectedConditions.visibilityOf(defi));
            defi.click();
            WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
            webDriverWait3.until(ExpectedConditions.visibilityOf(affronter));
            affronter.click();
            WebDriverWait webDriverWait4 = new WebDriverWait(driver, 5);
            webDriverWait4.until(ExpectedConditions.visibilityOf(passer));
            passer.click();
            WebDriverWait webDriverWait5 = new WebDriverWait(driver, 5);
            webDriverWait5.until(ExpectedConditions.visibilityOf(ok));
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ok.click();
            lancerDefi(driver);
        }

    }
}
