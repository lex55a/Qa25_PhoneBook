package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HelperContacts extends HelperBase {
    public HelperContacts(WebDriver wd) {
        super (wd);;
    }

    public void openAddForm(){
        pause(500);
        click(By.cssSelector("a[href='/add']"));
    }

    public void fillAddForm(Contact contact) {
        typeName(contact.getName());
        typeLastName(contact.getLastName());
        typePhone(contact.getPhone());
        typeEmail(contact.getEmail());
        typeAddress(contact.getAddress());
        typeDescription(contact.getDescription());

    }

    public void typeDescription(String description) {
        type(By.name("placeholder"),description);
    }

    public void typeAddress(String address) {
        type(By.name("placeholder"),address);
    }

    public void typeEmail(String email) {
        type(By.name("placeholder"),email);
    }

    public void typePhone(int phone) {
        type(By.name("placeholder"), String.valueOf(phone));
    }

    public void typeLastName(String lastName) {
        type(By.name("placeholder"),lastName);
    }

    public void typeName(String name) {
        type(By.name("placeholder"),name);
    }

    public void clickSaveButton() {
        if (isElementPresent(By.xpath("//button[text()='Save']")))
            click(By.xpath("//button[text()='Save']"));
    }

}

