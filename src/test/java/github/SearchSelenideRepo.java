package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideRepo {

    @Test
    void shouldFindSelenideRepositoryInGithub () {
        // открыть github.com
        open ("https://github.com/");
        // ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=\"nav-search-input\"]").setValue("selenide").pressEnter();
        // нижимаем на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click(); //без $$ и first также выберется первое значение, но такой код объясняет что мы делаем
        // check: в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide / selenide"));
    }
}
