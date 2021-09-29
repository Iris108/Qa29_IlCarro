package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void submitForm() {
        click(By.xpath("//button [@type='submit']"));
    }

    //h2[text()='Logged in success']
    public boolean isLoggedSuccess() {
        String text = wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        return text.equals("Logged in success");
    }
    public boolean isLogged(){
        return wd.findElements(By.xpath("//a[.='Log in']")).size() > 0;
    }

    public void logout() {
        new WebDriverWait(wd,10).until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//a[text()=' Logout ']"))));
        click(By.xpath("//a[text()=' Logout ']"));

    }

    public void clickOkButton(){
        if(isElementPresent(By.xpath("//button[.='Ok']"))){
            click(By.xpath("//button[.='Ok']"));
        }
    }

    public boolean isLogoutPresent(){
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(String name, String lastname, String email, String password) {
     type(By.id("name"),name);
     type(By.id("lastName"),lastname);
     type(By.id("email"),email);
     type(By.id("password"),password);

    }

    public void checkPolicy() {
        //click(By.xpath("//label[@for = 'terms-of-use']"));
        JavascriptExecutor js =(JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').checked=true;");
    }
}
