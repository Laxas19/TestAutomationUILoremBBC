package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoremIpsumTextGeneratedPage extends BasePage{
    public LoremIpsumTextGeneratedPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div/p[1]")
    private WebElement firstParagraphOfGeneratedText;

    @FindBy(xpath = "//div[@id='lipsum']")
    private WebElement generatedLoremIpsum;


    @FindAll (@FindBy (xpath = "//div/p"))
    private List <WebElement> listOfParagraphs;


    public String getFirstSentenceOfFirstParagraph(){
        String[] sentencesOfFirstParagraphDividedByDot;
        sentencesOfFirstParagraphDividedByDot = firstParagraphOfGeneratedText.getText().split("[.]");
        return sentencesOfFirstParagraphDividedByDot[0];
    }
    public int getAmountOfWordsGenerated(){
        String [] words = generatedLoremIpsum.getText().split(" ");
        return words.length;
    }
    public int getAmountOfParagraphsContainingLoremWord(){
        int amount = 0;
        for(WebElement paragraph: listOfParagraphs){
            if(paragraph.getText().contains("lorem")){
                amount++;
            }
        }
        return amount;
    }
    public int getAverageAmount(){
        int totalAmountOfParagraphsContainsLorem = getAmountOfParagraphsContainingLoremWord();
        for (int i = 0; i < 9; i++) {
            driver.navigate().refresh();
            totalAmountOfParagraphsContainsLorem +=getAmountOfParagraphsContainingLoremWord();
        }
        return totalAmountOfParagraphsContainsLorem/10;
    }
}
