package straightforward;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTest {

    private static Browser browser;
    private Page page;

    @BeforeClass
    public static void setup() {
        // Initialize Playwright and launch the browser once before all tests
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeMethod
    public void createPage() {
        // Create a new page before each test method
        page = browser.newPage();
    }

    @Test
    public void testLogin() {
        page.navigate("https://www.saucedemo.com/");
        page.locator("//input[@id='user-name']" ).fill("standard_user");
        page.locator("//input[@id='user-name']").fill("secret_sauce");
    }

    @AfterMethod
    public void closePage() {

        page.close();
    }

    @AfterClass
    public static void tearDown() {
     
        browser.close();
    }
}
