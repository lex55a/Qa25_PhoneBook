package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContacts extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User()
                    .withEmail("elena.krylataya@gmail.com").withPassword("Lenakira11$"));
            app.getHelperUser().add();
            app.getHelperUser().clickNameButton();
            app.getHelperUser().fillAddForm(Contact.builder().build());
            Contact contact = Contact.builder()
                    .name("Petya")
                    .lastName("Petrov")
                    .phone(0500000000)
                    .email("petya201000@gmail.com")
                    .address("Haifa")
                    .description("driver")
                    .build();

        }
    }

    @Test
    public void addNewContactSuccessAll() {
//        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Petya")
                .lastName("Petrov")
                .phone(0500000000)
                .email("petya201000@gmail.com")
                .address("Haifa")
                .description("driver")
                .build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("elena.krylataya@gmail.com", "Lenakira11$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().fillAddForm(Contact.builder().build());
        app.getHelperUser().clickNameButton();

        Assert.assertTrue(app.getHelperUser().isLogged());

    }
//    @Test
//    public void addNewContactSuccess() {
//        app.getHelperUser().openLoginRegistrationForm();
//        app.getHelperUser().fillLoginRegistrationForm("elena.krylataya@gmail.com", "Lenakira11$");
//        app.getHelperUser().submitLogin();
//        Assert.assertTrue(app.getHelperUser().isLogged());
//
//    }

@AfterMethod
public void postCondition() {
    app.getHelperUser().clickSaveButton();
}

    }

