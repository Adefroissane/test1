import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HentaiHeroesPage {

    protected WebDriver driver;

    @FindBy(css = "#contains_all > header")
    protected Header header;

    public HentaiHeroesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
    }
    public Header getHeader(){
        return header;
    }

}
