package task_2_1.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.*;

public class BoardPage {

    private final SelenideElement boardTitle = $x("//h4");

    public BoardPage shouldBeOpened(String title) {
        boardTitle.shouldHave(visible, text(title));
        return this;
    }
}
