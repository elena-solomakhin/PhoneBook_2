package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContact extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("noa5@gmail.com").setPassword("4567QQqq$$"));
        }
    }
    @Test
    public void DeleteContactOne(){
        app.contact().openContacts();
        int CountContactsBeforeDelete = app.contact().getContactCount();//3
        if (CountContactsBeforeDelete>0){
        app.contact().deleteContact();
        app.contact().pause(2000);
        int CountContactsAfterDelete = app.contact().getContactCount();//2
        Assert.assertEquals(CountContactsAfterDelete,CountContactsBeforeDelete-1);
        }
    }
}