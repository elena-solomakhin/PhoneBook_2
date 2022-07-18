package manager;

import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;
    HelperUser helperUser;
    HelperContact contact;//1
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
    public void init(){

        wd=new ChromeDriver();
        WebDriverListener listener= new MyListener();
        wd= new EventFiringDecorator(listener).decorate(wd);
        logger.info("All tests run in Chrome browser");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        logger.info("current url ---- "+wd.getCurrentUrl());
        helperUser=new HelperUser(wd);
        contact= new HelperContact(wd);//2

    }

    public void stop(){

        wd.quit();
    }


    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperContact contact() {  //3
        return contact;
    }
}
