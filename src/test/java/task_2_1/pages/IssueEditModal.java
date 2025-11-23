package task_2_1.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class IssueEditModal {

    private final SelenideElement title = $x("//label[contains(text(), 'Название')]/following::input[1]");
    private final SelenideElement description = $x("//label[contains(text(), 'Описание')]/following::textarea[1]");
    private final SelenideElement boardReadOnly = $x("//label[contains(text(), 'Проект')]/following::*[contains(@class, 'Mui-disabled')]");
    private final SelenideElement priority = $x("//label[contains(text(), 'Приоритет')]/following::*[@role='combobox'][1]");
    private final SelenideElement executor = $x("//label[contains(text(), 'Исполнитель')]/following::*[@role='combobox'][1]");
    private final SelenideElement status = $x("//label[contains(text(), 'Статус')]/following::*[@role='combobox'][1]");
    private final SelenideElement updateIssueButton = $x("//button[.='Обновить']");
    private final SelenideElement goToBoardButton = $x("//button[contains(text(), 'Перейти на доску')]");
    //private final SelenideElement openEditModal = $x("//div[contains(@class, 'MuiPaper-outlined')]/following::h6[text()='Добавление микроанимаций интерфейса']");

    private SelenideElement openExactModal(String title) {
        return $x("//div[contains(@class, 'MuiPaper-outlined')]/following::h6[text()='" + title+ "']");
    }


    public IssueEditModal setTitleEdit(String text) {
        title.clear();
        title.setValue(text);
        return this;
    }

    public IssueEditModal setTitleClear() {
        title.clear();
        return this;
    }

    public IssueEditModal setDescriptionEdit(String text) {
        description.clear();
        description.setValue(text);
        return this;
    }

    public IssueEditModal selectPriorityEdit(String prior) {
        priority.click();
        $x("//li[contains(., '" + prior + "')]").click();
        return this;
    }

    public IssueEditModal selectExecutorEdit(String exec) {
        executor.click();
        $x("//li[contains(., '" + exec + "')]").click();
        return this;
    }

    public IssueEditModal selectStatusEdit(String stat) {
        status.click();
        $x("//li[contains(., '" + stat + "')]").click();
        return this;
    }

    public IssueEditModal checkBoardIsReadOnly() {
        boardReadOnly.shouldNotBe(enabled);
        return this;
    }

    public IssueEditModal checkUpdateButtonIsInactive() {
        updateIssueButton.shouldNotBe(enabled);
        return this;
    }

    public void updateModal() {
       updateIssueButton.shouldBe(enabled).click();
    }

    public BoardPage goToBoard() {
        goToBoardButton.shouldBe(enabled).click();
        return new BoardPage();
    }

    public IssueEditModal openIssueEditModal(String title) {
        openExactModal(title).shouldBe(visible).click();
        return this;
    }


}
