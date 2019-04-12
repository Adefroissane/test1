import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MissionPage extends HentaiHeroesPage {

    public MissionPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "claim")
    private WebElement missionTermine;

    @FindBy(className = "blue_text_button")
    private WebElement mission;

    @FindBy(css = "#contains_all > section > div.tabs > h4.missions.selected")
    private WebElement repereMission;

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/button")
    private WebElement validerRecompense;

    @FindBy(xpath = "//*[@id=\"missions\"]/div/div[2]/button")
    private WebElement recuperer;

    @FindBy(xpath ="//*[@id=\"missions\"]/div/div[1]/a")
    private WebElement retour;

    public void collectMission(WebDriver driver) {
        try{
            Thread.sleep(750);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        List<WebElement> myElements = driver.findElements(By.className("purple_text_button"));
        System.out.println("Nombre de mission à recolter" + myElements.size());
        if(myElements.size() !=0) {
            for (WebElement e : myElements) {
                if (e.isDisplayed()) {
                    e.click();

                    try {
                        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
                        webDriverWait2.until(ExpectedConditions.visibilityOf(validerRecompense));
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException ab) {
                            ab.printStackTrace();
                        }
                        validerRecompense.click();
                    } catch (NoSuchElementException nf) {}
                }
            }
        }
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ab){
            ab.printStackTrace();
        }
        try{
            if (recuperer.isDisplayed()) {
                recuperer.click();
            }
        }
        catch(NoSuchElementException recuperer){}
    }

    public void lanceMission(WebDriver driver){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(repereMission));
        System.out.println("Passe");
        try{
            Thread.sleep(750);
        }
        catch(InterruptedException ne){
            ne.printStackTrace();
        }
        try {
            List<WebElement> myElements2 = driver.findElements(By.className("blue_text_button"));
            System.out.println("Nombre de mission restante" + myElements2.size());
            if (myElements2.size() != 0) {
                for (WebElement e : myElements2) {
                    try{
                        Thread.sleep(750);
                    }
                    catch(InterruptedException ae){
                        ae.printStackTrace();
                    }
                    if (e.isDisplayed()) {
                        e.click();
                    }
                }
            }
        }
        catch(NoSuchElementException ne){}
    }

}
