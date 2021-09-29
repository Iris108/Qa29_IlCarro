package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test

    public void loginSuccess(){
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("noa@gmail.com","Nnoa12345$");
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isLogged());
    }

    @Test

    public void negativeLoginWrongPassword(){
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("noa@gmail.com","N23456");
        app.userHelper().submitForm();
        Assert.assertFalse(app.userHelper().isLoggedSuccess());
    }
  @AfterMethod
    public void postCondition(){
        app.userHelper().clickOkButton();
       if(app.userHelper().isLogoutPresent()) {
           app.userHelper().logout();

        }//logout
        }

        }




