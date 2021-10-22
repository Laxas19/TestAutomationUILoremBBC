package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsBbcPage extends BasePage{
    public NewsBbcPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[contains(@class,'gel-canon-bold nw-o-link-split__anchor')]/h3")
    private WebElement mainArticle;

    @FindBy(xpath = "//div[@class='gs-c-promo-body gel-1/3@m gel-1/4@l gel-2/5@xxl']//li[@class='nw-c-promo-meta']/a/span")
    private WebElement categoryLinkOfFirstArticle;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchInput;

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container'][1]/a")
    private WebElement coronavirusButton;



    public String getStringFromMainArticle(){
        return mainArticle.getText();
    }
    public String getStringFromCategoryLinkOfFirstArticle(){
        return categoryLinkOfFirstArticle.getText();
    }
    public void setSearchInput(){
        searchInput.sendKeys(categoryLinkOfFirstArticle.getText());
        searchInput.sendKeys(Keys.ENTER);
    }
    public void clickCoronavirusButton(){
        coronavirusButton.click();
    }
}
