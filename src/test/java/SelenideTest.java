import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideTest {


    @Test
    public void selenideWithListener(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").setValue("Daria9797/allureReports").pressEnter();
        $(By.linkText("Daria9797/allureReports")).click();
        $("#issues-tab").click();
        $("#issue_1_link").shouldHave(text("10"),visible);

    }

}
