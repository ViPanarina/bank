package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.Wait;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    Wait wait;
    @FindBy(xpath = "//*[@ng-click='home()']")
    protected WebElement homeButton;

    @FindBy(xpath = "//*[@ng-click='customer()']")
    protected WebElement customerLoginButton;

    @FindBy(xpath = "//*[@ng-click='manager()']")
    protected WebElement managerLoginButton;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(homeButton);
        wait.forVisibility(customerLoginButton);
        wait.forVisibility(managerLoginButton);
    }

    public void clickOnCustomerLoginButton() {
        click(customerLoginButton);
    }

    public void clickOnHomeButton() {
        click(homeButton);
    }

    public void clickOnBankManagerLoginButton() {
        click(managerLoginButton);
    }
}
