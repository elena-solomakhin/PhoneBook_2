package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase{
    //precondition Login
    @BeforeMethod
    public void preCondition(){
        if (app.getHelperUser().isLogged()!=true) {
            User user= new User().setEmail("noa5@gmail.com").setPassword("4567QQqq$$");
            app.getHelperUser().openLoginRegistrationForm();
            app.getHelperUser().fillLoginRegistrationForm(user);
            app.getHelperUser().submitLogin();
            Assert.assertTrue(app.getHelperUser().isLogged());
        }
    }

    @Test
    public void addNewContactSuccess(){
        Contact contact= Contact.builder()
                .name("Mara")
                .lastName("Naiv")
                .phone("0832345678")
                .email("mara@gmail.com")
                .address("Nes Zion")
                .description("doctor")
                .build();// create object

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().submit();
    }

}
