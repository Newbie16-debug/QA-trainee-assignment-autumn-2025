package task_2_1.config;

import com.codeborne.selenide.Configuration;

public class TestsConfig {
    public static void init() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.baseUrl = "https://avito-tech-internship-psi.vercel.app";
        Configuration.timeout = 10000;
    }
}
