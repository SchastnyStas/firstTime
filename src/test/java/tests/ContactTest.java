package tests;

import objects.Account;
import objects.Contact;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class ContactTest extends BaseTest {

    Random random = new Random();

    @Test
    public void createContactTest() {

        SoftAssert softAssert = new SoftAssert();

        Account account = new Account(
                "account" + random.nextInt(10),
                "website",
                "Investor",
                "nothing",
                "80293313131"
        );
        String accountName = account.getAccountName();
        Contact contact = new Contact(
                "Prof.",
                "V" + random.nextInt(100),
                "D" + random.nextInt(100),
                accountName,
                "8-029-321-58-5" + random.nextInt(100)
        );
        String contactFullName = contact.getFirstName() + " " + contact.getLastName();

        loginPage.openPage(LOGIN_URL).login(username, password);

        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL).createNewAccount(account);

        newContactModalPagePage.openPage(NEW_CONTACT_MODAL_URL).createNewContact(contact);

        contactListPage.openPage(CONTACT_LIST_URL);

        softAssert.assertEquals(contactListPage.getExistContactAccountName(accountName), accountName);
        softAssert.assertEquals(contactListPage.getExistContactName(contactFullName),
                contactFullName);
        softAssert.assertEquals(contactListPage.getExistPhoneNumberByAccountName(accountName),
                contact.getPhoneContact());
        softAssert.assertAll();
    }
}
