package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AskQuestionPage extends BasePage{
    public AskQuestionPage(WebDriver driver) {
        super(driver);
    }
    private final String VALID_QUESTION_INPUT = "Some interesting question to BBC they wont even check";
    private final String VALID_EMAIL = "No check for the format of email so u can input any string and it actually works";
    private final String VALID_NAME = "Not blank Name";

    @FindBy(xpath = "//button[@class='button']")
    private WebElement submitButton;
    @FindAll (@FindBy (xpath = "//div[@class='input-error-message']"))
    private List<WebElement> submitErrorsList;

    @FindBy(xpath = "//div[@class='long-text-input-container']/textarea")
    private WebElement questionInputField;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameInputField;

    @FindBy(xpath = "//input[@placeholder='Email address']")
    private WebElement emailInputField;

    @FindBy(xpath = "//div[@class='section-header-group__section-subheader']")
    private WebElement questionSubmitSuccessMassage;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkboxForTermsOfServices;


    public void clickSubmitButton(){
        submitButton.click();
    }
    public boolean submitErrorsVisibility(){
        for(WebElement error: submitErrorsList){
            if(error.isDisplayed() == false){
                return false;
            }
        }
        return true;
    }
    public void setQuestionInputField(){
        questionInputField.sendKeys(VALID_QUESTION_INPUT);
    }
    public void setNameInputField(){
        nameInputField.sendKeys(VALID_NAME);
    }
    public void setEmailInputField(){
        emailInputField.sendKeys(VALID_EMAIL);
    }
    public void clickCheckboxForTermsOfServices(){
        checkboxForTermsOfServices.click();
    }
    public boolean questionSubmitSuccessMassage(){
        return questionSubmitSuccessMassage.isDisplayed();
    }
}
