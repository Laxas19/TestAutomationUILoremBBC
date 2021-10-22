package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPageBbc extends BasePage{
    public CoronavirusPageBbc(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//li[contains(@class, 'secondary-menuitem-container')]/a")
    private WebElement yourCoronavirusStoryButton;

    @FindBy(xpath = "//div[contains(@class, 'gel-1/4@l gel-1/5@xxl nw-o-keyline')][2]")
    private WebElement askQuestionLink;

    public void clickYourCoronavirusStoryButton(){
        yourCoronavirusStoryButton.click();
    }
    public void clickOnAskQuestionLink(){
        askQuestionLink.click();
    }
}
