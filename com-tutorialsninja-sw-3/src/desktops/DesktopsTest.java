package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBalticOrder() throws InterruptedException {
        /**
         * 1.1 Mouse hover on Desktops Tab and click
         * 1.2 Click on “Show All Desktops”
         * 1.3 Select Sort By position "Name: Z to A"
         * 1.4 Verify the Product will arrange in Descending order.
         */
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverElementAndClick(By.xpath("//a[contains(text(),'Desktops')]"));
        Thread.sleep(2000);
        //1.2 Click on “Show All Desktops”
        mouseHoverElementAndClick(By.xpath("//a[text()='Show AllDesktops']"));
        Thread.sleep(2000);
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        Thread.sleep(2000);
        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> expectedProductInOrder = driver.findElements(By.xpath("//div[@class='product-thumb']"));
        List<String> productInOrder = new ArrayList<>();
        for (WebElement product1 : expectedProductInOrder) {
            productInOrder.add(product1.getText());
        }
        System.out.println("Expected Product in Order: " + expectedProductInOrder);
        Thread.sleep(2000);
        List<WebElement> originalProductInOrder = driver.findElements(By.xpath("//div[@class='product-thumb']"));
        List<String> productOriginalOrder = new ArrayList<>();
        for (WebElement product2 : originalProductInOrder) {
            productOriginalOrder.add(product2.getText());
        }
        System.out.println("Original Products In Order: " + originalProductInOrder);
        Thread.sleep(2000);
        Assert.assertEquals(expectedProductInOrder, originalProductInOrder);
        Thread.sleep(2000);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        /**
         * 2.1 Mouse hover on Currency Dropdown and click
         * 2.2 Mouse hover on £Pound Sterling and click
         * 2.3 Mouse hover on Desktops Tab.
         * 2.4 Click on “Show All Desktops”
         * 2.5 Select Sort By position "Name: A to Z"
         * 2.6 Select product “HP LP3065”
         * 2.7 Verify the Text "HP LP3065"
         * 2.8 Select Delivery Date "2023-11-27"
         * 2.9.Enter Qty "1” using Select class.
         * 2.10 Click on “Add to Cart” button
         * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
         * 2.12 Click on link “shopping cart” display into success message
         * 2.13 Verify the text "Shopping Cart"
         * 2.14 Verify the Product name "HP LP3065"
         * 2.15 Verify the Delivery Date "2023-11-27"
         * 2.16 Verify the Model "Product21"
         * 2.17 Verify the Total "£74.73"
         */
        //2.1 Mouse hover on Currency Dropdown and click
        mouseHoverElementAndClick(By.xpath("//span[contains(text(),'Currency')]"));
        Thread.sleep(2000);
        // 2.2 Mouse hover on £Pound Sterling and click
        mouseHoverElementAndClick(By.xpath("//button[contains(text(),'£Pound Sterling')]"));
        Thread.sleep(2000);
        // 2.3 Mouse hover on Desktops Tab.
        mouseHoverElementAndClick(By.xpath("//a[contains(text(),'Desktops')]"));
        Thread.sleep(2000);
        // 2.4 Click on “Show All Desktops”
        mouseHoverElementAndClick(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        Thread.sleep(2000);
        // Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (A - Z)");
        Thread.sleep(2000);
        // 2.6 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        Thread.sleep(2000);
        // 2.7 Verify the Text "HP LP3065"
        String actualText = getTextElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        Assert.assertEquals("Invalid Text", "HP LP3065", actualText);
        Thread.sleep(2000);
        // 2.8 Select Delivery Date "2023-11-27"
//        driver.findElement(By.xpath("//input[@id='input-option225']")).clear();
//        sendTextToElement(By.xpath("//input[@id='input-option225']"), "2023-11-27");
        String year = "2023";
        String month = "November";
        String date = "27";

        clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']")); //of date textbox
        while (true) {
            String monthYear = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='picker-switch']")).getText(); //of Date and year element title in calender
            String[] a = monthYear.split(" "); //we need different month and year so split
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']"));
            }

        }
//        Select the date
//        Locator for all dates is mentioned
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='datepicker-days']//tbody//tr//td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
        Thread.sleep(2000);
        // 2.9.Enter Qty "1” using Select class.
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");
        Thread.sleep(2000);
        // 2.10 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Thread.sleep(2000);
        // 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String actualMessage = getTextElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Invalid message", "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×", actualMessage);
        Thread.sleep(2000);
        // 2.12 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));
        Thread.sleep(2000);
        // 2.13 Verify the text "Shopping Cart  (1.00kg)"
        String actualText1 = getTextElement(By.xpath("//h1[contains(text(),'Shopping Cart         (1.00kg) ')]"));
        Assert.assertEquals("Invalid Text", "Shopping Cart  (1.00kg)", actualText1);
        Thread.sleep(2000);
        // 2.14 Verify the Product name "HP LP3065"
        String actualProductName = getTextElement(By.xpath("(//a[contains(text(),'HP LP3065')])[2]"));
        Assert.assertEquals("Invalid Product name", "HP LP3065", actualProductName);
        Thread.sleep(2000);
        // 2.15 Verify the Delivery Date:2023-11-27
        String actualDeliveryDate = getTextElement(By.xpath("//small[normalize-space()='Delivery Date:2023-11-27']"));
        Assert.assertEquals("Invalid Delivery Date", "Delivery Date:2023-11-27", actualDeliveryDate);
        Thread.sleep(2000);
        // 2.16 Verify the Model "Product21"
        String actualModel = getTextElement(By.xpath("//td[normalize-space()='Product 21']"));
        Assert.assertEquals("Invalid Product Model", "Product 21", actualModel);
        Thread.sleep(2000);
        // 2.17 Verify the Total "£74.73"
        String actualTotal = getTextElement(By.xpath("//tbody//tr//td[6]"));
        Assert.assertEquals("Invalid Total", "£74.73", actualTotal);
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}//Run the program