package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;
Logger logger = LoggerFactory.getLogger(HelperBase.class);
    public HelperBase(WebDriver wd) {

        this.wd = wd;
    }
    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void type(By locator, String text){
        if(text!=null){
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void click(By locator){

        wd.findElement(locator).click();
    }
    public void submit() {
        wd.findElement(By.xpath("//div//button//b")).click(); //button b

    }

    public void takeScreenShots(String pathToFile){
        File tmp= ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screen= new File(pathToFile);
        try {
            Files.copy(tmp,screen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}




