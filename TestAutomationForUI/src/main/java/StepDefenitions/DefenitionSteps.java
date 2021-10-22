package StepDefenitions;
import Pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageManager.PageManager;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.main;
import static org.junit.Assert.*;

public class DefenitionSteps {
   private WebDriver driver;
   private PageManager pageManager;
   private MainLoremIpsumPage mainLoremIpsumPage;
   private LoremIpsumTextGeneratedPage loremIpsumTextGeneratedPage;
   private BbcHomePage bbcHomePage;
   private NewsBbcPage newsBbcPage;
   private SearchResultBbcPage searchResultBbcPage;
   private AskQuestionPage askQuestionPage;
   private CoronavirusPageBbc coronavirusPageBbc;

   private final String SPECIFIC_RUSSIAN_WORD_FIRST_PARAGRAPH_SHOULD_CONTAIN = "рыба";
   private final String FIRST_SENTENCE_OF_GENERATED_LOREM_IPSUM_EXPECTED = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
   private final String RIGHT_QUERY_FOR_MAIN_ARTICLE = "British MP Sir David Amess stabbed to death";
   private final String SPECIFIC_VALUE_FIRST_SEARCH_RESULT_ARTICLE_EXPECTED = "Weather forecast for the UK";



   @Before
   public void testsSetUp() {
      chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      pageManager = new PageManager(driver);
   }

   @And("User opens main Lorem Ipsum page")
   public void openMainLoremIpsumPage() {
      mainLoremIpsumPage = pageManager.getMainLoremIpsumPage();
      mainLoremIpsumPage.openMainLoremIpsumPage();
      mainLoremIpsumPage.WaitForPageLoadComplete(30);
   }

   @When("User clicks on russian version of site")
   public void userClicksOnRussianVersionOfSite() {
      mainLoremIpsumPage.setRussianLanguage();
   }

   @After
   public void tearDown() {
      driver.close();
   }

   @Then("First paragraph must contain specific word")
   public void firstParagraphMustContainSpecificWord() {
      assertTrue(mainLoremIpsumPage.getStringFromFirstLoremParagraph().contains(SPECIFIC_RUSSIAN_WORD_FIRST_PARAGRAPH_SHOULD_CONTAIN));
   }

   @And("User clicks generate Lorem Ipsum button")
   public void userClicksGenerateLoremIpsumButton() {
      mainLoremIpsumPage.WaitForPageLoadComplete(30);
      mainLoremIpsumPage.clickGenerateLoremIpsumButton();
   }

   @Then("User verify that first sentence of generated paragraph must be equal to specific value")
   public void firstSentenceOfGeneratedParagraphMustBeEqualToSpecificValue() {
      loremIpsumTextGeneratedPage = pageManager.getLoremIpsumTextGeneratedPage();
      loremIpsumTextGeneratedPage.WaitForPageLoadComplete(30);
      assertEquals(FIRST_SENTENCE_OF_GENERATED_LOREM_IPSUM_EXPECTED, loremIpsumTextGeneratedPage.getFirstSentenceOfFirstParagraph());
   }

   @And("User clicks words radiobutton")
   public void userClicksWordsRadiobutton() {
      mainLoremIpsumPage.clickRadioButtonWords();
   }

   @When("User inputs {string} of words to generate")
   public void userInputsAmountOfWordsToGenerate(String amountOfWordsToGenerate) {
      mainLoremIpsumPage.setAmountOfTextGenerated(amountOfWordsToGenerate);
   }

   @Then("User checks amount of words equals to {string}")
   public void userChecksAmountOfWordsEqualsToValue(String expectedAmount){
      loremIpsumTextGeneratedPage = pageManager.getLoremIpsumTextGeneratedPage();
      assertEquals(Integer.parseInt(expectedAmount), loremIpsumTextGeneratedPage.getAmountOfWordsGenerated());
   }

   @And("User uncheck start with Lorem Ipsum checkbox")
   public void userUncheckStartWithLoremIpsumCheckbox() {
      mainLoremIpsumPage.uncheckStartWithLoremCheck();
   }

   @Then("User verify that first sentence of generated paragraph must be not equal to specific value")
   public void userVerifyThatFirstSentenceOfGeneratedParagraphMustBeNotEqualToSpecificValue() {
      loremIpsumTextGeneratedPage = pageManager.getLoremIpsumTextGeneratedPage();
      loremIpsumTextGeneratedPage.WaitForPageLoadComplete(30);
      assertNotEquals(FIRST_SENTENCE_OF_GENERATED_LOREM_IPSUM_EXPECTED, loremIpsumTextGeneratedPage.getFirstSentenceOfFirstParagraph());
   }

   @Then("User checks that average amount of paragraphs more then {int}")
   public void userChecksThatAverageAmountOfParagraphsMoreThen(int averageAmountMustBe) {
      loremIpsumTextGeneratedPage = pageManager.getLoremIpsumTextGeneratedPage();
      assertTrue(loremIpsumTextGeneratedPage.getAverageAmount()>=averageAmountMustBe);
   }

   @Given("User opens BBC home page")
   public void userOpensBBCHomePage() {
      bbcHomePage = pageManager.getBbcHomePage();
      bbcHomePage.openHomeBBCPageURL();
   }

   @When("User clicks News button")
   public void userClicksNewsButton() {
      bbcHomePage.clickNewsButton();
   }

   @Then("User checks the name of headline article matches specific query")
   public void userChecksTheNameOfHeadlineArticleMatchesSpecificQuery() {
      newsBbcPage = pageManager.getNewsBbcPage();
      assertEquals(RIGHT_QUERY_FOR_MAIN_ARTICLE, newsBbcPage.getStringFromMainArticle());
   }

   @When("User input in search field category link of the headline article")
   public void userInputInSearchFieldCategoryLinkOfTheHeadlineArticle() {
      newsBbcPage = pageManager.getNewsBbcPage();
      newsBbcPage.setSearchInput();
   }

   @Then("User checks that first article of search result matches specific value")
   public void userChecksThatFirstArticleOfSearchResultMatchesSpecificValue() {
      searchResultBbcPage = pageManager.getSearchResultBbcPage();
      assertEquals(SPECIFIC_VALUE_FIRST_SEARCH_RESULT_ARTICLE_EXPECTED, searchResultBbcPage.getArticleDescriptionString());
   }

   @And("User clicks on the coronavirus button")
   public void userClicksOnTheCoronavirusButton() {
      newsBbcPage = pageManager.getNewsBbcPage();
      newsBbcPage.clickCoronavirusButton();
   }

   @And("User clicks Your coronavirus story button")
   public void userClicksYourCoronavirusStoryButton() {
      coronavirusPageBbc = pageManager.getCoronavirusPageBbc();
      coronavirusPageBbc.clickYourCoronavirusStoryButton();
   }

   @And("User clicks ask your question link")
   public void userClicksAskYourQuestionLink() {
      coronavirusPageBbc.clickOnAskQuestionLink();
   }

   @When("User clicks submit button with blank input fields")
   public void userClicksSubmitButtonWithBlankInputFields() {
      askQuestionPage = pageManager.getAskQuestionPage();
      askQuestionPage.clickSubmitButton();
   }

   @Then("User checks that errors massages are displayed")
   public void userChecksThatErrorsMassagesAreDisplayed() {
      assertTrue(askQuestionPage.submitErrorsVisibility());
   }

   @When("User clicks submit button with correct data in input fields but not checks radiobutton for terms of services")
   public void userClicksSubmitButtonWithCorrectDataInInputFieldsButNotChecksRadiobuttonForTermsOfServices() {
      askQuestionPage = pageManager.getAskQuestionPage();
      askQuestionPage.setEmailInputField();
      askQuestionPage.setNameInputField();
      askQuestionPage.setQuestionInputField();
   }

   @And("User clicks checkbox fort terms of services")
   public void userClicksCheckboxFortTermsOfServices() {
      askQuestionPage.clickCheckboxForTermsOfServices();
   }

   @Then("User checks that massage about question submit success displayed")
   public void userChecksThatMassageAboutQuestionSubmitSuccessDisplayed() {
      assertTrue(askQuestionPage.questionSubmitSuccessMassage());
   }
}