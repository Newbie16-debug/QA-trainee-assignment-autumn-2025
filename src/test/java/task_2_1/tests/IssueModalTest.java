package task_2_1.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task_2_1.config.TestsConfig;
import task_2_1.pages.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class IssueModalTest {

    private final SelenideElement buttonCreateIssue = $("div[role='presentation']").$("button");

    @BeforeAll
    static void init() {
        TestsConfig.init();
    }

    @Disabled
    @Test
    @DisplayName("Создание таски при заполнении всех необходимых полей")
    void canCreateIssueWithNecessaryFields() {
        open("/");
        IssueCreateModal modal = new HeaderPage().openIssueCreateModal();

        modal.setTitle("Задача тестовая #777")
                .setDescription("Описание тестовой задачи")
                .selectBoard("Рефакторинг API")
                .selectPriority("Medium")
                .selectExecutor("Максим Орлов")
                .createModal();

        $("div.MuiModal-root").shouldNotBe(visible);
        open("/");
        $$("div.MuiPaper-root.MuiPaper-outlined").findBy(text("Задача тестовая #777"))
                .shouldBe(visible);
    }

    @Disabled
    @Test
    @DisplayName("Кнопка Создать неактивна, если не заполнить все необходимые поля")
    void cantCreateIssueWithoutNecessaryFields() {
        //IssuesPage issuesPage = new IssuesPage().openPage();
        //IssueCreateModal modal = issuesPage.openIssueCreateModal();
        open("/");
        IssueCreateModal modal = new HeaderPage().openIssueCreateModal();

        modal.setTitle("Задача тестовая #121").setDescription("Описание тестовой задачи");

        buttonCreateIssue.shouldNotBe(Condition.enabled);
    }

//    @Test
//    @DisplayName("Пустая строка в поле Название -> кнопка Обновить неактивна")
//    void editIssue() {
//        open("/");
//        //IssueEditModal issueEditModal = new IssueEditModal().openIssueEditModal("Оптимизация загрузки медиа-контента");
//        IssueEditModal issueEditModal = new IssueEditModal().openIssueEditModal("Оптимизация использования памяти");
//        Selenide.sleep(2000);
//        //issueEditModal.setTitleEdit("");
//        issueEditModal.setTitleClear();
//        Selenide.sleep(2000);
//        issueEditModal.checkUpdateButtonIsInactive();
//        Selenide.sleep(2000);
//        //Selenide.sleep(5000);
//
//    }
}
