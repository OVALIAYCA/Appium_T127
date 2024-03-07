package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPage {


    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement guestButton;

    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement departureText;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButton;







}
