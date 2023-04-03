package pages.customerLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import wait.Wait;

public class CustomerLoginPage extends PageBase {

    Wait wait;

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userSelect")
    protected WebElement userSelect;

    @FindBy(xpath = "//*[@type='submit']")
    protected WebElement loginButton;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(userSelect);
    }

    public void checkForVisibilityLoginButton() {
        wait = new Wait(driver);
        wait.forVisibility(loginButton);
    }

    public void selectExistingUser(String userName) {
        selectOption(userName, userSelect);
    }

    public void clickOnLoginButton() {
        click(loginButton);
    }


}
