package task_2_1.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class IssuesPage {

    private final SelenideElement createIssueButtonSecond = $x("(//button[text()='Создать задачу'])[2]");
    private final SelenideElement searchBarInput = $x("//input[@placeholder='Поиск']");
    private final SelenideElement statusSelect = $x("//label[contains(text(), 'Статус')]/following::*[@role='combobox'][1]");
    private final SelenideElement boardSelect = $x("//label[contains(text(), 'Доска')]/following::*[@role='combobox'][1]");


    public IssuesPage openPage() {
        open("/");
        return this;
    }

    public IssuesPage searchBar(String searchItem) {
        searchBarInput.shouldBe(visible).setValue(searchItem).pressEnter();
        return this;
    }

    public IssuesPage selectStatus(String stat) {
        statusSelect.click();
        $x("//li[contains(., '" + stat + "')]").click();
        return this;
    }

    public IssuesPage selectBoard(String project) {
        boardSelect.click();
        $x("//li[contains(., '" + project + "')]").click();
        return this;
    }


    public IssueCreateModal openIssueCreateModalSecond() {
        createIssueButtonSecond.shouldBe(visible).click();
        $x("//h5[contains(., 'Создание задачи')]").shouldBe(visible);
        return new IssueCreateModal();
    }

}
