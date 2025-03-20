package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComboBox {

    private static final String COMBO_BOX = "//input[@class='slds-combobox__input slds-input']";
    private static final String COMBO_BOX_OPTION = "//label[contains(text(),'Account Name')]/ancestor::lightning-grouped-combobox[contains(@class,'slds-form-element')]//*[@title='%s']";
    WebDriver driver;

    public ComboBox(WebDriver driver) {
        this.driver = driver;
    }

    public void accountSelectOption(String option) {
        driver.findElement(By.xpath(String.format(COMBO_BOX))).click();
        driver.findElement(By.xpath(String.format(COMBO_BOX_OPTION, option))).click();
    }
}
