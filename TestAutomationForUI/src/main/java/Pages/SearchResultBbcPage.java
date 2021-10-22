package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultBbcPage extends BasePage {
    public SearchResultBbcPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//p[@class='ssrcss-1q0x1qg-Paragraph eq5iqo00']")
    private WebElement articleDescription;

    public String getArticleDescriptionString(){
        return articleDescription.getText();
    }
}
