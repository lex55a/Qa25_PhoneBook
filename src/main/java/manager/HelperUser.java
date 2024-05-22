package manager;

import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
//    WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
//    loginTab.click();
        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
//        WebElement emailInput = wd.findElement(By.name("email"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
        type(By.name("email"), email);

//        WebElement passwordInput = wd.findElement(By.xpath("//input[last()]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
        type(By.xpath("//input[last()]"), password);

    }

    public void fillLoginRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.xpath("//input[last()]"), user.getPassword());
    }

    public void submitLogin() {
        click(By.xpath("//button[text()='Login']"));
    }


    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }


    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public boolean isNoContactsHereDisplayed() {
        WebDriverWait wait = new WebDriverWait(wd,5);
        return   wait.until(ExpectedConditions
                .textToBePresentInElement(wd.findElement(By.cssSelector(".contact-page_message__2qafk>h1")),"No Contacts here!"));
    }


    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();
    }


    public void add() {
        click(By.cssSelector("a[href='/add']"));
    }

    public void clickNameButton() {
        click(By.xpath("//input[@placeholder='Name']"));
    }
    

    public void clickSaveButton() {
        if (isElementPresent(By.xpath("//button[text()='Save']")))
            click(By.xpath("//button[text()='Save']"));
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

}