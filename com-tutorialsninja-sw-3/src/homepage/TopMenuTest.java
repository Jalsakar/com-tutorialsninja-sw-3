package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    /**
     * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
     * 1.2 This method should click on the menu whatever name is passed as parameter.
     */
        public void selectMenu(String menu) {
            WebElement menuList = driver.findElement(By.linkText(menu));
            Actions actions = new Actions(driver);
            actions.moveToElement(menuList).click().build().perform();
        }


    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        /**
         * 1.1 Mouse hover on “Desktops” Tab and click
         * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
         * 1.3 Verify the text ‘Desktops’
         */
        // * 1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverElementAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        Thread.sleep(2000);
        // * 1.2 call selectMenu method and pass the menu = “Show AllDesktops”
        selectMenu("Show AllDesktops");
        Thread.sleep(2000);
        // * 1.3 Verify the text ‘Desktops’
        String actualText = getTextElement(By.xpath("//h2[normalize-space()='Desktops']"));
        Assert.assertEquals("Invalid Text","Desktops", actualText);
        Thread.sleep(2000);
    }


    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        /**
         * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
         * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
         * 2.3 Verify the text ‘Laptops & Notebooks’
         */
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Thread.sleep(2000);
        //2.2 call selectMenu method and pass the menu = “Show AllLaptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
        Thread.sleep(2000);
        //2.3 Verify the text ‘Laptops & Notebooks’
        String actualText = getTextElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));
        Assert.assertEquals("Invalid Text","Laptops & Notebooks", actualText);
        Thread.sleep(2000);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        /**
         * 3.1 Mouse hover on “Components” Tab and click
         * 3.2 call selectMenu method and pass the menu = “Show All Components”
         * 3.3 Verify the text ‘Components'
         */
        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverElementAndClick(By.xpath("//a[normalize-space()='Components']"));
        Thread.sleep(2000);
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
        Thread.sleep(2000);
        //3.3 Verify the text ‘Components'
        String actualText = getTextElement(By.xpath("//h2[normalize-space()='Components']"));
        Assert.assertEquals("Invalid Text","Components", actualText);
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
            closeBrowser();
    }
}//Run the program