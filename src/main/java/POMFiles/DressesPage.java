package POMFiles;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPage extends ParentClass{
WebElement myElement;
    public DressesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@title='Printed Chiffon Dress'])[2]")
    private WebElement chiffonDress;

    @FindBy(css = "button[name='Submit']")
    private WebElement addToCart;

    @FindBy(css = "a[title='Proceed to checkout'] >span")
    private WebElement proceedToCheckOut1;

    public void findElementAndClick(String element) {
        switch (element) {
            case "chiffonDress":
                myElement = chiffonDress;
                break;
            case "addToCart":
                myElement = addToCart;
                break;
            case "proceedToCheckOut1":
                myElement = proceedToCheckOut1;
                break;
        }
        clickFunction(myElement);
    }
}
