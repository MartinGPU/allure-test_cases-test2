package allure;

import base.TestBase;
import com.codeborne.selenide.Condition;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class BusTicketSearchTest extends TestBase {

    @Test
    @AllureId("23920")
    @DisplayName("Search bus ticket")
    @Story("Search bus ticket")
    @Owner("allure8")
    @Feature("Search ticket")
    public void searchBusTicket() {
        step("Open main page", () -> {
            open("https://bus.tutu.ru/");
        });
        step("Set departure city", () -> {
            $("[placeholder='Откуда']").setValue("Москва");
        });
        step("Set arrival city", () -> {
            $("[placeholder='Куда']").setValue("Иваново");
        });
        step("Set date", () -> {
            $("#date").setValue("28.07.2023");
        });
        step("Click to search", () -> {
            $("[data-ti='order-button-outer']").click();
            sleep(5000);
        });
        step("Check available tickets", () -> {
            $$("span.index__nowrap___1JmzG").get(0).shouldHave(Condition.text("Москва"));
            $$("span.index__nowrap___1JmzG").get(1).shouldHave(Condition.text("Иваново"));
            $$("span.index__nowrap___1JmzG").get(2).shouldHave(Condition.text("28 июля 2023"));
        });
    }
}
