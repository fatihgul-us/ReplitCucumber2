package POMFiles;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends ParentClass {
    WebElement myElement;

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "login")
    private WebElement login;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement passwd;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin;

    @FindBy(xpath = "(//a[@title=\"Dresses\"])[2]")
    private WebElement dresses;

    public void findElementAndClick(String element) {

        switch (element) {
            case "login":
                myElement = login;
                break;
            case "submitLogin":
                myElement = submitLogin;
                break;
            case "dresses":
                myElement = dresses;
                break;
        }
        clickFunction(myElement);
    }

    public void findElementAndSendKeys(String element, String keys) {

        switch (element) {

            case "email":
                myElement = email;
                break;
            case "passwd":
                myElement = passwd;
                break;


        }
        sendKeys(myElement, keys);
    }
}
