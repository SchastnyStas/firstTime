package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    private static final String INPUT_XPATH = "//*[contains(text(), '%s')]/ancestor::div[contains(@part, 'input-text')]//input";
    private static final String TEXTAREA_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//textarea";
    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }
    public void writeTextToInput(String text){
        driver.findElement(By.xpath(String.format(INPUT_XPATH, label))).sendKeys(label);
    }
    public void writeTextToTextarea(String text){
        driver.findElement(By.xpath(String.format(TEXTAREA_XPATH, label))).sendKeys(label);
    }
}
