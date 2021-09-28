package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;
    private String email;
    private String password;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

    /// ******************************************
    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);

        }
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
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

}


