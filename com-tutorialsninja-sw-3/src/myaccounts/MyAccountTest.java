package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class MyAccountTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    /**
     * 1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
     * 1.2 This method should click on the options whatever name is passed as parameter.
     * (Hint: Handle List of Element and Select options)
     */
    public void selectMyAccountOptions(String option) {
        WebElement menuList = driver.findElement(By.linkText(option));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuList).click().build().perform();
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        /**
         * 1.1 Click on My Account Link.
         * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
         * 1.3 Verify the text “Register Account”.
         */
        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(2000);
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        Thread.sleep(2000);
        //1.3 Verify the text “Register Account”.
        Assert.assertEquals("Register Account", getTextElement(By.xpath("//h1[normalize-space()='Register Account']")));
        Thread.sleep(2000);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        /**
         * 2.1 Click on My Account Link.
         * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
         * 2.3 Verify the text “Returning Customer”.
         */
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(2000);
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        Thread.sleep(2000);
        //2.3 Verify the text “Returning Customer”.
        Assert.assertEquals("Returning Customer", getTextElement(By.xpath("//h2[normalize-space()='Returning Customer']")));
        Thread.sleep(2000);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        /**
         * 3.1 Click on My Account Link.
         * 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
         * 3.3 Enter First Name
         * 3.4 Enter Last Name
         * 3.5 Enter Email
         * 3.6 Enter Telephone
         * 3.7 Enter Password
         * 3.8 Enter Password Confirm
         * 3.9 Select Subscribe Yes radio button
         * 3.10 Click on Privacy Policy check box
         * 3.11 Click on Continue button
         * 3.12 Verify the message “Your Account Has Been Created!”
         * 3.13 Click on Continue button
         * 3.14 Click on My Account Link.
         * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
         * 3.16 Verify the text “Account Logout”
         * 3.17 Click on Continue button
         */
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(2000);
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        Thread.sleep(2000);
        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Ram");
        Thread.sleep(2000);
        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Krishna");
        Thread.sleep(2000);
        //Generate a random Email
        final String randomEmail = randomEmail();
        //3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"), randomEmail);
        Thread.sleep(2000);
        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "07384585896");
        Thread.sleep(2000);
        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Snow123");
        Thread.sleep(2000);
        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "Snow123");
        Thread.sleep(2000);
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']"));
        Thread.sleep(2000);
        // 3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        Thread.sleep(2000);
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        Thread.sleep(2000);
        //3.12 Verify the message “Your Account Has Been Created!”
        String actualText = getTextElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        Assert.assertEquals("Your Account Has Been Created!", actualText);
        Thread.sleep(2000);
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        Thread.sleep(2000);
        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));
        Thread.sleep(2000);
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        Thread.sleep(2000);
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals("Account Logout", getTextElement(By.xpath("//h1[normalize-space()='Account Logout']")));
        Thread.sleep(2000);
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        Thread.sleep(2000);
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        /**
         * 4.1 Click on My Account Link.
         * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login"
         * 4.4 Enter Email address
         * 4.5 Enter Password
         * 4.6 Click on Login button
         * 4.7 Verify text “My Account”
         * 4.8 Click on My Account Link.
         * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
         * 4.10 Verify the text “Account Logout”
         * 4.11 Click on Continue button
         */
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(2000);
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        Thread.sleep(2000);
        //4.4 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "morya1234@gmail.com");
        Thread.sleep(2000);
        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Snow123");
        Thread.sleep(2000);
        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        Thread.sleep(2000);
        //4.7 Verify text “My Account”
        Assert.assertEquals("My Account", getTextElement(By.xpath("//span[text()='My Account']")));
        Thread.sleep(2000);
        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(2000);
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        Thread.sleep(2000);
        //4.10 Verify the text “Account Logout”
        String actualLogoutText = getTextElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals("Invalid text", "Account Logout", actualLogoutText);
        Thread.sleep(2000);
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}
