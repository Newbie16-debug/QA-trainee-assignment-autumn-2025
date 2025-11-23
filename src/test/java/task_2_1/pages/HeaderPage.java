package task_2_1.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HeaderPage {

    private final SelenideElement createIssueButton = $("button[type=button]");
    private final SelenideElement boardsPageLink = $x("//a[text()='Проекты']");
    private final SelenideElement issuesPageLink = $x("//a[text()='Все задачи']");

    public IssuesPage openIssuesPage() {
        issuesPageLink.shouldBe(visible).click();
        return new IssuesPage();
    }

    public BoardsPage openBoardsPage() {
        boardsPageLink.shouldBe(visible).click();
        return new BoardsPage();
    }

    public IssueCreateModal openIssueCreateModal() {
        createIssueButton.shouldBe(visible).click();

        $x("//h5[contains(., 'Создание задачи')]").shouldBe(visible);
        return new IssueCreateModal();
    }
}
