package task_2_1.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task_2_1.config.TestsConfig;
import task_2_1.pages.IssuesPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FiltersTest {

    @BeforeAll
    static void init() {
        TestsConfig.init();
    }



    @Test
    @DisplayName("Поиск по существующему названию выдает результирующую таску/таски")
    void successfulSearchWithExistedTitle() {
        IssuesPage issuesPage = new IssuesPage().openPage();
        String searchItem = "Оптимизация загрузки медиа-контента";
        issuesPage.searchBar(searchItem);
        $x("//div[contains(@class,'MuiPaper-root')][.//h6[text()='" + searchItem + "']]")
                .shouldBe(visible);

    }

    @Test
    @DisplayName("Поиск по несуществующему названию выдает Задачи не найдены")
    void unsuccessfulSearchWithNotExistedTitle() {
        IssuesPage issuesPage = new IssuesPage().openPage();
        //Selenide.sleep(2000);
        String searchItem = "ijdfcsjk309kdf0-943k";
        issuesPage.searchBar(searchItem);
        $x("//h5[text()='Задачи не найдены']")
                .shouldBe(visible);
    }

    @Test
    @DisplayName("Фильтр по статусу выдает таски только с таким статусом")
    void filterByStatusShowsExactStatus() {
        IssuesPage issuesPage = new IssuesPage().openPage();
        String status = "InProgress";
        issuesPage.selectStatus(status);
        ElementsCollection tasks = $$("div.MuiPaper-root.MuiPaper-outlined");
        tasks.forEach(task -> task.$("span").shouldHave(text(status)));
    }

    @Test
    @DisplayName("Фильтр по доске выдает таски только с такой доской")
    void filterByBoardShowsExactBoards() {
        IssuesPage issuesPage = new IssuesPage().openPage();
        String board = "Переход на Kubernetes";
        issuesPage.selectBoard(board);
        ElementsCollection tasks = $$("div.MuiPaper-root.MuiPaper-outlined");
        tasks.forEach(task -> task.$("p").shouldHave(text(board)));
    }

    @Test
    @DisplayName("Фильтр по доске выдает таски только с такой доской")
    void filterByStatusAndByBoardShowsExactStatusesAndBoards() {
        IssuesPage issuesPage = new IssuesPage().openPage();
        String status = "InProgress";
        String board = "Переход на Kubernetes";
        issuesPage.selectStatus(status);
        issuesPage.selectBoard(board);
        ElementsCollection tasks = $$("div.MuiPaper-root.MuiPaper-outlined");
        tasks.forEach(task -> {
            task.$("span").shouldHave(text(status)).highlight();
            task.$("p").shouldHave(text(board)).highlight();
        });

    }
}
