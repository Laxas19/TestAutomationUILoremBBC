package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BbcHomePage extends BasePage{
    public BbcHomePage(WebDriver driver) {
        super(driver);
    }
    private final String homeBBCPageURL = "https://www.bbc.com/";

    @FindBy(xpath = "//li[@class='orb-nav-newsdotcom'][1]")
    private WebElement newsButton;

    public void openHomeBBCPageURL(){
        driver.get(homeBBCPageURL);
    }
    public void clickNewsButton(){
        newsButton.click();
    }
}
