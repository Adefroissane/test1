import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class automatisation {

    WebDriver driver;

    @Before
    public void init()
    {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.hentaiheroes.com/");
    }

    @After
    public void teardown()
    {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    @Test
    public void automatisationHarem()
    {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);

        boolean recoltNecessaire = homePage.recoltHarem(driver);
        if (recoltNecessaire == true) {
            HaremPage haremPage = homePage.ouvrirLeHarem(driver);
            haremPage.recolt(driver);
        }
    }

    @Test
    public void automatisationCombat()
    {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);

        boolean combatNonNull = homePage.getHeader().combatNecessaire(driver);
        if (combatNonNull == true) { AventurePage aventurePage = homePage.openAventure(driver);
                LastZonePage lastZonePage = aventurePage.openLastZone(driver);
                Combat(driver);
            }
        }

    @Test
    public void automatisationPachinko()
    {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        boolean pachinkoGratuitPresent = homePage.pachinkoGratuitPresent(driver);
        if (pachinkoGratuitPresent == true) {
            PachinkoPage pachinkoPage = homePage.openPachinkoPage(driver);
            pachinkoPage.collectPachinkoGratuit(driver);
        }
    }

    @Test
    public void automatisationRecoltMission()
    {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        MissionPage missionPage = homePage.openMissionPage(driver);
        missionPage.collectMission(driver);
    }

    @Test
    public void automatisationLancementMission()
    {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        boolean missionDispo = homePage.missionDisponible(driver);
        System.out.println(missionDispo);
        if (missionDispo == true) {
            MissionPage missionPage = homePage.openMissionPage(driver);
            missionPage.lanceMission(driver);
        }
    }

    @Test
    public void automatisationDuel1() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        DuelPage duelPage = homePage.openDuelPage(driver);
        if(duelPage.combat1Fait(driver) == true)
        {
            if (duelPage.combat1PlusFaible(driver) == true)
            {
                CombatPage combatPage = duelPage.duel1(driver);
                DuelPage duelPage2 = combatPage.combattreDuel(driver);
            }
        }
    }

    @Test
    public void automatisationDuel2() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        DuelPage duelPage = homePage.openDuelPage(driver);
        if(duelPage.combat2Fait(driver) == true)
        {
            if (duelPage.combat2PlusFaible(driver) == true)
            {
                CombatPage combatPage = duelPage.duel2(driver);
                DuelPage duelPage2 = combatPage.combattreDuel(driver);
            }
        }
    }

    @Test
    public void automatisationDuel3() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        DuelPage duelPage = homePage.openDuelPage(driver);
        if (duelPage.combat3Fait(driver) == true) {
            if (duelPage.combat3PlusFaible(driver) == true) {
                CombatPage combatPage = duelPage.duel3(driver);
                DuelPage duelPage2 = combatPage.combattreDuel(driver);
            }
        }
    }

    @Test
    public void automatisationDefi() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        TourDeLaGloirePage tourDeLaGloirePage = homePage.openTourDeLaGloire(driver);
        tourDeLaGloirePage.lancerDefi(driver);
    }



    private void Combat(WebDriver driver)
    {
        LastZonePage lastZonePage = new LastZonePage(driver);
        CombatPage combatPage = lastZonePage.openCombatPage(driver);
        LastZonePage lastZonePage2 = combatPage.combattreBoss(driver);
        boolean combatNonNull = lastZonePage2.getHeader().combatNecessaire(driver);
        if (combatNonNull == true)
        {
            Combat(driver);
        }
    }

}


