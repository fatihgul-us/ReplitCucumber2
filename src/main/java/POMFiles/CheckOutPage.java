package POMFiles;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends ParentClass {

    WebElement myElement;

    public CheckOutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "total_product")
    private WebElement totalProductPrice;

    @FindBy(id = "total_shipping")
    private WebElement totalShippingPrice;

    @FindBy(id = "total_price_without_tax")
    private WebElement totalPriceWithoutTax;

    @FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
    private WebElement proceedToCheckOut2;

    @FindBy(css = "button[name='processAddress']>span")
    private WebElement proceedToCheckOut3;

    @FindBy(css = "input[id=cgv]")
    private WebElement agreeCheckBox;

    @FindBy(css = "button[name='processCarrier']>span")
    private WebElement proceedToCheckOut4;

    @FindBy(css = "a[class='bankwire']")
    private WebElement payBankWire;

    @FindBy(xpath = "(//button[@type='submit']/span)[2]")
    private WebElement confirmMyOrder;

    @FindBy(css = "p[class='cheque-indent']>strong")
    private WebElement confirmMessage;

    public String findElementAndGetText(String element) {
        switch (element) {
            case "totalProductPrice":
                myElement = totalProductPrice;
                break;
            case "totalShippingPrice":
                myElement = totalShippingPrice;
                break;
            case "totalPriceWithoutTax":
                myElement = totalPriceWithoutTax;
                break;
            case "confirmMessage":
                myElement = confirmMessage;
                break;
        }
        return getText(myElement);
    }

    public void findElementAndClick(String element) {
        switch (element) {
            case "proceedToCheckOut2":
                myElement = proceedToCheckOut2;
                break;
            case "proceedToCheckOut3":
                myElement = proceedToCheckOut3;
                break;
//            case "agreeCheckBox":
//                myElement = agreeCheckBox;
//                break;
            case "proceedToCheckOut4":
                myElement = proceedToCheckOut4;
                break;
            case "payBankWire":
                myElement = payBankWire;
                break;
            case "confirmMyOrder":
                myElement = confirmMyOrder;
                break;

        }
        clickFunction(myElement);
    }
    public void findElementAndCheck(){

        myElement=agreeCheckBox;
      //  wait.until(ExpectedConditions.visibilityOf(myElement));
        myElement.click();
    }
}
