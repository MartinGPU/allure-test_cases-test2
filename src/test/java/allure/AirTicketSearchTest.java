package allure;

import base.TestBase;
import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Layer("web_ui_2")
public class AirTicketSearchTest extends TestBase {

    @Test
    @AllureId("23881")
    @DisplayName("Search air ticket")
    @Story("Search air ticket")
    @Owner("allure8")
    @Microservice("second service")
    @JiraIssues({@JiraIssue("HOMEWORK-774")})
    @Feature("Search ticket")
    public void searchAirTicket() {
        step("Open main page", () -> {
            open("https://www.tutu.ru/");
        });
        step("Input departure city", () -> {
            $("[name='city_from']").setValue("Москва");
        });
        step("Input arrival city", () -> {
            $("[name='city_to']").setValue("Сургут");
        });
        step("Select departure date", () -> {
            $("[name='date_from']").setValue("24.07.2023");
        });
        step("Select arrival date", () -> {
            $("[name='date_back']").setValue("27.07.2023");
        });
        step("Click to search", () -> {
            $$(".spinner").get(0).click();
        });
        step("Check available tickets", () -> {
            $$("span").get(40).shouldHave(Condition.text("предлож"));
        });
    }
}