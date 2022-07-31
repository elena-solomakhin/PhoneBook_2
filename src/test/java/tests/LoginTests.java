package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }

    }

    @Test
    public void loginASuccess() {
        User user= new User().setEmail("noa5@gmail.com").setPassword("4567QQqq$$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());

        // 6.Assert ( is login success?)   logout present?PRESENT

    }

    @Test
    public void loginNegativeTestsWrongEmail() {
        User user= new User().setEmail("noagmail.com").setPassword("45689888");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorFormatDisplayed());
        // 6.Assert ( is login unsuccessful?)   logout present? NOT

    }

}
