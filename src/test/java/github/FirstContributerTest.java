package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstContributerTest {

    @Test
    void firstContributerShouldBeAndreiSolntsev() {
        Configuration.browserSize="800x300";
        // открыть страничку репозитория Селенида
        open ("https://github.com/selenide/selenide");
//        $(".Layout-sidebar").$(byText("Contributors")).closest("div")
//                .$$("ul li").first().hover();

         $$(".Layout-sidebar .BorderGrid-row").find(text("Contributors"))
                 .$$("ul li").first().hover();

        // check в появившемся окошке(оверлей) текст Andrei Solntsev
         $$(".Popover-message").find(visible).shouldHave(text("Andrei Solntsev"));
         sleep(5000);
    }
}
