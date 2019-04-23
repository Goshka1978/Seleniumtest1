import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WelcomePage extends AbstractPage {

    @FindBy(css = "button.acceptButton")
    private WebElement eulaClickButton;

    @FindBy(css = ".event-aware.navbarIcons")
    private WebElement navbar;

    @FindBy(css = "a.navbarIconOuter.navbarIconBorder")
    private List<WebElement> elements;


//    @FindBy( css = ".navbarIcon.icon-hboard")
    //private WebElement Dashboard

    @FindBy(css = "a[href='#syllabus']")
//    @FindBy( css = ".navbarIcon.icon-syllabus")
    private WebElement Syllabus;

    @FindBy(css = "button.expand_all")
    private WebElement ExpandAllClickButton;

    @FindBy(css = "div[data-guid='d4f6ebaf-38b4-4d15-8d70-fdb1669b6290']")
    private WebElement postAssessment;

    @FindBy(css = "div.assessment_preview h1")
    private WebElement postAssessmentTitle;

    public WelcomePage(final WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

        driver.get("https://uat3app.efficientlearning.com/pv5/v8/5/app/cpa/far.html?u=73c3f4a9-a4e2-4a0f-824c-4597fa50c09d");
    }

    public void clickEula() {
        wait(elementToBeClickable(eulaClickButton)).click();
    }

    public void checkNavbar() {
        wait(visibilityOf(navbar));
    }

    public int elemetsCounter() {
        return elements.size();
    }

    public void hoverElement(WebElement element) {
        wait(visibilityOf(element));
        getActions().moveToElement(element).build().perform();
    }

    public void hoverSyllabus() {
        hoverElement(Syllabus);
    }

    public String getBackgroundColor(WebElement element) {
        return element.getCssValue("background-color");
    }

    public String getColor(WebElement element) {
        String rgbaColor = element.getCssValue("color");
        return Color.fromString(rgbaColor).asHex();
    }

    public String getSyllabusBackgroundColor() {
        return getBackgroundColor(Syllabus);
    }


    //public void hoverDashboard() { wait(visibilityOf(Dashboard)).}

    public WebElement clickSyllabus() {
        wait(visibilityOf(Syllabus)).click();
        return Syllabus;
    }

    public void clickExpand() {
        wait(visibilityOf(ExpandAllClickButton)).click();
    }

    public WebElement getPostAssessment() {
        return wait(visibilityOf(postAssessment));
    }

    public WebElement getPostAssessmentTitle() {
        return wait(visibilityOf(postAssessmentTitle));
    }

}
