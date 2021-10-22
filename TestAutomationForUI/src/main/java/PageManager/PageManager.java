package PageManager;

import Pages.*;
import org.openqa.selenium.WebDriver;

public class PageManager {
    WebDriver driver;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public MainLoremIpsumPage getMainLoremIpsumPage() {
        return new MainLoremIpsumPage(driver);
    }
    public LoremIpsumTextGeneratedPage getLoremIpsumTextGeneratedPage(){
        return new LoremIpsumTextGeneratedPage(driver);
    }
    public BbcHomePage getBbcHomePage(){
        return new BbcHomePage(driver);
    }
    public NewsBbcPage getNewsBbcPage(){
        return new NewsBbcPage(driver);
    }
    public SearchResultBbcPage getSearchResultBbcPage(){
        return new SearchResultBbcPage(driver);
    }
    public CoronavirusPageBbc getCoronavirusPageBbc(){
        return new CoronavirusPageBbc(driver);
    }
    public AskQuestionPage getAskQuestionPage(){
        return new AskQuestionPage(driver);
    }
}