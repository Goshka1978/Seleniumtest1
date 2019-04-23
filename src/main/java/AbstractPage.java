import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class AbstractPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public AbstractPage(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        initElements(driver, this);
        actions = new Actions(driver);
    }

    protected WebElement wait(ExpectedCondition<WebElement> condition) {
        return wait.until(condition);
    }

    protected Actions getActions() {
        return actions;
    }
}
