package straightforward;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        page.navigate("https://www.saucedemo.com/");
        page.locator("//input[@id='user-name']").fill("standard_user");
        page.locator("//input[@id='password']").fill("secret_sauce");
        page.locator("//input[@id='user-name']").press("Enter");
        Assert.assertEquals(page.url(), "https://www.saucedemo.com/inventory.html");
    }
}
