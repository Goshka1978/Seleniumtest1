import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadCourseTestTest extends AbstractSeleniumTest {

    @Test
    void testAcceptButtonIsClickable() {
        final WelcomePage welcomePage = gotoWelcomePage();
        welcomePage.clickEula();
    }

    @Test
    void testSyllabusColorChangesOnClick() {
        final WelcomePage welcomePage = gotoWelcomePage();
        welcomePage.clickEula();
        welcomePage.checkNavbar();
        WebElement syllabus = welcomePage.clickSyllabus();
        String color = welcomePage.getColor(syllabus);
        assertEquals("#0f90c0", color);
    }

    @Test
    void testNavbarIsVisible() {
        final WelcomePage welcomePage = gotoWelcomePage();
        welcomePage.clickEula();
        welcomePage.checkNavbar();
    }
    @Test
    void testClickSyllabus() {
        final WelcomePage welcomePage = gotoWelcomePage();
        welcomePage.clickEula();
        welcomePage.checkNavbar();
//        welcomePage.elemetsCounter();
        welcomePage.hoverSyllabus();
        assertEquals("rgba(208, 233, 250, 1)", welcomePage.getSyllabusBackgroundColor());
              welcomePage.clickSyllabus();
        welcomePage.clickExpand();
        WebElement postAssessment = welcomePage.getPostAssessment();
        WebElement postAssessmentTitle = postAssessment.findElement(By.cssSelector("div.title"));
        assertEquals("17. Post Assessment I.1", postAssessmentTitle.getText());
        postAssessmentTitle.click();
        WebElement postAssessmentTitle1 = welcomePage.getPostAssessmentTitle();
        assertEquals("Post Assessment I.1", postAssessmentTitle1.getText());
    }


}