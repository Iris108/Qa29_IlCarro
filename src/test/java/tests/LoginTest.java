package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test

    public void loginSuccess(){
        openLoginForm();
        fillLoginForm("noa@gmail.com","Nnoa12345$");
        submitForm();
        Assert.assertTrue(isLogged());
    }

    @Test

    public void negativeLoginWrongPassword(){
        openLoginForm();
        fillLoginForm("noa@gmail.com","N23456");
        submitForm();
        Assert.assertFalse(isLoggedSuccess());
    }
  @AfterMethod
    public void postCondition(){
        clickOkButton();
       if(isLogoutPresent()) {
           logout();

       }//logout
    }



        }




