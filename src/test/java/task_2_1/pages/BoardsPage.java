package task_2_1.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

public class BoardsPage {

    private SelenideElement goToBoardByTitle(String title) {
        return $x("//h6[contains(text(), '" + title + "')]/following::a[1]");
    }

    public BoardsPage openPage() {
        open("/boards");
        return this;
    }

    public BoardPage openBoardPage(String title) {
        goToBoardByTitle(title).shouldBe(visible).click();
        return new BoardPage();
    }





}
