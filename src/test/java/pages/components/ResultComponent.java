package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    public void checkResult(String key, String value){
        $(".table").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
