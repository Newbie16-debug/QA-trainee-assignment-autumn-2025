package task_2_1.pages;

import com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class IssueCreateModal {

    private final SelenideElement title = $x("//label[contains(text(), 'Название')]/following::input[1]");
    private final SelenideElement description = $x("//label[contains(text(), 'Описание')]/following::textarea[1]");
    private final SelenideElement board = $x("//label[contains(text(), 'Проект')]/following::*[@role='combobox'][1]");
    private final SelenideElement priority = $x("//label[contains(text(), 'Приоритет')]/following::*[@role='combobox'][1]");
    private final SelenideElement executor = $x("//label[contains(text(), 'Исполнитель')]/following::*[@role='combobox'][1]");
    private final SelenideElement buttonCreateIssue = $("div[role='presentation']").$("button");

    public IssueCreateModal setTitle(String text) {
        title.setValue(text);
        return this;
    }

    public IssueCreateModal setDescription(String text) {
        description.setValue(text);
        return this;
    }

    public IssueCreateModal selectBoard(String project) {
        board.click();
        $x("//li[contains(., '" + project + "')]").click();
        return this;
    }

    public IssueCreateModal selectPriority(String prior) {
        priority.click();
        $x("//li[contains(., '" + prior + "')]").click();
        return this;
    }

    public IssueCreateModal selectExecutor(String exec) {
        executor.click();
        $x("//li[contains(., '" + exec + "')]").click();
        return this;
    }

    public void createModal() {
        buttonCreateIssue.shouldBe(enabled).click();
    }
}
