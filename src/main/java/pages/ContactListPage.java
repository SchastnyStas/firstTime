package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactListPage extends BasePage {
    public static final String TABLE_CONTACT_XPATH = "//table//tbody";
    public static final String CONTACT_NAME_FIELD_XPATH = TABLE_CONTACT_XPATH + "//a[contains" +
            "(@title, '%s')]";
    public static final String CONTACT_ACCOUNT_NAME_FIELD_XPATH = TABLE_CONTACT_XPATH + "//a" +
            "[contains(@title, '%s')]";
    public static final String PHONE_BY_CONTACT_NAME_XPATH = CONTACT_ACCOUNT_NAME_FIELD_XPATH +
            "/ancestor::tr//span[contains(@class, 'forceOutputPhone')]";
    public static final String CONTACT_OWNER_BY_ACCOUNT_XPATH = CONTACT_ACCOUNT_NAME_FIELD_XPATH +
            "/ancestor::tr//a[contains(@class, 'uiOutputText')]";

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public ContactListPage openPage(String url) {
        driver.get(url);
        waitForPageToLoad();
        return this;
    }

    public void waitForPageToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TABLE_CONTACT_XPATH)));
    }

    public String getExistContactName(String contactName) {
        return driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, contactName))).getText();
    }

    public String getExistContactAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(CONTACT_ACCOUNT_NAME_FIELD_XPATH, accountName))).getText();
    }

    public String getExistPhoneNumberByAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(PHONE_BY_CONTACT_NAME_XPATH, accountName))).getText();
    }

    public String getExistContactOwnerByAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(CONTACT_OWNER_BY_ACCOUNT_XPATH, accountName))).getText();
    }
}
