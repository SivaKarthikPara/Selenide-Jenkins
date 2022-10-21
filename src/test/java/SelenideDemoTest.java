import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.impl.CiReportUrl;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideDemoTest {

    private final static String flipkartTitle =
            "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";

    private final static String searchField = "input[title='Search for products, brands and more']";
    private final static String resultsXpath = "._10Ermr";

    @Test
    public void searchProduct() {
        Configuration.baseUrl = "https://www.flipkart.com";
        open("/");
        //validating title
        assertThat(title()).isEqualTo(flipkartTitle);
        $(By.cssSelector(searchField)).setValue("Samsung Mobile").pressEnter();
        $(By.cssSelector(resultsXpath)).shouldBe(Condition.visible);
        String searchResultText = $(By.cssSelector(resultsXpath)).getText();
        assertThat(searchResultText).matches("Showing 1 – \\d+ of \\d+ results for \"Samsung Mobile\"");
        System.out.println($(By.cssSelector(resultsXpath)).getText());
    }

    @AfterTest
    public void after() {
        CiReportUrl url = new CiReportUrl();
        System.out.println(url.getReportsUrl(""));
    }

}
