package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContact extends TestBase{
    Random random = new Random();
    int i = random.nextInt(1000)+1000;
    //precondition Login
    @BeforeMethod
    public void preCondition(){
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("noa5@gmail.com").setPassword("4567QQqq$$"));

//            Assert.assertTrue(app.getHelperUser().isLogged());
        }
    }

    @Test
    public void addNewContactSuccess(){
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
        app.contact().submit();
        Assert.assertTrue(app.contact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactAddedByPhone(contact.getPhone()));
    }

}

