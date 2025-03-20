package tests;

import objects.Account;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class AccountTest extends BaseTest {

    Random random = new Random();

    @Test
    public void createAccountTest() {
        SoftAssert softAssert = new SoftAssert();

        Account account = new Account(
                "account" + random.nextInt(10),
                "website",
                "Investor",
                "nothing",
                "80293313131"
        );
        String accountName = account.getAccountName();

        loginPage.openPage(LOGIN_URL).login(username, password);

        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL).createNewAccount(account);

        accountListPage.openPage(ACCOUNT_LIST_URL);

        softAssert.assertEquals(accountListPage.getExistAccountName(accountName), accountName);
        softAssert.assertEquals(accountListPage.getExistPhoneNumberByAccountName(accountName),
                account.getPhone());
        softAssert.assertAll();
    }
}
