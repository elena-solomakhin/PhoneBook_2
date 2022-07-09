package manager;

import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;
    HelperUser helperUser;
    HelperContact contact;//1

    public void init(){

        wd=new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
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
