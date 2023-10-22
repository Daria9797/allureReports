import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepTest {
    @Test
    @DisplayName("Лямбда шаги через step")
    public void testWithStep(){

        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", ()-> {
            open("https://github.com/");
        });
        step("Кликаем по полю поиска",()->{
            $(".search-input").click();
        });

        step("Заполняем поле поиска названием репозитория и выполняем поиск",()->{
            $("#query-builder-test").setValue("Daria9797/allureReports").pressEnter();
        });

        step ("Открываем найденный репозиторий",()->{
            $(By.linkText("Daria9797/allureReports")).click();
        });
        step("Открываем раздел Issue",()->{
            $("#issues-tab").click();
        });
        step("Проверяем что есть issue c номером 10",()->{
            $("#issue_1_link").shouldHave(text("10"),visible);
        });

    }

    @Test
    @DisplayName("Шаги с аннотацией @Step")
    public void testWithAnn(){

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps ann=new WebSteps();
        ann.openMainPage();
        ann.clickFieldSearch();
        ann.doSearch();
        ann.openRepo();
        ann.openIssue();
        ann.checkIssue();
    }
}
