package tests.manager_login;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.bankManagerLogin.BankManagerLoginPage;
import pages.bankManagerLogin.addCustomer.AddCustomerPage;
import pages.bankManagerLogin.customers.CustomersPage;
import pages.bankManagerLogin.openAccount.OpenAccountPage;
import pages.customerLogin.CustomerLoginPage;
import pages.customerLogin.account.AccountPage;
import tests.TestBase;

import java.io.IOException;

public class RegisterNewCustomerTest extends TestBase {
    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    CustomerLoginPage customerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    AccountPage accountPage;
    CustomersPage customersPage;

    Faker faker = new Faker();
    String firstName = faker.internet().uuid();
    String lastName = faker.internet().uuid();
    String firstNameAndLastName = firstName + " " + lastName;
    String postCode = faker.address().zipCode();
    String currencyValue = "Dollar";

    @Test
    public void registerNewCustomerOpenAccountAndCustomerLogin() throws IOException {
        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.takeAndCompareScreenshot("homePage", null);
        homePage.clickOnBankManagerLoginButton();

        bankManagerLoginPage = new BankManagerLoginPage(app.driver);
        bankManagerLoginPage.waitForLoading();
        bankManagerLoginPage.openAddCustomerTab();

        addCustomerPage = new AddCustomerPage(app.driver);
        addCustomerPage.waitForLoading();
        addCustomerPage.fillAddCustomerForm(firstName, lastName, postCode);
        addCustomerPage.clickOnAddCustomerButton();

        String expectedResult = "Customer added successfully with customer id :";
        String actualResult = addCustomerPage.getAlertText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        addCustomerPage.clickAlertOkButton();

        bankManagerLoginPage.openAccountTab();
        openAccountPage = new OpenAccountPage(app.driver);
        openAccountPage.waitForLoading();
        openAccountPage.selectExistingUser(firstNameAndLastName);
        openAccountPage.selectCurrency(currencyValue);
        openAccountPage.clickOnProcessButton();

        String expectedRes = "Account created successfully with account Number :";
        String actualRes = openAccountPage.getAlertText();
        Assert.assertTrue(actualRes.contains(expectedRes));
        openAccountPage.clickAlertOkButton();

        homePage.clickOnHomeButton();
        homePage.waitForLoading();
        homePage.clickOnCustomerLoginButton();
        customerLoginPage = new CustomerLoginPage(app.driver);
        customerLoginPage.waitForLoading();
        customerLoginPage.selectExistingUser(firstNameAndLastName);
        customerLoginPage.clickOnLoginButton();
        accountPage = new AccountPage(app.driver);
        accountPage.waitForLoading();

        homePage.clickOnHomeButton();
        homePage.waitForLoading();
        homePage.clickOnBankManagerLoginButton();

        bankManagerLoginPage.waitForLoading();
        bankManagerLoginPage.openCustomersTab();

        customersPage = new CustomersPage(app.driver);
        customersPage.waitForLoading();
        customersPage.fillSearchCustomerInput(firstName);
        customersPage.waitForLoading();
        customersPage.checkExistingCustomer(1);
        customersPage.deleteTableRow(firstName);
    }

    @Test
    public void registerNewUserWithInvalidData() throws IOException {
        String firstName = "Invalid first name";
        String lastName = "Invalid last name";

        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.takeAndCompareScreenshot("homePage", null);
        homePage.clickOnBankManagerLoginButton();

        bankManagerLoginPage = new BankManagerLoginPage(app.driver);
        bankManagerLoginPage.waitForLoading();
        bankManagerLoginPage.openAddCustomerTab();

        addCustomerPage = new AddCustomerPage(app.driver);
        addCustomerPage.waitForLoading();
        addCustomerPage.fillAddCustomerForm(firstName, lastName, "");
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.takeAndCompareScreenshot("addCustomerPage", null);

        bankManagerLoginPage.openAccountTab();

        openAccountPage = new OpenAccountPage(app.driver);
        openAccountPage.waitForLoading();
        openAccountPage.checkNotExistingCustomer(firstNameAndLastName);

        homePage.clickOnHomeButton();
        homePage.waitForLoading();
        homePage.clickOnCustomerLoginButton();

        customerLoginPage = new CustomerLoginPage(app.driver);
        customerLoginPage.waitForLoading();
        customerLoginPage.checkNotExistingCustomer(firstNameAndLastName);


    }

}
