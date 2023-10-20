import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AnnotationTest {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step ("Кликаем по полю поиска")
    public void clickFieldSearch(){
        $(".search-input").click();
    }

    @Step ("Заполняем поле поиска названием репозитория и выполняем поиск")
    public void doSearch(){
        $("#query-builder-test").setValue("Daria9797/allureReports").pressEnter();
    }

    @Step ("Открываем найденный репозиторий")
    public void openRepo(){
        $(By.linkText("Daria9797/allureReports")).click();
    }

    @Step ("Открываем раздел Issue")
    public void openIssue(){
        $("#issues-tab").click();
    }

    @Step ("Проверяем что есть issue c номером 10")
    public void checkIssue(){
        $("#issue_1_link").shouldHave(text("10"),visible);
    }
}
