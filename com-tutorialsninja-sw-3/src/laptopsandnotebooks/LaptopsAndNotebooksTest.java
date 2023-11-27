package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        /**
         * 1.1 Mouse hover on Laptops & Notebooks Tab and click
         * 1.2 Click on “Show All Laptops & Notebooks”
         * 1.3 Select Sort By "Price (High > Low)"
         * 1.4 Verify the Product price will arrange in High to Low order.
         */
        //1.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Thread.sleep(2000);
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        Thread.sleep(2000);
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        Thread.sleep(2000);
        //1.4 Verify the Product price will arrange in High to Low order
        List<WebElement> expectedProductPriceInOrder = driver.findElements(By.xpath("//p[@class='price']"));
        List<String> productPriceInOrder = new ArrayList<>();
        for (WebElement product1 : expectedProductPriceInOrder) {
            productPriceInOrder.add(product1.getText());
        }
        System.out.println("Expected Product in Order: " + expectedProductPriceInOrder);
        Thread.sleep(2000);
        List<WebElement> originalProductPriceInOrder = driver.findElements(By.xpath("//p[@class='price']"));
        List<String> productOriginalOrder = new ArrayList<>();
        for (WebElement product2 : originalProductPriceInOrder) {
            productOriginalOrder.add(product2.getText());
        }
        System.out.println("Original Products In Order: " + originalProductPriceInOrder);
        Thread.sleep(2000);
        Assert.assertEquals(expectedProductPriceInOrder, originalProductPriceInOrder);
        Thread.sleep(2000);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        /**
         * 2.1 Mouse hover on Laptops & Notebooks Tab and click
         * 2.2 Click on “Show All Laptops & Notebooks”
         * 2.3 Select Sort By "Price (High > Low)"
         * 2.4 Select Product “MacBook”
         * 2.5 Verify the text “MacBook”
         * 2.6 Click on ‘Add To Cart’ button
         * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
         * 2.8 Click on link “shopping cart” display into success message
         * 2.9 Verify the text "Shopping Cart"
         * 2.10 Verify the Product name "MacBook"
         * 2.11 Change Quantity "2"
         * 2.12 Click on “Update” Tab
         * 2.13 Verify the message “Success: You have modified your shopping cart!”
         * 2.14 Verify the Total £737.45
         * 2.15 Click on “Checkout” button
         * 2.16 Verify the text “Checkout”
         * 2.17 Verify the Text “New Customer"
         * 2.18 Click on “Guest Checkout” radio button
         * 2.19 Click on “Continue” tab
         * 2.20 Fill the mandatory fields
         * 2.21 Click on “Continue” Button
         * 2.22 Add Comments About your order into text area
         * 2.23 Check the Terms & Conditions check box
         * 2.24 Click on “Continue” button
         * 2.25 Verify the message “Warning: Payment method required!"
         */
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        Thread.sleep(2000);
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        Thread.sleep(2000);
        // 2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        Thread.sleep(2000);
        // 2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
        // 2.5 Verify the text “MacBook”
        String actualText = getTextElement(By.xpath("//h1[normalize-space()='MacBook']"));
        Assert.assertEquals("Invalid Text","MacBook", actualText);
        // 2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Thread.sleep(2000);
        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualMessage = getTextElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Invalid message", "Success: You have added MacBook to your shopping cart!\n" +
                "×", actualMessage);
        Thread.sleep(2000);
        // 2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));
        Thread.sleep(2000);
        // 2.9 Verify the text "Shopping Cart  (0.00kg)"
        String actualText1 = getTextElement(By.xpath("//h1[contains(text(),'Shopping Cart         (0.00kg)')]"));
        Assert.assertEquals("Invalid Text", "Shopping Cart  (0.00kg)", actualText1);
        Thread.sleep(2000);
        // 2.10 Verify the Product name "MacBook"
        String actualProductName = getTextElement(By.xpath("(//a[contains(text(),'MacBook')])[2]"));
        Assert.assertEquals("Invalid Product name", "MacBook", actualProductName);
        Thread.sleep(2000);
        // 2.11 Change Quantity "2"
        driver.findElement(By.xpath("//input[@class='form-control']")).clear();
        sendTextToElement(By.xpath("//input[@class='form-control']"), "2");
        Thread.sleep(2000);
        // 2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//button[@data-original-title='Update']"));
        Thread.sleep(2000);
        // 2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualMessage1 = getTextElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Invalid message", "Success: You have modified your shopping cart!\n" +
                "×", actualMessage1);
        Thread.sleep(2000);
        // 2.14 Verify the Total £737.45
        ////Changing currency
        mouseHoverElementAndClick(By.xpath("//span[text()='Currency']"));
        ////Mouse hover on £Pound Sterling and click
        mouseHoverElementAndClick(By.xpath("//button[text()='£Pound Sterling']"));
        Thread.sleep(2000);
        String actualTotal = getTextElement(By.xpath("//tbody//tr//td[6]"));
        Assert.assertEquals("Invalid Total", "£737.45", actualTotal);
        Thread.sleep(2000);
        // 2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        // 2.16 Verify the text “Checkout”
        String actualText2 = getTextElement(By.xpath("//h1[contains(text(),'Checkout')]"));
        Assert.assertEquals("Invalid Text", "Checkout", actualText2);
        Thread.sleep(2000);
        // 2.17 Verify the Text “New Customer"
        String actualText3 = getTextElement(By.xpath("//h2[normalize-space()='New Customer']"));
        Assert.assertEquals("Invalid Text", "New Customer", actualText3);
        Thread.sleep(2000);
        // 2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        Thread.sleep(2000);
        // 2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        Thread.sleep(2000);
        // 2.20 Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"), "Ram");
        sendTextToElement(By.id("input-payment-lastname"), "Krishna");
        sendTextToElement(By.id("input-payment-email"), "ramkrishna@gmail.com" );
        sendTextToElement(By.id("input-payment-telephone"), "02088872436" );
        sendTextToElement(By.id("input-payment-address-1"), "13, Happy Residency");
        sendTextToElement(By.id("input-payment-city"), "Ahmedabad");
        sendTextToElement(By.id("input-payment-postcode"), "393002");
        selectByVisibleTextFromDropDown(By.id("input-payment-country"), "India");
        selectByVisibleTextFromDropDown(By.id("input-payment-zone"),"Gujarat");
        Thread.sleep(2000);
        // 2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        Thread.sleep(2000);
        // 2.22 Add Comments About your order into text area
        clickOnElement(By.xpath("//textarea[@name='comment']"));
        Thread.sleep(2000);
        // 2.23 Check the Terms & Conditions check box
        clickOnElement(By.cssSelector("input[value='1'][name='agree']"));
        Thread.sleep(2000);
        // 2.24 Click on “Continue” button
        clickOnElement(By.id("button-payment-method"));
        Thread.sleep(2000);
        // 2.25 Verify the message “Warning: Payment method required!"
        Assert.assertEquals("Incorrect page displayed", "Warning: Payment method required!\n" +
                "×", getTextElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
