package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContact extends TestBase{


    @BeforeMethod
    public void preCondition(){
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("noa5@gmail.com").setPassword("4567QQqq$$"));
            logger.info("user");
    }
    }

    @Test (invocationCount = 5)
    public void addNewContactSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Contact contact= Contact.builder()
                .name("Mara"+i)
                .lastName("Naiv")
                .phone("083234"+i)
                .email("mara@gmail.com")
                .address("Nes Zion")
                .description("doctor")
                .build();// create object

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContact();
        Assert.assertTrue(app.contact().isContactAddedByName(contact.getName()));
        logger.info("Check name - " +contact.getName());
        Assert.assertTrue(app.contact().isContactAddedByPhone(contact.getPhone()));
        logger.info("Check phone -" +contact.getPhone());
}
}

