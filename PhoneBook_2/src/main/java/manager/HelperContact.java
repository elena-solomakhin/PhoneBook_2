package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HelperContact extends HelperBase {

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {

        click(By.xpath("//a[@href='/add']"));// =//a[text()='ADD']
    }

    public void fillContactForm(Contact contact) {

        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());

    }

    public boolean isContactAddedByName(String name) {

        List <WebElement> names = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : names) {
            if (el.getText().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List <WebElement> phones= wd.findElements(By.cssSelector("h3"));
        for (WebElement el: phones){
            if (el.getText().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public void openContacts() {
        click(By.cssSelector("a[href='/contacts']"));
    }

    public void  deleteContact() {

     click(By.cssSelector("div.contact-item_card__2SOIM"));
     click(By.xpath("//button[text()='Remove']"));
    }

    public int getContactCount() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }
}
