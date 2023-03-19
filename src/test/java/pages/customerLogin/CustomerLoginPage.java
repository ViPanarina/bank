package pages.customerLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class CustomerLoginPage extends PageBase {

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userSelect")
    private WebElement userSelect;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginButton;

    public void selectExistingUser(String userName){
        selectOption(userName, userSelect);
    }

    public void clickOnLoginButton(){
        click(loginButton);
    }
}
