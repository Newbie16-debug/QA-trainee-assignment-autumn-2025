package task_2_1.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import task_2_1.config.TestsConfig;
import task_2_1.pages.BoardPage;
import task_2_1.pages.BoardsPage;
import task_2_1.pages.HeaderPage;

import static com.codeborne.selenide.Selenide.open;

public class BoardsTest {

    @BeforeAll
    static void init() {
        TestsConfig.init();
    }

    @Test
    void checkBoard() {
        open("/");
        HeaderPage headerPage = new HeaderPage();
        BoardsPage boardsPage = headerPage.openBoardsPage();
        String project = "Редизайн карточки товара";
        BoardPage boardPage = boardsPage.openBoardPage(project);
        boardPage.shouldBeOpened(project);
    }

}
