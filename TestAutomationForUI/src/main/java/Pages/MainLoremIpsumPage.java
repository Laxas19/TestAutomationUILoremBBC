package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainLoremIpsumPage extends BasePage{
    public MainLoremIpsumPage(WebDriver driver) {
        super(driver);
    }
    private final String LOREM_IPSUM_URL = "https://lipsum.com/";

    @FindBy(xpath = "//a[contains(@href, 'ru')]")
    private WebElement russianLoremIpsumVersion;

    @FindBy(xpath = "//div[1]/p")
    private WebElement firstLoremParagraph;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement generateLoremIpsumButton;

    @FindBy(xpath = "//input[@value='words']")
    private WebElement radioButtonWords;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement amountOfTextInputField;

    @FindBy(xpath = "//input[@id='start']")
    private WebElement startWithLoremCheck;

    public void openMainLoremIpsumPage(){
    driver.get(LOREM_IPSUM_URL);
    }

    public void setRussianLanguage(){
        russianLoremIpsumVersion.click();
    }
    public String getStringFromFirstLoremParagraph(){
       return firstLoremParagraph.getText();
    }
    public void clickGenerateLoremIpsumButton(){
        generateLoremIpsumButton.click();
    }
    public void clickRadioButtonWords(){
        radioButtonWords.click();
    }
    public void setAmountOfTextGenerated(String value){
        amountOfTextInputField.clear();
        amountOfTextInputField.sendKeys(value);
    }
    public void uncheckStartWithLoremCheck(){
        if(startWithLoremCheck.isSelected()){
            startWithLoremCheck.click();
        }
    }

}
