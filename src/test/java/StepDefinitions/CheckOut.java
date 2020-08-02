package StepDefinitions;

import POMFiles.CheckOutPage;
import POMFiles.DressesPage;
import POMFiles.MainPage;
import Utilities.Driver;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckOut {
    WebDriver driver;
    MainPage mainPage = new MainPage();
    DressesPage dresses = new DressesPage();
    CheckOutPage checkOut = new CheckOutPage();

    @Given("^Navigate to: \"([^\"]*)\"$")
    public void navigate_to(String arg1) {
        driver = Driver.getDriver();
        driver.get(arg1);
        driver.manage().window().maximize();
    }

    @Then("^Click on sign in menu$")
    public void click_on_sign_in_menu() {
        mainPage.findElementAndClick("login");
    }

    @Then("^Enter the email: \"([^\"]*)\" and password: \"([^\"]*)\"$")
    public void enter_the_email_and_password(String arg1, String arg2) {
        mainPage.findElementAndSendKeys("email", arg1);
        mainPage.findElementAndSendKeys("passwd", arg2);

    }

    @Then("^Click on sign in button$")
    public void click_on_sign_in_button() {
        mainPage.findElementAndClick("submitLogin");
    }

    @When("^Click on the dresses$")
    public void click_on_the_dresses() {
        mainPage.findElementAndClick("dresses");
    }

    @Then("^Click on the any item from the page$")
    public void click_on_the_any_item_from_the_page() {
        dresses.findElementAndClick("chiffonDress");
    }

    @Then("^Click on the add to cart$")
    public void click_on_the_add_to_cart() {
        dresses.findElementAndClick("addToCart");
    }

    @Then("^Click on the proceed to checkout button-1$")
    public void click_on_the_proceed_to_checkout_button1() {
        dresses.findElementAndClick("proceedToCheckOut1");
    }

    @Then("^Verify Total products \\+ Total shipping = Total$")
    public void verify_Total_products_Total_shipping_Total() {
        String a = checkOut.findElementAndGetText("totalProductPrice")
                .replaceAll("([$])", "").trim();

        String b = checkOut.findElementAndGetText("totalShippingPrice")
                .replaceAll("([$])", "").trim();

        String c = checkOut.findElementAndGetText("totalPriceWithoutTax")
                .replaceAll("([$])", "").trim();

        System.out.println(a + " -- " + b + " --- " + c);
        double totalProductPrice = Double.parseDouble(a);
        double totalShippingPrice = Double.parseDouble(b);
        double totalPriceWithoutTax = Double.parseDouble(c);
        Assert.assertEquals(totalProductPrice + totalShippingPrice, totalPriceWithoutTax, 0.1);
    }

    @When("^Click on the proceed to checkout button-2$")
    public void click_on_the_proceed_to_checkout_button2() {
        checkOut.findElementAndClick("proceedToCheckOut2");
    }

    @Then("^Click on the proceed to checkout button-3$")
    public void click_on_the_proceed_to_checkout_button3() {
        checkOut.findElementAndClick("proceedToCheckOut3");
    }

    @Then("^Click on the 'I agree....' checkbox$")
    public void click_on_the_checkbox() {
        checkOut.findElementAndCheck();
    }

    @And("^Click on the proceed to checkout button-4$")
    public void click_on_the_proceed_to_checkout_button4() {
        checkOut.findElementAndClick("proceedToCheckOut4");
    }

    @Then("^Click on the Pay by bank wire$")
    public void click_on_the_Pay_by_bank_wire() {
        checkOut.findElementAndClick("payBankWire");
    }

    @Then("^Click on the I confirm my order button$")
    public void click_on_the_I_confirm_my_order_button() {
        checkOut.findElementAndClick("confirmMyOrder");
    }

    @Then("^Verify Order confirmation text is displayed$")
    public void verify_Order_confirmation_text_is_displayed() {
        System.out.println(checkOut.findElementAndGetText("confirmMessage"));
        Assert.assertEquals("Your order on My Store is complete.", checkOut.findElementAndGetText("confirmMessage"));
    }

}
