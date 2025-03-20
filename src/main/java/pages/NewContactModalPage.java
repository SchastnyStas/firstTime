package pages;

import elements.Button;
import elements.ComboBox;
import elements.Dropdown;
import elements.Input;
import objects.Contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewContactModalPage extends BasePage {

    @FindBy(xpath = "//*[@name = 'SaveEdit']")
    public WebElement saveButton;

    @FindBy(name = "SaveAndNew")
    public WebElement saveAndNewButton;

    @FindBy(name = "CancelEdit")
    public WebElement cancelButton;

    public NewContactModalPage(WebDriver driver) {
        super(driver);
    }

    public NewContactModalPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public void createNewContact(Contact contact) {
        new Dropdown(driver, "Salutation").accountSelectOption(contact.getSalutation());
        new Input(driver, "First Name").writeTextToInput(contact.getFirstName());
        new Input(driver, "Last Name").writeTextToInput(contact.getLastName());
        new ComboBox(driver).accountSelectOption(contact.getAccountName());
        new Input(driver, "Phone").writeTextToInput(contact.getPhoneContact());
        new Button(driver).clickButton(saveButton);
    }
}
