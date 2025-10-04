package org.example;

import com.microsoft.playwright.*;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        try (Playwright playwright = Playwright.create()) {

//            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            BrowserContext context = browser.newContext();
            Page page;
            page = browser.newPage();
            page.navigate("https://playwright. /", new Page.NavigateOptions()
                    .setTimeout(0)); // 30 seconds
            assertThat(page).hasTitle(Pattern.compile("Playwright"));
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }
    }
}